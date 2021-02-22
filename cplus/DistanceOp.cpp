#include<iostream>

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

       void operator=(const Distance& d){
           feet = d.feet;
           inches = d.inches;
       }

       void displayDistance(){
           std::cout << "F: " << feet << " I: " << inches << std::endl;
       }
};

int main(){
    Distance d1(11, 10), d2(5, 11);

    std::cout << "First Distance : ";
    d1.displayDistance();
    std::cout << "Second Distance : ";
    d2.displayDistance();

    d1 = d2;

    std::cout << "First Distance : ";
    d1.displayDistance();

    return 0;
}