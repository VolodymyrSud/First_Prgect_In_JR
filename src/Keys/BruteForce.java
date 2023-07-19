package Keys;

import java.io.File;

public class BruteForce extends Key{
    @Override
    public String readeFile(File file) {
        String fileText = super.readeFile(file);
        int minSubstringLength = 3;

        for (int i = 0; i < fileText.length() - minSubstringLength; i++) {
            for (int j = i + minSubstringLength; j < fileText.length(); j++) {
                String substring = fileText.substring(i, j);
                if (fileText.indexOf(substring, j) != -1) {
                    if (substring.equals(Constants.KEY_DECODING_3_SPACES)) {
                        shiftLeft(Constants.SHIFT_ON_3);
                        return fileText.trim().replace(Constants.KEY_DECODING_3_SPACES, Constants.SPACE_3_SYMBOLS_RIGHT);
                    }
                    if (substring.equals(Constants.KEY_DECODING_4_SPACES)) {
                        shiftLeft(4);
                        return fileText.trim().replace(Constants.KEY_DECODING_4_SPACES, Constants.SPACE_4_SYMBOLS_RIGHT);
                    }
                    if (substring.equals(Constants.KEY_DECODING_5_SPACES)) {
                        shiftLeft(5);
                        return fileText.trim().replace(Constants.KEY_DECODING_5_SPACES, Constants.SPACE_5_SYMBOLS_RIGHT);
                    }
                }
            }
        }
        return fileText;
    }
}
