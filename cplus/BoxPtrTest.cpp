#include <iostream>
class Box{
    public:
       Box(double l=2.0, double b=2.0, double h=2.0){
           std::cout << "Constructor called. " << std::endl;
           length = l;
           breadth = b;
           height = h;
       }
    public:
       double Volume(){
           return length*breadth*height;
       }
    private:
      double length;
      double breadth;
      double height;
};

int main(){
    Box box1(3.3, 1.2, 1.5);
    Box box2(8.5, 6.0, 2.0);
    Box* ptrBox;
    ptrBox = &box1;

    std::cout << "Volume of box1 : " << ptrBox->Volume() << std::endl;

    ptrBox = &box2;
    std::cout << "Volume of box2 : " << ptrBox->Volume() << std::endl;

    return 0;
}