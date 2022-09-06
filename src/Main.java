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
        task4();
        task5();

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

    public static void task4() {
        int[] arr4 = generateRandomArray();
        long start = System.currentTimeMillis();
        quickSort(arr4,0, 99_999);
        System.out.println(System.currentTimeMillis() - start);
    }
    public static void task5() {
        int[] arr5 = generateRandomArray();
        long start = System.currentTimeMillis();
        mergeSort(arr5);
        System.out.println(System.currentTimeMillis() - start);
    }


    public static void quickSort(int[] arr, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, end);
        }
    }

    private static int partition(int[] arr, int begin, int end) {
        int pivot = arr[end];
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                swapElements(arr, i, j);
            }
        }

        swapElements(arr, i + 1, end);
        return i + 1;
    }


    public static void mergeSort(int[] arr) {
        if (arr.length < 2) {
            return;
        }
        int mid = arr.length / 2;
        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];

        for (int i = 0; i < left.length; i++) {
            left[i] = arr[i];
        }

        for (int i = 0; i < right.length; i++) {
            right[i] = arr[mid + i];
        }

        mergeSort(left);
        mergeSort(right);

        merge(arr, left, right);
    }

    public static void merge(int[] arr, int[] left, int[] right) {

        int mainP = 0;
        int leftP = 0;
        int rightP = 0;
        while (leftP < left.length && rightP < right.length) {
            if (left[leftP] <= right[rightP]) {
                arr[mainP++] = left[leftP++];
            } else {
                arr[mainP++] = right[rightP++];
            }
        }
        while (leftP < left.length) {
            arr[mainP++] = left[leftP++];
        }
        while (rightP < right.length) {
            arr[mainP++] = right[rightP++];
        }
    }

}