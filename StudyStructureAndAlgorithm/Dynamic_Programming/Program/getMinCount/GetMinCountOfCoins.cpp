#include <bits/stdc++.h>
using namespace std;

int getMinCount(int* coins, int coins_len, int money) {
    //定义状态数组
    int* f = new int[money+1];
    //初始状态
    f[0] = 0;

    //从小到大依次计算每一个状态
    for(int i = 1; i <= money; ++i) {
        //每一个状态  初始时设为正无穷
        f[i] = INT_MAX;
        //对于每一种状态, 前k-1枚硬币都是已知的,只需要求最后一枚硬币
        //这个循环是用来求最后一枚硬币的面值, 循环尝试每一个种面值
        for(int j = 0; j < coins_len; ++j) {
            // 判断能否使用该面值
            if(i >= coins[j] && f[i-coins[j]] != INT_MAX) {
                f[i] = min(f[i], f[i-coins[j]]+1);
            }
        }
    }

    //返回最少使用的硬币数 -1说明无法拼出
    return f[money] == INT_MAX ? -1:f[money];

}

int main() {
    int* coins = new int[3]{2, 3, 5};
    int num = getMinCount(coins, 3, 50);
    num == -1 ? cout<<"无法拼出该数字"<<endl : cout<<"最少需要" << num << "个硬币" << endl;
    return 0;
}
