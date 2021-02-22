#include<iostream>

class PrintData{
    public:
      void print(int i){
          std::cout << "整数为: " <<  i << std::endl;
      }

      void print(double f){
          std::cout << "浮点数为：" << f << std::endl;
      }

      void print(char str[]){
          std::cout << "字符串为："<< str << std::endl;
      }
};

int main(){
    PrintData pd;
    pd.print(5);

    pd.print(500.263);

   // pd.print("Hello C++");

    char ch[] = "Hello C++";

    pd.print(ch);

    return 0;
}