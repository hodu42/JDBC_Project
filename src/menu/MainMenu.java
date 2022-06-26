package menu;

import io.Keypad;
import io.Screen;

public class MainMenu {
    public static final int INSERT_SUBJECT = 1;
    public static final int MOVE_TO_SIGNUP = 2;
    public static final int MOVE_TO_SEARCH = 3;
    public static final int EXIT = 4;

    // display main menu and get user command
    public int displayMainMenu(Screen screen, Keypad keypad) {
        screen.displayMessageLine( "\n\t\t MENU:\n" );
        screen.displayMessageLine( "\t\t1 - Subject Registration" );
        screen.displayMessageLine( "\t\t2 - move to signup" );
        screen.displayMessageLine( "\t\t3 - move to search" );
        screen.displayMessageLine( "\t\t4 - exit" );
        screen.displayMessage( "\tChoice: " );
        return keypad.getInt();
    }
}
