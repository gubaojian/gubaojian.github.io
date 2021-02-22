#include <iostream>

const int MAX = 3;

int runoobArrayTest(){

    double runoobAarray[5] = {1000.0, 2.0, 3.4, 17.0, 50.0};
    double* p;
    p = runoobAarray;

    std::cout << "使用指针的数组值" <<std::endl;
    for(int i=0; i< 5; i++){
        std::cout << "*(p + " << i << ") : ";
        std::cout << *(p+i) << std::endl;
    }

    std::cout << "使用 runoobArray 作为地址的数组值" << std::endl; 
    for(int i=0; i<5; i++){
        std::cout << "*(runoobArray + " << i << ") : ";
        std::cout << *(runoobAarray + i) << std::endl;
    }


    return 0;
}

int main(){
    char chs[MAX] = {'a', 'b', 'c'};
    char* ptr;
    ptr = chs;

    for(int i=0; i<MAX; i++){
        std::cout << "Address of var[" << i << "] = ";
        std::cout << (int*)ptr << std::endl;

        std::cout << "Value of var[" << i << "] = ";
        std::cout << *ptr << std::endl;

        ptr++;  
    }
}