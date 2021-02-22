
#include<stdio.h>
#include<stddef.h>
#include<type_traits>


struct AnyType{
    template <typename T>
    operator T();
};
/**
template <typename T> consteval size_t CountMember(auto&&... args){
    if constexpr (!requires{T{args..}}){
        return sizeof...(args) - 1;
    }else{
        return CountMember<T>(args..., AnyType);
    }
}*/

template <typename T, typename = void, typename ...Ts>
struct CountMember{
    constexpr static size_t value = sizeof...(Ts)-1;
};

template <typename T, typename ...Ts>
struct CountMember<T, std::void_t<decltype(T{Ts{}...})>,Ts...>{
    constexpr static size_t value = CountMember<T, void, Ts..., AnyType>::value;
};

int main(int argc, char** argv){
    struct Test{int a; int b; int c; int d;};
    printf("%zu\n", CountMember<Test>());
}