#include <iostream>

double getAverage(int attr[], int size){
    int i, sum = 0;
    double avg;
    for(i=0; i<size; i++){
        sum += attr[i];
    }
    avg = double(sum)/size;
    return avg;
}


int main(){
    int balance[5] = {1000, 2, 3, 17, 51};
    double avg;
    avg = getAverage(balance, 5);
    std::cout << "平均值是：" << avg << std::endl;
    return 0;
}