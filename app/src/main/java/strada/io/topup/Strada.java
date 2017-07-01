package strada.io.topup;

import android.net.Uri;

/**
 * Created by Gray Owl on 6/30/2017.
 */

public class Strada {
    final static int SPLASH_TIME = 3000;
    String encodedHash = Uri.encode("#");
    String encodedStar = Uri.encode("*");

    public String getCheckBalCode(String network){
        String checkBalCode = null;
        switch (network){
            case "Tmobile":
                checkBalCode = "tel:" + encodedHash + 686 + encodedHash;
                break;
            case "Airtel":
                break;
            case "MTN":
                break;
            case "Tigo":
                break;
            case "Glo":
                break;
            case "Expresso":
                break;
            case "Vodafone":
                break;
            case "Tmo2":
                checkBalCode = "tel:" + encodedHash + 225 + encodedHash;
            default:
                break;
        }

        return checkBalCode;
    }



}
