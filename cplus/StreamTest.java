import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamTest{
    public static void main(String[] args){

        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jk");
        
        long emptyCount = strings.stream().filter(string->string.isEmpty()).count();

        System.out.println("空字符串的数量为： " + emptyCount);

        emptyCount = strings.stream().filter(string->string.length() == 3).count();

        System.out.println("字符串长度为3 的数量为： " + emptyCount);

        List<String> filterList = strings.stream().filter(string->!string.isEmpty()).collect(Collectors.toList());

        System.out.println("筛选后列表: " + filterList);

        String mergeString  = strings.stream().filter(string->!string.isEmpty()).collect(Collectors.joining(", "));

        System.out.println("Merge String " + mergeString);

        List<Integer> numbers = Arrays.asList(1, 2, 13, 4, 15, 6, 17, 8, 19 );

        List<Integer> squareList = numbers.stream().map(i -> i*i).distinct().collect(Collectors.toList());

        System.out.println("SquareList " + squareList);
        System.out.println("列表：" + numbers);

        IntSummaryStatistics stats = numbers.stream().mapToInt((x)->x).summaryStatistics();

        System.out.println("列表中的最大值为： " + stats.getMax());
        System.out.println("列表中的最小值为：" + stats.getMin());
        System.out.println("所有数之和： " + stats.getSum());
        System.out.println("平均数： " + stats.getAverage());
        System.out.println("随机数：");

        Random random = new Random();

        random.ints().limit(10).sorted().forEach(System.out::println);

        long pcount = strings.parallelStream().filter(string->string.isEmpty()).count();

        System.out.println("空字符串数量为 " + pcount);


    }
}