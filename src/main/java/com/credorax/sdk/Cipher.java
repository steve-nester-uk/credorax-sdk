package com.credorax.sdk;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Helper class for generating a request with a cipher from request Map and 
 * signature key
 * @author Steve Nester 
 */
public class Cipher extends Object {
    private String signKey;
    private String maskedRequestStr;
    
    protected Cipher(String signKey) {
        super();
        this.signKey = signKey;
    }
    /**
     * Builds a request string with request parameters which can be sent in the 
     * body of a HTTP request.  Sorts request parameters and appends the generated 
     * cipher key in the 'K' parameter.
     * @param req   Request object to convert to request string
     * @return          Generated request string in name value pair format
     */
    protected String createRequest(Request req) {
        String request = this.getSortedParams(req.getParams());
        this.setMaskedRequestStr(request);
        return request;
    }
    
    private String getSortedParams(Map<String, String> map){
        try {
            // Use TreeMap to sort parameters in alpha numeric order
            Map<String, String> sortedMap = new TreeMap<String, String>(map);
            StringBuilder sb = new StringBuilder();
            for (String key : sortedMap.keySet()) {
                String value = sortedMap.get(key);
                sb.append(key).append('=').append(URLEncoder.encode(value, "US-ASCII")).append('&');
            }
            String cipher = doGetPackageSignature(sortedMap.values());
            sb.append("K=").append(cipher);
            return sb.toString();
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Cipher.class.getName()).log(Level.SEVERE, null, ex);
            return "UnsupportedEncodingException error";
        }
    }
    
    private String doGetPackageSignature(Iterable<String> sorted) {
        try {
            MessageDigest md = null;

            StringBuilder b = new StringBuilder();
            for (String value : sorted) {
                value = value.replaceAll("[\\<\\>\\\"\\'\\(\\)\\\\]", " ").trim();
                b.append(value);
            }
            b.append(this.getSignKey());

            md = MessageDigest.getInstance("MD5");
            md.update(b.toString().getBytes("US-ASCII"), 0, b.toString().length());
            
            StringBuilder sb = new StringBuilder(32);
            sb.append(new BigInteger(1,md.digest()).toString(16));
            while(sb.length() < 32) {
                sb.insert(0,"0");
            }
            return sb.toString();
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Cipher.class.getName()).log(Level.SEVERE, null, ex);
            return "UnsupportedEncodingException error";
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Cipher.class.getName()).log(Level.SEVERE, null, ex);
            return "NoSuchAlgorithmException error";
        }
    }

    /**
     * @return the signKey
     */
    protected String getSignKey() {
        return signKey;
    }

    /**
     * @param signKey the signKey to set
     */
    protected void setSignKey(String signKey) {
        this.signKey = signKey;
    }

    /**
     * @return the maskedRequestStr
     */
    public String getMaskedRequestStr()
    {
        return maskedRequestStr;
    }

    /**
     * @param maskedRequestStr the maskedRequestStr to set
     */
    private void setMaskedRequestStr(String s)
    {
        StringBuilder sb = new StringBuilder(s.length());
        int b1pos = s.indexOf("b1=");
        int b5pos = s.indexOf("b5=");
        if (b1pos != -1) {
            sb.append(s.substring(0, b1pos+3));
            int nextAmpersandPos = s.substring(b1pos).indexOf("&");
            if ((b1pos + 3) != nextAmpersandPos) {
                final char[] cardNum = s.substring(b1pos+3, (b1pos + nextAmpersandPos)).toCharArray();
                Arrays.fill(cardNum, 6, cardNum.length - 4, '*');
                sb.append(cardNum);
                if (b5pos != -1) {
                    sb.append(s.substring((b1pos + nextAmpersandPos), b5pos+3));
                    nextAmpersandPos = s.substring(b5pos).indexOf("&");
                    final char[] cvvNum = s.substring(b5pos+3, (b5pos + nextAmpersandPos)).toCharArray();
                    Arrays.fill(cvvNum, 0, cvvNum.length, '*');
                    sb.append(cvvNum);
                    sb.append(s.substring((b5pos + nextAmpersandPos), s.length()));
                }
                else {
                    sb.append(s.substring((b1pos + nextAmpersandPos), s.length()));
                }
            }
        }
        else {
            sb.append(s);
        }
        this.maskedRequestStr = sb.toString();
    }
}
