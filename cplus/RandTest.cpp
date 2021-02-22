#include <iostream>
#include <ctime>
#include <cstdlib>


int main(){
     
     srand((unsigned) time(NULL));

     for(int i=0; i<10; i++){
         int j = rand();
         std::cout << "随机数：" << j << std::endl;
     }

}