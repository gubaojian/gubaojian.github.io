import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

public class Java8Tester{
    public static void main(String [] args){
        List<String> names = new ArrayList<String>();
        names.add("Google");
        names.add("Runoob");
        names.add("Taobao");
        names.add("Baidu");
        names.add("Sina ");

        Collections.sort(names, new Comparator<String>(){

            @Override
            public int compare(String s1, String s2){
                return s1.compareTo(s2);
            }
        });

        System.out.println(names);

        Collections.sort(names, (s1,s2)-> s2.compareTo(s1));

        System.out.println(names);

        names.forEach(System.out::println);

    }
}