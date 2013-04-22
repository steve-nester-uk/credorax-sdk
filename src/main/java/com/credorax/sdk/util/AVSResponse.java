package com.credorax.sdk.util;

/**
 * Static helper class for AVS
 * 
 * @author Steve Nester
 */
public class AVSResponse {
    /**
     * Method returns a text description of the AVS response
     * @param avsResponse
     * @return text description of the AVS response
     */
    public static String getAVSResponse(String avsResponse) {
        if (avsResponse == null) {
            return "";
        }
        else {
            if (avsResponse.equals("-")) {
                return "The card is not in service for AVS";
            }
            else if (avsResponse.equals("A")) {
                return "Partial Match - Address matches; Zip/Postal Code does not match";
            }
            else if (avsResponse.equals("B")) {
                return "Partial Match - Address matches; Postal Code not supplied or not checked";
            }
            else if (avsResponse.equals("C")) {
                return "No Match - Postal Code does not match; Address not supplied or not checked";
            }
            else if (avsResponse.equals("D")) {
                return "No Match - Address does not match; Postal Code not supplied or not checked";
            }
            else if (avsResponse.equals("E")) {
                return "Error response for Merchant Category";
            }
            else if (avsResponse.equals("F")) {
                return "Full Match - Address and Postal Code matches";
            }
            else if (avsResponse.equals("G")) {
                return "International No Match - Address not verified";
            }
            else if (avsResponse.equals("I")) {
                return "Address information not verified";
            }
            else if (avsResponse.equals("M")) {
                return "International Full Match - Address and Zip/Postal Code matches";
            }
            else if (avsResponse.equals("N")) {
                return "No Match - Address and Postal Code do not match";
            }
            else if (avsResponse.equals("P")) {
                return "International Partial Match - Zip/Postal Code matches; Address does not match";
            }
            else if (avsResponse.equals("R")) {
                return "Issuer system unavailable or timeout; Retry";
            }
            else if (avsResponse.equals("S")) {
                return "Service not supported by issuer";
            }
            else if (avsResponse.equals("U")) {
                return "Address information unavailable";
            }
            else if (avsResponse.equals("W")) {
                return "For US addresses: Partial Match - nine-digit Zip Code matches; Address does not match.  For addresses outside the US: Partial Match - Postal Code matches; Address does not match";
            }
            else if (avsResponse.equals("X")) {
                return "For US addresses: Full Match - nine-digit Zip Code and Address match.  For addresses outside the US: Full Match - Postal Code and Address match";
            }
            else if (avsResponse.equals("Y")) {
                return "Street address and postal code match";
            }
            else if (avsResponse.equals("Y")) {
                return "Postal/ZIP matches; street addres does not match or street address not included in request.";
            }
            else {
                return "Unrecognised AVS Response Code, please check the latest API specification";
            }
        }
    }
}
