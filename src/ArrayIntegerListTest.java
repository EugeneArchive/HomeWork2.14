import exceptions.BadRequest;
import exceptions.IncorrectNumberOfMassive;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ArrayIntegerListTest {
    IntegerList out = new ArrayIntegerList(3);
    IntegerList out2 = new ArrayIntegerList(3);

    @BeforeEach
    public void setOut() {
        out.add(12);
        out.add(13);
        out.add(14);
        out2.add(12);
        out2.add(13);
        out2.add(14);
    }

    @Test
    void add() {
        Integer expected = out.add(15);
        Integer actual = 15;
        assertEquals(expected, actual);
    }

    @Test
    void testAdd() {
        Integer expected = out.add(1, 15);
        Integer actual = 15;
        assertEquals(expected, actual);
    }

    @Test
    void set() {
        Integer expected = out.add(1, 15);
        Integer actual = 15;
        assertEquals(expected, actual);
    }

    @Test
    void remove() {
        Integer expected = out.removeByItem(12);
        Integer actual = 12;
        assertEquals(expected, actual);
    }

    @Test
    void testRemove() {
        Integer expected = out.remove(1);
        Integer actual = 13;
        assertEquals(expected, actual);
    }

    @Test
    void contains() {
        boolean expected = out.contains(12);
        boolean actual = true;
        assertEquals(expected, actual);
    }

    @Test
    void indexOf() {
        int expected = out.indexOf(12);
        int actual = 0;
        assertEquals(expected, actual);
    }

    @Test
    void lastIndexOf() {
        int expected = out.indexOf(13);
        int actual = 1;
        assertEquals(expected, actual);
    }

    @Test
    void get() {
        int expected = out.get(1);
        int actual = 13;
        assertEquals(expected, actual);
    }

    @Test
    void testEquals() {

        boolean expected = out.equals(out2);
        boolean actual = true;

        assertEquals(expected, actual);
    }

    @Test
    void size() {
        int expected = out.size();
        int actual = 3;
        assertEquals(expected, actual);
    }

    @Test
    void isEmpty() {
        out.clear();
        boolean expected = out.isEmpty();
        boolean actual = true;
        assertEquals(expected, actual);
    }


    @Test
    void clear() {
        out.clear();
        int expected = out.size();
        int actual = 0;
        assertEquals(expected, actual);
    }

    @Test
    void toArray() {
        Integer[] a = {12, 13, 14};
        boolean expected = Arrays.equals(out.toArray(), a);
        boolean actual = true;
        assertEquals(expected, actual);
    }

    @Test
    public void shouldThrowIllegalArgumentException() {
        assertThrows(BadRequest.class, () -> out.removeByItem(15));
        assertThrows(IncorrectNumberOfMassive.class, () -> out.remove(7));
        assertThrows(IncorrectNumberOfMassive.class, () -> out.get(7));
    }
}