package Tests;

import Realization.Segment;
import Realization.Triangle;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Polina on 05-Aug-15.
 */
public class SmallFunctionsTests {

    @Test
    public void testSegmentConstruction1() {
        final String line1 = new String("100010001");
        final String line2 = new String("00010001000");
        final int number = 3;
        List<Triangle> expected = new ArrayList<Triangle>();
        for (int i = 0; i < 5; i++) {
            expected.add(new Triangle("1", "000"));
        }
        Segment tested = new Segment(line1, line2, number);
        List<Triangle> actual = tested.getTriangles();
        assertEquals(expected, actual);
    }

    @Test
    public void testSegmentConstruction2() {
        final String line1 = new String("111111111");
        final String line2 = new String("00000000000");
        final int number = 3;
        List<Triangle> expected = new ArrayList<Triangle>();
        expected.add(new Triangle("1", "000"));
        expected.add(new Triangle("0", "111"));
        expected.add(new Triangle("1", "000"));
        expected.add(new Triangle("0", "111"));
        expected.add(new Triangle("1", "000"));
        Segment tested = new Segment(line1, line2, number);
        List<Triangle> actual = tested.getTriangles();
        assertEquals(expected, actual);
    }

    @Test
    public void testSegmentConstruction3() {
        final String line1 = new String("1000100010001000100010001");
        final String line2 = new String("000100010001000100010001000");
        final int number = 7;
        List<Triangle> expected = new ArrayList<Triangle>();
        for (int i = 0; i < 13; i++) {
            expected.add(new Triangle("1", "000"));
        }
        Segment tested = new Segment(line1, line2, number);
        List<Triangle> actual = tested.getTriangles();
        assertEquals(expected, actual);
    }

    @Test
    public void testPermutateSegment1() {
        final String line1 = new String("100010001");
        final String line2 = new String("00010001000");
        final int number = 3;
        String expected = "00000";
        Segment tested = new Segment(line1, line2, number);
        String actual = tested.permutateSegment();
        assertEquals(expected, actual);
    }

    @Test
    public void testPermutateSegment2() {
        final String line1 = new String("111111111");
        final String line2 = new String("00000000000");
        final int number = 3;
        String expected = "01010";
        Segment tested = new Segment(line1, line2, number);
        String actual = tested.permutateSegment();
        assertEquals(expected, actual);
    }

}
