import java.util.Scanner;

public class Menu {

    private static final int EXIT_NUMBER = 0;
    private static final int ENCODE_FILE = 1;
    private static final int DECODE_FILE = 2;

    private static final String MENU_INFO =
            """
                    Select an action:
                    1 - Encode file
                    2 - Decode file
                    0 - Exit
                    """;

    private static boolean isRunning = true;
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
            scanner.close();
        }
    }

    private void itemToEncodeFile() {

    }

    private void itemToDecodeFile() {

    }

    private void itemToExit() {

    }
}
