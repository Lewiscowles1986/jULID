package lewiscowles.core;


import java.security.SecureRandom;


public final class SecureRandomGenerator implements RandomGeneratorInterface {
    public double generate() {
        SecureRandom randGen = new SecureRandom();
        return randGen.nextDouble();
    }
}
