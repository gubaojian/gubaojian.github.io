#include <iostream>

class Shape{

    public:
      virtual int getArea() = 0;
      void setWidth(int w){
          width = w;
      }
      void setHeight(int h){
          height = h;
      }

      protected:
       int width;
       int height;
};

class Rectangle : public Shape{
    public:
      int getArea(){
        return (width*height);
      }
};

class Triangle : public Shape{
    public:
     int getArea(){
         return (width*height)/2;
     }
};

int main(){
    Rectangle rect;
    Triangle tri;

    rect.setWidth(5);
    rect.setHeight(7);

    std::cout << "Total Rectangle area: " << rect.getArea() << std::endl;
    
    tri.setWidth(5);
    tri.setHeight(7);

    std::cout << "Total Triangle area: " << tri.getArea() << std::endl;

    return 0;
}