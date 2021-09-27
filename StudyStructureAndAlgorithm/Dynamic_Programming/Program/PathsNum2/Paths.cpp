#include <bits/stdc++.h>
using namespace std;

//用-1表示障碍
int paths_num(vector<vector<int>> a){
    //矩阵的边缘情况
    int m = a.size();
    if(m == 0) return 0;
    int n = a[0].size();
    if(n == 0) return 0;

    //开始和结束有障碍时直接返回0
    if(a[0][0] == -1 || a[m-1][n-1] == -1) {
        return 0;
    }

    int f[m][n];
    for(int i = 0; i < m; ++i) {
        for(int j = 0; j < n; ++j) {
            //遇到障碍是设为0
            if(a[i][j] == -1) {
                f[i][j] = 0;
                continue;
            }

            //初始化
            if(i == 0 && j == 0) {
                f[i][j] = 1;
                continue;
            }

            //第一行
            if(i == 1) {
                f[i][j] = f[i][j-1];
                continue;
            }

            //第一列
            if(j == 1) {
                f[i][j] = f[i-1][j];
                continue;
            }

            //其他情况
            f[i][j] = f[i-1][j] + f[i][j-1];

            /*
            后面三种情况可以简化代码为:
            f[i][j] = 0;
            if(i > 0) {
                f[i][j] += f[i-1][j];
            }

            if(j > 0) {
                f[i][j] += f[i][j-1];
            }

            */
        }
    }

    return f[m-1][n-1];
}


