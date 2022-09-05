import exceptions.BadRequest;
import exceptions.IncorrectNumberOfMassive;
import exceptions.ValueIsNullException;

import java.util.Arrays;

public class ArrayIntegerList implements IntegerList {

    private Integer[] integers;
    private int size;

    public ArrayIntegerList(int length) {
        integers = new Integer[length];
    }
    public ArrayIntegerList() {
        integers = new Integer[10];
    }

    private Integer[] grow() {
        int oldCapacity = integers.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        return integers = Arrays.copyOf(integers, newCapacity);
    }

    private void validateItem(Integer item) {
        if (item == null) {
            throw new ValueIsNullException("Строка пустая");
        }
    }

    private void validateIndex(int index) {
        if (index < 0 || index > size) {
            throw new IncorrectNumberOfMassive("Некорректный индекс");
        }
    }

//    private static void sortInsertion(Integer[] arr) {
//        for (int i = 1; i < arr.length; i++) {
//            int temp = arr[i];
//            int j = i;
//            while (j > 0 && arr[j - 1] >= temp) {
//                arr[j] = arr[j - 1];
//                j--;
//            }
//            arr[j] = temp;
//        }
//    }


    @Override
    public Integer add(Integer item) {
        validateItem(item);
        if (size == integers.length) {
            integers = grow();
        }
        integers[size++] = item;
        return item;
    }

    @Override
    public Integer add(int index, Integer item) {
        validateItem(item);
        validateIndex(index);
        if (size == index) {
            integers[size++] = item;
            return item;
        }
        if (size == integers.length) {
            integers = grow();
        }
        System.arraycopy(integers, index, integers, index + 1, size - index);
        integers[index] = item;
        size++;
        return item;
    }

    @Override
    public Integer set(int index, Integer item) {
        validateItem(item);
        validateIndex(index);
        integers[index] = item;
        return item;
    }

    @Override
    public Integer removeByItem(Integer item) {
        validateItem(item);
        int index = indexOf(item);
        if (index == -1) {
            throw new BadRequest("Элемент не найден!");
        }
        if (!(index == size)) {
            System.arraycopy(integers, index + 1, integers, index, size - index - 1);
        }
        size--;
        return item;
    }

    @Override
    public Integer remove(int index) {
        validateIndex(index);
        Integer item = integers[index];
        if (!(index == size)) {
            System.arraycopy(integers, index + 1, integers, index, size - index - 1);
        }
        size--;
        return item;
    }

    @Override
    public boolean contains(Integer item) {
        Integer[] integersCopy = toArray();
        quickSort(integersCopy, 0, size-1);
        return binaryFind(integers, item);
    }

    private static boolean binaryFind(Integer[] arr, Integer item) {
        int min = 0;
        int max = arr.length - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (item == arr[mid]) {
                return true;
            }

            if (item < arr[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }

    @Override
    public int indexOf(Integer item) {
        validateItem(item);
        for (int i = 0; i < size; i++) {
            if (integers[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        validateItem(item);
        for (int i = size - 1; i >= 0; i--) {
            if (integers[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        validateIndex(index);
        return integers[index];
    }

    @Override
    public boolean equals(IntegerList otherList) {
        if (Arrays.equals(this.integers, otherList.toArray())) {
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }



    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public Integer[] toArray() {
        return Arrays.copyOf(integers, size);
    }


    public static void quickSort(Integer[] arr, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, end);
        }
    }


    private static int partition(Integer[] arr, int begin, int end) {
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

    private static void swapElements(Integer[] arr, int indexA, int indexB) {
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }
}
