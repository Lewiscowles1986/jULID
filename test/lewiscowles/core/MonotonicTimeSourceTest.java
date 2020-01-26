package lewiscowles.core;

import static org.junit.Assert.assertThat;

import static org.hamcrest.Matchers.lessThan;

import org.junit.Test;

public class MonotonicTimeSourceTest {
    @Test
    public void monotonicTimeSourceAlwaysIncreases() {
        TimeSourceInterface timeSource = new MonotonicTimeSource();
        for (int i = 0; i < 1000000; i++) {
          assertThat( timeSource.getTime(), lessThan(timeSource.getTime()) );
        }
    }
}
