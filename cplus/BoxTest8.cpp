#include<iostream>

class Box{
        double length;
        double breadth;
        double height;
    public:
       
       double getVolume(){
           return length*breadth*height;
       }

       void setLength(double len){
           length = len;
       }

       void setBreadth(double bre){
           breadth = bre;
       }

       void setHeight(double hei){
           height = hei;
       }

       friend Box operator+(const Box&a, const Box& b);
};

Box operator+(const Box& a, const Box& b){
    Box box;
    box.length = a.length + b.length;
    box.breadth = a.breadth + b.breadth;
    box.height = a.height + b.height;
    return box;
}

int main(){
    Box box1;
    Box box2;
    Box box3;
    double volume = 0;

    box1.setLength(6.0);
    box1.setBreadth(7.0);
    box1.setHeight(5.0);

    box2.setLength(12.0);
    box2.setBreadth(13.0);
    box2.setHeight(10.0);

    volume = box1.getVolume();

    std::cout << "Volume of box1 : " << volume << std::endl;

    volume = box2.getVolume();
    std::cout << "Volume of box2 : " << volume << std::endl;
    box3 = box1 + box2;
    
    volume = box3.getVolume();

    std::cout << "Volume of box3 : " << volume << std::endl;
}