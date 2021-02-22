#include<iostream>
#include<pthread.h>

#define NUM_THREADS 5

void* say_hello(void* args){
    std::cout << "Hello Runoob!" << std::endl;
    return 0;
}

int main(){
    pthread_t tids[NUM_THREADS];
    for(int i=0; i< NUM_THREADS; ++i){
        int ret = pthread_create(&tids[i], NULL, say_hello, NULL);
        if(ret != 0){
            std::cout << "pthread_create error: error_code=" << ret << std::endl;
        }
    }
    pthread_exit(NULL);
}