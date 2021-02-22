#include <iostream>
#include <limits>
#include <stdio.h>

enum color {
    red,
    green,
    blue
};

int main(){
    color c = color::blue;
    std::cout << "type: \t\t" << "***************size****************" << std::endl;
    std::cout << "bool \t\t" << "占用字节" << sizeof(bool) ;
    std::cout << "\t最大值"  << std::numeric_limits<bool>::max() ;
    std::cout << "\t最小值" << std::numeric_limits<bool>::min() << std::endl;

    std::cout << "singed char: \t"  << "占用字节" << sizeof(signed char);
    std::cout << "\t最大值" << std::numeric_limits<int>::max();
    std::cout << "\t最小值" << std::numeric_limits<int>::min() << std::endl;

    std::cout << c << std::endl;

    const int WIDTH = 100;
    const int HEIGHT  = 40;
    const char NEWLINE = '\n';

    int area = WIDTH*HEIGHT;

    std::cout << area  << std::endl;

    std::cout << NEWLINE << "换行" << std::endl;

    int* __restrict__ nums = (int*)malloc(8*sizeof(int));

    for(int i=0; i<8; i++){
        nums[i] += 5;
        nums[i] +=3;
    }

    for(int i=0; i<8; i++){
        std::cout << nums[i] << std::endl;
    }
  }