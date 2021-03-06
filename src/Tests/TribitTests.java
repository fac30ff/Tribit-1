package Tests;

import Realization.Tribit;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Polina on 05-Aug-15.
 */

@RunWith(Parameterized.class)
public class TribitTests {

    private String input;
    private String expected;

    public TribitTests(String input, String expected) {
        this.input = input;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static List testStrings() {
        return Arrays.asList(new Object[][]{
                {"0000", "0"}, // Tests on strings with length 4. (Test #0)
                {"1000", "0"}, //1
                {"0100", "0"}, //2
                {"1100", "1"}, //3
                {"0010", "0"}, //4
                {"1010", "1"}, //5
                {"0110", "1"}, //6
                {"1110", "1"}, //7
                {"0001", "0"}, //8
                {"1001", "0"}, //9
                {"0101", "0"}, //10
                {"1101", "1"}, //11
                {"0011", "0"}, //12
                {"1011", "1"}, //13
                {"0111", "1"}, //14
                {"1111", "1"}, //15
                {"0000000000000000", "0"}, // Tests on strings with length 16.
                {"1111111111111111", "1"}, //17
                {"0101101001011010", "0"}, //18
                {"0000111100001111", "0"}, //19
                {"0110100101101001", "1"}, //20
                {"0110110000110110", "1"}, //21
                {"1001100110011001", "0"}, //22
                {"1110111100111000", "1"}, // Test from description.
                {"0011111010101100", "1"}, //24
                {"0011111010100011", "1"}, //25
                {"1111011001001010011001101101010100011010111010011111011001011101", "1"}, // Test on strings with length 64.
                {"1100100100001111110110101010001000100001011010001100001000110100", "1"}  // Final description test.

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
        String actual = testedTribit.countCheckSum();
        assertEquals(expected, actual);
    }

}
