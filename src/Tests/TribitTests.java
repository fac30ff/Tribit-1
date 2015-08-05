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
    private String output;

    public TribitTests(String input, String output) {
        this.input = input;
        this.output = output;
    }

    @Parameterized.Parameters
    public static List testStrings() {
        return Arrays.asList(new Object[][]{
                {"0000", "0"}, // Tests on strings with length 4.
                {"0001", "0"},
                {"0010", "0"},
                {"0011", "0"},
                {"0100", "0"},
                {"0101", "0"},
                {"0110", "1"},
                {"0111", "1"},
                {"1000", "0"},
                {"1001", "0"},
                {"1010", "1"},
                {"1011", "1"},
                {"1100", "1"},
                {"1101", "1"},
                {"1110", "1"},
                {"1111", "1"},
                {"0000000000000000", "0"}, // Tests on strings with length 16.
                {"1111111111111111", "1"},
                {"0101101001011010", "1"},
                {"1111000011110000", "1"},
                {"1001011010010110", "0"},
                {"0110110000110110", "1"},
                {"1001100110011001", "0"},
                {"1110111100111000", "1"}, // Test from description.
                {"1011101001101111100101110101100010101011011001100101001001101111", "0"}, // Test on strings with length 64.
                {"1100100100001111110110101010001000100001011010001100001000110100", "1"}  // Final description test.
        });
    }

    @Test
    public void primitiveTestsOnTribit() {
        Tribit testedTribit = new Tribit();
        String a = testedTribit.countCheckSum(input);
        assertEquals(a, output);
    }

}
