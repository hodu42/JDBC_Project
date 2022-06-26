package io;

import java.util.Scanner;

public class Keypad {
    private Scanner input;

    public Keypad() { input = new Scanner( System.in ); }
    public int getInt() { return input.nextInt(); }
    public String getString() { return input.next(); }
}