#include <iostream>


const int MAX = 3;

int main(){
    int nums[MAX] = {10, 100, 200};
    int *ptr;
    ptr = nums;

    for(int i=0; i<MAX; i++){
        std::cout << "Address of var[ " << i << "] = ";
        std::cout << ptr << std::endl;
        std::cout << "Value of var[" << i << "] = ";
        std::cout << *ptr << std::endl;
        ptr++;
    }

    ptr = &nums[MAX-1];

    for(int i=MAX; i > 0; i--){
        std::cout << "Address of var[" << i << "] = ";
        std::cout << ptr << std::endl;
        std::cout << "Value of var[" << i << "] = ";
        std::cout << *ptr << std::endl;
        ptr--;
    }


   ptr = nums;
   int i = 0;
   while( ptr <= &nums[MAX-1]){
       std::cout << "Address of var[" << i << "] = ";
       std::cout << ptr << std::endl;

       std::cout << "Value of var["  << i << "] = " <<  std::endl;
       std::cout << *ptr << std::endl;
       ptr++;
       i++;
   }


    return 0;
}