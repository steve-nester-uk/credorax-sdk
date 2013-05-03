package com.credorax.sdk.tests;

import com.credorax.sdk.SDKException;
import com.credorax.sdk.Request;

/**
 * Helper class for implementers/testers of the Credorax ePower Gateway API.
 * Static methods in the class return a Request object with the minimum required
 * fields for each of the Basic Operations.
 * 
 * @author Steve Nester
 */
public class BasicOperations {
    /**
     * 
     * @param merchantID
     * @param requestID
     * @return              Request object with minimum required fields for operation
     * @throws SDKException 
     */
    public static Request getTestSaleRequest(String merchantID,String requestID) throws SDKException {
        return getStandAloneRequest("1", merchantID, requestID);
    }
    /**
     * 
     * @param merchantID
     * @param requestID
     * @return              Request object with minimum required fields for operation
     * @throws SDKException 
     */
    public static Request getTestAuthOnlyRequest(String merchantID,String requestID) throws SDKException {
        return getStandAloneRequest("2", merchantID, requestID);
    }
    /**
     * 
     * @param merchantID
     * @param requestID
     * @param responseID
     * @param previousAuthCode
     * @param previousRequestID
     * @return              Request object with minimum required fields for operation
     * @throws SDKException 
     */
    public static Request getTestCaptureRequest(String merchantID,String requestID, String responseID, String previousAuthCode, String previousRequestID) throws SDKException {
        return BasicOperations.getReferralRequest("3", merchantID, requestID, responseID, previousAuthCode, previousRequestID);
    }
    /**
     * 
     * @param merchantID
     * @param requestID
     * @param responseID
     * @param previousAuthCode
     * @param previousRequestID
     * @return              Request object with minimum required fields for operation
     * @throws SDKException 
     */
    public static Request getTestAuthVoidRequest(String merchantID,String requestID, String responseID, String previousAuthCode, String previousRequestID) throws SDKException {
        return BasicOperations.getReferralRequest("4", merchantID, requestID, responseID, previousAuthCode, previousRequestID);
    }
    /**
     * 
     * @param merchantID
     * @param requestID
     * @param responseID
     * @param previousAuthCode
     * @param previousRequestID
     * @return              Request object with minimum required fields for operation
     * @throws SDKException 
     */
    public static Request getTestReferralCreditRequest(String merchantID,String requestID, String responseID, String previousAuthCode, String previousRequestID) throws SDKException {
        return BasicOperations.getReferralRequest("5", merchantID, requestID, responseID, previousAuthCode, previousRequestID);
    }
    /**
     * 
     * @param merchantID
     * @param requestID
     * @return              Request object with minimum required fields for operation
     * @throws SDKException 
     */
    public static Request getTestIndependentCreditRequest(String merchantID,String requestID) throws SDKException {
        return getStandAloneRequest("6", merchantID, requestID);
    }
    /**
     * 
     * @param merchantID
     * @param requestID
     * @param responseID
     * @param previousAuthCode
     * @param previousRequestID
     * @return              Request object with minimum required fields for operation
     * @throws SDKException 
     */
    public static Request getTestSaleVoidRequest(String merchantID,String requestID, String responseID, String previousAuthCode, String previousRequestID) throws SDKException {
        return getReferralRequest("7", merchantID, requestID, responseID, previousAuthCode, previousRequestID);
    }
    /**
     * 
     * @param merchantID
     * @param requestID
     * @param responseID
     * @param previousAuthCode
     * @param previousRequestID
     * @return              Request object with minimum required fields for operation
     * @throws SDKException 
     */
    public static Request getTestRefundVoidRequest(String merchantID,String requestID, String responseID, String previousAuthCode, String previousRequestID) throws SDKException {
        return getReferralRequest("8", merchantID, requestID, responseID, previousAuthCode, previousRequestID);
    }
    /**
     * 
     * @param merchantID
     * @param requestID
     * @param responseID
     * @param previousAuthCode
     * @param previousRequestID
     * @return              Request object with minimum required fields for operation
     * @throws SDKException 
     */
    public static Request getTestCaptureVoidRequest(String merchantID,String requestID, String responseID, String previousAuthCode, String previousRequestID) throws SDKException {
        return getReferralRequest("9", merchantID, requestID, responseID, previousAuthCode, previousRequestID);
    }
    
    private static Request getStandAloneRequest(String opCode, String merchantID,String requestID) throws SDKException {
        Request req = new Request();
        req.setM(merchantID);
        req.setO(opCode);
        req.setA1(requestID);
        req.setA4("1020");
        req.setB1("4543130000001116");
        req.setB3("12");
        req.setB4("20");
        req.setB5("123");
        req.setC1("John Smith");
        req.setC3("John.Smith@example.com");
        req.setD1("1.1.1.1");
        return req;
    }
    private static Request getReferralRequest(String opCode, String merchantID,String requestID, String responseID, String previousAuthCode, String previousRequestID) throws SDKException {
        Request req = new Request();
        req.setM(merchantID);
        req.setO(opCode);
        req.setA1(requestID);
        req.setA4("1020");
        req.setD1("1.1.1.1");
        req.setG2(responseID);
        req.setG3(previousAuthCode);
        req.setG4(previousRequestID);
        return req;
    }
}
