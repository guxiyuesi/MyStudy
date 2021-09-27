package practice_2.practice_2_1_3;

import java.util.Scanner;

public class RedAndBlack {
    public static  char[][] maze;
    public static int cnt = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        int r = sc.nextInt();
        while (r != 0 && c != 0) {
            cnt = 0;
            int tempR = 0, tempC = 0;
            maze = new char[r][c];
            for (int i = 0; i < r; i++) {
                String str = "";
                str = sc.next();
                for (int j = 0; j < c; j++) {
                   maze[i][j] = str.charAt(j);
                   if (maze[i][j] == '@') {
                       tempR = i;
                       tempC = j;
                   }
                }
            }

            traverse(tempR, tempC);
            System.out.println(cnt);
            c = sc.nextInt();
            r = sc.nextInt();
        }
    }

    public static void traverse(int r , int c) {
        if (maze[r][c] == '#') return;
        cnt ++;
        maze[r][c] = '#';
        int[][] direction = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int i = 0; i < direction.length; i++) {
           int tempR = r + direction[i][0];
           int tempC = c + direction[i][1];
           if (tempR < 0 || tempC < 0 || tempR >= maze.length || tempC >= maze[r].length) continue;
           if (maze[tempR][tempC] == '#') continue;
           traverse(tempR, tempC);
        }
    }
}
