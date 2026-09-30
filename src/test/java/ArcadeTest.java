import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.DisplayName;
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
    @DisplayName("Challenge 1: Arcade constructor stores fields")
    void arcadeConstructorStoresFields() {
        Arcade arcade = new Arcade("Arcade of Legions", "Variety", 1982);

        assertEquals("Arcade of Legions", arcade.getName(),
            "challenge1 failed - constructor/getName should store Arcade of Legions.");
        assertEquals("Variety", arcade.getType(),
            "challenge1 failed - constructor/getType should store Variety.");
        assertEquals(1982, arcade.getYear(),
            "challenge1 failed - constructor/getYear should store 1982.");
    }

    @Test
    @DisplayName("Challenge 2: setters update fields")
    void arcadeSettersUpdateFields() {
        Arcade arcade = new Arcade("Old Name", "Old Type", 1900);
        arcade.setName("New Name");
        arcade.setType("New Type");
        arcade.setYear(2000);

        assertEquals("New Name", arcade.getName(),
            "challenge2 failed - setName() should update the name.");
        assertEquals("New Type", arcade.getType(),
            "challenge2 failed - setType() should update the type.");
        assertEquals(2000, arcade.getYear(),
            "challenge2 failed - setYear() should update the year.");
    }

    @Test
    @DisplayName("Challenge 1: describe prints details")
    void describePrintsArcadeDetails() {
        Arcade arcade = new Arcade("Arcade of Legions", "Variety", 1982);
        String output = captureOutput(arcade::describe);

        assertTrue(output.contains("Arcade of Legions"),
            "challenge1 failed - describe() must print the arcade name.");
        assertTrue(output.contains("Variety"),
            "challenge1 failed - describe() must print the arcade type.");
        assertTrue(output.contains("1982"),
            "challenge1 failed - describe() must print the year 1982.");
    }

    @Test
    @DisplayName("Game class still works")
    void gameConstructorStillWorks() {
        Game game = new Game("Pokemon", 1996, "RPG");

        assertEquals("Pokemon", game.getName(),
            "failed - Game.getName() should still return Pokemon.");
        assertEquals(1996, game.getYear(),
            "failed - Game.getYear() should still return 1996.");
        assertEquals("RPG", game.getType(),
            "failed - Game.getType() should still return RPG.");
    }

    @Test
    @DisplayName("Challenge 3: Main creates Arcade and Games")
    void mainCreatesArcadeAndGameObjects() {
        String output = captureOutput(() -> Main.main(new String[] {}));

        assertTrue(output.contains("Arcade of Legions"),
            "challenge3 failed - Main should create Arcade of Legions and print its details.");
        assertTrue(output.contains("Pokemon"),
            "challenge3 failed - Main should create/print a Pokemon Game.");
        assertTrue(output.contains("Spaceball"),
            "challenge3 failed - Main should create/print a Spaceball Game.");
    }
}
