package com.ymbj.java8newfeature.twocolon;

// 如何用 '::' 来访问类Something中的方法呢？先定义一个接口，因为必须要用 functional interface 来接收，
// 否则编译错误（The target type of this expression must be a functional interface）
//————————————————
//版权声明：本文为CSDN博主「kegaofei」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
//原文链接：https://blog.csdn.net/kegaofei/article/details/80582356
@FunctionalInterface
interface IConvert<F, T> {
    T convert(F form);
}

