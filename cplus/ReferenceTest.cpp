#include <iostream>

void swap(int& a, int& y);

double values[] = {10.1, 12.6, 33.1, 24.1, 50.0};

double &setValues(int i){
    return values[i];
}

int main(){
    int i; 
    double d;
    int& r = i;
    double& s = d;
    i = 5;


    std::cout << "Value of i : " << i << std::endl;
    std::cout << "Value of i Reference : " << r << std::endl;
    
    d = 11.7;

    std::cout << "Value of d : " << d << std::endl;

    std::cout << "Value of d Reference : " << s << std::endl;


    int a = 100;
    int b = 200;

    std::cout << "交换前，a的值：" << a << std::endl;
    std::cout << "交换前，b的值：" << b << std::endl;

    swap(a, b);

    std::cout << "交换后，a的值为： " << a << std::endl;
    std::cout << "交换后，b的值为：" << b << std::endl;

    std::cout << "改变前的值" << std::endl;

    for(int i=0; i< 5; i++){
        std::cout << "values[" << i << "] = " ;
        std::cout << values[i] << std::endl; 
    }

    setValues(1) = 20.23;
    setValues(3) = 70.8;

    std::cout << "改变后的值" << std::endl;

    for(int i=0; i< 5; i++){
        std::cout << "values[" << i << "] = ";
        std::cout << values[i] << std::endl;
    }


    return 0;
}

void swap(int& x, int& y){
    int temp;
    temp = x;
    x = y;
    y = temp;
}