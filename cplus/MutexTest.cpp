#include <iostream>
#include <mutex>
#include <chrono>
#include <thread>

std::mutex mtx;

std::recursive_mutex rc_mtx;

std::timed_mutex tmtx;

std::mutex emutx;


void print_even(int n){
    if(n%2 == 0){
        std::cout << n  << "is even\n";
    }else{
        throw std::logic_error("not even");
    }
}

void print_thread_id(int id){
    try{
        emutx.lock();
        std::lock_guard<std::mutex> elock(emutx, std::adopt_lock);
        print_even(id);
    }catch(std::logic_error& error){
        std::cout << "[exception caught]\n";
    }
}

void fireworks(){
    while(!tmtx.try_lock_for(std::chrono::microseconds(200))){
        std::cout << "-";
    }

    std::this_thread::sleep_for(std::chrono::microseconds(200));
    std::cout << "\n";
    tmtx.unlock();
}

void print_block(int n, char c){
   std::lock_guard<std::mutex> lock(mtx);
   for(int i=0; i<n; i++){
        std::cout << c << std::endl;
   }
}






void print_next(int n, char c){
    std::lock_guard<std::recursive_mutex> rlock(rc_mtx);
    for(int i=0; i<n; i++){
        std::cout << c << std::endl;
   }
}

int main(){
    std::thread one(print_next, 50, '*');
    std::thread two(print_next, 50, '$');

    one.join();
    two.join();

    std::thread threads[10];

    for(int i=0; i<10; i++){
        threads[i] = std::thread(fireworks);
    }
    
    for(auto& th : threads){
         th.join();        
    }

    std::thread threadEvens[10];
    for(int i=0; i<10; i++){
          threadEvens[i] = std::thread(print_thread_id, i + 1);
    }

    for(auto& threadEven : threadEvens){
        threadEven.join();
    }

    return 0;
}