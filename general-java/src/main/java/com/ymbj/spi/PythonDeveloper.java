package com.ymbj.spi;

public class PythonDeveloper implements Developer {

    @Override
    public void sayHi() {
        System.out.println("Hi, I am a Python Developer.");
    }
}
