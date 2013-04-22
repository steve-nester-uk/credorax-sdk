package com.credorax.sdk.util;

/**
 * Helper class for dealing with the ResultCode 
 * 
 * @author Steve Nester
 */
public class ResultCode {
    /**
     * Method returns a text description of the resultCode
     * @param resultCode
     * @return text description of the resultCode
     */
    public static String getResultCode(int resultCode) {
        switch (resultCode) {
            case -13:
                return "Transaction must include valid 3D secure data";
            case -12:
                return "Card Secure Code has to be present";
            case -11:
                return "Currency is not supported for the given merchant";
            case -10:
                return "Unclassified Error";
            case -9:
                return "Parameter is malformed.";
            case -8:
                return "Package Signature is malformed";
            case -7:
                return "No Response from the Gateway.  Connection is broken";
            case -5:
                return "Transaction has been rejected.  Processing has been stopped.";
            case -3:
                return "Account status was not updated";
            case -2:
                return "Account does not exist.";
            case -1:
                return "Account already exists.";
            case 0:
                return "Transaction has been executed successfully";
            case 1:
                return "Transaction has been denied by the Gate";
            case 2:
                return "Transaction has been denied by the Gate due to a high fraud score";
            case 3:
                return "Transaction has been denied by the Gate due to a AVS rules";
            case 4:
                return "Transaction has been denied by the Gate due to an interchange timeout";
            case 5:
                return "Transaction has been declined.";
            case 7:
                return "Redirect URL issued, see field z11";
            case 9:
                return "Transaction has been denied by the Gate due to the LUHN check failure.";
            case 100:
                return "Transaction is 3D enrolled";
            default:
                return "Unrecognised resultCode, please check the latest API specification";
        }
    }
}
