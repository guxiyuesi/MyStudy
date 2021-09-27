#include <bits/stdc++.h>
using namespace std;

int maximum_product_subarray(int* a, int n) {
    //ȥ��n==0�����
    if(n==0) return 0;

    //������������
    //f[n]�洢���������е����˻�
    //g[n]�洢���������е���С�˻�
    int f[n], g[n];
    //��ʼ����
    f[0] = a[0];
    //res �洢���˻�
    int res = INT_MIN;
    //���������α���ÿ��״̬
    for(int i = 1; i < n; ++i) {
        //���a[i] >= 0
        //�����˻�ʱ, ǰ��������еĳ˻�Խ��Խ��
        //����С�˻�ʱ, ǰ��������еĳ˻�ԽСԽ��
        if(a[i] >= 0) {
            f[i] = max(a[i], a[i] * f[i-1]);
            g[i] = min(a[i], a[i] * g[i-1]);
        } else {
        //���a[i] < 0
        //�����˻�ʱ, ǰ��������еĳ˻�ԽСԽ��
        //����С�˻�ʱ, ǰ��������еĳ˻�Խ��Խ��
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
