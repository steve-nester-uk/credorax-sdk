package com.credorax.sdk.tests;

import com.credorax.sdk.InvalidDataFormat;
import com.credorax.sdk.Request;

/**
 *
 * @author Steve Nester <com.credorax>
 */
public class SpecialApplications
{
    /**
     * 
     * @param merchantID
     * @param requestID
     * @return              Request object with minimum required fields for operation
     * @throws InvalidDataFormat 
     */
    public static Request getTestGamingPayTo(String merchantID,String requestID) throws InvalidDataFormat {
        return getStandAloneRequest("30", merchantID, requestID);
    }
    
    public static Request getTestRetrieval(String merchantID,String requestID,String originalRequestID) throws InvalidDataFormat {
        return getRetrievalOperationRequest("101", merchantID,requestID, originalRequestID);
    }
    
    private static Request getStandAloneRequest(String opCode, String merchantID,String requestID) throws InvalidDataFormat {
        Request req = new Request();
        req.setM(merchantID);
        req.setO(opCode);
        req.setA1(requestID);
        req.setA4("1020");
        req.setB1("4111111111111111");
        req.setB3("12");
        req.setB4("20");
        req.setB5("123");
        req.setC1("John Smith");
        req.setC3("John.Smith@example.com");
        req.setD1("1.1.1.1");
        req.setD2("TESTING");
        //i1?
        return req;
    }
    private static Request getRetrievalOperationRequest(String opCode, String merchantID, String requestID, String originalRequestID) throws InvalidDataFormat {
        Request req = new Request();
        req.setM(merchantID);
        req.setO(opCode);
        req.setA1(requestID);
        req.setD1("1.1.1.1");
        req.setD2("TESTING");
        req.setG4(originalRequestID);
        return req;
    }
}
