package StdDrawAbout.functionValue;

import edu.princeton.cs.algs4.StdDraw;

public class Main {
    public static void main(String[] args) {
        int N= 100;
        StdDraw.setXscale(0, N);        //x  范围为 0~N
        StdDraw.setYscale(0, N * N);    //y  范围为 0~N*N
        StdDraw.setPenRadius(0.01);     //设置画笔粗细
        for (int l = 1; l <= N; l++) {
            StdDraw.point(l, l);        //y = x
            StdDraw.point(l, l*l);   //y = x^2
            StdDraw.point(l, l * Math.log(l));  //y = x * lnx
        }
    }
}
