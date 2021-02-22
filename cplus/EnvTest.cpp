#include <iostream>
#include <stdlib.h>
#include <stdio.h>
#include <string>


const std::string ENV[24] = {
    "COMSPEC", "DOCUMENT_ROOT", "GATEWAY_INTERFACE",
    "HTTP_ACCEPT", "HTTP_ACCEPT_ENCODING",
    "HTTP_ACCEPT_LANGUAGE", "HTTP_CONNECTION",
    "HTTP_HOST", "HTTP_USER_AGENT", "PATH",
    "QUERY_STRING", "REMOTE_ADDR", "REMOTE_PORT",
    "REQUEST_METHOD", "REQUEST_URI", "SCRIPT_FILENAME",
    "SCRIPT_NAME", "SERVER_ADDR", "SERVER_ADMIN",
    "SERVER_NAME", "SERVER_PORT", "SERVER_PROTOCOL",
    "SERVER_SIGNATURE", "SERVER_SOFTWARE"
};

int main(){

    std::cout << "Content-type: text/html \r\n\r\n";
    std::cout << "<html>\n";
    std::cout << "<head>\n";
    std::cout << "<title>CGI 环境变量</title>\n";
    std::cout << "</head>";
    std::cout << "<body>\n";
    std::cout << "<table border=\"0\" cellspacing=\"2\" >";

    for(int i=0; i<24; i++){
        std::cout << "<tr><td>" << ENV[i] << "</td><td>";
        char* value = getenv(ENV[i].c_str());
        if(value != 0){
            std::cout << value;
        }else{
            std::cout << "环境变量不存在。";
        }
        std::cout << "</td></tr>\n";
    }

    std::cout << "</table>\n";
    std::cout << "</body>\n";
    std::cout << "</html>\n";


    return 0;
}