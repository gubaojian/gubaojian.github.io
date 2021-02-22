#include <iostream>

int main(){
    double* ptr = NULL;
    ptr = new double;

    *ptr = 29494.99;

    std::cout << "Value of pvalue : " << *ptr << std::endl;

    delete ptr;


   char* chPtr = NULL;
   chPtr = new char[20];

   
   delete[] chPtr;

   int m = 20;
   int*  aPtr = new int[m];

   delete[] aPtr;


   int** array;

   array  = new int *[m];
   for(int i=0; i<m; i++){
       array[i] = new int[m];
   }

   for(int i=0; i<m; i++){
       delete [] array[i];
   }

   delete[] array;

   int **p;
   int i,j;

   p = new int *[4];

   for(i=0; i<4; i++){
       p[i] = new int[8];
   }

   for(i=0; i<4; i++){
       for(j=0; j<8; j++){
           p[i][j] = j*i;
       }
   }


   for(i=0; i<4; i++){
       for(j=0; j<8; j++){
           std::cout << p[i][j] << "\t";
       }
       std::cout << std::endl;
   }

   for(i=0; i<4; i++){
       delete [] p[i];
   }

   delete [] p;

   
 
    

    return 0;
}