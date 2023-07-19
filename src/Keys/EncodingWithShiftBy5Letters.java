package Keys;

import java.io.File;

public class EncodingWithShiftBy5Letters extends Key{
    @Override
    public String readeFile(File file) {
        shiftRight(Constants.SHIFT_ON_5);
        String fileText = super.readeFile(file);
        return fileText.trim().replace(Constants.SPACE, Constants.KEY_ENCODING_5_SPACES);
    }
}
