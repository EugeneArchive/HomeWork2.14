
import exceptions.BadRequest;
import exceptions.IncorrectNumberOfMassive;
import exceptions.ValueISNullException;

import java.util.Arrays;

public class ArrayList implements StringList {
    private String[] items;
    private int realSize = 0;

    public ArrayList(int size) {
        this.items = new String[size];
    }

    private String[] grow() {
        int oldCapacity = items.length;
        // int newCapacity = oldCapacity + (oldCapacity >> 1) + 1;
        int newCapacity = oldCapacity + 1;
        return items = Arrays.copyOf(items, newCapacity);
    }

    private void checkNull(String item) {
        if (item == null) {
            throw new ValueISNullException("Строка пустая");
        }
    }

    @Override
    public String add(String item) {
        checkNull(item);
        for (int i = 0; i < items.length; i++) {
            if (items[i] == null) {
                items[i] = item;
                realSize++;
                return item;
            }
        }

        items = grow();
        items[items.length - 1] = item;
        realSize++;
        return item;
    }


    @Override
    public String add(int index, String item) {
        checkNull(item);
        items[index] = item;
        realSize++;
        return item;
    }

    @Override
    public String set(int index, String item) {
        checkNull(item);
        if (index >= items.length) {
            throw new IncorrectNumberOfMassive("Индекс добавления от 0 до " + (items.length - 1));
        }
        items[index] = item;
        realSize++;
        return item;
    }

    @Override
    public String remove(String item) {
        checkNull(item);
        for (int i = 0; i < size(); i++) {
            if (items[i] == item) {
                String r = items[i];
                items[i] = null;
                return r;
            }
        }
        throw new BadRequest("Элемент не найден!");
    }

    @Override
    public String remove(int index) {
        if (index >= items.length || index > size()) {
            throw new BadRequest("Элемент не найден!");
        }
        String r = items[index];
        items[index] = null;
        return r;
    }

    @Override
    public boolean contains(String item) {
        checkNull(item);
        for (int i = 0; i < items.length; i++) {
            if (items[i] == null) {
                continue;
            }
            if(items[i].contains(item))
                return true;
        }
        return false;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < items.length - 1; i++) {
            if (items[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = items.length - 1; i > 0; i--) {
            if (items[i] == null) {
                continue;
            }
            if (items[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        if (index >= items.length) {
            throw new IncorrectNumberOfMassive("Индекс добавления от 0 до " + (items.length - 1));
        }
        return items[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        if (otherList == null) {
            throw new BadRequest("Неверные данные!");
        }
        if (Arrays.equals(items, otherList.toArray())) {
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return realSize;
    }


    @Override
    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size(); i++) {
           items[i] = null;
        }
        realSize = 0;
    }

    @Override
    public String[] toArray() {
        return new String[0];
    }
}
