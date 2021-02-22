#include <iostream>

class Time{
    private:
      int hours;
      int minutes;

    public:
       Time(){
           hours = 0;
           minutes = 0;
       }

       Time(int h, int m){
           hours = h;
           minutes = m;
       }

       void displayTime(){
           std::cout << "H: " << hours << " M: " << minutes << std::endl;
       }

       Time operator++(){
           ++minutes;
           if(minutes >= 60){
               ++hours;
               minutes -=60;
           }
           return Time(hours, minutes);
       }

       Time operator++(int){
           Time t(hours, minutes);
           ++minutes;
           if(minutes >= 60){
               ++hours;
               minutes -=60;
           }
           return t;
       }
};

int main(){
    Time t1(11, 59), t2(10, 40);

    ++t1;
    t1.displayTime();
    ++t1;
    t1.displayTime();

    t2++;
    t2.displayTime();

    t2++;
    t2.displayTime();

    return 0;
}