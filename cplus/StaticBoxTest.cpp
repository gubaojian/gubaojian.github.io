#include <iostream>


class Box{
    public:
      static int objectCount;

      Box(double l=2.0, double b=2.0, double h=2.0){
          std::cout << "Constructor called. " << std::endl;
          length = l;
          breadth = b;
          height = h;
          objectCount++;
      }

      double Volume(){
          return length *breadth*height;
      }
      static int getCount(){
          return objectCount;
      }

    private:
       double length;
       double breadth;
       double height;
};

int Box::objectCount = 0;

int main(){
    Box box1(3.3, 1.2, 1.5);
    Box box2(8.5, 6.0, 2.0);

    std::cout << "Total objects:  " << Box::objectCount << std::endl;
    std::cout << "Total objects:  " << Box::getCount() << std::endl;

    return 0;
}