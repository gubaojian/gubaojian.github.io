#include <iostream>

class Line{
    public:
       void setLength(double len);
       double getLength();
    public:
       Line(double len);
       Line(const Line& line);
       ~Line();
    private:
       double length;  
       int *ptr; 
};

Line::Line(double len):length(len){
    std::cout << "Object Line is being created" << std::endl;
    ptr = new int;
    *ptr = len;
    length = len;
}

Line::Line(const Line& line){
    std::cout << "Object is copy constructor  " << std::endl;
    ptr = new int;
    *ptr = *line.ptr;
}

Line::~Line(){
    delete ptr;
    std::cout << "Object is being deleted" << std::endl;
}

void Line::setLength(double len){
    length = len;
}

double Line::getLength(){
    return length;
}

void display(Line obj){
    std::cout << "line 大小 : " << obj.getLength() << std::endl;
}


int main(){
    Line line(19);
    
    std::cout << "Length of line : " << line.getLength() << std::endl;
    line.setLength(6);

    display(line);

    std::cout << "Length of line : " << line.getLength() << std::endl;

    Line line2 = line;

    display(line2);

    return 0;
}