#include<iostream>
#include<vector>
#include<cstdlib>
#include<string>
#include<stdexcept>

template <class T> class Stack{


     private:
        std::vector<T> elems;
    public:
      void push(T const&);
      void pop();
      T top() const;
      bool empty()const{
          return elems.empty();
      } 
};

template <class T> void Stack<T>::push(T const& elem){
    elems.push_back(elem);
}

template <class T> void Stack<T>::pop(){
    if(elems.empty()){
        throw std::out_of_range("Stack<>::pop(): empty stack");
    }
    elems.pop_back();
}

template <class T> T Stack<T>::top() const{
    if(elems.empty()){
        throw std::out_of_range("Stack<>::top(): empty stack");
    }
    return elems.back();
}


int main(){
    try{
        Stack<int> intStacks;
        Stack<std::string> stringStacks;
        
        intStacks.push(7);

        std::cout << intStacks.top() << std::endl;

        stringStacks.push("Hello");


        std::cout << stringStacks.top() << std::endl;

        stringStacks.pop();
        stringStacks.pop();


    }catch(std::exception const& ex){
        std::cerr << "Exception " << ex.what() << std::endl;
    }
}



