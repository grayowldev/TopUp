package com.ideogramm.topup;

import android.net.Uri;

public class MtnNetworkManager implements MobileNetworkManager {

    @Override
    public String getBalance(String country) {
        if (country.equalsIgnoreCase("ghana"))
            return "*124" + Uri.encode("#");
        return null;
    }

}
