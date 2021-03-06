package com.credorax.sdk.tests;

import com.credorax.sdk.SDKException;
import com.credorax.sdk.Request;

/**
 * Helper class for implementers/testers of the Credorax ePower Gateway API.
 * Static methods in the class return a Request object with the minimum required
 * fields for each of the Card-On-File (recurring) Operations.
 * 
 * @author Steve Nester
 */
public class ManualSubscriptionOperations {
    /**
     * 
     * @param merchantID
     * @param requestID
     * @return              Request object with minimum required fields for operation
     * @throws SDKException 
     */
    public static Request getTestStartSubscriptionWithInitialDebit(String merchantID,String requestID) throws SDKException {
        return getStartSubscriptionRequest("23", merchantID, requestID);
    }
    /**
     * 
     * @param merchantID
     * @param requestID
     * @return              Request object with minimum required fields for operation
     * @throws SDKException 
     */
    public static Request getTestStartSubscriptionWithInitialAuth(String merchantID,String requestID) throws SDKException {
        return getStartSubscriptionRequest("28", merchantID, requestID);
    }
    /**
     * 
     * @param merchantID
     * @param requestID
     * @param token
     * @return              Request object with minimum required fields for operation
     * @throws SDKException 
     */
    public static Request getTestSubscriptionDebitCycle(String merchantID,String requestID, String token) throws SDKException {
        return getUseTokenRequest("24", merchantID, requestID, token);
    }
    /**
     * 
     * @param merchantID
     * @param requestID
     * @param token
     * @return              Request object with minimum required fields for operation
     * @throws SDKException 
     */
    public static Request getTestSubscriptionDebitCycleAuthStep(String merchantID,String requestID, String token) throws SDKException {
        return getUseTokenRequest("32", merchantID, requestID, token);
    }
    /**
     * 
     * @param merchantID
     * @param requestID
     * @param token
     * @param responseID
     * @param previousAuthCode
     * @param previousRequestID
     * @return              Request object with minimum required fields for operation
     * @throws SDKException 
     */
    public static Request getTestStartSubscriptionCapture(String merchantID,String requestID, String token, String responseID, String previousAuthCode, String previousRequestID) throws SDKException {
        return getReferralRequest("29", merchantID, requestID, token, responseID, previousAuthCode, previousRequestID);
    }
    /**
     * 
     * @param merchantID
     * @param requestID
     * @param token
     * @param responseID
     * @param previousAuthCode
     * @param previousRequestID
     * @return              Request object with minimum required fields for operation
     * @throws SDKException 
     */
    public static Request getTestSubscriptionDebitCycleCapture(String merchantID,String requestID, String token, String responseID, String previousAuthCode, String previousRequestID) throws SDKException {
        return getReferralRequest("33", merchantID, requestID, token, responseID, previousAuthCode, previousRequestID);
    }
    private static Request getStartSubscriptionRequest(String opCode, String merchantID,String requestID) throws SDKException {
        Request req = new Request();
        req.setM(merchantID);
        req.setO(opCode);
        req.setA1(requestID);
        req.setA4("1030");
        req.setA8("1234567890123456");
        req.setB1("4543130000001116");
        req.setB3("12");
        req.setB4("20");
        req.setB5("123");
        req.setC1("John Smith");
        req.setC2("999-9999-9999");
        req.setC3("John.Smith@example.com");
        //req.setC4("10");
        //req.setC5("Downing Street");
        //req.setC6("10");
        //req.setC7("London");
        //req.setC8("-");
        req.setC9("GB");  
        req.setC10("0000");
        req.setD1("1.1.1.1");
        return req;
    }
    private static Request getUseTokenRequest(String opCode, String merchantID,String requestID, String token) throws SDKException {
        Request req = new Request();
        req.setM(merchantID);
        req.setO(opCode);
        req.setA1(requestID);
        //req.setA4("2530");
        req.setD1("1.1.1.1");
        if (opCode.equals("32")) {
            req.setH7("1");
        }
        req.setG1(token);
        return req;
    }
    private static Request getReferralRequest(String opCode, String merchantID,String requestID, String token, String responseID, String previousAuthCode, String previousRequestID) throws SDKException {
        Request req = new Request();
        req.setM(merchantID);
        req.setO(opCode);
        req.setA1(requestID);
        req.setD1("1.1.1.1");
        req.setG1(token);
        req.setG2(responseID);
        req.setG3(previousAuthCode);
        req.setG4(previousRequestID);
        return req;
    }
}
