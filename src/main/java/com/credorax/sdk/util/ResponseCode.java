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
    public static String getResponseCode(String responseCode) {
        if (responseCode.equals("N3")) {
            return "Cash Service Not Available";
        }
        else if (responseCode.equals("N4")) {
            return "Cash Back Request Exceeds Issuer Limit";
        }
        else if (responseCode.equals("N7")) {
            return "N7 (visa, \"Decline CVV2 failure\"";
        }
        else if (responseCode.equals("R0")) {
            return "Stop Payment Order";
        }
        else if (responseCode.equals("R1")) {
            return "Revocation of Authorisation Order";
        }
        else if (responseCode.equals("R3")) {
            return "Revocation of all Authorisations Order";
        }
        
        int responseCodeInt = Integer.parseInt(responseCode);
        
        switch (responseCodeInt) {
            case 00:
                return "Approved or completed successfully";
            case 1:
                return "Approved or completed successfully";
            case 2:
                return "Refer to card issuer";
            case 3:
                return "Invalid merchant";
            case 4:
                return "Do not honour";
            case 5:
                return "Do not honour";
            case 6:
                return "Invalid Transaction for Terminal";
            case 7:
                return "Honour with ID";
            case 8:
                return "Time-Out";
            case 9:
                return "No Original";
            case 10:
                return "Unable to Reverse";
            case 11:
                return "Partial Approval";
            case 12:
                return "Invalid transaction card / issuer / acquirer";
            case 13:
                return "Invalid amount";
            case 14:
                return "Invalid card number";
            case 17:
                return "Invalid Capture date (terminal business date)";
            case 19:
                return "System Error; Re-enter transaction";
            case 20:
                return "No From Account";
            case 21:
                return "No To Account";
            case 22:
                return "No Checking Account";
            case 23:
                return "No Saving Account";
            case 24:
                return "No Credit Account";
            case 30:
                return "Format error";
            case 34:
                return "Implausible card data";
            case 39:
                return "Transaction Not Allowed";
            case 41:
                return "Lost Card, Pickup";
            case 42:
                return "Special Pickup";
            case 43:
                return "Hot Card, Pickup (if possible)";
            case 44:
                return "Pickup Card";
            case 51:
                return "Not sufficient funds";
            case 54:
                return "Expired card";
            case 55:
                return "Incorrect PIN; Re-enter";
            case 57:
                return "Transaction not permitted on card";
            case 58:
                return "Txn Not Permitted On Term";
            case 59:
                return "Suspected Fraud";
            case 61:
                return "Exceeds amount limit";
            case 62:
                return "Restricted card";
            case 63:
                return "MAC Key Error";
            case 65:
                return "Exceeds frequence limit";
            case 66:
                return "Exceeds Acquirer Limit";
            case 67:
                return "Retain Card; no reason specified";
            case 68:
                return "Response received too late.";
            case 75:
                return "Exceeds PIN Retry";
            case 76:
                return "Invalid Account";
            case 77:
                return "Issuer Does Not Participate In The Service";
            case 78:
                return "Function Not Available";
            case 79:
                return "Key Validation Error";
            case 80:
                return "Approval for Purchase Amount Only";
            case 81:
                return "Unable to Verify PIN";
            case 82:
                return "Invalid Card Verification Value";
            case 83:
                return "Not declined (valid for all zero amount transactions)";
            case 84:
                return "Invalid Life Cycle of transaction";
            case 85:
                return "No Keys To Use";
            case 86:
                return "K M E Sync Error";
            case 87:
                return "PIN Key Error";
            case 88:
                return "MAC sync Error";
            case 89:
                return "Security Violation";
            case 91:
                return "Issuer not available";
            case 92:
                return "Invalid Issuer";
            case 93:
                return "Transaction cannot be completed";
            case 94:
                return "Invalid originator";
            case 95:
                return "Contact Acquirer";
            case 96:
                return "System malfunction";
            case 97:
                return "No funds Transfer";
            case 98:
                return "Duplicate Reversal";
            case 99:
                return "Duplicate Transaction";
            default:
                return "Unrecognised responseCode, please check the latest API specification";
        }
    }
}
