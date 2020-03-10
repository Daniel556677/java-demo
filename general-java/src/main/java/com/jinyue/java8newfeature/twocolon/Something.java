package com.jinyue.java8newfeature.twocolon;

class Something {

    // constructor methods
    Something() {}

    Something(String something) {
        System.out.println(something);
    }

    // static methods
    static String startsWith(String s) {
        return String.valueOf(s.charAt(0));
    }

    // Object method
    String endWith(String s) {
        return String.valueOf(s.charAt(s.length()-1));
    }

    void endWith() {}
}