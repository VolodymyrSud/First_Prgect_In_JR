import Keys.Constants;
import Keys.Key;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CeasarCypher {
    public static final String ALPHABET = "абвгґдеєжзиіїйклмнопрстуфхцчшщьюя.,\":-!? ";

    public void encode(String sourceFileName, String targetFileName, Key key) {
        String fileText = key.readeFile(new File(sourceFileName));
        StringBuilder textBuilder = new StringBuilder();
        for (char ch : fileText.toCharArray()) {
            int index = ALPHABET.indexOf(ch);
            if (index != Constants.LAST_POINT) {
                int encryptedIndex = (index + key.getShift()) % ALPHABET.length();
                textBuilder.append(ALPHABET.charAt(encryptedIndex));
            } else {
                textBuilder.append(ch);
            }
        }
        saveToFile(targetFileName, textBuilder.toString());
    }

    public void decode(String sourceFileName, String targetFileName, Key key) {
        String fileText = key.readeFile(new File(sourceFileName));
        StringBuilder textBuilder = new StringBuilder();
        for (char ch : fileText.toCharArray()) {
            int index = ALPHABET.indexOf(ch);
            if (index != Constants.LAST_POINT) {
                int decryptedIndex = (index - key.getShift() + ALPHABET.length()) % ALPHABET.length();
                textBuilder.append(ALPHABET.charAt(decryptedIndex));
            } else {
                textBuilder.append(ch);
            }
        }
        saveToFile(targetFileName, textBuilder.toString());
    }

    private void saveToFile(String fileName, String text) {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(text);
        } catch (IOException e) {
            System.out.println("Error saving to file: " + e.getMessage());
        }
    }
}
