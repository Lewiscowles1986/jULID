package lewiscowles.core;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.equalTo;

public class UlidTest {

    protected Ulid mUlid;
    protected RandomGeneratorInterface mRG;
    protected TimeSourceInterface mTS;
    protected final long TIME = 1469918176385l;

    @BeforeEach
    public void setUp() {
        mTS = new SystemTimeSource();
        mRG = new SecureRandomGenerator();
        mUlid = new Ulid(mTS, mRG);
    }

    @Test
    public void newUlidShouldReturnCorrectLength() {
        String hash = mUlid.get();
        assertThat(hash.length(), equalTo(26));
    }

    @Test
    public void getRandIsGreaterThanZero() {
        assertThat( mRG.generate(), greaterThan(0.0) );
    }

    @Test
    public void getRandIsLessThanOne() {
        assertThat( mRG.generate(), lessThan(1.0) );
    }

    @Test
    public void encodeTimeShouldReturnExpectedEncodedResult()
    {
        String hash = mUlid.encodeTime(TIME, 10);
        assertThat(hash, equalTo("01ARYZ6S41"));
    }

    @Test
    public void encodeTimeShouldChangeLengthProperly()
    {
        String hash = mUlid.encodeTime(TIME,12);
        assertThat(hash, equalTo("0001ARYZ6S41"));
    }

    @Test
    public void encodeTimeShouldTruncateTimeIfNotLongEnough()
    {
        String hash = mUlid.encodeTime(TIME, 8);
        assertThat(hash, equalTo("ARYZ6S41"));
    }

    @Test
    public void encodeRandomShouldReturnCorrectLength()
    {
        int length = 12;
        String hash = mUlid.encodeRandom(length);
        assertThat(hash.length(), equalTo(length));
    }

}
