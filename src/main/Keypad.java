package main;

import java.util.Scanner;

class Keypad {
    private Scanner input;

    public Keypad() { input = new Scanner( System.in ); }
    public int getInput() { return input.nextInt(); }
}