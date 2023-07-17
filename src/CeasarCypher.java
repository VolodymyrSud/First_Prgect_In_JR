import Keys.Key;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CeasarCypher {
    public static final String ALPHABET = "абвгґдеєжзиіїйклмнопрстуфхцчшщьюя.,\":-!? ";

    public void encode(String sourceFileName, String targetFileName, Key key) {
        String fileText = key.readeFile(new File(sourceFileName));
        StringBuilder cipherText = new StringBuilder();
        for (char ch : fileText.toCharArray()) {
            int index = ALPHABET.indexOf(ch);
            if (index != -1) {
                int encryptedIndex = (index + key.getShift()) % ALPHABET.length();
                cipherText.append(ALPHABET.charAt(encryptedIndex));
            } else {
                cipherText.append(ch);
            }
        }
        saveToFile(targetFileName, cipherText.toString());
    }

    public void decode(String sourceFileName, String targetFileName, Key key) {
        String fileText = key.readeFile(new File(sourceFileName));

        StringBuilder plainText = new StringBuilder();

        for (char ch : fileText.toCharArray()) {
            int index = ALPHABET.indexOf(ch);
            if (index != -1) {
                int decryptedIndex = (index - key.getShift() + ALPHABET.length()) % ALPHABET.length();
                plainText.append(ALPHABET.charAt(decryptedIndex));
            } else {
                plainText.append(ch);
            }
        }
        saveToFile(targetFileName, plainText.toString());
    }

    private void saveToFile(String fileName, String text) {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(text);
        } catch (IOException e) {
            System.out.println("Error saving to file: " + e.getMessage());
        }
    }
}
