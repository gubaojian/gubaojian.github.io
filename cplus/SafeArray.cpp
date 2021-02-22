#include <iostream>

const int SIZE = 10;

class SafeArray{
    
    private:
       int arr[SIZE];

    public:
      SafeArray(){
          for(int i=0; i<SIZE; i++){
              arr[i] = i;
          }
      }

      int &operator[](int i){
          if(i > SIZE){
              std::cout << "索引超过最大值" << std::endl;
              return arr[0];
          }
          return arr[i];
      }
};

int main(){
    SafeArray sa;

    std::cout << "A[2] 的值为 : " << sa[2] << std::endl;
    std::cout << "A[5] 的值为 : " << sa[5] << std::endl;
    std::cout << "A[12] 的值为 : " << sa[12] << std::endl;

    return 0;
}