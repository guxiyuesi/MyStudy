/**题目描述：
 * 未名湖附近共有 n 个大小湖泊 L1, L2, ..., Ln（其中包括未名湖），每个湖泊 Li里住着一只青蛙
 * Fi（1≤i≤n）。如果湖泊 Li和 Lj之间有水路相连，则青蛙 Fi和 Fj互称为邻居。现在已知每只青蛙的
 * 邻居数目 x1, x2, ..., xn，请你给出每两个湖泊之间的相连关系。
 *
 * 输入描述：
 * 第一行是测试数据的组数 t（0 ≤ t ≤ 20）。每组数据包括两行，第一行是整数 n（2 ≤ n ≤ 10），
 * 第二行是 n 个整数，x1, x2,..., xn（0 ≤ xi < n）。
 *
 * 输出描述：
 * 对输入的每组测试数据，如果不存在可能的相连关系，输出"NO"。否则输出"YES"，并用 n×n
 * 的矩阵表示湖泊间的相邻关系，即如果湖泊 i 与湖泊 j 之间有水路相连，则第 i 行的第 j 个数字为
 * 1，否则为 0。每两个数字之间输出一个空格。如果存在多种可能，只需给出一种符合条件的情形。
 * 相邻两组测试数据之间输出一个空行。
 *
 * 样例输入：
 * 2
 * 7
 * 4 3 1 5 4 2 1
 * 6
 * 4 3 1 4 2 0
 *
 * 样例输出：
 * YES
 * 0 1 1 1 1 0 0
 * 1 0 0 1 1 0 0
 * 1 0 0 0 0 0 0
 * 1 1 0 0 1 1 1
 * 1 1 0 1 0 1 0
 * 0 0 0 1 1 0 0
 * 0 0 0 1 0 0 0
 * NO
 *
 * 分析:
 *      本题是判断给定的序列是否是可图的
 *      异常情况:
 *          1. 非增排序后, 第一个元素的度大于节点个数
 *          2. 最大度数后的d1个元素各减1后出现负数
 *      截止情况:
 *          非增排序后, 第一个元素的度数为0
 *
 *      一个元素判断可图时, 确定该图的方法:
 *          1. 对于每个节点, 使用一个节点类{ 顶点的度, 序号 }
 *          2. 每次对剩下的顶点按度数从大到小的顺序排序后，设最前面的顶点（即当前度数最大的顶
 * 点）序号为 i、度数为 d1，对后面 d1个顶点每个顶点（序号设为 j）度数减 1，并连边，即在邻接
 * 矩阵 Edge 中设置 Edge[i][j]和 Edge[j][i]为 1。
 * */

package eg_1.eg_1_2;

import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
//结果不唯一
public class Main {
    public static void main(String[] args) {

        //节点类
        class Node implements Comparable{
            public int deg;
            public int index;

            @Override
            public int compareTo(Object o) {
                Node node = (Node)o;
                return this.deg - node.deg;
            }
        }


        int t = 0;
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        //多组测试数据
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();

            //读入度数序列
            ArrayList<Node> v = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                Node node = new Node();
                node.deg = sc.nextInt();
                node.index = j;
                v.add(node);
            }
            int v_len = v.size();

            int[][] E = new int[n][n];              //边集

           //判断是否有负数
            for (int j = 0; j < v_len; j++) {
               if(v.get(j).deg < 0) {
                   StdOut.println("NO");
                   return;
               }
            }
            v.sort(Comparator.reverseOrder());

            //对于非增序列, 从第一个元素开始处理, 判断序列是否可图
            while (v.get(0).deg > 0) {

                for (Node node:v) {
                    StdOut.print(node.deg + " ");
                }
                StdOut.println();
                if(v.get(0).deg > v.size()) {
                    StdOut.println("NO");
                    return;
                }
                //将d1删除以后, 把后面的d1.deg个元素与d1建立联系
                for(int k = 1; k <=v.get(0).deg; ++k) {
                    E[v.get(0).index][v.get(0+k).index] = 1;
                    E[v.get(0+k).index][v.get(0).index] = 1;
                    v.get(0+k).deg --;
                    //出现负数时, 说明序列不可图
                    if(v.get(0+k).deg < 0) {
                        StdOut.println("NO");
                        return;
                    }
                }
                v.get(0).deg = 0;
                v.sort(Comparator.reverseOrder());
            }

            //输出图
            StdOut.println("YES");
            print(E);
        }
    }

    public static void print(int[][] v) {
        for (int i = 0; i < v.length; ++i) {
            for (int j= 0; j < v[i].length; ++j) {
                if(j == 0) StdOut.print(v[i][j]);
                else StdOut.print(" " + v[i][j]);
            }
            StdOut.println();
        }
    }
}
