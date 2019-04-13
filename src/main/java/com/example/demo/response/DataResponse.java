package com.example.demo.response;

public class DataResponse {
    private String data;

    public DataResponse(Object data) {
        this.data = data.toString();
    }

    public String getData() {
        return data;
    }
}
