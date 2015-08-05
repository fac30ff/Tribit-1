package Tests;

import Realization.Tribit;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Created by Polina on 05-Aug-15.
 */

@RunWith(Parameterized.class)
public class TestCheckLength {

    private String input;
    private int expected;


    public TestCheckLength(String input, int expected) {
        this.input = input;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
        /*0*/        {"abc", -1},
        /*1*/        {"1111", 1},
        /*2*/        {"1111000011110000", 2},
        /*3*/        {"1234567890123456123456789012345612345678901234561234567890123456", 3},
        /*4*/        {"12345678901234561234567890123456", -1},
        /*5*/        {"123456789012", -1},
        /*6*/        {"12345",-1},
        /*7*/        {"1", -1}
        });
    }

    @Test
    public void testCheckLength() {
        Tribit testedTribit = new Tribit();
        int actual = testedTribit.checkLength(input);
        assertEquals(expected, actual);
    }
}
