#include <iostream>

int main(){
    std::cout << "Hello World" << std::endl;

    #if 0
    std::cout << "Hello Zero" << std::endl;
    #endif

     #if 1
    std::cout << "Hello One" << std::endl;
    #endif
}