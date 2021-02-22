#include <iostream>

class Box{
    public:
      Box (double l=2.0, double b=2.0, double h=2.0){
          std::cout << "Constructor called." << std::endl;
          length = l;
          breadth = b;
          height = h;
      }
    public:
       double Volume(){
           return length*breadth*height;
       }
       int compare(Box& box){
           return this->Volume() > box.Volume();
       }
    private:
       double length;
       double breadth;
       double height;
};




int main(){
    Box box1(3.3, 1.2, 1.5);
    Box box2(8.5, 6.0, 2.0);

    if(box1.compare(box2)){
        std::cout << "Box2 is smaller than Box1 " << std::endl;
    }else{
        std::cout << "Box2 is equal to or larger than Box1 " << std::endl;
    }

    return 0;
}