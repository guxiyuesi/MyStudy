#include <bits/stdc++.h>
using namespace std;

bool jump_game(int len, int* a) {
    //��һ��len���ȵ�����洢״̬
    bool f[len];
    int i, index;
    //f[0]��ʼ��Ϊtrue
    f[0] = true;
    //�����ұ���ÿһ��״̬
    for(index = 1; index < len; ++index) {
            //ÿһ��״̬��ʼ��Ϊfalse
            f[index] = false;
        //��0��ʼ, ����index֮ǰ������״̬, ����i�����ܷ񵽴�index
        //ֻҪ��һ�����Ե���Ϳ���
        for(i = 0; i < index; ++i) {
            //״̬ת�Ʒ���, �����㷽��ʱ״̬תΪtrue, ���ƶ�����һ��״̬
            if(f[i] && index-i <= a[i]) {
                f[index] = true;
                break;
            }
        }

    }

    //�����ܷ񵽴����һ��ʯͷ
    return f[len-1];
}

int main(){
    int a[5] = {3, 2, 1, 0, 4};
    cout << jump_game(5, a) << endl;

    return 0;
}
