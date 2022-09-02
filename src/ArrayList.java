
import exceptions.*;

import java.util.Arrays;

public class ArrayList implements StringList {
    private String[] items;
    private int size;

    public ArrayList(int length) {
        items = new String[length];
    }

    public ArrayList() {
        items = new String[10];
    }

    private String[] grow() {
        int oldCapacity = items.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        return items = Arrays.copyOf(items, newCapacity);
    }

    private void validateSize() {
        if (size == items.length) {
            throw new StorageIsFullException();
        }
    }

    private void validateItem(String item) {
        if (item == null) {
            throw new ValueIsNullException("Строка пустая");
        }
    }

    private void validateIndex(int index) {
        if (index < 0 || index > size) {
            throw new IncorrectNumberOfMassive("Некорректный индекс");
        }
    }

    @Override
    public String add(String item) {
        validateItem(item);
        if (size == items.length) {
            items = grow();
        }
        items[size++] = item;
        return item;
    }


    @Override
    public String add(int index, String item) {
        validateItem(item);
        validateIndex(index);
        if (size == index) {
            items[size++] = item;
            return item;
        }
        if (size == items.length) {
            items = grow();
        }
        System.arraycopy(items, index, items, index + 1, size - index);
        items[index] = item;
        size++;
        return item;
    }

    @Override
    public String set(int index, String item) {
        validateItem(item);
        validateIndex(index);

        items[index] = item;
        return item;
    }

    @Override
    public String remove(String item) {
        validateItem(item);
        int index = indexOf(item);
        if (index == -1) {
            throw new BadRequest("Элемент не найден!");
        }
        if (!(index == size)) {
            System.arraycopy(items, index + 1, items, index, size - index - 1);
        }
        size--;
        return item;
    }


    @Override
    public String remove(int index) {
        validateIndex(index);

        String item = items[index];
        if (!(index == size)) {
            System.arraycopy(items, index + 1, items, index, size - index - 1);
        }
        size--;
        return item;
    }

    @Override
    public boolean contains(String item) {
//        validateItem(item);
//        for (int i = 0; i < size; i++) {
//            if (items[i].contains(item))
//                return true;
//        }
//        return false;
        return indexOf(item) != -1;
    }

    @Override
    public int indexOf(String item) {
        validateItem(item);
        for (int i = 0; i < size; i++) {
            if (items[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        validateItem(item);
        for (int i = size - 1; i >= 0; i--) {
            if (items[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        validateIndex(index);
        return items[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        if (Arrays.equals(this.items, otherList.toArray())) {
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
//        for (int i = 0; i < size; i++) {
//           items[i] = null;
//        }
        size = 0;
    }

    @Override
    public String[] toArray() {
        return Arrays.copyOf(items, size);
    }
}
