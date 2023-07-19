package Keys;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Key {
    public static int shift;

    public int getShift() {
        return shift;
    }

    public String readeFile(File file){
        StringBuilder content = new StringBuilder();
        String filePath = file.getPath();
        try (FileReader reader = new FileReader(filePath)) {
            int character;
            while ((character = reader.read()) != Constants.LAST_POINT) {
                content.append((char) character);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return content.toString();
    }

    protected int shiftRight(int shift) {
        Key.shift = shift;
        return shift;
    }

    protected int shiftLeft(int shift) {
        Key.shift = shift;
        return -shift;
    }
}