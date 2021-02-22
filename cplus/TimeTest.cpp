#include <iostream>
#include <ctime>

int main(){

    time_t now = time(0);

    char* dt = ctime(&now);

    std::cout << "本地日期和时间" << dt << std::endl;

    tm* gmtm = gmtime(&now);
    dt = asctime(gmtm);

    std::cout << "UTC 日期和时间：" << dt << std::endl;



    std::cout << "1970 到目前经过的秒数：" << now << std::endl;

    tm* ltm = localtime(&now);

    std::cout << "年："<< 1900 + ltm->tm_year << std::endl;
    std::cout << "月：" << 1 + ltm->tm_mon << std::endl;
    std::cout << "日：" << ltm->tm_mday << std::endl;
    std::cout << "时间：" << ltm->tm_hour << ":";

    std::cout << ltm->tm_min << ":";
    std::cout << ltm->tm_sec << std::endl;
    
}