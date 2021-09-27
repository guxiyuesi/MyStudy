package practice_2.practice_2_1_2;

import java.util.Scanner;

public class Practice_2_1_2 {
    public static int n = -1;
    static  class Diamond {
        public boolean flag;
        public int[] nums;
        public Diamond() {
            flag = false;
            this.nums = new int[4];
        }
    }
    public static void main(String[] args) {  
        Scanner sc = new Scanner(System.in);   
        while (true) {
           n = sc.nextInt();
           if(n == 0) return;
           Diamond[][] diamonds = new Diamond[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    diamonds[i][j] = new Diamond();
                    for (int k = 0; k < 4; k++) {
                        diamonds[i][j].nums[k] = sc.nextInt();
                    }
                }
            }

            if (dfs(diamonds[0][0], diamonds)) {
                System.out.println("Possible");
            }
            else {
                System.out.println("Impossible");
            }
        }
    }
    
    public static boolean dfs(Diamond d, Diamond[][] diamonds){
        if (d.flag == true) return true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 4; k++) {
                    if (d.nums[k] == diamonds[i][j].nums[(k+2)%4] && d != diamonds[i][j]) {
                        d.flag = true;
                        dfs(diamonds[i][j], diamonds);
                    }
                }
            }
        }
        if (d.flag == true) return true;
        return false;
    }
}
