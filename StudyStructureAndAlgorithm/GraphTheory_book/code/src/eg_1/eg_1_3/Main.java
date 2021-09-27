package eg_1.eg_1_3;

import java.util.Scanner;

/**输入描述：
 输入文件中包含多个测试数据，每个测试数据描述了一个无权有向图。每个测试数据的第一
 行为两个正整数 n 和 m，1≤ n ≤ 100，1≤ m ≤ 500，分别表示该有向图的顶点数目和边数，顶点的
 序号从 1 开始计起。接下来有 m 行，每行为两个正整数，用空格隔开，分别表示一条边的起点和
 终点。每条边出现一次且仅一次，图中不存在自身环和重边。输入文件最后一行为 0 0，表示输入
 数据结束。
 输出描述：
 对输入文件中的每个有向图，输出两行：第 1 行为 n 个正整数，表示每个顶点的出度；第 2
 行也为 n 个正整数，表示每个顶点的入度。每两个正整数之间用一个空格隔开，每行的最后一个
 正整数之后没有空格。
 样例输入：
 7 9
 1 2
 2 3
 2 5
 2 6
 3 5
 4 3
 5 2
 5 4
 6 7
 4 7
 1 4
 2 1
 2 2
 2 3
 2 3
 4 2
 4 3
 0 0

 样例输出：
 1 3 1 1 2 1 0
 0 2 2 1 2 1 1
 1 4 0 2
 1 2 3 1
 * */

public class Main {
    //边节点
    static class ArcNode {
        public int arcNodeNum;                    //节点的编号
        public ArcNode arcNode;            //指向下一个节点
    }

    //顶点
    static class Node {
        public ArcNode OutArcHead;          //出边表表头
        public ArcNode InArcHead;           //入边表表头
    }

    //图
    static class Graph {
        public Node[] nodes;                //顶点数组
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()) {
            int n, m;
            n = sc.nextInt();               //顶点数
            m = sc.nextInt();               //边数
            //文件结束条件
            if(n == 0 && m == 0) return;

            //创建图 使用下标代替顶点序号
            Graph g = new Graph();
            //初始化顶点数组
            g.nodes = new Node[n];
            for (int i = 0; i < n; i++) {
                g.nodes[i] = new Node();
                //初始化顶点数组中的出边集
                g.nodes[i].OutArcHead = new ArcNode();
                g.nodes[i].OutArcHead.arcNodeNum = Integer.MAX_VALUE;
                g.nodes[i].OutArcHead.arcNode = null;
                //初始化顶点数组中的入边集
                g.nodes[i].InArcHead = new ArcNode();
                g.nodes[i].InArcHead.arcNodeNum = Integer.MAX_VALUE;
                g.nodes[i].InArcHead.arcNode = null;
            }

            //输入边
            for (int i = 0; i < m; i++) {
                int begin = 0, end = 0;
                begin = sc.nextInt();
                end = sc.nextInt();
                //创建出边节点
                ArcNode outArcNode = new ArcNode();
                outArcNode.arcNodeNum = end;
                //将出边节点插入到对应边集中
                outArcNode.arcNode = g.nodes[begin-1].OutArcHead.arcNode;
                g.nodes[begin-1].OutArcHead.arcNode = outArcNode;

                //创建入边节点
                ArcNode inArcNode = new ArcNode();
                inArcNode.arcNodeNum = begin;
                //将入边节点插入到对应边集中
                inArcNode.arcNode = g.nodes[end-1].InArcHead.arcNode;
                g.nodes[end-1].InArcHead.arcNode = inArcNode;
            }

            //输出出度
            for (int i = 0; i < n; i++) {
                ArcNode tempNode = g.nodes[i].OutArcHead.arcNode;
                int cnt = 0;
                while(tempNode != null) {
                    cnt ++;
                    tempNode = tempNode.arcNode;
                }

                if(i == 0) {
                    System.out.print(""+cnt);
                } else {
                    System.out.print(" " + cnt);
                }
            }


            System.out.println();

            //输出入度
            for (int i = 0; i < n; i++) {
                ArcNode tempNode = g.nodes[i].InArcHead.arcNode;
                int cnt = 0;
                while(tempNode != null) {
                    cnt ++;
                    tempNode = tempNode.arcNode;
                }

                if(i == 0) {
                    System.out.print(""+cnt);
                } else {
                    System.out.print(" " + cnt);
                }
            }
        }
    }
}
