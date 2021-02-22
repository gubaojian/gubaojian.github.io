#include <iostream>
#include <thread>
#include <mutex>

std::mutex foo,bar;


void task_a(){
    std::lock(foo, bar);
    std::unique_lock<std::mutex> lockOne(foo, std::adopt_lock);
    std::unique_lock<std::mutex> lockTwo(bar, std::adopt_lock);
    std::cout << "task a" << std::endl;

    std::lock
}

void task_b(){
    std::unique_lock<std::mutex> lockOne,lockTwo;
    lockOne = std::unique_lock<std::mutex>(bar, std::defer_lock);
    lockTwo = std::unique_lock<std::mutex>(foo, std::defer_lock);
    std::lock(lockOne, lockTwo);
    std::cout << "task b" << std::endl;
}

int main(){
    std::thread th1(task_a);
    std::thread th2(task_b);

    th1.join();
    th2.join();

    return 0;
}