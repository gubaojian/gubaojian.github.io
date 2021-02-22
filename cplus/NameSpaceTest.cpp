#include <iostream>

namespace first_space{
    void func(){
        std::cout << "Inside first_space " << std::endl;
    }
}

namespace second_space{
    void func(){
        std::cout << "Inside second_space " << std::endl;
    }
}

int main(){
    first_space::func();
    second_space::func();


    return 0;
}