#include <iostream>

class Check{
    private:
       int i;
    public:
      Check():i(3){

      }

      Check operator--(){
          Check temp;
          temp.i = --i;
          return temp;
      }

      Check operator--(int){
          Check temp;
          temp.i = i--;
          return temp;
      }

      void Display(){
          std::cout << "i = " << i << std::endl;
      }
};

int main(){
    Check obj, obj1;

    obj.Display();
    obj1.Display();

    obj1 = --obj;
    obj.Display();
    obj1.Display();

    obj1 = obj--;
    obj.Display();
    obj1.Display();

    return 0;
}