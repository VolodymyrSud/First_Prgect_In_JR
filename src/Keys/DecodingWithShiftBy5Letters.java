package Keys;

import java.io.File;

public class DecodingWithShiftBy5Letters extends Key{
    @Override
    public String readeFile(File file) {
        shiftLeft(5);
        String fileText = super.readeFile(file);
        return fileText.trim().replace("ґґґґґ", "ґ");
    }
}
