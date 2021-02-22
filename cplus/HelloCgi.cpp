#include <iostream>

int main(){
    std::cout << "Content-type: text/html \r\n\r\n";
    std::cout << "<html>\n";
    std::cout << "<head>\n";
    std::cout << "<title>Hello World - 第一个CGI程序</title>\n";
    std::cout << "</head>\n";
    std::cout << "<body>\n";
    std::cout << "<h2>Hello World! 这是我的第一个CGI程序 </h2>\n";
    std::cout << "</body>\n";
    std::cout << "</html>\n";
    
    return 0;
}