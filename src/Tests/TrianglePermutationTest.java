package Tests;

import Realization.Triangle;
import Realization.Tribit;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Polina on 09-Aug-15.
 */

@RunWith(Parameterized.class)
public class TrianglePermutationTest {
    private String input;
    private String expected;

    public TrianglePermutationTest(String input, String expected) {
        this.input = input;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static List testStrings() {
        return Arrays.asList(new Object[][]{
                {"0000", "0"}, //0
                {"0001", "0"}, //1
                {"0010", "0"}, //2
                {"1100", "0"}, //3
                {"0100", "0"}, //4
                {"1010", "0"}, //5
                {"0110", "1"}, //6
                {"0111", "1"}, //7
                {"1000", "0"}, //8
                {"1001", "0"}, //9
                {"0101", "1"}, //10
                {"1011", "1"}, //11
                {"0011", "1"}, //12
                {"1101", "1"}, //13
                {"1110", "1"}, //14
                {"1111", "1"}, //15
        });
    }

    @Test
    public void primitiveTestsOnTribit() {
        String firstBit = input.substring(0, 1);
        String lastBits = input.substring(1);
        Triangle testedTriangle = new Triangle(firstBit, lastBits);
        try {
            testedTriangle.permutate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String actual = testedTriangle.getFirstBit();
        assertEquals(expected, actual);
    }
}
