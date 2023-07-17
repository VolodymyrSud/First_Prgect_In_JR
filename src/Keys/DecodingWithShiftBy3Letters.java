package Keys;

import java.io.File;

public class DecodingWithShiftBy3Letters extends Key{
    @Override
    public String readeFile(File file) {
        shiftLeft(3);
        String fileText = super.readeFile(file);
        return fileText.trim().replace("ввв", "в");
    }
}
