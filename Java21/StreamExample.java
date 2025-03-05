import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamExample {
    public static void main(String[] args) {
        // 创建一个示例列表
        List<String> fruits = Arrays.asList("apple", "banana", "orange", "apple", "grape", "banana");

        // 1. 过滤操作 - 筛选以'a'开头的水果
        System.out.println("以'a'开头的水果：");
        fruits.stream()
                .filter(f -> f.startsWith("a"))
                .forEach(System.out::println);

        // 2. 去重操作
        System.out.println("\n去重后的水果列表：");
        fruits.stream()
                .distinct()
                .forEach(System.out::println);

        // 3. 映射操作 - 转换为大写
        System.out.println("\n转换为大写：");
        fruits.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);

        // 4. 排序操作
        System.out.println("\n按字母排序：");
        fruits.stream()
                .sorted()
                .forEach(System.out::println);

        // 5. 统计操作
        long count = fruits.stream().count();
        System.out.println("\n水果总数：" + count);

        // 6. 收集操作 - 分组统计
        Map<String, Long> fruitCount = fruits.stream()
                .collect(Collectors.groupingBy(
                        fruit -> fruit,
                        Collectors.counting()));
        System.out.println("\n每种水果的数量：");
        fruitCount.forEach((fruit, num) -> System.out.println(fruit + ": " + num));

        // 7. 匹配操作
        boolean hasApple = fruits.stream().anyMatch(f -> f.equals("apple"));
        System.out.println("\n是否包含apple：" + hasApple);

        // 8. 数值流操作
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int sum = numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("\n数字总和：" + sum);

        double average = numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
        System.out.println("平均值：" + average);
    }
}