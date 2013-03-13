package com.credorax.sdk;

import com.credorax.sdk.util.AVSResponse;
import com.credorax.sdk.util.CVVResponse;
import com.credorax.sdk.util.ResponseCode;
import com.credorax.sdk.util.ResultCode;
import java.util.HashMap;
import java.util.Map;

/**
 * Object represents all response-specific parameters which can be returned by 
 * the Credorax ePower Gateway following an API request.
 * 
 * @author Steve Nester 
 */
public class Response extends Object {
    //Specifc Response Details
    private Request request;
    private String T;
    private String z1;
    private String z2;
    private String z3;
    private String z4;
    private String z5;
    private String z6;
    private String z7;
    private String z8;
    private String z9;
    private String z11;
    private String z13;
    private String z14;
    private String z100;
    
    private String g1;
    private String responseStr;
    /**
     * Class constructor
     * @param responseStr   String of response parameters returned from the API
     *                      request.
     * @param request       The request object from which the API request was 
     *                      generated.
     */
    public Response(String responseStr, Request request) {
        super();
        this.responseStr = responseStr;
        //build resposne from responseStr
        this.request = request;
        if (responseStr != null) {
            String[] params = responseStr.split("&");
            Map<String, String> map = new HashMap<String, String>();
            for (String param : params) {
                if (param.length() > 3) {
                    String key = param.split("=")[0];
                    String value = param.split("=")[1];
                    map.put(key, value);
                }
            }
            if (map.containsKey("T")) {
                this.T = map.get("T");
            }
            if (map.containsKey("z1")) {
                this.z1 = map.get("z1");
            }
            if (map.containsKey("z2")) {
                this.z2 = map.get("z2");
            }
            if (map.containsKey("z3")) {
                this.z3 = map.get("z3");
            }
            if (map.containsKey("z4")) {
                this.z4 = map.get("z4");
            }
            if (map.containsKey("z5")) {
                this.z5 = map.get("z5");
            }
            if (map.containsKey("z6")) {
                this.z6 = map.get("z6");
            }
            if (map.containsKey("z7")) {
                this.z7 = map.get("z7");
            }
            if (map.containsKey("z8")) {
                this.z8 = map.get("z8");
            }
            if (map.containsKey("z9")) {
                this.z9 = map.get("z9");
            }
            if (map.containsKey("z11")) {
                this.z11 = map.get("z11");
            }
            if (map.containsKey("z13")) {
                this.z13 = map.get("z13");
            }
            if (map.containsKey("z14")) {
                this.z14 = map.get("z14");
            }
            if (map.containsKey("z100")) {
                this.z100 = map.get("z100");
            }
            if (map.containsKey("g1")) {
                this.g1 = map.get("g1");
            }
        }
    }
    /**
     * @return the request
     */
    public Request getRequest() {
        return request;
    }

    /**
     * @param request the request to set
     */
    public void setRequest(Request request) {
        this.request = request;
    }

    /**
     * @return the T
     */
    public String getT() {
        return T;
    }

    /**
     * @param T the T to set
     */
    public void setT(String T) {
        this.T = T;
    }

    /**
     * @return the z1
     */
    public String getZ1() {
        return z1;
    }

    /**
     * @param z1 the z1 to set
     */
    public void setZ1(String z1) {
        this.z1 = z1;
    }

    /**
     * @return the z2
     */
    public String getZ2() {
        return z2;
    }

    /**
     * @param z2 the z2 to set
     */
    public void setZ2(String z2) {
        this.z2 = z2;
    }

    /**
     * @return the z3
     */
    public String getZ3() {
        return z3;
    }

    /**
     * @param z3 the z3 to set
     */
    public void setZ3(String z3) {
        this.z3 = z3;
    }

    /**
     * @return the z4
     */
    public String getZ4() {
        return z4;
    }

    /**
     * @param z4 the z4 to set
     */
    public void setZ4(String z4) {
        this.z4 = z4;
    }

    /**
     * @return the z5
     */
    public String getZ5() {
        return z5;
    }

    /**
     * @param z5 the z5 to set
     */
    public void setZ5(String z5) {
        this.z5 = z5;
    }

    /**
     * @return the z6
     */
    public String getZ6() {
        return z6;
    }

