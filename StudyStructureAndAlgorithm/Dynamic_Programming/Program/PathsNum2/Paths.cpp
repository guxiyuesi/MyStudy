#include <bits/stdc++.h>
using namespace std;

//��-1��ʾ�ϰ�
int paths_num(vector<vector<int>> a){
    //����ı�Ե���
    int m = a.size();
    if(m == 0) return 0;
    int n = a[0].size();
    if(n == 0) return 0;

    //��ʼ�ͽ������ϰ�ʱֱ�ӷ���0
    if(a[0][0] == -1 || a[m-1][n-1] == -1) {
        return 0;
    }

    int f[m][n];
    for(int i = 0; i < m; ++i) {
        for(int j = 0; j < n; ++j) {
            //�����ϰ�����Ϊ0
            if(a[i][j] == -1) {
                f[i][j] = 0;
                continue;
            }

            //��ʼ��
            if(i == 0 && j == 0) {
                f[i][j] = 1;
                continue;
            }

            //��һ��
            if(i == 1) {
                f[i][j] = f[i][j-1];
                continue;
            }

            //��һ��
            if(j == 1) {
                f[i][j] = f[i-1][j];
                continue;
            }

            //�������
            f[i][j] = f[i-1][j] + f[i][j-1];

            /*
            ��������������Լ򻯴���Ϊ:
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


