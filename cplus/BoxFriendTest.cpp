#include <iostream>

class Box{
    private:
       double width;
    public:
       friend void printWidth(Box box);
       void setWidth(double wid);
    public:
       friend class BigBox;
};

class BigBox{

    public:
       void print(int width,  Box& box){
           box.setWidth(width);
           std::cout << "Width of box : " << box.width << std::endl;
       }
};

void Box::setWidth(double wid){
    width = wid;
}

void printWidth(Box box){
    std::cout << "Width of box : " << box.width << std::endl;
}

int main(){
    Box box;

    box.setWidth(10.0);

    printWidth(box);
}