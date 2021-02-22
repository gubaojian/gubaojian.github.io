#include<iostream>

inline int MAX(int x, int y){
    return (x > y) ? x : y;
}

int main(){
    std::cout << "Max (20, 10): " << MAX(20, 10) << std::endl;
    std::cout << "Max (0, 200): " << MAX(0, 200) << std::endl;
    std::cout << "Max (100, 1010): " << MAX(100, 1010) << std::endl;

    return 0;
}