#include <iostream>

class Line{
    public:
      double length;
      void setLength(double len);
      double getLength();
};

double Line::getLength(){
    return length;
}

void Line::setLength(double len){
    length = len;
}

int main(){
    Line line;
    line.setLength(6);

    std::cout << "Length of line: " << line.getLength() << std::endl;

    line.length = 10.0;

    std::cout << "Length of line : " << line.length << std::endl;

    return 0;
}