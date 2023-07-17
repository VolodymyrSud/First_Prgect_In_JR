package Keys;

import java.io.File;

public class EncodingWithShiftBy3Letters extends Key{
    @Override
    public String readeFile(File file) {
        shiftRight(3);
        String fileText = super.readeFile(file);
        return fileText.trim().replace(" ", "   ");
    }
}
