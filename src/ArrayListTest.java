import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayListTest {
    StringList out = new ArrayList(6);
    StringList out2 = new ArrayList(6);

    @BeforeEach
    public void setOut() {
        out.add("qwe");
        out.add("qwe2");
        out.add("qwe");
        out2.add("qwe");
        out2.add("qwe2");
        out2.add("qwe");
    }


    @Test
    void add() {
        String expected = out.add("abc");
        String actual = "abc";
        assertEquals(expected, actual);
    }

    @Test
    void testAdd() {
        String expected = out.add(1, "abc");
        String actual = "abc";
        assertEquals(expected, actual);
    }

    @Test
    void set() {
        String expected = out.add(1, "abc");
        String actual = "abc";
        assertEquals(expected, actual);
    }

    @Test
    void remove() {
        String expected = out.remove("qwe2");
        String actual = "qwe2";
        assertEquals(expected, actual);
    }

    @Test
    void testRemove() {
        String expected = out.remove(1);
        String actual = "qwe2";
        assertEquals(expected, actual);
    }

    @Test
    void contains() {
        out.add(1, "abc");
        boolean expected = out.contains("abc");
        boolean actual = true;
        assertEquals(expected, actual);
    }

    @Test
    void indexOf() {
        int expected = out.indexOf("qwe");
        int actual = 0;
        assertEquals(expected, actual);
    }

    @Test
    void lastIndexOf() {
        int expected = out.lastIndexOf("qwe");
        int actual = 2;
        assertEquals(expected, actual);
    }

    @Test
    void get() {
    }

    @Test
    void testEquals() {
        boolean expected = out.equals(out2);
        boolean actual = true;
        System.out.println(out.size());
        System.out.println(out2.size());
        assertEquals(expected, actual);
    }

    @Test
    void size() {
        int expected = out.size();
        int actual = 2;
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
    }
}