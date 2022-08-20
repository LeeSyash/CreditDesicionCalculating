package com.moskot.testTask;

public class DBAdapter {
    private static DBAdapter instance;

    private DBAdapter() {
    }

    public static DBAdapter getInstance() {
        if (instance == null) {
            instance = new DBAdapter();
        }
        return instance;
    }

    public Double getOpenLoanSum(int idClient) {
        return 12.0;
    }

    public void insertLimitDecision(Client client) {
        System.out.println(client);
    }
}
