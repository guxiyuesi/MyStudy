#include <bits/stdc++.h>
using namespace std;

//����ը
void up_bomb(vector<vector<char>>& g, int** f, int i, int j) {
    //��һ�е����
    if(i == 0) {
        if(g[i][j] == '0' || g[i][j] == 'W') {
            f[i][j] = 0;
        }
        else {
            f[i][j] = 1;
        }
        return ;
    }

    //ת�Ʒ���
    if(g[i][j] == 'W') {
        f[i][j] = 0;
    }
    else if(g[i][j] == 'E') {
        f[i][j] = f[i-1][j] + 1;
    }
    else {
        f[i][j] = f[i-1][j];
    }
}

int bomb_game(vector<vector<char>>& g) {
    int m = g.size();
    if(m == 0) return 0;
    int n = g.size();
    if(n == 0) return 0;

    //����ը�Ķ�̬�滮״̬
    int f_up[m][n];
    //����ը�Ķ�̬�滮״̬
    int f_down[m][n];
    //����ը�Ķ�̬�滮״̬
    int f_left[m][n];
    //����ը�Ķ�̬�滮״̬
    int f_right[m][n];

    int res = INT_MIN;


    //Up Bomb
    for(int i = 0; i < m; ++i) {
        for(int j = 0; j < n; ++j) {
             //��һ�е����
            if(i == 0) {
                if(g[i][j] == '0' || g[i][j] == 'W') {
                    f_up[i][j] = 0;
                }
                else {
                    f_up[i][j] = 1;
                }
               continue;
            }


            //ת�Ʒ���
            if(g[i][j] == 'W') {
                f_up[i][j] = 0;
            }
            else if(g[i][j] == 'E') {
                f_up[i][j] = f_up[i-1][j] + 1;
            }
            else {
                f_up[i][j] = f_up[i-1][j];
            }
        }
    }


    //Down Bomb
    for(int i = m - 1; i >= 0 ; --i) {
        for(int j = 0; j < n; ++j) {
             //���һ�е����
            if(i == m-1) {
                if(g[i][j] == '0' || g[i][j] == 'W') {
                    f_down[i][j] = 0;
                }
                else {
                    f_down[i][j] = 1;
                }
                continue;
            }

            //ת�Ʒ���
            if(g[i][j] == 'W') {
                f_down[i][j] = 0;
            }
            else if(g[i][j] == 'E') {
                f_down[i][j] = f_down[i+1][j] + 1;
            }
            else {
                f_down[i][j] = f_down[i+1][j];
            }
        }
    }


    //Left Bomb
    for(int j = 0; j < n; ++j) {
        for(int i = 0; i < m; ++i) {
            //��һ��
            if(j == 0) {
                if(g[i][j] == '0' || g[i][j] == 'W') {
                    f_left[i][j] = 0;
                }
                else {
                    f_left[i][j] = 1;
                }
               continue;
            }

            //ת�Ʒ���
            if(g[i][j] == 'W') {
                f_left[i][j] = 0;
            }
            else if(g[i][j] == 'E') {
                f_left[i][j] = f_left[i][j-1] + 1;
            }
            else {
                f_left[i][j] = f_left[i][j-1];
            }
        }
    }

    //Right Bomb
    for(int j = n - 1; j >= 0; --j) {
        for(int i = 0; i < m; ++i) {
            //���һ��
            if(j == m-1) {
                if(g[i][j] == '0' || g[i][j] == 'W') {
                    f_right[i][j] = 0;
                }
                else {
                    f_right[i][j] = 1;
                }
               continue;
            }

            //ת�Ʒ���
             if(g[i][j] == 'W') {
                f_right[i][j] = 0;
            }
            else if(g[i][j] == 'E') {
                f_right[i][j] = f_right[i][j+1] + 1;
            }
            else {
                f_right[i][j] = f_right[i][j-1];
            }
        }
    }

    //��ȡ�յص����ֵ
    for(int i = 0; i < m; ++i) {
        for(int j = 0; j < n; ++j) {
            if(g[i][j] == 'W' || g[i][j] == 'E') {
                continue;
            }

            res = max(res, f_up[i][j] + f_down[i][j] + f_left[i][j] + f_right[i][j]);
        }
    }
    return res;

}

int main() {
    vector<vector<char>> g;
    vector<char> f;
    f.push_back('0');
    f.push_back('E');
    f.push_back('0');
    f.push_back('0');
    g.push_back(f);
    f.clear();
    f.push_back('E');
    f.push_back('0');
    f.push_back('W');
    f.push_back('E');
    g.push_back(f);
    f.clear();
    f.push_back('0');
    f.push_back('E');
    f.push_back('0');
    f.push_back('0');
    g.push_back(f);
    cout << bomb_game(g);
}

