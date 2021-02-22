#include<iostream>
#include<fstream>

int main(){
    char data[100];
    std::ofstream outfile;
    outfile.open("afile.dat");

    std::cout << "Writing to the file" << std::endl;
    std::cout << "Enter your name: ";

    std::cin.getline(data, 100);


    outfile << data << std::endl;

    std::cout << "Enter your age: ";

    
    std::cin >> data;
    std::cin.ignore();

    outfile << data << std::endl;

    outfile.close();

    std::ifstream infile;
    infile.open("afile.dat");

    std::cout << "Reading from the file " << std::endl;

    infile >> data;

    std::cout << data << std::endl;

    infile >> data;

    std::cout << data << std::endl;

    infile.close();


    return 0;
}