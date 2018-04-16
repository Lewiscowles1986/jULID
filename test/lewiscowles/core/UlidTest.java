package lewiscowles.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertThat;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;

import org.junit.Before;
import org.junit.Test;

public class UlidTest {

    protected Ulid mUlid;
    protected RandomGeneratorInterface mRG;
    protected TimeSourceInterface mTS;
    protected final long TIME = 1469918176385l;

    @Before
    public void setUp() {
        mTS = new SystemTimeSource();
        mRG = new SecureRandomGenerator();
        mUlid = new Ulid(mTS, mRG);
    }

    @Test
    public void newUlidShouldReturnCorrectLength() {
        String hash = mUlid.get();
        assertEquals( hash.length(), 26 );
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
        assertEquals("01ARYZ6S41", hash);
    }

    @Test
    public void encodeTimeShouldChangeLengthProperly()
    {
        String hash = mUlid.encodeTime(TIME,12);
        assertEquals("0001ARYZ6S41", hash);
    }

    @Test
    public void encodeTimeShouldTruncateTimeIfNotLongEnough()
    {
        String hash = mUlid.encodeTime(TIME, 8);
        assertEquals("ARYZ6S41", hash);
    }

    @Test
    public void encodeRandomShouldReturnCorrectLength()
    {
        long length = 12;
        String hash = mUlid.encodeRandom(length);
        assertEquals(length, hash.length());
    }

}
