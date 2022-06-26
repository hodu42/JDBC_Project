package main;

class SearchMenu {
    public static final int SHOW_SUBJECT = 1;
    public static final int SHOW_SIGNUP = 2;
    public static final int SHOW_SUBJECT_ATTENDANCE = 3;
    public static final int BACK = 4;
    public static final int EXIT = 5;




    public int displaySearch(Screen screen, Keypad keypad) {
        screen.displayMessageLine( "\n\t\t MENU:\n" );
        screen.displayMessageLine( "\t\t1 - 개설강좌 조회" );
        screen.displayMessageLine( "\t\t2 - 수강신청 확인서 조회" );
        screen.displayMessageLine( "\t\t3 - 출석부 조회" );
        screen.displayMessageLine( "\t\t4 - 이전 메뉴로" );
        screen.displayMessageLine( "\t\t5 - 종료" );
        screen.displayMessage( "\tChoice: " );
        return keypad.getInput();
    }
}
