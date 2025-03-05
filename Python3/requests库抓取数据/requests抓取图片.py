import requests

from requests库抓取数据.other import get_urls


def get_images(url, name):
    headers = {
        "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.149 Safari/537.36"
    }
    # 发送请求
    response = requests.get(url, headers=headers)
    with open(f"{name}.jpg", 'wb') as f:
        f.write(response.content)


for index, url in enumerate(get_urls()):
    get_images(url, index)
