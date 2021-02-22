#include <algorithm>
#include <iostream>
#include <deque>

int main(){
    std::deque<int> alice{1, 2, 3};
    std::deque<int> bob{7, 8, 9};

    auto print = [](const int& n){
        std::cout << " " << n;
    };

    std::cout << "alice: ";
    std::for_each(alice.begin(), alice.end(), print);
    std::cout << "\n";
    std::cout << "bob  : ";
    std::for_each(bob.begin(), bob.end(), print);
    std::cout << "\n";

    std::swap(alice, bob);

    std::cout << "alice: ";
    std::for_each(alice.begin(), alice.end(), print);
    std::cout << "\n";
    std::cout << "box : ";
    std::for_each(bob.begin(), bob.end(), print);
    std::cout << "\n";
}