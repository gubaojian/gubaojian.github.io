#include <iostream>


void getSeconds(unsigned long *ptr);

double getAverage(int* arr, int size);


int * myFunction();

int main(){
    int p;
    int *pp;
    int **ppp;

     p = 3000;
     pp = &p;
     ppp = &pp;

     int balance[5] = {1000, 2, 3, 17, 50};

     double avg;

     std::cout << "p的值为: " << p << std::endl;

     std::cout << "*ptr 值为: " << *pp << std::endl;

     std::cout << "**ptr 值为: " << **ppp << std::endl;

     unsigned long sec;


     getSeconds(&sec);


     std::cout << "Number of seconds :" << sec << std::endl;

     avg = getAverage(balance, 5);


     std::cout << "Average value is: " << avg << std::endl;

     int* a = myFunction();

     for(int i=0; i<10; i++){
         std::cout << "*(a + " << i << ") : ";
         std::cout << *(a + i) << std::endl;
     }

     delete a;

     return 0;
}


void getSeconds(unsigned long *ptr){
   *ptr = time(NULL);
}

double getAverage(int *attr, int size){
    int i, sum = 0;
    double avg;
    for(int i=0; i<size; i++){
        sum += attr[i];
    }
    avg = ((double)sum) / size;
    return avg;
}

int* myFunction(){
    int* a = new int[10];

    srand((unsigned)time(NULL));

    for(int i=0; i<10; i++){
        a[i] = rand();
        std::cout << a[i] << std::endl;
    }

    return a;
}