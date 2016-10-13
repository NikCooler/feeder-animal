package com.eat.go;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;


/**
 * @author Nik Smirnov
 */
public abstract class JSONResponse<T> implements Serializable {

    private T data;

    private Status status;

    public JSONResponse(){}

    public JSONResponse(T data, Status status) {
        super();
        this.data = data;
        this.status = status;
    }

    @ApiModelProperty(name = "data", required = true)
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @ApiModelProperty(name = "status", required = true)
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
