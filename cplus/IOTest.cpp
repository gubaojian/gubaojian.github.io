#include <iostream>

int main(){
    char str[] = "Hello C++";

    std::cout << "Value of str is : " << str << std::endl;


    char name[50];


    std::cin >> name;

    std::cout << "你的名字是: " << name << std::endl;

    char estr[] = "Unable to read";
    std::cerr << "Error message : " << estr << std::endl;


    char lstr[] = "Unable to read";

    std::clog << "Error message : " << lstr << std::endl;
}