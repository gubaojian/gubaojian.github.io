#include <iostream>
#include <csignal>
#include <unistd.h>

void signal_handler(int signum){
    std::cout << "Interrupt signal (" << signum << ") received. \n";
    exit(signum);
}

int main(){
    signal(SIGINT, signal_handler);
    
    int i=0;
    while(++i){
        std::cout << "Going to sleeping.... " << std::endl;
        if(i == 3){
            raise(SIGINT);
        }
        sleep(1);
    }

    return 0;
}