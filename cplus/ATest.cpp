#include <iostream>
#include <assert.h>

class A{
    public:
      int a;
    public:
       A(){
           a1 = 1;
           a2 = 2;
           a3 = 3;
           a = 4;
       }
    public:
       void fun(){
           std::cout << a << std::endl;
           std::cout << a1 << std::endl;
           std::cout << a2 << std::endl;
           std::cout << a3 << std::endl;
       }
   public :
      int a1;
   protected:
      int a2;
   private:
      int a3;   
};

class B : public A{
    public:
      int a;
    public:
     B(int i){
         A();
         a = 1;
     }  
    public:
      void fun(){
          std::cout << a << std::endl;
          std::cout << a1 << std::endl;
          std::cout << a2 << std::endl;
          //std::cout << a3 << std::endl;
      }
};

int main(){
    B b(10);
    std::cout << b.a << std::endl;
    std::cout << b.a1 << std::endl;
    //std::cout << b.a2 << std::endl;
    //std::cout << b.a3 << std::endl;
    system("pause");
    return 0;
}