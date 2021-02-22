#include <iostream>
#include <thread>
#include <future>

int main(){
    std::promise<int> p;
    std::future<int> f = p.get_future();
    std::thread t([&p]{
        try{
            throw std::runtime_error("Example");
        }catch(...){
            try{
                p.set_exception(std::current_exception());
            }catch(...){
            }
        }
    });

    try{
        std::cout << f.get();
    }catch(const std::exception& e){
        std::cout << "Exception from the thread: " << e.what() << "\n";
    }
    t.join();

}