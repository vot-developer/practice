package org.multithreading;

/*
library should always create a single instance of any of the superheroes and return the same instance
to all the requesting consumers.
 */
public class Superman {
    private volatile static Superman instance;

    private Superman() {
    }

    public static Superman getInstance(){
        if (instance == null){
            synchronized (Superman.class){
                if (instance == null)
                    instance = new Superman();
            }
        }
        return instance;
    }
}
