package org.attentiveness.news.data.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Api Response
 */
public class ApiResponse<T> {

    @SerializedName("showapi_res_code")
    private int code;

    @SerializedName("showapi_res_error")
    private String message;

    @SerializedName("showapi_res_body")
    private T obj;

    public ApiResponse() {

    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder;
        stringBuilder = new StringBuilder();
        stringBuilder.append("********** Api Response **********").append("\n");
        stringBuilder.append("code = ").append(this.getCode()).append("\n");
        stringBuilder.append("message = ").append(this.getMessage()).append("\n");
        stringBuilder.append(obj.getClass().getCanonicalName()).append(" = ").append(this.getObj()).append("\n");
        stringBuilder.append("********** Api Response **********").append("\n");
        return stringBuilder.toString();
    }
}
