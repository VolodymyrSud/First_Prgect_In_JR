package Keys;

import java.io.File;

public class EncodingWithShiftBy3Letters extends Key{
    @Override
    public String readeFile(File file) {
        shiftRight(Constants.SHIFT_ON_3);
        String fileText = super.readeFile(file);
        return fileText.trim().replace(Constants.SPACE, Constants.KEY_ENCODING_3_SPACES);
    }
}
