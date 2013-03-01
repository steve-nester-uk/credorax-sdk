package com.credorax.sdk;

import com.credorax.sdk.transport.Https;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Object represents all request parameters which can be sent to the Credorax
 * ePower Gateway.  Also includes a helper method for generating and sending
 * API requests.
 * Example usage:
 * <pre>
 * Request request = new Request();
 * request.setM(merchantID)
 * request.set...
 * ... (set all required request parameters)
 * Response response = request.send(signKey,gatewayURL);
 * response.printResponseOutput();
 * </pre>
 * 
 * @author Steve Nester
 */
public class Request extends Object {

    private boolean validateFields = true;
    //Identification Information
    private String M;
    private String K;
    private String O;
    private String V;
    
    //Billing Details
    private String a1;
    private String a2;
    private String a3;
    private String a4;
    private String a5;
    private String a6;
    private String a7;
    private String a8;
    
    //Payment Card Account
    private String b1;
    private String b2;
    private String b3;
    private String b4;
    private String b5;
    
    //Billing Contact Details
    private String c1;
    private String c2;
    private String c3;
    private String c4;
    private String c5;
    private String c6;
    private String c7;
    private String c8;
    private String c9;
    private String c10;
//    private String c11;
    
    //Fruad Scrubbing Information
    private String d1;
    private String d4;
    private String d5;
    private String d6;
    private String d7;
    
//    //Customer Contact Details
//    private String e1;
//    private String e2;
//    private String e3;
//    private String e4;
//    private String e5;
//    private String e6;
//    private String e7;
//    private String e8;
//    private String e9;
//    private String e10;
//    private String e11;
//    private String e12;
//    private String e13;
//    private String e14;
//    
//    //Shipping Contact Details
//    private String f1;
//    private String f2;
//    private String f3;
//    private String f4;
//    private String f5;
//    private String f6;
//    private String f7;
//    private String f8;
//    private String f9;
//    private String f10;
//    private String f11;
//    private String f12;
//    private String f13;
//    private String f14;
    
    //Refferal Details
    private String g1;
    private String g2;
    private String g3;
    private String g4;
    
    //General Marketing Details and Tuning
    private String d2;
    private String d3;
    private String h1;
    private String h2;
    private String h3;
    private String h4;
    private String h5;
    private String h6;
    private String h7;
    private String h8;
    private String h9;
    private String h10;
    private String i1;
    private String i2;
    private String i3;
    private String i4;
    private String i5;
    private String i8;
    private String i7;
    
    private String maskedRequest;
    
    public Request() {
        super();
    }
    public Request(boolean validateFields) {
        super();
        this.validateFields = validateFields;
    }
    /**
     * Helper method for building and sending HTTP over SSL request based on
     * receiver
     * 
     * @param signKey       the signature key that should be used to create the 
     *                      cipher.
     * @param gatewayURL    the gateway URL to which the transaction should be 
     *                      sent.  This should begin with https
     * @return              Response object containing the response of the 
     *                      request
     */
    public Response send(String signKey, String gatewayURL) {
        Cipher c = new Cipher(signKey);
        String responseStr = new Https().send(gatewayURL, c.createRequest(this));
        this.setMaskedRequest(c.getMaskedRequestStr());
        if (this.getB1() != null) {
            this.b1 = "xxx";
        }
        if (this.getB5() != null) {
            this.b5 = "xxx";
        }
        return new Response(responseStr, this);
    }
    /**
     * @return the M
     */
    public String getM() {
        return M;
    }

    /**
     * @param M the m to set
     */
    public void setM(String M) throws InvalidDataFormat {
        if ((!this.validateFields) || (M.matches("[a-zA-Z0-9_]{3,8}"))) {
            this.M = M;
        }
        else {
            InvalidDataFormat idf = new InvalidDataFormat();
            idf.setFieldName("M");
            idf.setRequiredFormat("[a-zA-Z0-9_]{3,8}");
            throw idf;
        }
    }

    /**
     * @return the K
     */
    public String getK() {
        return K;
    }

