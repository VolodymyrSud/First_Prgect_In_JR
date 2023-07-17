package Keys;

import java.io.File;

public class EncodingWithShiftBy4Letters extends Key{
    @Override
    public String readeFile(File file) {
        shiftRight(4);
        String fileText = super.readeFile(file);
        return fileText.trim().replace(" ", "    ");
    }
}
