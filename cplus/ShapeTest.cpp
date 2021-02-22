#include <iostream>

class Shape{
    public:
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

class PaintCost{
    public:
       int getCost(int area){
           return area*70;
       }
};

class Rectangle : public Shape, public PaintCost{
    public:
       int getArea(){
           return (width*height);
       }
};

int main(){
    Rectangle rect;
    rect.setWidth(5);
    rect.setHeight(7);

    int area = rect.getArea();

    std::cout << "Total area: " << rect.getArea() << std::endl;

    std::cout << "Total paint cost: $" << rect.getCost(area) << std::endl;

    return 0;
}