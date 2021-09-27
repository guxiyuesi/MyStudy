#include <bits/stdc++.h>
using namespace std;

int getMinCount(int* coins, int coins_len, int money) {
    //����״̬����
    int* f = new int[money+1];
    //��ʼ״̬
    f[0] = 0;

    //��С�������μ���ÿһ��״̬
    for(int i = 1; i <= money; ++i) {
        //ÿһ��״̬  ��ʼʱ��Ϊ������
        f[i] = INT_MAX;
        //����ÿһ��״̬, ǰk-1öӲ�Ҷ�����֪��,ֻ��Ҫ�����һöӲ��
        //���ѭ�������������һöӲ�ҵ���ֵ, ѭ������ÿһ������ֵ
        for(int j = 0; j < coins_len; ++j) {
            // �ж��ܷ�ʹ�ø���ֵ
            if(i >= coins[j] && f[i-coins[j]] != INT_MAX) {
                f[i] = min(f[i], f[i-coins[j]]+1);
            }
        }
    }

    //��������ʹ�õ�Ӳ���� -1˵���޷�ƴ��
    return f[money] == INT_MAX ? -1:f[money];

}

int main() {
    int* coins = new int[3]{2, 3, 5};
    int num = getMinCount(coins, 3, 50);
    num == -1 ? cout<<"�޷�ƴ��������"<<endl : cout<<"������Ҫ" << num << "��Ӳ��" << endl;
    return 0;
}
