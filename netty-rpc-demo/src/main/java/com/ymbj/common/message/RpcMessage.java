package com.ymbj.common.message;

import java.io.Serializable;

/**
 * netty远程通信过程中传递的消息
 */
public class RpcMessage implements Serializable {
    private String className;
    private String methodName;
    private Class<?>[] parameterType;
    private Object[] parameterValues;

    public RpcMessage(String className, String methodName, Class<?>[] parameterType, Object[] parameterValues) {
        this.className = className;
        this.methodName = methodName;
        this.parameterType = parameterType;
        this.parameterValues = parameterValues;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public void setParameterType(Class<?>[] parameterType) {
        this.parameterType = parameterType;
    }

    public void setParameterValues(String parameterValue) {
        this.parameterValues = parameterValues;
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

    public Object[] getParameterValues() {
        return parameterValues;
    }
}
