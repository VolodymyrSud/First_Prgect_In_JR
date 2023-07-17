package Keys;

import java.io.File;

public class DecodingWithShiftBy4Letters extends Key{
    @Override
    public String readeFile(File file) {
        shiftLeft(4);
        String fileText = super.readeFile(file);
        return fileText.trim().replace("гггг", "г");
    }
}