    /**
     * @param K the k to set
     */
    public void setK(String K) throws InvalidDataFormat {
        if ((!this.validateFields) || (K.matches("[a-zA-Z0-9]{1,32}"))) {
            this.K = K;
        }
        else {
            InvalidDataFormat idf = new InvalidDataFormat();
            idf.setFieldName("K");
            idf.setRequiredFormat("[a-zA-Z0-9]{1,32}");
            throw idf;
        }
    }

    /**
     * @return the O
     */
    public String getO() {
        return O;
    }

    /**
     * @param O the o to set
     */
    public void setO(String O) throws InvalidDataFormat {
        if ((!this.validateFields) || (O.matches("[0-9]{1,3}"))) {
            this.O = O;
        }
        else {
            InvalidDataFormat idf = new InvalidDataFormat();
            idf.setFieldName("O");
            idf.setRequiredFormat("[0-9]{1,3}");
            throw idf;
        }
    }

    /**
     * @return the V
     */
    public String getV() {
        return V;
    }

    /**
     * @param V the v to set
     */
    public void setV(String V) throws InvalidDataFormat {
        if ((!this.validateFields) || (V.equals("413"))) {
            this.V = V;
        }
        else {
            InvalidDataFormat idf = new InvalidDataFormat();
            idf.setFieldName("V");
            idf.setRequiredFormat("413");
            throw idf;
        }
    }

    /**
     * @return the a1
     */
    public String getA1() {
        return a1;
    }

    /**
     * @param a1 the a1 to set
     */
    public void setA1(String a1) throws InvalidDataFormat {
        if ((!this.validateFields) || (a1.matches("[a-zA-Z0-9]{1,32}"))) {
            this.a1 = a1;
        }
        else {
            InvalidDataFormat idf = new InvalidDataFormat();
            idf.setFieldName("a1");
            idf.setRequiredFormat("[a-zA-Z0-9]{1,32}");
            throw idf;
        }
    }

    /**
     * @return the a2
     */
    public String getA2() {
        return a2;
    }

    /**
     * @param a2 the a2 to set
     */
    public void setA2(String a2) throws InvalidDataFormat {
        if ((!this.validateFields) || (a2.matches("[0-9]"))) {
            this.a2 = a2;
        }
        else {
            InvalidDataFormat idf = new InvalidDataFormat();
            idf.setFieldName("a2");
            idf.setRequiredFormat("[0-9]");
            throw idf;
        }
    }

    /**
     * @return the a3
     */
    public String getA3() {
        return a3;
    }

    /**
     * @param a3 the a3 to set
     */
    public void setA3(String a3) throws InvalidDataFormat {
        if ((!this.validateFields) || (a3.matches("[0-1]"))) {
            this.a3 = a3;
        }
        else {
            InvalidDataFormat idf = new InvalidDataFormat();
            idf.setFieldName("a3");
            idf.setRequiredFormat("[0-1]");
            throw idf;
        }
    }

    /**
     * @return the a4
     */
    public String getA4() {
        return a4;
    }

    /**
     * @param a4 the a4 to set
     */
    public void setA4(String a4) throws InvalidDataFormat {
        if ((!this.validateFields) || (a4.matches("[0-9]{1,10}"))) {
            this.a4 = a4;
        }
        else {
            InvalidDataFormat idf = new InvalidDataFormat();
            idf.setFieldName("a4");
            idf.setRequiredFormat("[0-9]{1,10}");
            throw idf;
        }
    }

    /**
     * @return the a5
     */
    public String getA5() {
        return a5;
    }

    /**
     * @param a5 the a5 to set
     */
    public void setA5(String a5) throws InvalidDataFormat {
        if ((!this.validateFields) || (a5.matches("[A-Z]{3}"))) {
            this.a5 = a5;
        }
        else {
            InvalidDataFormat idf = new InvalidDataFormat();
            idf.setFieldName("a5");
            idf.setRequiredFormat("[A-Z]{3}");
            throw idf;
        }
    }

    /**
     * @return the a6
     */
    public String getA6() {
        return a6;
    }

