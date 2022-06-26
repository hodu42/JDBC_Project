package main;

public class Database {
    private Keypad keypad;
    private Screen screen;
    private Menu mainMenu;

    public void performTransactions() {
        boolean userExited = false;

        while ( !userExited ) {
            int command = mainMenu.displayMainMenu(screen, keypad);
            switch ( command ) {
                case Menu.BALANCE_INQUIRY:
                case Menu.WITHDRAWAL:
                case Menu.DEPOSIT:
                    currentTransaction = createTransaction( command );
                    currentTransaction.execute();
                    currentTransaction = null;
                    break;
                case Menu.EXIT:
                    userExited = true;
                    break;
                case Menu.PROGRAM_TERMINATE:
                    System.exit(0);
                    break;
                default:
                    screen.displayMessageLine(Message.ERR_CHOICE);
                    break;
            }
        }
    }
}
