package lewiscowles.core;


import java.security.SecureRandom;
import static java.lang.Math.random;


public final class SecureRandomGenerator implements RandomGeneratorInterface {
    public double generate() {
        try {
            SecureRandom randGen = new SecureRandom();
            return randGen.nextDouble();
        } catch(Exception e) {
            e.getMessage();
        }
        return random();
    }
}
