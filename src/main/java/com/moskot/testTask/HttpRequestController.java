package com.moskot.testTask;

public class HttpRequestController {
    private static HttpRequestController instance;

    private HttpRequestController() {
    }

    public static HttpRequestController getInstance() {
        if (instance == null) {
            instance = new HttpRequestController();
        }
        return instance;
    }

    public float getCurrencyExchange(){
        return 1F;
    }
}
