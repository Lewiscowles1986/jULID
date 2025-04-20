package lewiscowles.core;


import java.security.SecureRandom;
import java.util.Random;


public final class SecureRandomGenerator implements RandomGeneratorInterface {

    private final Random random;

    public SecureRandomGenerator() {
        this(new SecureRandom());
    }

    public SecureRandomGenerator(Random random) {
        this.random = random;
    }

    @Override
    public double generate() {
        return this.random.nextDouble();
    }
}
