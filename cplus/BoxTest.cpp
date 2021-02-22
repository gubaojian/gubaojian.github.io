#include <iostream>


class Box{
    public:
       double _length;
       double _breadth;
       double _height;
    public:
       double get(void);
       void set(double len, double breadth, double height);
       double getVolume();
};

double Box::get(void){
    return _length*_breadth*_height;
}

void Box::set(double length, double breadth, double height){
    _length = length;
    _breadth = breadth;
    _height = height;
}

double Box::getVolume(){
    return _length*_breadth*_height;
}

int main(){
    Box box1;
    Box box2;
    Box box3;

    double volume = 0;

    box1._height = 5.0;
    box1._length = 6.0;
    box1._breadth = 7.0;

    box2._height = 10.0;
    box2._length = 12.0;
    box2._breadth = 13.0;

    volume = box1._height*box1._length*box1._breadth;

    std::cout << "Box1 的体积：" << box1.getVolume() << std::endl;

    std::cout << "Box2 的体积：" << box2.getVolume() << std::endl;

    box3.set(16.0, 8.0, 12.0);

    std::cout << "Box3 的体积：" << box3.getVolume() << std::endl;

}