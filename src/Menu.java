import Keys.*;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Menu {

    private static final int EXIT_NUMBER = 0;
    private static final int ENCODE_FILE = 1;
    private static final int DECODE_FILE = 2;
    private static final int MOVE_RIGHT_ON_3 = 3;
    private static final int MOVE_RIGHT_ON_4 = 4;
    private static final int MOVE_RIGHT_ON_5 = 5;
    private static final int MOVE_LEFT_ON_3 = 3;
    private static final int MOVE_LEFT_ON_4 = 4;
    private static final int MOVE_LEFT_ON_5 = 5;
    private static final int BRUTE_FORCE = 6;

    private static final String MENU_INFO =
            """
                    Select an action:
                    1 - Encode file
                    2 - Decode file
                    0 - Exit
                    """;
    private static final String OPTIONS_FOR_ENCODE =
            """
                    Select an action:
                    3 - Move letter 3 positions to the right
                    4 - Move letter 4 positions to the right
                    5 - Move letter 5 positions to the right
                    0 - Exit
                    """;
    private static final String OPTIONS_FOR_DECODE =
            """
                    Select an action:
                    3 - Move letter 3 positions to the left
                    4 - Move letter 4 positions to the left
                    5 - Move letter 5 positions to the left
                    6 - Decode with brute force
                    0 - Exit
                    """;
    private static boolean isRunning = true;
    final CeasarCypher ceasarCypher = new CeasarCypher();
    final Scanner scanner = new Scanner(System.in);

    public void run() {
        while (isRunning) {
            System.out.println(MENU_INFO);
            int menuItem = scanner.nextInt();

            switch (menuItem) {
                case ENCODE_FILE -> itemToEncodeFile();
                case DECODE_FILE -> itemToDecodeFile();
                case EXIT_NUMBER -> itemToExit();
                default -> run();
            }
        }
    }

    private void itemToEncodeFile() {
        var encodingScanner = new Scanner(System.in);
        while (isRunning) {
            System.out.println(OPTIONS_FOR_ENCODE);
            int input = encodingScanner.nextInt();
            while (input == MOVE_RIGHT_ON_3 || input == MOVE_RIGHT_ON_4 || input == MOVE_RIGHT_ON_5) {
                Key key = switch (input) {
                    case MOVE_RIGHT_ON_3 -> new EncodingWithShiftBy3Letters();
                    case MOVE_RIGHT_ON_4 -> new EncodingWithShiftBy4Letters();
                    case MOVE_RIGHT_ON_5 -> new EncodingWithShiftBy5Letters();
                    default -> null;
                };
                String sourceFilePath = validateFilePath();
                String targetFilePath = createTargetFilePath(sourceFilePath);
                ceasarCypher.encode(sourceFilePath, targetFilePath, key);
                System.out.println("Encoded text saved to file: " + targetFilePath);
                return;
            }
            if (input == EXIT_NUMBER) {
                itemToExit();
            }else {
                System.out.println("Invalid input. Please try again.");
            }
        }
        encodingScanner.close();
    }

    private void itemToDecodeFile() {
        var decodingScanner = new Scanner(System.in);
        while (isRunning) {
            System.out.println(OPTIONS_FOR_DECODE);
            int input = decodingScanner.nextInt();
            while (input == MOVE_LEFT_ON_3 || input == MOVE_LEFT_ON_4 ||
                    input == MOVE_LEFT_ON_5 || input == BRUTE_FORCE) {
                Key key = switch (input) {
                    case MOVE_LEFT_ON_3 -> new DecodingWithShiftBy3Letters();
                    case MOVE_LEFT_ON_4 -> new DecodingWithShiftBy4Letters();
                    case MOVE_LEFT_ON_5 -> new DecodingWithShiftBy5Letters();
                    case BRUTE_FORCE -> new BruteForce();
                    default -> null;
                };
                String sourceFilePath = validateFilePath();
                String targetFilePath = createTargetFilePath(sourceFilePath);
                ceasarCypher.decode(sourceFilePath, targetFilePath, key);
                System.out.println("Decoded text saved to file: " + targetFilePath);
                return;
            }
            if (input == EXIT_NUMBER) {
                itemToExit();
            } else {
                System.out.println("Invalid input. Please try again.");
            }
        }
        decodingScanner.close();
    }

    private void itemToExit() {
        isRunning = false;
        System.out.println("Good luck!");
    }

    private String validateFilePath() {
        System.out.println("Provide path to source file: ");
        Scanner scannerForFileName = new Scanner(System.in);
        String filePath = scannerForFileName.nextLine();
        if (!Files.exists(Paths.get(filePath))) {
            throw new FilePathNotValid("Invalid file path!");
        }
        return filePath;
    }

    private String createTargetFilePath(String sourceFilePath) {
        String targetFilePath = sourceFilePath + "_result.txt";
        return targetFilePath;
    }
}
