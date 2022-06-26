package main;

class SignupMenu {
    public static final int SIGNUP = 1;
    public static final int UPDATE_SIGNUP = 2;
    public static final int BACK = 3;
    public static final int EXIT = 4;


    public int displaySignupMenu(Screen screen, Keypad keypad) {
        screen.displayMessageLine( "\n\t\t MENU:\n" );
        screen.displayMessageLine( "\t\t1 - 수강신청" );
        screen.displayMessageLine( "\t\t2 - 수강신청 변경" );
        screen.displayMessageLine( "\t\t3 - 이전 메뉴로" );
        screen.displayMessageLine( "\t\t4 - 종료" );
        screen.displayMessage( "\tChoice: " );
        return keypad.getInput();
    }
}
