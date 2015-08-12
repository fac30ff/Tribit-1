package Tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by Polina on 12-Aug-15.
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({
        SegmentOperationsTests.class,
        TestCheckLength.class,
        TestSegmentCounter.class,
        TrianglePermutationTest.class,
        TribitConstructionTests.class,
        TribitTests.class
})
public class TestRunner {
}
