package main;

import database.DAO;
import database.Transaction;

public class Database {
    private Keypad keypad;
    private Screen screen;
    private MainMenu mainMenu;
    private SignupMenu signupMenu;
    private SearchMenu searchMenu;
    private Transaction transaction;


    public Database(DAO dao) {
        keypad = new Keypad();
        screen = new Screen();
        mainMenu = new MainMenu();
        signupMenu = new SignupMenu();
        searchMenu = new SearchMenu();
        transaction = new Transaction(dao);
    }


    public void run() {
        screen.displayMessageLine(Message.WELCOME);

        boolean userExited = false;
        while ( !userExited ) {
            int command = mainMenu.displayMainMenu(screen, keypad);
            switch ( command ) {
                case MainMenu.INSERT_SUBJECT:
                    insertSubject();
                    break;
                case MainMenu.MOVE_TO_SIGNUP:
                    sighUpMenu();
                    break;
                case MainMenu.MOVE_TO_SEARCH:
                    searchMenu();
                    break;
                case MainMenu.EXIT:
                    userExited = true;
                    break;
                default:
                    screen.displayMessageLine(Message.ERR_CHOICE);
                    break;
            }
        }

        screen.displayMessageLine(Message.GOODBYE);
    }

    public void sighUpMenu() {
        boolean userExited = false;

        while ( !userExited ) {
            int command = searchMenu.displaySearch(screen, keypad);
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

    public void searchMenu() {
        boolean userExited = false;

        while ( !userExited ) {
            int command = searchMenu.displaySearch(screen, keypad);
            switch ( command ) {
                case SearchMenu.SHOW_SUBJECT:
                    break;
                case SearchMenu.SHOW_SIGNUP:
                    break;
                case SearchMenu.SHOW_SUBJECT_ATTENDANCE:
                    break;
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



    public void insertSubject() {
        int sbjId;
        String sbjName;
        int scId;

        screen.displayMessage("Enter Subject ID : ");
        sbjId = keypad.getInt();
        screen.displayMessage("Enter Subject Name : ");
        sbjName = keypad.getString();
        screen.displayMessage("Enter Seperated Class Name : ");
        scId = keypad.getInt();

        if (!transaction.insertSubject(sbjId, sbjName, scId)) {
            screen.displayMessageLine(Message.ERR);
        }
    }
}
