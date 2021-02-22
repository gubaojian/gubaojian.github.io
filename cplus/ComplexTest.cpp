#include <iostream>
class Complex{
    private:
      double i;
      double j;
    public:
      Complex(int a=0, int b =0);
      void display();
      Complex operator++();
      Complex operator++(int);
};

Complex::Complex(int a,int b){
    i = a;
    j = b;
}

void Complex::display(){
    std::cout << i << '+' << j << 'i' << std::endl;
}

Complex Complex::operator++(){
    ++i;
    ++j;
    return *this;
}

Complex Complex::operator++(int){
    Complex temp  = *this;
    ++*this;
    return temp;
}

int main(){
    Complex c1(2, 2), c2, c3;

    std::cout << "自增计算前：" << std::endl;
    std::cout << "c1 :";
    c1.display();
    std::cout << "c2 :";
    c2.display();
    std::cout << "c3 : ";
    c3.display();
     std::cout << std::endl;

    std::cout << "前缀自增计算后：" << std::endl;
    c2 = ++c1;
    std::cout << "c1: ";
    c1.display();
    std::cout << "c2: ";
    c2.display();
    std::cout << "c3: ";
    c3.display();
    std::cout << std::endl;

    std::cout << "后缀自增计算后: " << std::endl;
    c3 = c1++;
    std::cout << "c1 : ";
    c1.display();
    std::cout << "c3 : ";
    c3.display(); 
}