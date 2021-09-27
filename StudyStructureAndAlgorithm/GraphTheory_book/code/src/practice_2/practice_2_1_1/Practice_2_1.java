/** 农田灌溉(Farm Irrigation), ZOJ2412
 题目描述：
 Benny 有一大片农田需要灌溉。农田是一个长方形，被分割成许多小的正方形。每个正方形
 中都安装了水管。不同的正方形农田中可能安装了不同的水管。一共有 11 种水管，分别用字母 A～
 K 标明，如图 2.11(a)所示。
 图 2.11 水管类型及农田的地图
 Benny 农田的地图是由描述每个正方形农田中水管类型的字母组成的矩阵。例如，如果农田
 的地图为：
 ADC
 FJK
 IHE
 则农田中水管分布如图 2.11(b)所示。
 某些正方形农田的中心有水源，因此水可以沿着水管从一个正方形农田流向另一个正方形农
 田。如果水可以流经某个正方形农田，则整个正方形农田可以全部灌溉到。
 Benny 想知道至少需要多少个水源，以保证整个长方形农田都能被灌溉到？
 例如，图 2.11(b)所示的农田至少需要 3 个水源，图中的圆点表示每个水源。
 输入描述：
 输入文件中包含多个测试数据。每个测试数据的第 1 行为两个整数 M 和 N，表示农田中有 M
 行，每行有 N 个正方形。接下来有 M 行，每行有 N 个字符。字符的取值为'A'～'K'，表示对应正
 方形农田中水管的类型。当 M 或 N 取负值时，表示输入文件结束；否则 M 和 N 的值为正数，且
 其取值范围是 1≤M, N≤50。
 输出描述：
 对输入文件中的每个测试数据所描述的农田，输出占一行，为求得的所需水源数目的最小值。

 *
 * */
package practice_2.practice_2_1_1;

import java.util.Scanner;

public class Practice_2_1 {
    public static int M, N;
    public static Block[][] g = new Block[51][51];
    static class Block {
        char str;
        int[][] direction;
        boolean state;

        public  Block(char str) {
            this.str = str;
            this.state = false;
            switch (this.str) {
                //左: 0, -1     右: 0, 1     上:-1, 0     下: 1, 0
                case 'A':
                    direction = new int[][]{{0, -1}, {-1, 0}};
                    break;
                case 'B':
                    direction = new int[][]{{0, 1}, {-1, 0}};
                    break;
                case 'C':
                    direction = new int[][]{{0, -1}, {1, 0}};
                    break;
                case 'D':
                    direction = new int[][]{{0, 1}, {1, 0}};
                    break;
                case 'E':
                    direction = new int[][]{{-1, 0}, {1, 0}};
                    break;
                case 'F':
                    direction = new int[][]{{0, -1}, {0, 1}};
                    break;
                case 'G':
                    direction = new int[][]{{0, -1}, {0, 1}, {-1, 0}};
                    break;
                case 'H':
                    direction = new int[][]{{-1, 0}, {1, 0}, {0, -1}};
                    break;
                case 'I':
                    direction = new int[][]{{0, -1}, {0, 1}, {1, 0}};
                    break;
                case 'J':
                    direction = new int[][]{{-1, 0}, {1, 0}, {0, 1}};
                    break;
                case 'K':
                    direction = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
                    break;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
       while (!(M < 0 && N < 0)) {
           if (M < 0 || N < 0) {
               System.out.println(0);
               M = sc.nextInt();
               N = sc.nextInt();
               continue;
           }
           //create the graph
           for (int i = 0; i < M; i++) {
               String tempS = sc.next();
               for (int j = 0; j < tempS.length(); j++) {
                   g[i][j] = new Block(tempS.charAt(j));
               }
           }

           System.out.println(traverse());
           M = sc.nextInt();
           N = sc.nextInt();
       }
    }

    public static int traverse() {
        int cnt = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if(g[i][j].state == false) {
                    cnt ++;
                    dfs(g[i][j], i, j);
                }
            }
        }

        return cnt;
    }

    public static void dfs( Block block, int r, int c) {
        if(block.state == true) return;
        block.state = true;
        int tempR = r, tempC = c;
        for (int i = 0; i < block.direction.length; i++) {
           tempR = r + block.direction[i][0];
           tempC = c + block.direction[i][1];
           if(tempR < 0 || tempR >= M || tempC < 0 || tempC >= N || g[tempR][tempC].state == true) continue;
            for (int j = 0; j < g[tempR][tempC].direction.length; j++) {
                if(block.direction[i][0] + g[tempR][tempC].direction[j][0] == 0 &&
                        block.direction[i][1] + g[tempR][tempC].direction[j][1] == 0) {
                    dfs(g[tempR][tempC], tempR, tempC);
                }
            }
        }
    }

}

