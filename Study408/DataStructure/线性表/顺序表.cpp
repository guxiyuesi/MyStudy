#define ElemType int
#define maxSize 50
#include <bits/stdc++.h>

//定义结构体
typedef struct {
    ElemType *data;
    int length;
}SqList;

//初始化顺序表
void InitList(SqList& L) {
    L.data = new ElemType[maxSize];
    L.length = 0;
}

//返回顺序表的长度
int Length(SqList L) {
    return L.length;
}

//按值查找 为-1时说明没找到
int LocateElem(SqList L,ElemType e) {
    for(int i = 0; i < L.length; ++i) {
        if(L.data[i] == e) return i;
    }
    return -1;
}

//按位置查找
int GetElem(SqList L, int i) {
    //判断异常情况
    if(i < 0 || i >= L.length) {
        return -1;
    }

    return L.data[i];
}

//在第i个位置插入元素
bool ListInsert(SqList& L, int i , ElemType e) {
    //位置异常情况
    if(i < 1 || i-1 > L.length) {
        return false;
    }
    //顺序表已满
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

// 输出顺序表
void PrintList(SqList L) {
    for(int i = 0; i < L.length; ++i) {
        printf("%d ", L.data[i]);
    }
}

//删除第i个位置的元素
bool ListDelete(SqList& L, int i) {
    //异常情况
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


