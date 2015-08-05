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
public class TestSegmentCounter {

    private int input;
    private int expected;

    public TestSegmentCounter(int input, int expected) {
        this.input = input;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
        /*0*/        {1, 1},
        /*1*/        {4, 2},
        /*2*/        {9, 3},
        /*3*/        {16, 4},
        /*4*/        {25, 5}
        });
    }

    @Test
    public void testSegmentCounter() throws Exception {
        Tribit testedTribit = new Tribit();
        int actual = testedTribit.segmentsCounter(input);
        assertEquals(expected,actual);
    }
}
