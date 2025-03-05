
/*
 * @Author: ZHANGCHAO
 * @Date: 2025-03-03 16:25:33
 * @LastEditors: ZHANGCHAO
 * @LastEditTime: 2025-03-04 09:23:09
 * @FilePath: \Java21\App.java
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {
    public static String getCountry(String address) {
        // 去除字符串两端的空格
        address = address.trim();
        // 匹配最后一个逗号后面的内容
        Pattern pattern = Pattern.compile(".*,\\s*([A-Za-z\\s]+)\\s*$");
        Matcher matcher = pattern.matcher(address);
        if (matcher.find()) {
            return matcher.group(1).trim();
        }
        return null;
    }

    public static void main(String[] args) {
        String address1 = "Njiverheidstraat 15, 2222 AV Katwijk, Netherlands   ";
        String country1 = getCountry(address1);
        System.out.println(country1);

        String address2 = "Level 8, 580 St Kilda Road, Melbourne Vic 3004, Australia  ";
        String country2 = getCountry(address2);
        System.out.println(country2);

        String address3 = "123 Main St, Anytown, United States  ";
        String country3 = getCountry(address3);
        System.out.println(country3);
    }
}