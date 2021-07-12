/** 例 1.1 用邻接矩阵存储有向图，并输出各顶点的出入和入度。
 * 输入描述：
 *  输入文件中包含多个测试数据，每个测试数据描述了一个无权有向图。每个测试数据的第一
 *  行为两个正整数 n 和 m，1 ≤ n ≤ 100，1 ≤ m ≤ 500，分别表示该有向图的顶点数目和边数，顶点的
 *  序号从 1 开始计起。接下来有 m 行，每行为两个正整数，用空格隔开，分别表示一条边的起点和
 *  终点。每条边出现一次且仅一次，图中不存在自身环和重边。输入文件最后一行为 0 0，表示输入
 *  数据结束。
 *
 *输出描述：
 * 对输入文件中的每个有向图，输出两行：第 1 行为 n 个正整数，表示每个顶点的出度；第 2
 * 行也为 n 个正整数，表示每个顶点的入度。每两个正整数之间用一个空格隔开，每行的最后一个
 * 正整数之后没有空格。
 * 样例输入：
 * 7 9
 * 1 2
 * 2 3
 * 2 5
 * 2 6
 * 3 5
 * 4 3
 * 5 2
 * 5 4
 * 6 7
 * 0 0
 *
 * 样例输出：
 * 1 3 1 1 2 1 0
 * 0 2 2 1 2 1 1
 *
 * 分析:
 *  邻接矩阵中, 第i行的总和表示 第i+1个元素的出度
 *              第i列的总和表示 第i+1个元素的入度
 * */
package eg_1_1;

import edu.princeton.cs.algs4.StdOut;

import java.util.Scanner;

public class Main {
    public static int[][] E;           //边集
    public static int m, n;             //m个顶点, n条边
    public static int op, ip;           //op 出度, ip入度

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        m = sc.nextInt();
        n = sc.nextInt();

        if(m <= 0 || n < 0) return;
        E = new int[m][m];

        int v1 = 0, v2 = 0;
        for (int i = 0; i < n; i++) {
            v1 = sc.nextInt();
            v2 = sc.nextInt();
            E[v1-1][v2-1] = 1;
        }

        //输出出度
        for (int i = 0; i < m; i++) {
            op = 0;
            for (int j = 0; j < m; j++) {
                op += E[i][j];
            }

            if(i < m -1) {
                StdOut.print(op + " ");
            } else {
                StdOut.print(op);
            }
        }
        StdOut.println();


        //输出入度
        for (int i = 0; i < m; i++) {
            ip = 0;
            for (int j = 0; j < m; j++) {
                ip += E[j][i];
            }

            if(i < m -1) {
                StdOut.print(ip + " ");
            } else {
                StdOut.print(ip);
            }
        }
        StdOut.println();
    }
}
