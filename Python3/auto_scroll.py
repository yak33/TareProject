#!D:/TOOLS/anaconda3/python.exe
import time
import win32gui
import win32con
import win32api
import logging
from pynput import keyboard
import threading
import random

# 配置日志输出
logging.basicConfig(
    level=logging.INFO, 
    format='%(asctime)s - %(levelname)s: %(message)s',
    datefmt='%Y-%m-%d %H:%M:%S'
)

# 创建一个事件标志
stop_event = threading.Event()

def on_press(key):
    """
    键盘按键回调函数
    """
    try:
        if key == keyboard.Key.esc:
            logging.info("检测到ESC按键，准备停止程序...")
            stop_event.set()
            return False  # 停止监听
    except Exception as e:
        logging.error(f"键盘监听出错：{e}")

def find_window(window_title):
    """
    根据窗口标题查找窗口句柄
    """
    logging.info(f"正在搜索窗口：{window_title}")
    hwnd = win32gui.FindWindow(None, window_title)
    if hwnd == 0:
        logging.error(f"未找到标题为 '{window_title}' 的窗口")
        # 打印所有窗口以供参考
        def enum_windows_callback(hwnd, windows):
            windows.append((hwnd, win32gui.GetWindowText(hwnd)))
            return True
        
        windows = []
        win32gui.EnumWindows(enum_windows_callback, windows)
        logging.info("当前所有窗口：")
        for hwnd, title in windows:
            logging.info(f"窗口句柄: {hwnd}, 标题: {title}")
        
        raise Exception(f"未找到标题为 '{window_title}' 的窗口")
    logging.info(f"找到窗口，句柄为：{hwnd}")
    return hwnd

def simulate_smooth_drag(start_x, start_y, end_y, duration=0.5, steps=50):
    """
    模拟平滑的拖拽操作
    
    :param start_x: 起始X坐标
    :param start_y: 起始Y坐标
    :param end_y: 结束Y坐标
    :param duration: 拖拽持续时间
    :param steps: 拖拽步数
    """
    try:
        # 按下鼠标左键
        win32api.mouse_event(win32con.MOUSEEVENTF_LEFTDOWN, 0, 0, 0, 0)
        
        # 计算每一步的移动距离
        y_distance = end_y - start_y
        sleep_time = duration / steps
        
        # 平滑移动
        for i in range(steps + 1):
            progress = i / steps  # 0 到 1 之间的进度
            current_y = start_y + int(y_distance * progress)
            win32api.SetCursorPos((start_x, current_y))
            time.sleep(sleep_time)
        
        # 释放鼠标左键
        win32api.mouse_event(win32con.MOUSEEVENTF_LEFTUP, 0, 0, 0, 0)
        return True
        
    except Exception as e:
        logging.error(f"拖拽操作失败: {e}")
        return False

def simulate_scroll_with_retry(hwnd, x, y, drag_distance, max_retries=3):
    """
    模拟滚动并进行重试
    
    :param hwnd: 窗口句柄
    :param x: 鼠标X坐标
    :param y: 鼠标Y坐标
    :param drag_distance: 拖拽距离
    :param max_retries: 最大重试次数
    :return: 是否滚动成功
    """
    # 保存当前激活窗口
    current_hwnd = win32gui.GetForegroundWindow()
    
    for attempt in range(max_retries):
        try:
            # 将目标窗口移到前台
            win32gui.ShowWindow(hwnd, win32con.SW_RESTORE)
            win32gui.SetForegroundWindow(hwnd)
            
            # 短暂等待窗口激活
            time.sleep(0.2)
            
            # 移动鼠标到起始位置
            win32api.SetCursorPos((x, y))
            time.sleep(0.1)
            
            # 执行平滑拖拽
            success = simulate_smooth_drag(x, y, y - drag_distance)
            
            # 恢复原窗口
            if current_hwnd and current_hwnd != hwnd:
                win32gui.SetForegroundWindow(current_hwnd)
            
            if success:
                return True
                
        except Exception as e:
            logging.warning(f"滚动尝试 {attempt + 1}/{max_retries} 失败: {e}")
            if attempt < max_retries - 1:
                time.sleep(1)
    
    return False

def simulate_smooth_scroll(hwnd, x, y, total_distance, duration=30, small_scroll_distance=100):
    """
    模拟缓慢平滑滚动，适用于瀑布流页面
    
    :param hwnd: 窗口句柄
    :param x: 鼠标X坐标
    :param y: 鼠标Y坐标
    :param total_distance: 总共需要滚动的距离
    :param duration: 总持续时间（秒）
    :param small_scroll_distance: 每次小幅滚动的距离
    """
    try:
        # 保存当前激活窗口
        current_hwnd = win32gui.GetForegroundWindow()
        
        # 将目标窗口移到前台
        win32gui.ShowWindow(hwnd, win32con.SW_RESTORE)
        win32gui.SetForegroundWindow(hwnd)
        
        # 计算需要滚动的次数
        scroll_count = total_distance // small_scroll_distance
        interval = duration / scroll_count
        
        # 执行多次小幅滚动
        for i in range(scroll_count):
            if stop_event.is_set():
                break
                
            # 移动鼠标到起始位置
            win32api.SetCursorPos((x, y))
            time.sleep(0.1)
            
            # 执行一次小幅滚动
            win32api.mouse_event(win32con.MOUSEEVENTF_WHEEL, 0, 0, -small_scroll_distance)
            
            # 添加随机等待时间，使滚动更自然
            wait_time = interval + random.uniform(-0.2, 0.2)
            time.sleep(wait_time)
        
        # 恢复原窗口
        if current_hwnd and current_hwnd != hwnd:
            win32gui.SetForegroundWindow(current_hwnd)
            
        return True
        
    except Exception as e:
        logging.error(f"平滑滚动失败: {e}")
        return False

