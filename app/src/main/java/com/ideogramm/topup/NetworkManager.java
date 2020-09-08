package com.ideogramm.topup;

public class NetworkManager {
    public static String getBalace( String country, String network){
        if (network.equalsIgnoreCase("tmobile")) return new TmobileNetworkManager().getBalance(country);
//        else if (network.equalsIgnoreCase("mtn")) return
        return null;
    }
}
