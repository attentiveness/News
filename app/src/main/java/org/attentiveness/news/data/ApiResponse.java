package org.attentiveness.news.data;


import com.google.gson.annotations.SerializedName;

public class ApiResponse<T> {

    @SerializedName("showapi_res_code")
    private int code;

    @SerializedName("showapi_res_error")
    private String message;

    @SerializedName("showapi_res_body")
    private T obj;

    public ApiResponse() {
        //empty
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
        return "ApiResponse{" +
                "code=" + code +
                ", message=" + message +
                ", obj=" + obj +
                "}";
    }
}
