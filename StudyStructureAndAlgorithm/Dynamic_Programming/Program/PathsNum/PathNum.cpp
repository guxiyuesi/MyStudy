#include <bits/stdc++.h>
using namespace std;

int PathNum(int m, int n) {
    //����һ�� m��n�е�����
    int f[m][n];

    //���м���
    for(int i = 0; i < m; ++i) {
        //ÿһ�д������Ҽ���
        for(int j = 0; j < n; ++j) {
            //�߽������ĳ�ʼ��: ��0�� �� ��0��ֻ��һ���߷�
            if(i == 0 || j == 0) {
                f[i][j] = 1;
            } else {
                //״̬ת�Ʒ���
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
