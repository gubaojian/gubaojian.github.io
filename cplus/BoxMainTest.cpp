#include<iostream>

class Box{

    private:
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
       void setBreadth(double pre){
           breadth = pre;
       }
       void setHeight(double hei){
           height = hei;
       }

       Box operator+(const Box& b){
           Box box;
           box.length = this->length + b.length;
           box.breadth = this->breadth + b.breadth;
           box.height = this->height + b.height;
           return box;
       }
};

int main(){
    Box box1;
    Box box2;
    Box box3;
    double volume = 0.0;

    box1.setLength(6.0);
    box1.setHeight(5.0);
    box1.setBreadth(7.0);

    box2.setLength(12.0);
    box2.setBreadth(13.0);
    box2.setHeight(10.0);

    volume = box1.getVolume();

    std::cout << "Voume of box1 " << volume << std::endl;

    volume = box2.getVolume();

    std::cout << "Volume of box2 " << volume << std::endl;

    box3 = box1 + box2;


    volume = box3.getVolume();

    std::cout << "Volume of box3 : " << volume << std::endl;

    return 0;
}