    /**
     * @param a6 the a6 to set
     */
    public void setA6(String a6) throws InvalidDataFormat {
        if ((!this.validateFields) || (a6.matches("[0-9][0-9]([0][0-9]|[1][0-2])([0-2][0-9]|[3][0-1])"))) {
            this.a6 = a6;
        }
        else {
            InvalidDataFormat idf = new InvalidDataFormat();
            idf.setFieldName("a6");
            idf.setRequiredFormat("[0-9][0-9]([0][0-9]|[1][0-2])([0-2][0-9]|[3][0-1])");
            throw idf;
        }
    }

    /**
     * @return the a7
     */
    public String getA7() {
        return a7;
    }

    /**
     * @param a7 the a7 to set
     */
    public void setA7(String a7) throws InvalidDataFormat {
        if ((!this.validateFields) || (a7.matches("([0-1][0-9]|[2][0-3])[0-5][0-9][0-5][0-9]"))) {
            this.a7 = a7;
        }
        else {
            InvalidDataFormat idf = new InvalidDataFormat();
            idf.setFieldName("a7");
            idf.setRequiredFormat("([0-1][0-9]|[2][0-3])[0-5][0-9][0-5][0-9]");
            throw idf;
        }
    }

    /**
     * @return the a8
     */
    public String getA8() {
        return a8;
    }

    /**
     * @param a8 the a8 to set
     */
    public void setA8(String a8) throws InvalidDataFormat {
        if ((!this.validateFields) || (a8.matches("[0-9]{1,16}"))) {
            this.a8 = a8;
        }
        else {
            InvalidDataFormat idf = new InvalidDataFormat();
            idf.setFieldName("a8");
            idf.setRequiredFormat("[0-9]{1,16}");
            throw idf;
        }
    }

    /**
     * @return the b1
     */
    public String getB1() {
        return b1;
    }

    /**
     * @param b1 the b1 to set
     */
    public void setB1(String b1) throws InvalidDataFormat {
        if ((!this.validateFields) || (b1.matches("[0-9]{8,19}"))) {
            this.b1 = b1;
        }
        else {
            InvalidDataFormat idf = new InvalidDataFormat();
            idf.setFieldName("b1");
            idf.setRequiredFormat("[0-9]{8,19}");
            throw idf;
        }
    }

    /**
     * @return the b2
     */
    public String getB2() {
        return b2;
    }

    /**
     * @param b2 the b2 to set
     */
    public void setB2(String b2) throws InvalidDataFormat {
        if ((!this.validateFields) || (b2.matches("[0-9]{1,2}"))) {
            this.b2 = b2;
        }
        else {
            InvalidDataFormat idf = new InvalidDataFormat();
            idf.setFieldName("b2");
            idf.setRequiredFormat("[0-9]{1,2}");
            throw idf;
        }
    }

    /**
     * @return the b3
     */
    public String getB3() {
        return b3;
    }

    /**
     * @param b3 the b3 to set
     */
    public void setB3(String b3) throws InvalidDataFormat {
        if ((!this.validateFields) || (b3.matches("[0-9]{2,2}"))) {
            this.b3 = b3;
        }
        else {
            InvalidDataFormat idf = new InvalidDataFormat();
            idf.setFieldName("b3");
            idf.setRequiredFormat("[0-9]{2,2}");
            throw idf;
        }
    }

    /**
     * @return the b4
     */
    public String getB4() {
        return b4;
    }

    /**
     * @param b4 the b4 to set
     */
    public void setB4(String b4) throws InvalidDataFormat {
        if ((!this.validateFields) || (b4.matches("[0-9]{1,2}"))) {
            this.b4 = b4;
        }
        else {
            InvalidDataFormat idf = new InvalidDataFormat();
            idf.setFieldName("b4");
            idf.setRequiredFormat("[0-9]{1,2}");
            throw idf;
        }
    }

    /**
     * @return the b5
     */
    public String getB5() {
        return b5;
    }

    /**
     * @param b5 the b5 to set
     */
    public void setB5(String b5) throws InvalidDataFormat {
        if ((!this.validateFields) || (b5.matches("[0-9]{3,3}"))) {
            this.b5 = b5;
        }
        else {
            InvalidDataFormat idf = new InvalidDataFormat();
            idf.setFieldName("b5");
            idf.setRequiredFormat("[0-9]{3,3}");
            throw idf;
        }
    }

