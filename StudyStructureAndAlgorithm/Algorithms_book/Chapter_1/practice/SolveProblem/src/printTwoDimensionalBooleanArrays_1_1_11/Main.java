package printTwoDimensionalBooleanArrays_1_1_11;

import edu.princeton.cs.algs4.StdOut;

public class Main {
    public static void printTwoDimensionalBooleanArrays(boolean[][] arr) {
        if (arr == null || arr.length == 0) return;
        int column_length = arr[0].length;

        //打印列名
        StdOut.print(" ");
        for(int i = 0; i < column_length; ++i) {
            StdOut.print(" " + (i+1));
        }
        StdOut.println();

        int row_length = arr.length;
        for (int i = 0; i < row_length; i++) {
            StdOut.print(i+1 + " ");                              //打印行号
            for (int j = 0; j < column_length; j++) {
                String s = "";
                if(arr[i][j]) s += "*";
                else s += " ";
                if (j != column_length) {
                    StdOut.print(s + " ");
                }
                else StdOut.print(s);
            }
            StdOut.println();
        }
    }

    public static void main(String[] args) {
        boolean[][] arr = new boolean[2][2];
        arr[0][0] = true;
        arr[0][1] = false;
        arr[1][0] = false;
        arr[1][1] = true;
        printTwoDimensionalBooleanArrays(arr);
    }
}
