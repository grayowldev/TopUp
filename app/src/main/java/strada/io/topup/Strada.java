package strada.io.topup;

import android.net.Uri;
import android.support.annotation.Nullable;

/**
 * Created by Gray Owl on 6/30/2017.
 */

public class Strada {
    final static int SPLASH_TIME = 2500;
    String encodedHash = Uri.encode("#");
    String encodedStar = Uri.encode("*");

    public String getCheckBalCode(String network){
        String checkBalCode = null;
        switch (network){
            case "Tmobile":
                checkBalCode = "tel:" + encodedHash + 686 + encodedHash;
                break;
            case "Airtel":
                checkBalCode = "tel:" + encodedStar + 133 + encodedHash;
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

    public String getAddBalCode(String network, @Nullable int topupCode){
        String addBalCode = null;
        switch (network){
            case "Tmobile":
                addBalCode = "tel:" + encodedHash + 686 + encodedHash;
                break;
            case "Airtel":
                addBalCode = "tel:" + encodedStar + 134 + encodedStar + topupCode + encodedHash;
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
                addBalCode = "tel:" + encodedHash + 225 + encodedHash;
            default:
                break;
        }

        return addBalCode;
    }



}