def simulate_video_scroll(window_title, interval=2, scroll_distance=600):
    """
    模拟视频切换的滚动模式
    """
    try:
        # 查找窗口
        hwnd = find_window(window_title)
        
        # 获取窗口位置和大小
        logging.info("获取窗口位置信息")
        rect = win32gui.GetWindowRect(hwnd)
        x = rect[0]
        y = rect[1]
        width = rect[2] - rect[0]
        height = rect[3] - rect[1]
        
        logging.info(f"窗口信息: 位置({x},{y}), 大小({width}x{height})")
        
        # 计算滚动位置（窗口中心偏下位置，更适合视频滚动）
        scroll_x = x + width // 2
        scroll_y = y + int(height * 0.7)
        
        count = 0
        failed_attempts = 0
        
        while not stop_event.is_set():
            logging.info(f"第{count+1}次滚动 - 位置({scroll_x},{scroll_y})")
            
            if simulate_scroll_with_retry(hwnd, scroll_x, scroll_y, scroll_distance):
                logging.info(f"第{count+1}次滚动成功")
                failed_attempts = 0
            else:
                failed_attempts += 1
                logging.error(f"第{count+1}次滚动失败")
                if failed_attempts >= 3:
                    logging.error("连续失败3次，程序将退出")
                    break
            
            wait_time = interval + random.uniform(-0.5, 0.5)
            for _ in range(int(wait_time)):
                if stop_event.is_set():
                    break
                time.sleep(1)
            
            count += 1
            
    except Exception as e:
        logging.error(f"发生错误：{e}")
        logging.exception("详细错误信息：")

def simulate_waterfall_scroll(window_title, scroll_duration=30):
    """
    模拟瀑布流页面的缓慢滚动模式
    """
    try:
        # 查找窗口
        hwnd = find_window(window_title)
        
        # 获取窗口位置和大小
        logging.info("获取窗口位置信息")
        rect = win32gui.GetWindowRect(hwnd)
        x = rect[0]
        y = rect[1]
        width = rect[2] - rect[0]
        height = rect[3] - rect[1]
        
        logging.info(f"窗口信息: 位置({x},{y}), 大小({width}x{height})")
        
        # 计算滚动位置（窗口中心）
        scroll_x = x + width // 2
        scroll_y = y + height // 2
        
        count = 0
        while not stop_event.is_set():
            logging.info(f"第{count+1}次平滑滚动开始")
            
            # 执行一次完整的平滑滚动
            if simulate_smooth_scroll(hwnd, scroll_x, scroll_y, height, scroll_duration):
                logging.info(f"第{count+1}次平滑滚动完成")
            else:
                logging.error(f"第{count+1}次平滑滚动失败")
            
            # 等待一段时间再开始下一轮
            wait_time = random.uniform(1, 2)
            for _ in range(int(wait_time)):
                if stop_event.is_set():
                    break
                time.sleep(1)
            
            count += 1
            
    except Exception as e:
        logging.error(f"发生错误：{e}")
        logging.exception("详细错误信息：")

def print_menu():
    """
    打印模式选择菜单
    """
    print("\n=== 自动滚动模式选择 ===")
    print("1. 视频切换模式（快速上滑切换）")
    print("2. 瀑布流浏览模式（缓慢平滑滚动）")
    print("请输入模式编号(1或2): ", end='')

# 使用示例
if __name__ == "__main__":
    try:
        # 打印菜单并获取用户选择
        print_menu()
        mode = input().strip()
        
        while mode not in ['1', '2']:
            print("输入无效，请重新输入(1或2): ", end='')
            mode = input().strip()
        
        # 启动键盘监听线程
        listener = keyboard.Listener(on_press=on_press)
        listener.start()
        
        logging.info("程序已启动，按ESC键可以停止运行...")
        
        # 根据用户选择执行相应的滚动模式
        if mode == '1':
            logging.info("已选择视频切换模式")
            simulate_video_scroll("享屏", interval=2, scroll_distance=600)
        else:
            logging.info("已选择瀑布流浏览模式")
            simulate_waterfall_scroll("享屏", scroll_duration=30)
        
        # 等待键盘监听线程结束
        listener.join()
        
    except Exception as e:
        logging.error(f"脚本执行失败：{e}")
    finally:
        logging.info("程序已退出")