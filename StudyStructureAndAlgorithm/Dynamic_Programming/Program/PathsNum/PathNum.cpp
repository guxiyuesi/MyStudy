#include <bits/stdc++.h>
using namespace std;

int PathNum(int m, int n) {
    //开辟一个 m行n列的数组
    int f[m][n];

    //逐行计算
    for(int i = 0; i < m; ++i) {
        //每一行从左往右计算
        for(int j = 0; j < n; ++j) {
            //边界条件的初始化: 第0行 和 第0列只有一种走法
            if(i == 0 || j == 0) {
                f[i][j] = 1;
            } else {
                //状态转移方程
                f[i][j] = f[i-1][j] + f[i][j-1];
            }
        }
    }

    return f[m-1][n-1];
}

int main() {
    cout << PathNum(3, 2) << endl;
    return 0;
}
