#include <bits/stdc++.h>
using namespace std;

int minximum_paths_sum(vector<vector<int>>& a) {
    int m = a.size();
    if(m == 0) return 0;
    int n = a[0].size();
    if(n == 0) return 0;

    int f[m][n];
    for(int i = 0; i < m; ++i) {
        for(int j = 0; j < n; ++j) {
            f[i][j] = a[i][j];
            if(i == 0 && j > 0) {
                f[i][j] += f[i][j-1];
                continue;
            }

            if(j == 0 && i > 0) {
                f[i][j] += f[i-1][j];
                continue;
            }

            f[i][j] += min(f[i-1][j], f[i][j-1]);
        }
    }
    return f[m-1][n-1];
}
