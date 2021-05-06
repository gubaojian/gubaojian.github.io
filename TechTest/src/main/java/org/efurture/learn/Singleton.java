package org.efurture.learn;

public class Singleton {
    private  volatile static Singleton instance;

    private volatile static boolean hasMember;
    private volatile static int hasFlag;

    private Singleton(){
    }

    public static Singleton getInstance(){
        if(instance == null){
            synchronized (Singleton.class){
                if(instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args){
        System.out.println(getInstance());
    }
}