    /**
     * @param z6 the z6 to set
     */
    public void setZ6(String z6) {
        this.z6 = z6;
    }

    /**
     * @return the z7
     */
    public String getZ7() {
        return z7;
    }

    /**
     * @param z7 the z7 to set
     */
    public void setZ7(String z7) {
        this.z7 = z7;
    }

    /**
     * @return the z8
     */
    public String getZ8() {
        return z8;
    }

    /**
     * @param z8 the z8 to set
     */
    public void setZ8(String z8) {
        this.z8 = z8;
    }

    /**
     * @return the z9
     */
    public String getZ9() {
        return z9;
    }

    /**
     * @param z9 the z9 to set
     */
    public void setZ9(String z9) {
        this.z9 = z9;
    }

    /**
     * @return the z11
     */
    public String getZ11() {
        return z11;
    }

    /**
     * @param z11 the z11 to set
     */
    public void setZ11(String z11) {
        this.z11 = z11;
    }

    /**
     * @return the z13
     */
    public String getZ13() {
        return z13;
    }

    /**
     * @param z13 the z13 to set
     */
    public void setZ13(String z13) {
        this.z13 = z13;
    }

    /**
     * @return the z100
     */
    public String getZ100() {
        return z100;
    }

    /**
     * @param z100 the z100 to set
     */
    public void setZ100(String z100) {
        this.z100 = z100;
    }

    /**
     * @return the g1
     */
    public String getG1() {
        return g1;
    }

    /**
     * @param g1 the g1 to set
     */
    public void setG1(String g1) {
        this.g1 = g1;
    }
    /**
     * @return the full response string from the API request
     */
    public String getResponseStr()
    {
        return responseStr;
    }
    /**
     * 
     * @return a string representation of the receiver
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Request: ").append("\t").append("\t").append(this.getRequest().getMaskedRequest()).append("\n");
        sb.append("Response: ").append("\t").append("\t").append(this.getResponseStr()).append("\n");
        String time = this.getT();
        if (time != null) {
            sb.append("Response Time(T): ").append("\t").append(time).append("\n");
        }
        String responseID = this.getZ1();
        if (responseID != null) {
             sb.append("Response ID(z1): ").append("\t").append(responseID).append("\n");
        }
        String resultCode = this.getZ2();
        if (resultCode != null) {
             sb.append("Result Code(z2): ").append("\t").append(resultCode).append(" ").append(ResultCode.getResultCode(Integer.parseInt(resultCode))).append("\n");
        }
        
        if ((this.getZ2() != null) && (this.getZ2().equals("0") && (!this.getRequest().getO().equals("18")))) {
            String z6 = this.getZ6();
            String responseCodeDescription = "";
            if (z6 != null) {
                responseCodeDescription = ResponseCode.getResponseCode(z6);
            }
             sb.append("Response Code(z6): ").append("\t").append(z6).append(" ").append(responseCodeDescription).append("\n");
             sb.append("Auth Code(z4): ").append("\t").append("\t").append(this.getZ4()).append("\n");
             sb.append("Risk Score(z5): ").append("\t").append(this.getZ5()).append("\n");
            if (this.getZ9() != null) {
                 sb.append("AVS response(z9): ").append("\t").append(this.getZ9()).append(" ").append(AVSResponse.getAVSResponse(this.getZ9())).append("\n");
            }
            if (this.getZ14() != null) {
                 sb.append("CVV2 response(z14): ").append("\t").append(this.getZ14()).append(" ").append(CVVResponse.getCVVResponse(this.getZ14())).append("\n");
            }
        }
        else {
            String resultCodeText = this.getZ3();
            if (resultCodeText != null) {
                 sb.append("Result Code text(z3):").append("\t").append(resultCodeText).append("\n");
            }
        }
        String redirectURL = this.getZ11();
        if (redirectURL!= null) {
            sb.append("Redirect URL(z11): ").append("\t").append(redirectURL).append("\n");
        }
        return sb.toString();
    }
    /**
     * Prints to System.out a String representation of the receiver
     */
    public void printResponseOutput() {
        System.out.println(this.toString());
    }

    /**
     * @return the z14
     */
    public String getZ14() {
        return z14;
    }

    /**
     * @param z14 the z14 to set
     */
    public void setZ14(String z14) {
        this.z14 = z14;
    }
}
