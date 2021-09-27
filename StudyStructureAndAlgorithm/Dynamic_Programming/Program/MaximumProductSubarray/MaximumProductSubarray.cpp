#include <bits/stdc++.h>
using namespace std;

int maximum_product_subarray(int* a, int n) {
    //去除n==0的情况
    if(n==0) return 0;

    //开辟两个数组
    //f[n]存储连续子序列的最大乘积
    //g[n]存储连续子序列的最小乘积
    int f[n], g[n];
    //初始条件
    f[0] = a[0];
    //res 存储最大乘积
    int res = INT_MIN;
    //从左到右依次遍历每个状态
    for(int i = 1; i < n; ++i) {
        //如果a[i] >= 0
        //求最大乘积时, 前面的子序列的乘积越大越好
        //就最小乘积时, 前面的子序列的乘积越小越好
        if(a[i] >= 0) {
            f[i] = max(a[i], a[i] * f[i-1]);
            g[i] = min(a[i], a[i] * g[i-1]);
        } else {
        //如果a[i] < 0
        //求最大乘积时, 前面的子序列的乘积越小越好
        //就最小乘积时, 前面的子序列的乘积越大越好
            f[i] = max(a[i], a[i] * g[i-1]);
            g[i] = min(a[i], a[i] * f[i-1]);
        }
        res = max(res, f[i]);
    }

    return res;
}

int main() {
    int a[4] = {2, 3, -1, 8};
    cout << maximum_product_subarray(a, 4);

    return 0;
}
