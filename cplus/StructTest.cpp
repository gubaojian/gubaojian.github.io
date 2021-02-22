#include <iostream>
#include <cstring>

struct Books{
    char title[50];
    char author[50];
    char subject[100];
    int book_id;
};


typedef struct Books{
    char title[50];
    char author[50];
    char subject[100];
    int book_id'
} Books;

void printBook(struct Books book){
     std::cout << "书标题 : " << book.title << std::endl;
    std::cout << "书作者 : " << book.author << std::endl;
    std::cout << "书类目 : " << book.subject << std::endl;
    std::cout << "本书 ID : " << book.book_id << std::endl;
}

typedef long int * pint32;

int main(){

    Books book1;
    Books book2;

    strcpy(book1.title, "C++ 教程");
    strcpy(book1.author, "Runoob");
    strcpy(book1.subject, "编程语言");
    book1.book_id = 12345;

    strcpy(book2.title, "CSS 教程");
    strcpy(book2.author, "Runoob");
    strcpy(book2.subject, "前端技术");
    book2.book_id = 123456;

    //输出 Book1的信息
    std::cout << "第一本书标题 : " << book1.title << std::endl;
    std::cout << "第一本书作者 : " << book1.author << std::endl;
    std::cout << "第一本书类目 : " << book1.subject << std::endl;
    std::cout << "第一本书 ID : " << book1.book_id << std::endl;

    //输出 Book2的信息
    std::cout << "第二本书标题 : " << book2.title << std::endl;
    std::cout << "第二本书作者 : " << book2.author << std::endl;
    std::cout << "第二本书类目 : " << book2.subject << std::endl;
    std::cout << "第二本书 Id  :" << book2.book_id << std::endl;

    printBook(book1);

    printBook(book2);

    struct Books *bookPtr;

    bookPtr = &book1;

    printBook(*bookPtr);

     printBook(*bookPtr);

     pint32 x, y, z;
    

}