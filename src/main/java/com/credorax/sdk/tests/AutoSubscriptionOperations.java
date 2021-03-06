package com.credorax.sdk.tests;

import com.credorax.sdk.SDKException;
import com.credorax.sdk.Request;
import com.credorax.sdk.util.Encoding;
import java.util.Date;

/**
 * Helper class for implementers/testers of the Credorax ePower Gateway API.
 * Static methods in the class return a Request object with the minimum required
 * fields for each of the Auto Subscription Operations.
 * 
 * @author Steve Nester
 */
public class AutoSubscriptionOperations{
    /**
     * 
     * @param merchantID
     * @param requestID
     * @return              Request object with minimum required fields for operation
     * @throws SDKException 
     */
    public static Request getTestStartSubscriptionRequest(String merchantID,String requestID) throws SDKException {
        return getStartSubscriptionRequest("20", merchantID, requestID);
    }
    /**
     * 
     * @param merchantID
     * @param requestID
     * @param token
     * @return              Request object with minimum required fields for operation
     * @throws SDKException 
     */
    public static Request getTestCancelSubscriptionRequest(String merchantID,String requestID, String token) throws SDKException {
        return getCancelSubscriptionRequest("21", merchantID, requestID, token);
    }
    /**
     * 
     * @param merchantID
     * @param requestID
     * @param token
     * @return              Request object with minimum required fields for operation
     * @throws SDKException 
     */
    public static Request getTestUpdateSubscriptionRequest(String merchantID,String requestID, String token) throws SDKException {
        return getUpdateSubscriptionRequest("22", merchantID, requestID, token);
    }
    /**
     * 
     * @param merchantID
     * @param requestID
     * @return              Request object with minimum required fields for operation
     * @throws SDKException 
     */
    public static Request getTestStartSubscriptionWithInitialDebitRequest(String merchantID,String requestID) throws SDKException {
        return getStartSubscriptionRequest("25", merchantID, requestID);
    }
    /**
     * 
     * @param merchantID
     * @param requestID
     * @return              Request object with minimum required fields for operation
     * @throws SDKException 
     */
    public static Request getTestStartSubscriptionWithInitialAuthRequest(String merchantID,String requestID) throws SDKException {
        return getStartSubscriptionRequest("26", merchantID, requestID);
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
    public static Request getTestStartSubscriptionCaptureRequest(String merchantID,String requestID, String token, String responseID, String previousAuthCode, String previousRequestID) throws SDKException {
        return getReferralRequest("27", merchantID, requestID, token, responseID, previousAuthCode, previousRequestID);
    }
    
    private static Request getStartSubscriptionRequest(String opCode, String merchantID,String requestID) throws SDKException {
        Request req = new Request();
        req.setM(merchantID);
        req.setO(opCode);
        req.setA1(requestID);
        if (!opCode.equals("20")) {
            req.setA4("1030");    
        }
        req.setA8("1234567890123456");
        req.setB1("4543130000001116");
        req.setB3("12");
        req.setB4("20");
        req.setB5("123");
        req.setC1("John Smith");
        req.setC2("999-9999-9999");
        req.setC3("John.Smith@example.com");
        req.setC9("GB");
        req.setC10("n1123");
        req.setD1("1.1.1.1");
        StringBuilder subscriptionXML = new StringBuilder();
        subscriptionXML.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        subscriptionXML.append("<sbscr xmlns=\"http://www.Credorax.com/subscription\">");
        
        java.text.SimpleDateFormat startDateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd");
        subscriptionXML.append("<s>" + startDateFormat.format(new Date()) + "2012-09-01</s>");
        
        subscriptionXML.append("<rc>2</rc>");
        subscriptionXML.append("<ri>3</ri>");
        subscriptionXML.append("<c>");
        subscriptionXML.append("<a>29.95</a>");
        subscriptionXML.append("<p>30</p>");
        subscriptionXML.append("<ct>3</ct>");
        subscriptionXML.append("<cp>1</cp>");
        subscriptionXML.append("<cn>11</cn>");
        subscriptionXML.append("</c>");
        subscriptionXML.append("</sbscr>)");

        req.setH6(Encoding.hexEncode(subscriptionXML.toString()));
        return req;
    }
    private static Request getCancelSubscriptionRequest(String opCode, String merchantID,String requestID, String token) throws SDKException {
        Request req = new Request();
        req.setM(merchantID);
        req.setO(opCode);
        req.setA1(requestID);
        //req.setA4("2530");
        req.setD1("1.1.1.1");
        req.setG1(token);
        return req;
    }
    private static Request getUpdateSubscriptionRequest(String opCode, String merchantID,String requestID, String token) throws SDKException {
        Request req = new Request();
        req.setM(merchantID);
        req.setO(opCode);
        req.setA1(requestID);
        //req.setA4("2530");
        req.setB5("123");
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
}
