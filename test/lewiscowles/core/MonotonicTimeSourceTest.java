package lewiscowles.core;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.lessThan;

public class MonotonicTimeSourceTest {
    @Test
    public void monotonicTimeSourceAlwaysIncreases() {
        TimeSourceInterface timeSource = new MonotonicTimeSource();
        for (int i = 0; i < 1000000; i++) {
          assertThat( timeSource.getTime(), lessThan(timeSource.getTime()) );
        }
    }
}
