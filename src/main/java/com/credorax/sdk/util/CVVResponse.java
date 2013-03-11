package com.credorax.sdk.util;

/**
 * Static helper class for CVV
 * 
 * @author Steve Nester
 */
public class CVVResponse {
     /**
     * Method returns a text description of the CVV2 response
     * @param cvvResponse
     * @return text description of the CVV2 response
     */
    public static String getCVVResponse(String cvvResponse) {
        if (cvvResponse == null) {
            return "";
        }
        else {
            if (cvvResponse.equals("M")) {
                return "CVV2/CVC2 Match";
            }
            else if (cvvResponse.equals("N")) {
                return "CVV2/CVC2 No Match";
            }
            else if (cvvResponse.equals("P")) {
                return "Not processed";
            }
            else if (cvvResponse.equals("S")) {
                return "The CVV2 should be on the card but the merchant indicates it is not.";
            }
            else if (cvvResponse.equals("U")) {
                return "CVV2/CVC2 Unavailable – issuer does not support";
            }
            else if (cvvResponse.equals("Y")) {
                return "CVC1 Incorrect";
            }
            else if (cvvResponse.equals("R")) {
                return "CVV2/CVC2 Not sent";
            }
            else {
                return "Unrecognised CVV2 Response Code, please check the latest API specification";
            }
        }
    }
}
