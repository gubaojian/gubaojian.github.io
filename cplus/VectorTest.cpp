#include<iostream>
#include<vector>

int main(){
    std::vector<int> vec;
    int i;

    std::cout << "vector size = " << vec.size() << std::endl;

    for(int i=0; i<5; i++){
        vec.push_back(i);
    }


    std::cout << "extended vector size = " << vec.size() << std::endl;

    for(int i=0; i<5; i++){
        std::cout << "value of vec [ " << i << " ] = " << vec[i] << std::endl;
    }

    std::vector<int>::iterator v = vec.begin();

    while(v != vec.end()){
        std::cout << "value of v = " << *v << std::endl;
        v++;
    }

    return 0;
}