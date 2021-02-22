#include <iostream>
#include <iomanip>

int main(){
    double PI = 3.1415926;

    std::cout << PI << std::endl;

    std::cout << std::setprecision(2) << PI << std::endl;

    std::cout << std::fixed << std::setprecision(2) << PI << std::endl;

    std::cout << std::setfill('*') << std::setw(20) << std::setprecision(10) << PI << std::endl;

    std::cout << std::setfill('*') << std::setw(20) << std::setprecision(10) << std::left << PI << std::endl;


    std::cout << std::scientific << std::setprecision(10) << PI << std::endl;

    std::cout << std::scientific << std::uppercase << std::setprecision(10) << PI << std::endl;


}