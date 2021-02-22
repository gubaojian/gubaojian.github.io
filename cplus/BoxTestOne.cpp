#include <iostream>

class Box{
    public:
       double length;
    public:
       void setWidth(double wid);
       double getWidth();
    protected:
       double width;
};

class SmallBox:Box{
    public:
       void setSmallWidth(double wid);
       double getSmallWidth();
};

double Box::getWidth(){
    return width;
}

void Box::setWidth(double wid){
    width = wid;
}

double SmallBox::getSmallWidth(){
    return width;
}

void SmallBox::setSmallWidth(double wid){
    width = wid;
}

int main(){
    Box box;
    box.length = 10.0;

    std::cout << "Length of box : " << box.length << std::endl;

    box.setWidth(10.0);

    std::cout << "Width of box : " << box.getWidth() << std::endl;

    SmallBox sbox;

    sbox.setSmallWidth(5.0);

    std::cout << "Width of box : " << sbox.getSmallWidth() << std::endl;

    return 0;
}