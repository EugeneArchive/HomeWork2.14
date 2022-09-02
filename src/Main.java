import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        StringList stringList = new ArrayList(2);
//        System.out.println(stringList.size());

//        System.out.println(stringList.add("rdtg1"));
//        System.out.println(stringList.add("rdtg2"));

//        stringList.add("rdtg0");
//        for (int i = 0; i < stringList.size(); i++) {
//            System.out.println(stringList.get(i));
//        }
//        stringList.add("rdtg1");
//        System.out.println(stringList.size());
//        for (int i = 0; i < stringList.size(); i++) {
//            System.out.println(stringList.get(i));
//        }
//        stringList.add("rdtg2");
//        stringList.add("rdtg3");
//        stringList.add("rdtg4");
//        stringList.add("rdtg5");
//        for (int i = 0; i < stringList.size(); i++) {
//            System.out.println(stringList.get(i));
//        }
//        System.out.println(stringList.size());
//        stringList.clear();
//        System.out.println(stringList.size());

        task1();
        task2();
        task3();

           }

    private static void swapElements(int[] arr, int indexA, int indexB) {
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }

    public static int[] generateRandomArray() {
        java.util.Random random = new java.util.Random();
        int[] arr = new int[100_000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100_000) + 100_000;
        }
        return arr;
    }
    public static void sortBubble(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swapElements(arr, j, j + 1);
                }
            }
        }
    }

    public static void sortSelection(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            swapElements(arr, i, minElementIndex);
        }
    }

    public static void sortInsertion(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }

    public static void task1() {
        int[] arr1 = generateRandomArray();
        long start = System.currentTimeMillis();
        sortBubble(arr1);
        System.out.println(System.currentTimeMillis() - start);
    }
    public static void task2() {
        int[] arr2 = generateRandomArray();
        long start = System.currentTimeMillis();
        sortSelection(arr2);
        System.out.println(System.currentTimeMillis() - start);
    }
    public static void task3() {
        int[] arr3 = generateRandomArray();
        long start = System.currentTimeMillis();
        sortInsertion(arr3);
        System.out.println(System.currentTimeMillis() - start);
    }

}