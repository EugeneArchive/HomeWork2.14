import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        StringList stringList = new ArrayList(2);
       System.out.println(stringList.size());

//        System.out.println(stringList.add("rdtg1"));
//        System.out.println(stringList.add("rdtg2"));

        stringList.add("rdtg3");
        stringList.add("rdtg1");
        stringList.add("rdtg32");
        stringList.add("rdtg32");
        stringList.add("rdtg32");
        stringList.add("rdtg32");
        for (int i = 0; i < stringList.size(); i++) {
            System.out.println(stringList.get(i));
        }
        System.out.println(stringList.size());
        stringList.clear();
        System.out.println(stringList.size());
    }
}