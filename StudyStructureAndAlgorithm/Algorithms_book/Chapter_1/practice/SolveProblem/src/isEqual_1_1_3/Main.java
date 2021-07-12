package isEqual_1_1_3;

import edu.princeton.cs.algs4.StdOut;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        int first = Integer.parseInt(args[0]);
        int second = Integer.parseInt(args[1]);
        int third = Integer.parseInt(args[2]);
        if(first == second && second == third) {
            StdOut.println("equal");
        } else {
            StdOut.println("not equal");
        }
    }
}
