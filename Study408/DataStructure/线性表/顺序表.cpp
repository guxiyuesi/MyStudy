#define ElemType int
#define maxSize 50
#include <bits/stdc++.h>

//����ṹ��
typedef struct {
    ElemType *data;
    int length;
}SqList;

//��ʼ��˳���
void InitList(SqList& L) {
    L.data = new ElemType[maxSize];
    L.length = 0;
}

//����˳���ĳ���
int Length(SqList L) {
    return L.length;
}

//��ֵ���� Ϊ-1ʱ˵��û�ҵ�
int LocateElem(SqList L,ElemType e) {
    for(int i = 0; i < L.length; ++i) {
        if(L.data[i] == e) return i;
    }
    return -1;
}

//��λ�ò���
int GetElem(SqList L, int i) {
    //�ж��쳣���
    if(i < 0 || i >= L.length) {
        return -1;
    }

    return L.data[i];
}

//�ڵ�i��λ�ò���Ԫ��
bool ListInsert(SqList& L, int i , ElemType e) {
    //λ���쳣���
    if(i < 1 || i-1 > L.length) {
        return false;
    }
    //˳�������
    if(L.length == maxSize) {
        return false;
    }
    for(int index = L.length - 1; index >= i-1; index --) {
        L.data[index+1] = L.data[index];
    }
    L.data[i-1] = e;
    L.length += 1;
    return true;
}

// ���˳���
void PrintList(SqList L) {
    for(int i = 0; i < L.length; ++i) {
        printf("%d ", L.data[i]);
    }
}

//ɾ����i��λ�õ�Ԫ��
bool ListDelete(SqList& L, int i) {
    //�쳣���
    if(i < 1 || i > L.length) {
        return false;
    }

    for(int index = i - 1; index < L.length; ++index) {
        L.data[index] = L.data[index + 1];
    }
    L.length --;
    return true;
}

bool Empty(SqList L) {
    return L.length == 0;
}

void DestroyList(SqList& L) {
    delete L.data;
    L.length = 0;
}

int main() {
    SqList L;
    InitList(L);
    ListInsert(L, 1, 1);
    ListInsert(L, 2, 2);
    ListInsert(L, 2, 3);
    ListInsert(L, 1, 4);
    ListInsert(L, 3, 5);
    ListInsert(L, 8, 6);

    ListDelete(L, 1);
    printf("%d\n", Empty(L));
    PrintList(L);
    DestroyList(L);
}


