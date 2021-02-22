#include <iostream>
#include <iomanip>

int main(){
     int n[10];
     for(int i=0; i<10; i++){
         n[i] = i + 100;
     }
     std::cout << "Element" << std::setw(13) << "Value" << std::endl;
     for(int j=0; j<10; j++){
         std::cout << std::setw(7) << j << std::setw(13) << n[j] << std::endl;
     }
}