package main;

import database.DAO;
import database.Transaction;
import io.Keypad;
import io.Screen;
import menu.MainMenu;
import menu.SearchMenu;
import menu.SignupMenu;

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
                    screen.displayMessageLine(Message.ERR_CHOICE);//바꿔
                    break;
            }
        }
    }

    public void sighUpMenu() {
        boolean userExited = false;

        while ( !userExited ) {
            int command = signupMenu.displaySignupMenu(screen, keypad);
            switch ( command ) {
                case SignupMenu.SIGNUP:
                    insertSignUp();
                    break;
                case SignupMenu.UPDATE_SIGNUP:
                    updateSignUp();
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
                    transaction.showSubject();
                    break;
                case SearchMenu.SHOW_SIGNUP:
                    screen.displayMessage("Enter Student ID : ");
                    transaction.showSignUp(keypad.getInt());
                    break;
                case SearchMenu.SHOW_SUBJECT_ATTENDANCE:
                    screen.displayMessage("Enter Subject ID : ");
                    transaction.showSubjectAttendance(keypad.getInt());
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
        screen.displayMessage("Enter Seperated Class ID : ");
        scId = keypad.getInt();

        if (transaction.insertSubject(sbjId, sbjName, scId)) {
            screen.displayMessageLine(Message.OPEN_SUCCESS);
        }
        else {
            screen.displayMessageLine(Message.OPEN_FAIL);
        }
    }



    public void insertSignUp() {
        int stdId;
        int scId;
        int sbjId;
        String grade;

        screen.displayMessage("Enter Student ID : ");
        stdId = keypad.getInt();
        screen.displayMessage("Enter Subject ID : ");
        sbjId = keypad.getInt();
        screen.displayMessage("Enter Seperated Class Name : ");
        scId = keypad.getInt();
        screen.displayMessage("Enter Grade : ");
        grade = keypad.getString();

        if (transaction.insertSignUp(stdId, scId, sbjId, grade)) {
            screen.displayMessageLine(Message.SUCCESS_SIGN_UP);
        }
        else {
            screen.displayMessageLine(Message.FAIL_SIGN_UP);
        }
    }

    public void updateSignUp() {
        int stdId;
        int newScId;
        int newSbjId;
        int oldSbjId;

        screen.displayMessage("Enter Student ID : ");
        stdId = keypad.getInt();
        screen.displayMessage("Enter New Seperated Class ID : ");
        newScId = keypad.getInt();
        screen.displayMessage("Enter New Subject ID : ");
        newSbjId = keypad.getInt();
        screen.displayMessage("Enter Old Subject ID : ");
        oldSbjId = keypad.getInt();

        transaction.updateSignUp(stdId, newScId, newSbjId, oldSbjId);
        screen.displayMessageLine(Message.CHANGE_SUCCESS);
    }
}
