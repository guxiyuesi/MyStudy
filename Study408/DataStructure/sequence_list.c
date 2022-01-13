#include <stdio.h>

typedef struct {
	int* data;
	int MaxSize, length;
}SeqList;


int main() {
	SeqList L;
	initSeqList(&L);
	printf("L.length = ", L.length)
}


//初始化
void initSeqList(SeqList *L) {
	int initSize = 50;
	L.MaxSize = 100;
	L.length  = 0; 
	L.data = (int*)malloc(sizeof(int) * initSize);
	
}
