package menu;

import io.Keypad;
import io.Screen;

public class SearchMenu {
    public static final int SHOW_SUBJECT = 1;
    public static final int SHOW_SIGNUP = 2;
    public static final int SHOW_SUBJECT_ATTENDANCE = 3;
    public static final int SHOW_SEPARATED_CLASS_ATTENDANCE = 4;
    public static final int BACK = 5;
    public static final int EXIT = 6;

    public int displaySearch(Screen screen, Keypad keypad) {
        screen.displayMessageLine( "\n\t\t MENU:\n" );
        screen.displayMessageLine( "\t\t1 - show subject" );
        screen.displayMessageLine( "\t\t2 - show signup" );
        screen.displayMessageLine( "\t\t3 - show subject attendance" );
        screen.displayMessageLine( "\t\t4 - show separated class attendance" );
        screen.displayMessageLine( "\t\t5 - back" );
        screen.displayMessageLine( "\t\t6 - exit" );
        screen.displayMessage( "\tChoice: " );
        return keypad.getInt();
    }
}
