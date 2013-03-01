package com.credorax.sdk.util;

/**
 * Helper class for dealing with the ResponseCode 
 * 
 * @author Steve Nester
 */
public class ResponseCode
{
    /**
     * Method returns a text description of the Response Code
     * @param responseCode
     * @return text description of the responseCode
     */
    public static String getResponseCode(int responseCode) {
        switch (responseCode) {
            case 00:
                return "Approved or completed successfully";
            case 01:
                return "Approved or completed successfully";
            case 02:
                return "Refer to card issuer";
            default:
                return "Method incomplete - unrecognised responseCode, please check the latest API specification";
        }
    }
}
