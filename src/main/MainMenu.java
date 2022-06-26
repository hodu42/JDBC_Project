package main;

class MainMenu {
    public static final int SUBJECT_REGISTRATION = 1;
    public static final int MOVE_TO_SIGNUP = 2;
    public static final int MOVE_TO_SEARCH = 3;
    public static final int EXIT = 4;

    // display main menu and get user command
    public int displayMainMenu(Screen screen, Keypad keypad) {
        screen.displayMessageLine( "\n\t\t MENU:\n" );
        screen.displayMessageLine( "\t\t1 - 과목(개설강좌) 등록" );
        screen.displayMessageLine( "\t\t2 - 수강신청 메뉴로 이동" );
        screen.displayMessageLine( "\t\t3 - 자료 조회 메뉴로 이동" );
        screen.displayMessageLine( "\t\t4 - 종료" );
        screen.displayMessage( "\tChoice: " );
        return keypad.getInput();
    }
}