    /**
     * @return the c1
     */
    public String getC1() {
        return c1;
    }

    /**
     * @param c1 the c1 to set
     */
    public void setC1(String c1) throws InvalidDataFormat {
        if ((!this.validateFields) || (c1.matches("[a-zA-Z\\s]{5,64}"))) {
            this.c1 = c1;
        }
        else {
            InvalidDataFormat idf = new InvalidDataFormat();
            idf.setFieldName("c1");
            idf.setRequiredFormat("[a-zA-Z\\s]{5,64}");
            throw idf;
        }
    }

    /**
     * @return the c2
     */
    public String getC2() {
        return c2;
    }

    /**
     * @param c2 the c2 to set
     */
    public void setC2(String c2) throws InvalidDataFormat {
        //if (c2.matches("[0-9\\-\\s\\.]{5,32}")) {
        if ((!this.validateFields) || (c2.matches("[0-9\\-]{5,32}"))) {
            this.c2 = c2;
        }
        else {
            InvalidDataFormat idf = new InvalidDataFormat();
            idf.setFieldName("c2");
            idf.setRequiredFormat("[0-9\\-]{5,32}");
            throw idf;
        }
    }

    /**
     * @return the c3
     */
    public String getC3() {
        return c3;
    }

    /**
     * @param c3 the c3 to set
     */
    public void setC3(String c3) throws InvalidDataFormat {
        if ((!this.validateFields) || (c3.matches("^[_a-zA-Z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"))) {
            this.c3 = c3;
        }
        else {
            InvalidDataFormat idf = new InvalidDataFormat();
            idf.setFieldName("c3");
            idf.setRequiredFormat("^[_a-zA-Z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
            throw idf;
        }
    }

    /**
     * @return the c4
     */
    public String getC4() {
        return c4;
    }

    /**
     * @param c4 the c4 to set
     */
    public void setC4(String c4) throws InvalidDataFormat {
        if ((!this.validateFields) || (c4.matches("[a-zA-Z0-9\\s\\-]{1,16}"))) {
            this.c4 = c4;
        }
        else {
            InvalidDataFormat idf = new InvalidDataFormat();
            idf.setFieldName("c4");
            idf.setRequiredFormat("[a-zA-Z0-9\\s\\-]{1,16}");
            throw idf;
        }
    }

    /**
     * @return the c5
     */
    public String getC5() {
        return c5;
    }

    /**
     * @param c5 the c5 to set
     */
    public void setC5(String c5) throws InvalidDataFormat {
        if ((!this.validateFields) || (c5.matches("[a-zA-Z0-9\\s\\-]{4,64}"))) {
            this.c5 = c5;
        }
        else {
            InvalidDataFormat idf = new InvalidDataFormat();
            idf.setFieldName("c5");
            idf.setRequiredFormat("[a-zA-Z0-9\\s\\-]{4,64}");
            throw idf;
        }
    }

    /**
     * @return the c6
     */
    public String getC6() {
        return c6;
    }

    /**
     * @param c6 the c6 to set
     */
    public void setC6(String c6) throws InvalidDataFormat {
        if ((!this.validateFields) || (c6.matches("[0-9]{1,16}"))) {
            this.c6 = c6;
        }
        else {
            InvalidDataFormat idf = new InvalidDataFormat();
            idf.setFieldName("c6");
            idf.setRequiredFormat("[0-9]{1,16}");
            throw idf;
        }
        this.c6 = c6;
    }

    /**
     * @return the c7
     */
    public String getC7() {
        return c7;
    }

    /**
     * @param c7 the c7 to set
     */
    public void setC7(String c7) throws InvalidDataFormat {
        if ((!this.validateFields) || (c7.matches("[a-zA-Z0-9\\s\\-]{3,32}"))) {
            this.c7 = c7;
        }
        else {
            InvalidDataFormat idf = new InvalidDataFormat();
            idf.setFieldName("c7");
            idf.setRequiredFormat("[a-zA-Z0-9\\s\\-]{3,32}");
            throw idf;
        }
    }

    /**
     * @return the c8
     */
    public String getC8() {
        return c8;
    }

    /**
     * @param c8 the c8 to set
     */
    public void setC8(String c8) throws InvalidDataFormat {
        this.c8 = c8;
    }

    /**
     * @return the c9
     */
    public String getC9() {
        return c9;
    }

    /**
     * @param c9 the c9 to set
     */
    public void setC9(String c9) throws InvalidDataFormat {
        if ((!this.validateFields) || (c9.matches("[A-Z]{2,2}"))) {
            this.c9 = c9;
        }
        else {
            InvalidDataFormat idf = new InvalidDataFormat();
            idf.setFieldName("c9");
            idf.setRequiredFormat("[A-Z]{2,2}");
            throw idf;
        }
    }

    /**
     * @return the c10
     */
    public String getC10() {
        return c10;
    }

    /**
     * @param c10 the c10 to set
     */
    public void setC10(String c10) throws InvalidDataFormat {
        if ((!this.validateFields) || (c10.matches("[a-zA-Z0-9\\s\\-]{4,15}"))) {
            this.c10 = c10;
        }
        else {
            InvalidDataFormat idf = new InvalidDataFormat();
            idf.setFieldName("c10");
            idf.setRequiredFormat("[a-zA-Z0-9\\s\\-]{4,15}");
            throw idf;
        }
    }

//    /**
//     * @return the c11
//     */
//    public String getC11() {
//        return c11;
//    }
//
//    /**
//     * @param c11 the c11 to set
//     */
//    public void setC11(String c11) throws InvalidDataFormat {
//        this.c11 = c11;
//    }

    /**
     * @return the d1
     */
    public String getD1() {
        return d1;
    }

    /**
     * @param d1 the d1 to set
     */
    public void setD1(String d1) throws InvalidDataFormat {
        if ((!this.validateFields) || (d1.matches("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}"))) {
            this.d1 = d1;
        }
        else {
            InvalidDataFormat idf = new InvalidDataFormat();
            idf.setFieldName("d1");
            idf.setRequiredFormat("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}");
            throw idf;
        }
    }

    /**
     * @return the d4
     */
    public String getD4() {
        return d4;
    }

    /**
     * @param d4 the d4 to set
     */
    public void setD4(String d4) throws InvalidDataFormat {
        this.d4 = d4;
    }

    /**
     * @return the d5
     */
    public String getD5() {
        return d5;
    }

    /**
     * @param d5 the d5 to set
     */
    public void setD5(String d5) throws InvalidDataFormat {
        this.d5 = d5;
    }

    /**
     * @return the d6
     */
    public String getD6() {
        return d6;
    }

    /**
     * @param d6 the d6 to set
     */
    public void setD6(String d6) throws InvalidDataFormat {
        this.d6 = d6;
    }

    /**
     * @return the d7
     */
    public String getD7() {
        return d7;
    }

    /**
     * @param d7 the d7 to set
     */
    public void setD7(String d7) throws InvalidDataFormat {
        this.d7 = d7;
    }

//    /**
//     * @return the e1
//     */
//    public String getE1() {
//        return e1;
//    }
//
//    /**
//     * @param e1 the e1 to set
//     */
//    public void setE1(String e1) throws InvalidDataFormat {
//        this.e1 = e1;
//    }
//
//    /**
//     * @return the e2
//     */
//    public String getE2() {
//        return e2;
//    }
//
//    /**
//     * @param e2 the e2 to set
//     */
//    public void setE2(String e2) throws InvalidDataFormat {
//        this.e2 = e2;
//    }
//
//    /**
//     * @return the e3
//     */
//    public String getE3() {
//        return e3;
//    }
//
//    /**
//     * @param e3 the e3 to set
//     */
//    public void setE3(String e3) throws InvalidDataFormat {
//        this.e3 = e3;
//    }
//
//    /**
//     * @return the e4
//     */
//    public String getE4() {
//        return e4;
//    }
//
//    /**
//     * @param e4 the e4 to set
//     */
//    public void setE4(String e4) throws InvalidDataFormat {
//        this.e4 = e4;
//    }
//
//    /**
//     * @return the e5
//     */
//    public String getE5() {
//        return e5;
//    }
//
//    /**
//     * @param e5 the e5 to set
//     */
//    public void setE5(String e5) throws InvalidDataFormat {
//        this.e5 = e5;
//    }
//
//    /**
//     * @return the e6
//     */
//    public String getE6() {
//        return e6;
//    }
//
//    /**
//     * @param e6 the e6 to set
//     */
//    public void setE6(String e6) throws InvalidDataFormat {
//        this.e6 = e6;
//    }
//
//    /**
//     * @return the e7
//     */
//    public String getE7() {
//        return e7;
//    }
//
//    /**
//     * @param e7 the e7 to set
//     */
//    public void setE7(String e7) throws InvalidDataFormat {
//        this.e7 = e7;
//    }
//
//    /**
//     * @return the e8
//     */
//    public String getE8() {
//        return e8;
//    }
//
//    /**
//     * @param e8 the e8 to set
//     */
//    public void setE8(String e8) throws InvalidDataFormat {
//        this.e8 = e8;
//    }
//
//    /**
//     * @return the e9
//     */
//    public String getE9() {
//        return e9;
//    }
//
//    /**
//     * @param e9 the e9 to set
//     */
//    public void setE9(String e9) throws InvalidDataFormat {
//        this.e9 = e9;
//    }
//
//    /**
//     * @return the e10
//     */
//    public String getE10() {
//        return e10;
//    }
//
//    /**
//     * @param e10 the e10 to set
//     */
//    public void setE10(String e10) throws InvalidDataFormat {
//        this.e10 = e10;
//    }
//
//    /**
//     * @return the e11
//     */
//    public String getE11() {
//        return e11;
//    }
//
//    /**
//     * @param e11 the e11 to set
//     */
//    public void setE11(String e11) throws InvalidDataFormat {
//        this.e11 = e11;
//    }
//
//    /**
//     * @return the e12
//     */
//    public String getE12() {
//        return e12;
//    }
//
//    /**
//     * @param e12 the e12 to set
//     */
//    public void setE12(String e12) throws InvalidDataFormat {
//        this.e12 = e12;
//    }
//
//    /**
//     * @return the e13
//     */
//    public String getE13() {
//        return e13;
//    }
//
//    /**
//     * @param e13 the e13 to set
//     */
//    public void setE13(String e13) throws InvalidDataFormat {
//        this.e13 = e13;
//    }
//
//    /**
//     * @return the e14
//     */
//    public String getE14() {
//        return e14;
//    }
//
//    /**
//     * @param e14 the e14 to set
//     */
//    public void setE14(String e14) throws InvalidDataFormat {
//        this.e14 = e14;
//    }
//
//    /**
//     * @return the f1
//     */
//    public String getF1() {
//        return f1;
//    }
//
//    /**
//     * @param f1 the f1 to set
//     */
//    public void setF1(String f1) throws InvalidDataFormat {
//        this.f1 = f1;
//    }
//
//    /**
//     * @return the f2
//     */
//    public String getF2() {
//        return f2;
//    }
//
//    /**
//     * @param f2 the f2 to set
//     */
//    public void setF2(String f2) throws InvalidDataFormat {
//        this.f2 = f2;
//    }
//
//    /**
//     * @return the f3
//     */
//    public String getF3() {
//        return f3;
//    }
//
//    /**
//     * @param f3 the f3 to set
//     */
//    public void setF3(String f3) throws InvalidDataFormat {
//        this.f3 = f3;
//    }
//
//    /**
//     * @return the f4
//     */
//    public String getF4() {
//        return f4;
//    }
//
//    /**
//     * @param f4 the f4 to set
//     */
//    public void setF4(String f4) throws InvalidDataFormat {
//        this.f4 = f4;
//    }
//
//    /**
//     * @return the f5
//     */
//    public String getF5() {
//        return f5;
//    }
//
//    /**
//     * @param f5 the f5 to set
//     */
//    public void setF5(String f5) throws InvalidDataFormat {
//        this.f5 = f5;
//    }
//
//    /**
//     * @return the f6
//     */
//    public String getF6() {
//        return f6;
//    }
//
//    /**
//     * @param f6 the f6 to set
//     */
//    public void setF6(String f6) throws InvalidDataFormat {
//        this.f6 = f6;
//    }
//
//    /**
//     * @return the f7
//     */
//    public String getF7() {
//        return f7;
//    }
//
//    /**
//     * @param f7 the f7 to set
//     */
//    public void setF7(String f7) throws InvalidDataFormat {
//        this.f7 = f7;
//    }
//
//    /**
//     * @return the f8
//     */
//    public String getF8() {
//        return f8;
//    }
//
//    /**
//     * @param f8 the f8 to set
//     */
//    public void setF8(String f8) throws InvalidDataFormat {
//        this.f8 = f8;
//    }
//
//    /**
//     * @return the f9
//     */
//    public String getF9() {
//        return f9;
//    }
//
//    /**
//     * @param f9 the f9 to set
//     */
//    public void setF9(String f9) throws InvalidDataFormat {
//        this.f9 = f9;
//    }
//
//    /**
//     * @return the f10
//     */
//    public String getF10() {
//        return f10;
//    }
//
//    /**
//     * @param f10 the f10 to set
//     */
//    public void setF10(String f10) throws InvalidDataFormat {
//        this.f10 = f10;
//    }
//
//    /**
//     * @return the f11
//     */
//    public String getF11() {
//        return f11;
//    }
//
//    /**
//     * @param f11 the f11 to set
//     */
//    public void setF11(String f11) throws InvalidDataFormat {
//        this.f11 = f11;
//    }
//
//    /**
//     * @return the f12
//     */
//    public String getF12() {
//        return f12;
//    }
//
//    /**
//     * @param f12 the f12 to set
//     */
//    public void setF12(String f12) throws InvalidDataFormat {
//        this.f12 = f12;
//    }
//
//    /**
//     * @return the f13
//     */
//    public String getF13() {
//        return f13;
//    }
//
//    /**
//     * @param f13 the f13 to set
//     */
//    public void setF13(String f13) throws InvalidDataFormat {
//        this.f13 = f13;
//    }
//
//    /**
//     * @return the f14
//     */
//    public String getF14() {
//        return f14;
//    }
//
//    /**
//     * @param f14 the f14 to set
//     */
//    public void setF14(String f14) throws InvalidDataFormat {
//        this.f14 = f14;
//    }

    /**
     * @return the g1
     */
    public String getG1() {
        return g1;
    }

    /**
     * @param g1 the g1 to set
     */
    public void setG1(String g1) throws InvalidDataFormat {
        this.g1 = g1;
    }

    /**
     * @return the g2
     */
    public String getG2() {
        return g2;
    }

    /**
     * @param g2 the g2 to set
     */
    public void setG2(String g2) throws InvalidDataFormat {
        this.g2 = g2;
    }

    /**
     * @return the g3
     */
    public String getG3() {
        return g3;
    }

    /**
     * @param g3 the g3 to set
     */
    public void setG3(String g3) throws InvalidDataFormat {
        this.g3 = g3;
    }

    /**
     * @return the g4
     */
    public String getG4() {
        return g4;
    }

    /**
     * @param g4 the g4 to set
     */
    public void setG4(String g4) throws InvalidDataFormat {
        this.g4 = g4;
    }

    /**
     * @return the d2
     */
    public String getD2() {
        return d2;
    }

    /**
     * @param d2 the d2 to set
     */
    public void setD2(String d2) throws InvalidDataFormat {
        this.d2 = d2;
    }

    /**
     * @return the d3
     */
    public String getD3() {
        return d3;
    }

    /**
     * @param d3 the d3 to set
     */
    public void setD3(String d3) throws InvalidDataFormat {
        this.d3 = d3;
    }

    /**
     * @return the h1
     */
    public String getH1() {
        return h1;
    }

    /**
     * @param h1 the h1 to set
     */
    public void setH1(String h1) throws InvalidDataFormat {
        this.h1 = h1;
    }

    /**
     * @return the h2
     */
    public String getH2() {
        return h2;
    }

    /**
     * @param h2 the h2 to set
     */
    public void setH2(String h2) throws InvalidDataFormat {
        this.h2 = h2;
    }

    /**
     * @return the h3
     */
    public String getH3() {
        return h3;
    }

    /**
     * @param h3 the h3 to set
     */
    public void setH3(String h3) throws InvalidDataFormat {
        this.h3 = h3;
    }

    /**
     * @return the h4
     */
    public String getH4() {
        return h4;
    }

    /**
     * @param h4 the h4 to set
     */
    public void setH4(String h4) throws InvalidDataFormat {
        this.h4 = h4;
    }

    /**
     * @return the h5
     */
    public String getH5() {
        return h5;
    }

    /**
     * @param h5 the h5 to set
     */
    public void setH5(String h5) throws InvalidDataFormat {
        this.h5 = h5;
    }

    /**
     * @return the h6
     */
    public String getH6() {
        return h6;
    }

    /**
     * @param h6 the h6 to set
     */
    public void setH6(String h6) throws InvalidDataFormat {
        this.h6 = h6;
    }

    /**
     * @return the h7
     */
    public String getH7() {
        return h7;
    }

    /**
     * @param h7 the h7 to set
     */
    public void setH7(String h7) throws InvalidDataFormat {
        this.h7 = h7;
    }

    /**
     * @return the h8
     */
    public String getH8() {
        return h8;
    }

    /**
     * @param h8 the h8 to set
     */
    public void setH8(String h8) throws InvalidDataFormat {
        this.h8 = h8;
    }

    /**
     * @return the h9
     */
    public String getH9() {
        return h9;
    }

    /**
     * @param h9 the h9 to set
     */
    public void setH9(String h9) throws InvalidDataFormat {
        this.h9 = h9;
    }

    /**
     * @return the h10
     */
    public String getH10() {
        return h10;
    }

    /**
     * @param h10 the h10 to set
     */
    public void setH10(String h10) throws InvalidDataFormat {
        this.h10 = h10;
    }

    /**
     * @return the i1
     */
    public String getI1() {
        return i1;
    }

    /**
     * @param i1 the i1 to set
     */
    public void setI1(String i1) throws InvalidDataFormat {
        this.i1 = i1;
    }

    /**
     * @return the i2
     */
    public String getI2() {
        return i2;
    }

    /**
     * @param i2 the i2 to set
     */
    public void setI2(String i2) throws InvalidDataFormat {
        this.i2 = i2;
    }

    /**
     * @return the i3
     */
    public String getI3() {
        return i3;
    }

    /**
     * @param i3 the i3 to set
     */
    public void setI3(String i3) throws InvalidDataFormat {
        this.i3 = i3;
    }

    /**
     * @return the i4
     */
    public String getI4() {
        return i4;
    }

    /**
     * @param i4 the i4 to set
     */
    public void setI4(String i4) throws InvalidDataFormat {
        this.i4 = i4;
    }

    /**
     * @return the i5
     */
    public String getI5() {
        return i5;
    }

    /**
     * @param i5 the i5 to set
     */
    public void setI5(String i5) throws InvalidDataFormat {
        this.i5 = i5;
    }

    /**
     * @return the i6
     */
    public String getI8() {
        return i8;
    }

    /**
     * @param i6 the i6 to set
     */
    public void setI8(String i8) throws InvalidDataFormat {
        this.i8 = i8;
    }

    /**
     * @return the i7
     */
    public String getI7() {
        return i7;
    }

    /**
     * @param i7 the i7 to set
     */
    public void setI7(String i7) throws InvalidDataFormat {
        this.i7 = i7;
    }

   /**
    * 
    * @return a HashMap<String, String> collection of all the request parameters
    */
    public Map<String, String> getParams() {
        Map<String, String> parameters = new HashMap<String, String>();
        for (Field field : Request.class.getDeclaredFields()) {
            try {
                Object f = field.get(this);
                if (f != null) {
                    if (field.getName().equals("validateFields")) {
                        continue;
                    }
                    parameters.put(field.getName(), f.toString());
                }
            } catch (IllegalArgumentException ex) {
                Logger.getLogger(Request.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(Request.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return parameters;
    }

    /**
     * @return the maskedRequest
     */
    public String getMaskedRequest()
    {
        return maskedRequest;
    }

    /**
     * @param maskedRequest the maskedRequest to set
     */
    public void setMaskedRequest(String maskedRequest)
    {
        this.maskedRequest = maskedRequest;
    }
}
