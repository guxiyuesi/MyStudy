#include <bits/stdc++.h>
using namespace std;

bool jump_game(int len, int* a) {
    //开一个len长度的数组存储状态
    bool f[len];
    int i, index;
    //f[0]初始化为true
    f[0] = true;
    //从左到右遍历每一个状态
    for(index = 1; index < len; ++index) {
            //每一个状态初始化为false
            f[index] = false;
        //从0开始, 遍历index之前的所有状态, 看从i出发能否到达index
        //只要有一个可以到达就可以
        for(i = 0; i < index; ++i) {
            //状态转移方程, 当满足方程时状态转为true, 并移动到下一个状态
            if(f[i] && index-i <= a[i]) {
                f[index] = true;
                break;
            }
        }

    }

    //返回能否到达最后一个石头
    return f[len-1];
}

int main(){
    int a[5] = {3, 2, 1, 0, 4};
    cout << jump_game(5, a) << endl;

    return 0;
}
