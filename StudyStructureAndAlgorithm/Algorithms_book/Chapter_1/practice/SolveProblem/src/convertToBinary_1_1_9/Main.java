package convertToBinary_1_1_9;

import edu.princeton.cs.algs4.StdOut;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StringBuffer s = new StringBuffer("");
        int N = 0;
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        for (int i = N; i > 0; i /= 2) {
           s.append(i%2);
        }
        StdOut.println(s);
    }
}
