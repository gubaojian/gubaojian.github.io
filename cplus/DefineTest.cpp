#include <iostream>

#define PI 3.14159

#define MIN(a, b) (a < b ? a: b)

#define MKSTR(x) #x

#define concat(x, y) x##y##c

int main(){
    std::cout << "Value of PI : " << PI << std::endl;


    int i, j;
    i = 100;
    j = 30;

    std::cout << "较小的值为：" << MIN(i, j) << std::endl;


    std::cout << MKSTR(HELLO C++) << std::endl;

    int xy = 100;
    int xyc = 200;

    std::cout << concat(x, y) << std::endl;


    std::cout << "Value of __LINE__ : " << __LINE__ <<std::endl;
    std::cout << "Value of __FILE__ : " << __FILE__ << std::endl;
    std::cout << "Value of __DATE__ : " << __DATE__ << std::endl;
    std::cout << "Value of __TIME__ : " << __TIME__ << std::endl;

    return 0;
}