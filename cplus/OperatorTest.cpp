#include <iostream>
class A{
    private:
       int a;
    public:
       A();
       A(int n);
       A operator+(const A &obj);
       A operator+(const int b);
       friend A  operator+(const int b, A obj);
       void display();   
};

A::A(){
    a = 0;
}

A::A(int n){
    a = n;
}

A A::operator +(const A& obj){
    return this->a + obj.a;
}

A A::operator+(const int b){
    return A(a + b);
}

A operator+(const int b, A obj){
    return obj + b;
}

void A::display(){
    std::cout << a << std::endl;
}

int main(){
    A a1(1);
    A a2(2);
    A a3, a4, a5;

    a1.display();
    a2.display();
    int m=1;
    a3 = a1 + a2;
    a3.display();
    a4 = a1 + m;
    a4.display();
    a5 = m + a1;
    a5.display();
}