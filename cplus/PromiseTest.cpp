#include <vector>
#include <thread>
#include <future>
#include <numeric>
#include <iostream>
#include <chrono>

void accmulate(std::vector<int>::iterator first, std::vector<int>::iterator last, std::promise<int> accumulate_promise){
    int sum = std::accumulate(first, last, 0);
    accumulate_promise.set_value(sum);
}

void do_work(std::promise<void> barrier){
    std::this_thread::sleep_for(std::chrono::seconds(1));
    barrier.set_value();
}

int main(){
    std::vector<int> numbers = {1, 2, 3, 4, 5, 6, 7, 8};
    std::promise<int> accumulate_promise;
    std::future<int> accumulate_furture = accumulate_promise.get_future();
    std::thread work_thread(accmulate, numbers.begin(), numbers.end(), std::move(accumulate_promise));
    std::cout << "result=" << accumulate_furture.get() << "\n";
    work_thread.join();


    std::promise<void> barrier;
    std::future<void> barrier_future = barrier.get_future();
    std::thread barrier_worker_thread(do_work, std::move(barrier));
    std::cout << "barrier wait" << std::endl;
    barrier_future.get();
    std::cout << "barrier wait end" << std::endl;
    barrier_worker_thread.join();
}