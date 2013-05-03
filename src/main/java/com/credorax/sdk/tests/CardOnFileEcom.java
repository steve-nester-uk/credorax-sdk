package com.credorax.sdk.tests;

import com.credorax.sdk.SDKException;
import com.credorax.sdk.Request;

/**
 * Helper class for implementers/testers of the Credorax ePower Gateway API.
 * Static methods in the class return a Request object with the minimum required
 * fields for each of the Card-On-File Operations.
 * 
 * @author Steve Nester
 */
public class CardOnFileEcom {
    /**
     * 
     * @param merchantID
     * @param requestID
     * @return              Request object with minimum required fields for operation
     * @throws SDKException 
     */
    public static Request getTestRegistrationRequest(String merchantID,String requestID) throws SDKException {
        return getStandAloneRequest("10", merchantID, requestID);
    }
    /**
     * 
     * @param merchantID
     * @param requestID
     * @param token
     * @return              Request object with minimum required fields for operation
     * @throws SDKException 
     */
    public static Request getTestRegistrationDebitRequest(String merchantID,String requestID, String token) throws SDKException {
        return getUseTokenRequest("11", merchantID, requestID, token);
    }
    /**
     * 
     * @param merchantID
     * @param requestID
     * @param token
     * @return              Request object with minimum required fields for operation
     * @throws SDKException 
     */
    public static Request getTestRegistrationAuthOnlyRequest(String merchantID,String requestID, String token) throws SDKException {
        return getUseTokenRequest("12", merchantID, requestID, token);
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
    public static Request getTestRegistrationCaptureRequest(String merchantID,String requestID, String token, String responseID, String previousAuthCode, String previousRequestID) throws SDKException {
        return getReferralRequest("13", merchantID, requestID, token, responseID, previousAuthCode, previousRequestID);
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
    public static Request getTestRegistrationAuthVoidRequest(String merchantID,String requestID, String token, String responseID, String previousAuthCode, String previousRequestID) throws SDKException {
        return getReferralRequest("14", merchantID, requestID, token, responseID, previousAuthCode, previousRequestID);
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
    public static Request getTestRegistrationCreditRequest(String merchantID,String requestID, String token, String responseID, String previousAuthCode, String previousRequestID) throws SDKException {
        return getReferralRequest("15", merchantID, requestID, token, responseID, previousAuthCode, previousRequestID);
    }
    /**
     * 
     * @param merchantID
     * @param requestID
     * @param token
     * @return              Request object with minimum required fields for operation
     * @throws SDKException 
     */
    public static Request getTestLockRegisteredAcctRequest(String merchantID,String requestID, String token) throws SDKException {
        return getUseTokenRequest("16", merchantID, requestID, token);
    }
    /**
     * 
     * @param merchantID
     * @param requestID
     * @param token
     * @return              Request object with minimum required fields for operation
     * @throws SDKException 
     */
    public static Request getTestUnlockRegisteredAcctRequest(String merchantID,String requestID, String token) throws SDKException {
        return getUseTokenRequest("17", merchantID, requestID, token);
    }
    /**
     * 
     * @param merchantID
     * @param requestID
     * @param token
     * @return              Request object with minimum required fields for operation
     * @throws SDKException 
     */
    public static Request getTestRetrieveRegisteredAcctRequest(String merchantID,String requestID, String token) throws SDKException {
        return getUseTokenRequest("18", merchantID, requestID, token);
    }
    
/**
     * 
     * @param merchantID
     * @param requestID
     * @param token
     * @return              Request object with minimum required fields for operation
     * @throws SDKException 
     */
    public static Request getTestUpdateClientBillingRequest(String merchantID,String requestID, String token) throws SDKException {
        return getUpdateOperation("19", merchantID, requestID, token);
    }
    
    private static Request getStandAloneRequest(String opCode, String merchantID,String requestID) throws SDKException {
        Request req = new Request();
        req.setM(merchantID);
        req.setO(opCode);
        req.setA1(requestID);
        req.setA4("1030");
        req.setB1("4543130000001116");
        req.setB3("12");
        req.setB4("20");
        req.setB5("123");
        req.setC1("John Smith");
        req.setC3("John.Smith@example.com");
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
    
    private static Request getUpdateOperation(String opCode, String merchantID,String requestID, String token) throws SDKException {
        Request req = new Request();
        req.setM(merchantID);
        req.setO(opCode);
        req.setA1(requestID);
        req.setB1("4543130000001116");
        req.setB3("12");
        req.setB4("20");
        req.setB5("123");
        req.setD1("1.1.1.1");
        req.setG1(token);
        return req;
    }
}
