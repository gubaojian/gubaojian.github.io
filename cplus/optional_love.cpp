#include <iostream>
#include <optional>
#include <string>

std::optional<int> to_num_int(const std::string& num_str){
    std::optional<int> num;
    try {
        num = std::stoi(num_str);
    } catch (std::exception& exp) {
        std::cout <<"Hello Exception " << exp.what() << std::endl;
    }
    return num;
}

int main(){
    
    auto nums = {"3", "hhh$", "5", "6"};
    for(auto num : nums){
        std::optional<int>  s = to_num_int(num);
        if(s){
           std::cout <<"convert" << *s << std::endl;
        }else{
           std::cout <<"convert failed"  << std::endl;
        }
    }
    
    std::cout <<"Hello World" << std::endl;
}
