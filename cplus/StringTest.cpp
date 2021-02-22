#include <iostream>
#include <string>

int main(){
   
   char site[7] = {'R', 'U', 'N', 'O', 'O', 'B', '\0'};

   std::cout << "菜鸟教程： ";
   std::cout << site << std::endl;

   
    char str1[13] = "runoob";
    char str2[13] = "google";
    char str3[13];
    int len;

    strcpy(str3, str1);

    std::cout << "strcpy(str3, str1): " << str3 << std::endl;

    strcat(str1,  str2);

    std::cout << "strcat(str1, str2): " << str1 << std::endl;

    len = strlen(str1);

    std::cout << "strlen(str1): " << len  << std::endl;


    std::string pstr1 = "runoob";
    std::string pstr2 = "google";
    std::string pstr3;
    int plen;

    pstr3 = pstr1;

    std::cout << "str3 : " << pstr3  << std::endl;
    pstr3 = pstr1 + pstr2;

    std::cout << "pstr1 + pstr2 " << pstr3 << std::endl;

    plen = pstr3.size();

    std::cout << "str3.size() : " << plen << std::endl;


    return 0;
}