#include <iostream>

class Distance{
    private:
      int feet;
      int inches;
    public:

      Distance(){
          feet = 0;
          inches = 0;
      }

      Distance(int f, int i){
          feet = f;
          inches = i;
      }

      friend std::ostream &operator<<(std::ostream &output, const Distance &distance){
          output << "F: " << distance.feet << " I : " << distance.inches << std::endl;
          return output;
      }

      friend std::istream &operator>>(std::istream &input, Distance &distance){
          input >> distance.feet >> distance.inches;
          return input;
      }
};

int main(){
    Distance D1(11, 10), D2(5, 11), D3;
    
    std::cout << "Enter the value of object : " << std::endl;
    std::cin >> D3;
    std::cout << "First Distance : " << D1 << std::endl;
    std::cout << "Second Distance : " << D2 << std::endl;
    std::cout << "Third Distance : " << D3 << std::endl;

    return 0;
}