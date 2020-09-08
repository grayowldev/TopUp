package com.ideogramm.topup;

public class TmobileNetworkManager implements MobileNetworkManager {
    @Override
    public String getBalance(String country) {
        if (country.equalsIgnoreCase("usa")) return "#225#";
        return null;
    }
}
