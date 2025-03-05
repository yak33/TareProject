import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式示例类
 * 展示Java中正则表达式的常见用法
 */
public class RegexExample {
    public static void main(String[] args) {
        String test1 = "A00";
        String test2 = "100";
        String test3 = "A100";

        System.out.println(test1 + " 符合格式: " + isValidFormat(test1));
        System.out.println(test2 + " 符合格式: " + isValidFormat(test2));
        System.out.println(test3 + " 符合格式: " + isValidFormat(test3));
        // 调用各种正则表达式示例方法
        basicMatching();
        System.out.println("\n-----------------------------------\n");

        emailValidation();
        System.out.println("\n-----------------------------------\n");

        phoneNumberValidation();
        System.out.println("\n-----------------------------------\n");

        extractData();
        System.out.println("\n-----------------------------------\n");

        replaceExample();
        System.out.println("\n-----------------------------------\n");

        splitExample();
        System.out.println("\n-----------------------------------\n");

        findAllMatches();
    }

    public static boolean isValidFormat(String a) {
        // 正则表达式：匹配一个字母，后面跟着两位数字
        String pattern = "[A-Za-z]\\d{2}";
        return Pattern.matches(pattern, a);
    }

    /**
     * 基本的正则表达式匹配示例
     */
    public static void basicMatching() {
        System.out.println("基本匹配示例：");

        // 1. 简单的字符匹配
        String text = "Hello Java Regex";
        boolean isMatch = Pattern.matches("Hello.*", text);
        System.out.println("文本是否以'Hello'开头: " + isMatch);

        // 2. 使用Pattern和Matcher类
        Pattern pattern = Pattern.compile("Java");
        Matcher matcher = pattern.matcher(text);
        System.out.println("文本是否包含'Java': " + matcher.find());

        // 3. 字符类匹配
        pattern = Pattern.compile("[0-9]+");
        matcher = pattern.matcher("abc123def456");
        System.out.println("是否包含数字: " + matcher.find());
        matcher.reset();

        // 打印所有匹配的数字
        System.out.print("匹配的数字: ");
        while (matcher.find()) {
            System.out.print(matcher.group() + " ");
        }
        System.out.println();
    }

    /**
     * 电子邮件验证示例
     */
    public static void emailValidation() {
        System.out.println("电子邮件验证示例：");

        // 电子邮件正则表达式
        // 简化版本，实际应用可能需要更复杂的规则
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);

        String[] emails = {
                "user@example.com",
                "user.name@example.co.uk",
                "user-name@example.org",
                "invalid@email",
                "invalid@.com",
                "@example.com"
        };

