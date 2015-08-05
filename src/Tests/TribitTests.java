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
                {"0001", "0"}, //1
                {"0010", "0"}, //2
                {"0011", "0"}, //3
                {"0100", "0"}, //4
                {"0101", "0"}, //5
                {"0110", "1"}, //6
                {"0111", "1"}, //7
                {"1000", "0"}, //8
                {"1001", "0"}, //9
                {"1010", "1"}, //10
                {"1011", "1"}, //11
                {"1100", "1"}, //12
                {"1101", "1"}, //13
                {"1110", "1"}, //14
                {"1111", "1"}, //15
                {"0000000000000000", "0"}, // Tests on strings with length 16.
                {"1111111111111111", "1"}, //17
                {"0101101001011010", "1"}, //18
                {"1111000011110000", "1"}, //19
                {"1001011010010110", "0"}, //20
                {"0110110000110110", "1"}, //21
                {"1001100110011001", "0"}, //22
                {"1110111100111000", "1"}, // Test from description.
                {"1011101001101111100101110101100010101011011001100101001001101111", "0"}, // Test on strings with length 64.
                {"1100100100001111110110101010001000100001011010001100001000110100", "1"}  // Final description test.
        });
    }

    @Test
    public void primitiveTestsOnTribit() {
        Tribit testedTribit = new Tribit(input);
        String actual = testedTribit.countCheckSum();
        assertEquals(expected, actual);
    }

}
