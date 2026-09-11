import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

class ArcadeTest {

    private String captureOutput(Runnable action) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;

        try {
            System.setOut(new PrintStream(outputStream));
            action.run();
            return outputStream.toString();
        } finally {
            System.setOut(originalOut);
        }
    }

    @Test
    void arcadeConstructorStoresFields() {
        Arcade arcade = new Arcade("Arcade of Legions", "Variety", 1982);

        assertEquals("Arcade of Legions", arcade.getName(),
            "The arcade name should be stored by the constructor.");
        assertEquals("Variety", arcade.getType(),
            "The arcade type should be stored by the constructor.");
        assertEquals(1982, arcade.getYear(),
            "The arcade year should be stored by the constructor.");
    }

    @Test
    void arcadeSettersUpdateFields() {
        Arcade arcade = new Arcade("Old Name", "Old Type", 1900);

        arcade.setName("New Name");
        arcade.setType("New Type");
        arcade.setYear(2000);

        assertEquals("New Name", arcade.getName(),
            "setName() should update the arcade name.");
        assertEquals("New Type", arcade.getType(),
            "setType() should update the arcade type.");
        assertEquals(2000, arcade.getYear(),
            "setYear() should update the arcade year.");
    }

    @Test
    void describePrintsArcadeDetails() {
        Arcade arcade = new Arcade("Arcade of Legions", "Variety", 1982);

        String output = captureOutput(arcade::describe);

        assertTrue(output.contains("Arcade of Legions"),
            "describe() should print the arcade name.");
        assertTrue(output.contains("Variety"),
            "describe() should print the arcade type.");
        assertTrue(output.contains("1982"),
            "describe() should print the arcade opening year.");
    }

    @Test
    void gameConstructorStillWorks() {
        Game game = new Game("Pokemon", 1996, "RPG");

        assertEquals("Pokemon", game.getName(),
            "Game should still store its name after adding the Arcade class.");
        assertEquals(1996, game.getYear(),
            "Game should still store its year after adding the Arcade class.");
        assertEquals("RPG", game.getType(),
            "Game should still store its type after adding the Arcade class.");
    }

    @Test
    void mainCreatesArcadeAndGameObjects() {
        String output = captureOutput(() -> Main.main(new String[]{}));

        assertTrue(output.contains("Arcade of Legions"),
            "Main should create an Arcade and print its details.");
        assertTrue(output.contains("Pokemon"),
            "Main should still create and display Game objects.");
        assertTrue(output.contains("Spaceball"),
            "Main should still create and display Game objects.");
    }
}
