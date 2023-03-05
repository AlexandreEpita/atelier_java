package fr.epita.assistants.embedfiles;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Tst {

    @Test
    public void testWithExistingFile() {
        final var embedFile = new DisplayEmbedFile("other-sampltxt");
        final var result = embedFile.display().orElseThrow();
        assertTrue(result.contains("This is a sample"));
    }
}
