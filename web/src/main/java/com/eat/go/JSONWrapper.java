package com.eat.go;

import java.io.Serializable;


public class JSONWrapper<T> implements Serializable {

    private T data;
    private Status status;

    public JSONWrapper(){}

    public JSONWrapper(T data, Status status) {
        super();
        this.data = data;
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public enum Status {
        SUCCESS, FAILURE
    }

}
