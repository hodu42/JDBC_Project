package main;

public class Database {
    private Keypad keypad;
    private Screen screen;
    private MainMenu mainMenu;
    private SignupMenu signupMenu;
    private SearchMenu searchMenu;

    public void performTransactions() {
        boolean userExited = false;

        while ( !userExited ) {
            int command = mainMenu.displayMainMenu(screen, keypad);
            switch ( command ) {
                case MainMenu.SUBJECT_REGISTRATION:
                    break;
                case MainMenu.MOVE_TO_SIGNUP:
                    sighUpMenu();
                    break;
                case MainMenu.MOVE_TO_SEARCH:
                    break;
                case MainMenu.EXIT:
                    userExited = true;
                    break;
                default:
                    screen.displayMessageLine(Message.ERR_CHOICE);
                    break;
            }
        }
    }

    public void sighUpMenu() {
        boolean userExited = false;

        while ( !userExited ) {
            int command = searchMenu.displaySearch(screen, keypad);
            switch ( command ) {
                case SearchMenu.BACK:
                    userExited = true;
                    break;
                case SearchMenu.EXIT:
                    System.exit(0);
                    break;
                default:
                    screen.displayMessageLine(Message.ERR_CHOICE);
                    break;
            }
        }
    }

    public void searchMenu() {
        boolean userExited = false;

        while ( !userExited ) {
            int command = signupMenu.displaySignupMenu(screen, keypad);
            switch ( command ) {
                case SignupMenu.SIGNUP:
                    break;
                case SignupMenu.UPDATE_SIGNUP:
                    break;
                case SignupMenu.BACK:
                    userExited = true;
                    break;
                case SignupMenu.EXIT:
                    System.exit(0);
                    break;
                default:
                    screen.displayMessageLine(Message.ERR_CHOICE);
                    break;
            }
        }
    }
}
