package Tests;

import Realization.Segment;
import Realization.Tribit;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Polina on 11-Aug-15.
 */
@RunWith(Parameterized.class)
public class TribitConstructionTests {

    private String input;
    private List<Segment> expected;

    public TribitConstructionTests(String input, List<Segment> expected) {
        this.input = input;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static List testStrings() {
        return Arrays.asList(new Object[][]{
                {"0000", Arrays.asList(new Segment("0", "000", 1))}, // Tests on strings with length 4. (Test #0)
                {"1000", Arrays.asList(new Segment("0", "001", 1))}, //1
                {"0100", Arrays.asList(new Segment("0", "010", 1))}, //2
                {"1100", Arrays.asList(new Segment("0", "011", 1))}, //3
                {"0010", Arrays.asList(new Segment("0", "100", 1))}, //4
                {"1010", Arrays.asList(new Segment("0", "101", 1))}, //5
                {"0110", Arrays.asList(new Segment("0", "110", 1))}, //6
                {"1110", Arrays.asList(new Segment("0", "111", 1))}, //7
                {"0001", Arrays.asList(new Segment("1", "000", 1))}, //8
                {"1001", Arrays.asList(new Segment("1", "001", 1))}, //9
                {"0101", Arrays.asList(new Segment("1", "010", 1))}, //10
                {"1101", Arrays.asList(new Segment("1", "011", 1))}, //11
                {"0011", Arrays.asList(new Segment("1", "100", 1))}, //12
                {"1011", Arrays.asList(new Segment("1", "101", 1))}, //13
                {"0111", Arrays.asList(new Segment("1", "110", 1))}, //14
                {"1111", Arrays.asList(new Segment("1", "111", 1))}, //15
                {"0000000000000000", Arrays.asList(new Segment("0", "000", 1),
                        new Segment("00000", "0000000", 2))}, // Tests on strings with length 16.
                {"1111111111111111", Arrays.asList(new Segment("1", "111", 1),
                        new Segment("11111", "1111111", 2))}, //17
                {"0101101001011010", Arrays.asList(new Segment("0", "101", 1),
                        new Segment("10100", "1011010", 2))}, //18
                {"0000111100001111", Arrays.asList(new Segment("1", "111", 1),
                        new Segment("00001", "1110000", 2))}, //19
                {"0110100101101001", Arrays.asList(new Segment("1", "001", 1),
                        new Segment("01101", "0010110", 2))}, //20
                {"0110110000110110", Arrays.asList(new Segment("0", "110", 1),
                        new Segment("11000", "0110110", 2))}, //21
                {"1001100110011001", Arrays.asList(new Segment("1", "001", 1),
                        new Segment("10011", "0011001", 2))}, //22
                {"0001110011110111", Arrays.asList(new Segment("1", "110", 1),
                        new Segment("11110", "0111000", 2))}, // Test from description.
                {"1111011001001010011001101101010100011010111010011111011001011101",
                        Arrays.asList(new Segment("1", "011", 1),
                                new Segment("10100", "1101111", 2), new Segment("100101110", "10110001010", 3),
                                new Segment("1011011001100", "101001001101111", 4))}, // Test on strings with length 64.
                {"1100100100001111110110101010001000100001011010001100001000110100",
                        Arrays.asList(new Segment("0", "010", 1),
                                new Segment("11000", "1000011", 2), new Segment("000101101", "00001000100", 3),
                                new Segment("0101010110111", "111000010010011", 4))}  // Final description test.
        });
    }

    @Test
    public void primitiveTestsOnTribit() {
        Tribit testedTribit = null;
        try {
            testedTribit = new Tribit(input);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assert testedTribit != null;
        List<Segment> actual = testedTribit.getSegmentsList();
        assertEquals(expected, actual);
    }

}