        for (String email : emails) {
            Matcher matcher = pattern.matcher(email);
            System.out.println(email + " 是有效的电子邮件地址: " + matcher.matches());
        }
    }

    /**
     * 电话号码验证示例
     */
    public static void phoneNumberValidation() {
        System.out.println("电话号码验证示例：");

        // 中国手机号码正则表达式（简化版）
        String phoneRegex = "^1[3-9]\\d{9}$";
        Pattern pattern = Pattern.compile(phoneRegex);

        String[] phoneNumbers = {
                "13812345678",
                "15912345678",
                "19912345678",
                "12345678901", // 无效，不是以1[3-9]开头
                "1381234567", // 无效，位数不够
                "138123456789" // 无效，位数过多
        };

        for (String phone : phoneNumbers) {
            Matcher matcher = pattern.matcher(phone);
            System.out.println(phone + " 是有效的中国手机号码: " + matcher.matches());
        }
    }

    /**
     * 数据提取示例
     */
    public static void extractData() {
        System.out.println("数据提取示例：");

        // 从文本中提取日期
        String text = "今天是2023-04-15，明天是2023-04-16，后天是2023-04-17。";
        Pattern pattern = Pattern.compile("(\\d{4})-(\\d{2})-(\\d{2})");
        Matcher matcher = pattern.matcher(text);

        System.out.println("从文本中提取日期：");
        while (matcher.find()) {
            System.out.println("完整日期: " + matcher.group());
            System.out.println("  年份: " + matcher.group(1));
            System.out.println("  月份: " + matcher.group(2));
            System.out.println("  日期: " + matcher.group(3));
        }

        // 从地址中提取国家（类似于App.java中的示例）
        String address = "Level 8, 580 St Kilda Road, Melbourne Vic 3004, Australia";
        pattern = Pattern.compile(".*,\\s*([A-Za-z\\s]+)\\s*$");
        matcher = pattern.matcher(address);

        System.out.println("\n从地址中提取国家：");
        if (matcher.find()) {
            System.out.println("地址: " + address);
            System.out.println("国家: " + matcher.group(1).trim());
        }
    }

    /**
     * 字符串替换示例
     */
    public static void replaceExample() {
        System.out.println("字符串替换示例：");

        // 1. 简单替换
        String text = "The color of the sky is blue.";
        String result = text.replaceAll("blue", "azure");
        System.out.println("简单替换: " + result);

        // 2. 使用正则表达式替换所有数字为'X'
        text = "My phone number is 12345 and my age is 30.";
        result = text.replaceAll("\\d", "X");
        System.out.println("替换所有数字: " + result);

        // 3. 使用分组和反向引用
        text = "John Smith";
        // 交换名字和姓氏
        result = text.replaceAll("(\\w+)\\s+(\\w+)", "$2, $1");
        System.out.println("交换名字和姓氏: " + result);

        // 4. 使用Matcher.appendReplacement()和appendTail()
        text = "价格1是100元，价格2是200元，价格3是300元。";
        Pattern pattern = Pattern.compile("(\\d+)元");
        Matcher matcher = pattern.matcher(text);
        StringBuffer sb = new StringBuffer();

        // 将所有价格转换为美元（假设1元=0.14美元）
        while (matcher.find()) {
            int yuan = Integer.parseInt(matcher.group(1));
            double dollar = yuan * 0.14;
            matcher.appendReplacement(sb, String.format("%.2f美元", dollar));
        }
        matcher.appendTail(sb);

        System.out.println("复杂替换: " + sb.toString());
    }

    /**
     * 字符串分割示例
     */
    public static void splitExample() {
        System.out.println("字符串分割示例：");

        // 1. 按空格分割
        String text = "Java 正则表达式 示例";
        String[] words = text.split("\\s+");
        System.out.print("按空格分割: ");
        for (String word : words) {
            System.out.print(word + ", ");
        }
        System.out.println();

        // 2. 按多种分隔符分割
        text = "apple,banana;orange|grape";
        String[] fruits = text.split("[,;|]");
        System.out.print("按多种分隔符分割: ");
        for (String fruit : fruits) {
            System.out.print(fruit + ", ");
        }
        System.out.println();

        // 3. 限制分割次数
        text = "one,two,three,four,five";
        String[] parts = text.split(",", 3);
        System.out.print("限制分割次数(3): ");
        for (String part : parts) {
            System.out.print(part + ", ");
        }
        System.out.println();
    }

    /**
     * 查找所有匹配项示例
     */
    public static void findAllMatches() {
        System.out.println("查找所有匹配项示例：");

        // 查找所有HTML标签
        String html = "<div>这是一个<b>HTML</b>示例，包含<a href='https://example.com'>链接</a>和<img src='image.jpg'>图片</div>";
        Pattern pattern = Pattern.compile("<([a-zA-Z]+)[^>]*>");
        Matcher matcher = pattern.matcher(html);

        System.out.println("HTML中的所有标签：");
        while (matcher.find()) {
            System.out.println("完整标签: " + matcher.group());
            System.out.println("标签名称: " + matcher.group(1));
            System.out.println("位置: " + matcher.start() + "-" + matcher.end());
        }
    }
}