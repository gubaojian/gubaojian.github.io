#include<iostream>

double division(int a, int b){
    if(b == 0){
        throw "Division by zero condition!";
    }
    return (a/b);
}

struct MyException : public std::exception{
    const char* what() const throw(){
        return "C++ Exception";
    }
};

int main(){
    int x = 50;
    int y = 0;
    double z = 1;
    try{
        z = division(x, y);
    }catch(const char* msg){
        std::cerr << msg << std::endl;
    }
    
    try{
        throw MyException();
    }catch(MyException& e){
        std::cout << e.what() <<std::endl;
    }
}
