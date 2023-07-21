package Keys;

import java.io.File;

public class DecodingWithShiftBy5Letters extends Key{
    @Override
    public String readeFile(File file) {
        shiftLeft(Constants.SHIFT_ON_5);
        String fileText = super.readeFile(file);
        return fileText.trim().replace(Constants.KEY_DECODING_5_SPACES, Constants.SPACE_5_SYMBOLS_RIGHT);
    }
}
