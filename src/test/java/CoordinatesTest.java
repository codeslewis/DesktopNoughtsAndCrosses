import game.Coordinates;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CoordinatesTest {
    @Test
    public void illegalArgThrows() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Coordinates("D1");
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Coordinates("B4");
        });
    }

    @Test
    public void xAndYCorrectForA1() {
        Coordinates a1 = new Coordinates("A1");
        int a1xExpect = 2;
        int a1yExpect = 0;

        Assertions.assertEquals(a1xExpect, a1.getX());
        Assertions.assertEquals(a1yExpect, a1.getY());
    }

    @Test
    public void xAndYCorrectForA2() {
        Coordinates a1 = new Coordinates("A2");
        int a1xExpect = 1;
        int a1yExpect = 0;

        Assertions.assertEquals(a1xExpect, a1.getX());
        Assertions.assertEquals(a1yExpect, a1.getY());
    }

    @Test
    public void xAndYCorrectForA3() {
        Coordinates a1 = new Coordinates("A3");
        int a1xExpect = 0;
        int a1yExpect = 0;

        Assertions.assertEquals(a1xExpect, a1.getX());
        Assertions.assertEquals(a1yExpect, a1.getY());
    }

    @Test
    public void xAndYCorrectForB1() {
        Coordinates a1 = new Coordinates("B1");
        int a1xExpect = 2;
        int a1yExpect = 1;

        Assertions.assertEquals(a1xExpect, a1.getX());
        Assertions.assertEquals(a1yExpect, a1.getY());
    }

    @Test
    public void xAndYCorrectForB2() {
        Coordinates a1 = new Coordinates("B2");
        int a1xExpect = 1;
        int a1yExpect = 1;

        Assertions.assertEquals(a1xExpect, a1.getX());
        Assertions.assertEquals(a1yExpect, a1.getY());
    }

    @Test
    public void xAndYCorrectForB3() {
        Coordinates a1 = new Coordinates("B3");
        int a1xExpect = 0;
        int a1yExpect = 1;

        Assertions.assertEquals(a1xExpect, a1.getX());
        Assertions.assertEquals(a1yExpect, a1.getY());
    }

    @Test
    public void xAndYCorrectForC1() {
        Coordinates a1 = new Coordinates("C1");
        int a1xExpect = 2;
        int a1yExpect = 2;

        Assertions.assertEquals(a1xExpect, a1.getX());
        Assertions.assertEquals(a1yExpect, a1.getY());
    }

    @Test
    public void xAndYCorrectForC2() {
        Coordinates a1 = new Coordinates("C2");
        int a1xExpect = 1;
        int a1yExpect = 2;

        Assertions.assertEquals(a1xExpect, a1.getX());
        Assertions.assertEquals(a1yExpect, a1.getY());
    }

    @Test
    public void xAndYCorrectForC3() {
        Coordinates a1 = new Coordinates("C3");
        int a1xExpect = 0;
        int a1yExpect = 2;

        Assertions.assertEquals(a1xExpect, a1.getX());
        Assertions.assertEquals(a1yExpect, a1.getY());
    }
}
