package com.ymbj.executeflow;

public class VoidMethodReturnTest {
    public static void main(String[] args) {
        // 注意：void method 执行return语句后，main线程不会结束，还会继续执行，因此下面的语句是可以打印的
        testVoidMethodReturn();
        System.out.println("void method return successfully");
    }

    private static void testVoidMethodReturn() {
        return;
    }
}
