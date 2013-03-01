package com.credorax.sdk.util;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.BASE64Decoder;

/**
 * Helper class for encoding data as required by Credorax API
 * @author Steve Nester
 */
public class Encoding {
    public static String hexEncode(String s) {
        byte[] decodedBytes = s.getBytes();
        char[] unencodedXID = new String(decodedBytes).toCharArray();
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < unencodedXID.length; i++) {
            String toAppend = Integer.toHexString((int) unencodedXID[i]);
            while (toAppend.length() < 2) {
                toAppend = "0" + toAppend; // pad with leading zero if needed
            }
            sb.append(toAppend);
        }
        return sb.toString();
    }
    public static String hexEncode(byte[] bytes) {
        char[] unencodedXID = new String(bytes).toCharArray();
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < unencodedXID.length; i++) {
            String toAppend = Integer.toHexString((int) unencodedXID[i]);
            while (toAppend.length() < 2) {
                toAppend = "0" + toAppend; // pad with leading zero if needed
            }
            sb.append(toAppend);
        }
        return sb.toString();
    }
    public static byte[] base64Decode(String s) {
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            return decoder.decodeBuffer(s);
        } catch (IOException ex) {
            Logger.getLogger(Encoding.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
