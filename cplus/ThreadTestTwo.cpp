#include <iostream>
#include <cstdlib>
#include <pthread.h>

#define NUM_THREADS  5

void *PrintHello(void* threadId){
    int tid = *((int*)threadId);
    std::cout << "Hello Runnob! 线程 ID, " << tid << std::endl;
    pthread_exit(NULL);
}

int main(){
    pthread_t threads[NUM_THREADS];
    int indexes[NUM_THREADS];
    int rc;
    int i;

    for(i=0; i< NUM_THREADS; i++){
        std::cout << "main() : 创建线程，" << i << std::endl;
        indexes[i] = i;
        rc = pthread_create(&threads[i], NULL, PrintHello, (void*)&(indexes[i]));

        if(rc){
            std::cout << "Error: 无法创建线程, " << rc << std::endl;
            exit(-1);
        }
    }
    pthread_exit(NULL);
}