package menu;

import io.Keypad;
import io.Screen;

public class SignupMenu {
    public static final int SIGNUP = 1;
    public static final int UPDATE_SIGNUP = 2;
    public static final int BACK = 3;
    public static final int EXIT = 4;

    public int displaySignupMenu(Screen screen, Keypad keypad) {
        screen.displayMessageLine( "\n\t\t MENU:\n" );
        screen.displayMessageLine( "\t\t1 - SIGNUP" );
        screen.displayMessageLine( "\t\t2 - SIGNUP CHANGE" );
        screen.displayMessageLine( "\t\t3 - BACK" );
        screen.displayMessage( "\tChoice: " );
        return keypad.getInt();
    }
}
