#include <iostream>

class Distance{
    private:
      int feet;
      int inches;
    public:
       Distance(){
           feet = 0;
           inches = 0;
       }

       Distance(int f, int i){
           feet = f;
           inches = i;
       }

       void displayDistance(){
           std::cout << "F: " << feet << " I: "<< inches << std::endl;
       }

       Distance operator-(){
           feet = -feet;
           inches = -inches;
           return Distance(feet, inches);
       }

       bool operator < (const Distance& d){
           if(feet < d.feet){
               return true;
           }
           if(feet == d.feet && inches == d.inches){
               return true;
           }
           return false;
       }
};

int main(){
    Distance D1(11, 10), D2(5, 11);
    if(D1 < D2){
        std::cout << "D1 is less than D2 " << std::endl;
    }else{
        std::cout << "D2 is less than D1 " << std::endl;
    }
    return 0;
}