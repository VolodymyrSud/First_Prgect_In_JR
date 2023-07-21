package Keys;

import java.io.File;

public class DecodingWithShiftBy3Letters extends Key{
    @Override
    public String readeFile(File file) {
        shiftLeft(Constants.SHIFT_ON_3);
        String fileText = super.readeFile(file);
        return fileText.trim().replace(Constants.KEY_DECODING_3_SPACES, Constants.SPACE_3_SYMBOLS_RIGHT);
    }
}
