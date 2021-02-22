#include <iostream>
#include <cstdlib>
#include <ctime>

int* getRandom(){
    static int r[10];
    srand((unsigned)time(NULL));
    for(int i=0; i<10; i++){
        r[i] = rand();
        std::cout << r[i] << std::endl;
    }
    return r;
}

int main(){
    int* p;
    p = getRandom();
    for(int i=0; i<10; i++){
        std::cout <<"*(p + " << i << ") : ";
        std::cout <<  *(p + i) << std::endl;
    }
    return 0;
}