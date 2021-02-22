#include <iostream>

class Person{
   public:
      Person();
      ~Person();

   int getAge() const;
   int getCallingTimes() const;

   private:   
      int age;
      char* name;
      mutable int m_nums;
};

Person::Person(){
    m_nums = 0;
    age = 100;
}

int Person::getAge() const{
    m_nums++;
    return age;
}

int Person::getCallingTimes()const{
    return m_nums;
}

Person::~Person(){

}



int main(){

    Person* person = new Person();

    for(int i=0; i<10; i++){
         std::cout << "call " << i  << " " << person->getAge() << std::endl;
    }

    std::cout << "call times " << person->getCallingTimes() << std::endl;

}