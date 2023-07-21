package Keys;

import java.io.File;

public class DecodingWithShiftBy4Letters extends Key{
    @Override
    public String readeFile(File file) {
        shiftLeft(Constants.SHIFT_ON_4);
        String fileText = super.readeFile(file);
        return fileText.trim().replace(Constants.KEY_DECODING_4_SPACES, Constants.SPACE_4_SYMBOLS_RIGHT);
    }
}
