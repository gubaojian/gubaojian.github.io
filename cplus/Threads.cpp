#include <thread>
#include <iostream>
#include <mutex>


thread_local int g_num = 1;
std::mutex g_num_lock;

void fung(){
    std::lock_guard<std::mutex> gurad(g_num_lock);
    g_num++;
    std::cout<< std::this_thread::get_id() << " num " << g_num << std::endl;
}


int main(){

    std::thread one(fung);
    std::thread two(fung);

    one.join();
    two.join();

    fung();


}