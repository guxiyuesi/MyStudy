#include <bits/stdc++.h>
using namespace std;

int get_length_of_longest_subsequence(vector<int>& a) {
    int a_len = a.size();
    if(a_len == 0) return 0;
    int f[a_len];
    //��ʼ��
    f[0] = 1;
    //��¼��󳤶�
    int res = INT_MIN;
    //�������Ҽ���
    for(int i = 1; i < a_len; ++i) {
        //ÿ��״̬�ȳ�ʼ��Ϊ1
        f[i] = 1;
        //ת�Ʒ���
        if(a[i] > a[i-1]) {
            f[i] = max(f[i], f[i-1] + 1);
        }
        res = max(res, f[i]);
    }
    return res;
}

int main(){
    vector<int> a;
    a.push_back(5);
    a.push_back(1);
    a.push_back(2);
    a.push_back(3);
    cout << get_length_of_longest_subsequence(a);

    return 0;
}
