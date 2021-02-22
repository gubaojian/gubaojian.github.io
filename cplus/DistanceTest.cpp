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
      void displayDistance(){
          std::cout << "F: " << feet << " I: " << inches << std::endl;
      }
      Distance operator-(){
          feet = -feet;
          inches = -inches;
          return Distance(feet, inches);
      }
};

int main(){
    Distance D1(11, 10), D2(-5, 11);


    D1.displayDistance();
    D1 = -D1;
    D1.displayDistance();

    D2.displayDistance();
    D2 = -D2;
    D2.displayDistance();
    return 0;
}