import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Constructor;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

class ConstructorExamplesTest {

    @Test
    void classDefinesMultipleConstructors() {
        Constructor<?>[] constructors = ConstructorExamples.class.getDeclaredConstructors();

        assertTrue(constructors.length >= 2,
            "ConstructorExamples should demonstrate constructor overloading.");

        long differentParameterCounts = Arrays.stream(constructors)
            .map(Constructor::getParameterCount)
            .distinct()
            .count();

        assertTrue(differentParameterCounts >= 2,
            "The constructors should accept different parameter lists.");
    }

    @Test
    void constructingAnObjectCreatesAUsableInstance() throws Exception {
        Constructor<?> noArg = Arrays.stream(ConstructorExamples.class.getDeclaredConstructors())
            .filter(c -> c.getParameterCount() == 0)
            .findFirst()
            .orElse(null);

        assertTrue(noArg != null,
            "The example should include a no-argument constructor.");

        Object instance = noArg.newInstance();
        assertTrue(instance instanceof ConstructorExamples,
            "Calling a constructor should create an instance of the class.");
    }
}
