#include <iostream>
class Distance{
    private:
       int feet;
       int inches;
    public:
       Distance(){
           feet =0; 
           inches = 0;
       }

       Distance(int f, int i){
           feet = f;
           inches = i;
       }

       Distance operator()(int a, int b, int c){
           Distance d;
           d.feet = a + c + 10;
           d.inches = b + c + 100;
           return d;
       }

       void displayDistance(){
           std::cout << "F: " << feet << " I: " << inches << std::endl;
       }
};

int main(){
    Distance d1(11, 10), d2;

    std::cout << "First Distance : ";
    d1.displayDistance();

    d2 = d1(10, 10, 10);

    std::cout << "Second Distance : ";
    d2.displayDistance();

    return 0;
}