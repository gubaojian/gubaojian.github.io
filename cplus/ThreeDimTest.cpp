#include <iostream>

int main(){
    int i,j,k;
    int ***p;
    p = new int **[2];


    //输出数据
    for(i=0; i<2; i++){
        p[i] = new int *[3];
        for(j=0; j<3; j++){
            p[i][j] = new int[4];
        }
    }


    //输出 p[i][j][k] 三维数据
    for(i=0; i<2; i++){
        for(j=0; j<3; j++){
            for(k=0; k<4; k++){
                p[i][j][k] = i + j + k;
                std::cout << p[i][j][k] << " "; 
            }
            std::cout << std::endl;
        }
        std::cout << std::endl;
    }


    //释放内存
    for(i=0; i<2; i++){
        for(j=0; j<3; j++){
            delete [] p[i][j];
        }
    }

    //释放内存
    for(i=0; i<2; i++){
        delete [] p[i];
    }

    delete [] p;

    return 0;
}