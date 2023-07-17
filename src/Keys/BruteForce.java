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
                    if (substring.equals("ввв")) {
                        shiftLeft(3);
                        return fileText.trim().replace("ввв", "в");
                    }
                    if (substring.equals("гггг")) {
                        shiftLeft(4);
                        return fileText.trim().replace("гггг", "г");
                    }
                    if (substring.equals("ґґґґґ")) {
                        shiftLeft(5);
                        return fileText.trim().replace("ґґґґґ", "ґ");
                    }
                }
            }
        }
        return fileText;
    }
}
