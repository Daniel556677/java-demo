package com.jinyue.common.message;

/**
 * netty远程通信过程中传递的消息
 */
public class RpcMessage {
    private String className;
    private String methodName;
    private Class<?>[] parameterType;
    private String parameterValue;

    public void setClassName(String className) {
        this.className = className;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public void setParameterType(Class<?>[] parameterType) {
        this.parameterType = parameterType;
    }

    public void setParameterValue(String parameterValue) {
        this.parameterValue = parameterValue;
    }

    public String getClassName() {
        return className;
    }

    public String getMethodName() {
        return methodName;
    }

    public Class<?>[] getParameterType() {
        return parameterType;
    }

    public String getParameterValue() {
        return parameterValue;
    }
}
