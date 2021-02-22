#include <stdio.h>
#include <time.h>
#include <stdlib.h>
#include <unistd.h>


int main(){
    time_t rawtime;
    struct tm* info;
    char buffer[80];
    
    
    time(&rawtime);

    info = localtime(&rawtime);

    strftime(buffer, 80, "%Y-%m-%d %H:%M:%S", info);

    printf("格式化的日期&时间： ｜ %s | \n", buffer);


    time_t start_time, end_time;

    double diff_time;
    printf("程序启动...\n");
    time(&start_time);

    printf("休眠 5 秒...\n");
    sleep(5);

    time(&end_time);

    diff_time = difftime(end_time, start_time);

    printf("执行时间 = %f\n", diff_time);

    printf("程序退出");

    return 0;
}