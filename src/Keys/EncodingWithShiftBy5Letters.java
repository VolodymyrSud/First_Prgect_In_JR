package Keys;

import java.io.File;

public class EncodingWithShiftBy5Letters extends Key{
    @Override
    public String readeFile(File file) {
        shiftRight(5);
        String fileText = super.readeFile(file);
        return fileText.trim().replace(" ", "     ");
    }
}
