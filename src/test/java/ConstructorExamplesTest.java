import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Constructor;
import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ConstructorExamplesTest {

    @Test
    @DisplayName("Bonus: multiple constructors")
    void classDefinesMultipleConstructors() {
        Constructor<?>[] constructors = ConstructorExamples.class.getDeclaredConstructors();

        assertTrue(constructors.length >= 2,
            "bonus failed - ConstructorExamples should have at least 2 constructors (overloading).");

        long differentParameterCounts = Arrays.stream(constructors)
            .map(Constructor::getParameterCount)
            .distinct()
            .count();

        assertTrue(differentParameterCounts >= 2,
            "bonus failed - constructors should use different parameter lists.");
    }

    @Test
    @DisplayName("Bonus: no-arg constructor works")
    void constructingAnObjectCreatesAUsableInstance() throws Exception {
        Constructor<?> noArg = Arrays.stream(ConstructorExamples.class.getDeclaredConstructors())
            .filter(c -> c.getParameterCount() == 0)
            .findFirst()
            .orElse(null);

        assertTrue(noArg != null,
            "bonus failed - include a no-argument constructor.");

        Object instance = noArg.newInstance();
        assertTrue(instance instanceof ConstructorExamples,
            "bonus failed - new ConstructorExamples() should create an instance.");
    }
}
