package com.credorax.sdk.transport;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

/**
 * Class which builds and then sends a HTTP over SSL request.
 *
 * @author Steve Nester
 */
public class Https extends Object 
{
    private final static Logger LOGGER = Logger.getLogger(Https.class.getName());
    
    private Boolean outputHTTPHeaders = false;
    public Https() {
        super();
    }
    /**
     * Constructor which includes a variable to set outputHTTPHeaders.
     * When outputHTTPHeaders is true, the HTTPHeaders will be returned
     * after calling the send(..) method.
     * @param outputHTTPHeaders 
     */
    public Https(Boolean outputHTTPHeaders) {
        super();
        this.outputHTTPHeaders = outputHTTPHeaders;
    }
    /**
     * Method builds a HTTPS POST request with Content-Type
     * "application/x-www-form-urlencoded"
     *
     * @param gatewayURL    the URL to which the POST request should be sent
     * @param request       the form-urlencoded String with the request parameters,
     *                      which is sent in the payload/body of the HTTP request
     * @return              URLdecoded (java.net.URLDecoder) response String
     */
    public String send(String gatewayURL, String request)
    {
        URL url;
        HttpsURLConnection connection = null;
        StringBuilder response = null;
        try
        {
            //Create connection
            url = new URL(gatewayURL);
            connection = (HttpsURLConnection) url.openConnection();
            
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type",
                    "application/x-www-form-urlencoded");
            connection.setRequestProperty("Content-Length", ""
                    + Integer.toString(request.getBytes().length));
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setHostnameVerifier(new HostnameVerifier()  
            {   
                //Should be removed in production system.
                public boolean verify(String hostname, SSLSession session)  
                {  
                    return true;  
                }
            }); 
            //Send request
            DataOutputStream wr = new DataOutputStream(
                    connection.getOutputStream());
            wr.writeBytes(request);
            wr.flush();
            wr.close();

            
            //Get HTTP Response
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK)
            {  
                InputStream is = connection.getInputStream();
                BufferedReader rd = new BufferedReader(new InputStreamReader(is));
                String line;
                response = new StringBuilder();
                if (outputHTTPHeaders) {
                    response.append(getHeaders(connection));
                }
                while ((line = rd.readLine()) != null)
                {
                    response.append(line);
                    response.append('\r');
                }
                rd.close();
                is.close();
            }
            else
            {
                if (outputHTTPHeaders) {
                    response.append(getHeaders(connection));
                }
                response.append("Received HTTP response code: ");
                response.append(connection.getResponseCode());
                response.append(" - ");
                response.append(Https.httpResponseCode(connection.getResponseCode()));
            }
        }
        catch (IOException e)
        {
            LOGGER.log(Level.SEVERE, e.getMessage());
        }
        finally
        {
            if (connection != null)
            {
                connection.disconnect();
            }
        }
        try
        {
            if (response == null) {
                return null;
            }
            return URLDecoder.decode(response.toString(), "UTF-8");
        }
        catch (UnsupportedEncodingException ex)
        {
            LOGGER.log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    private String getHeaders(HttpsURLConnection connection) {
        StringBuilder response = new StringBuilder();
        if (connection.getHeaderFields() != null) {
            Map<String, List<String>> header = connection.getHeaderFields();
            for (String key : header.keySet()) {
                response.append(key);
                response.append(" : ");
                for (String value : header.get(key)) {
                    response.append(value);
                }
                response.append("\r");
            }
        }
        return response.toString();
    }

    private static String httpResponseCode(int responseCode)
    {
        switch (responseCode)
        {
            case HttpURLConnection.HTTP_ACCEPTED:
                return "Accepted";
            case HttpURLConnection.HTTP_BAD_GATEWAY:
                return "Bad Gateway";
            case HttpURLConnection.HTTP_BAD_METHOD:
                return "Method Not Allowed";
            case HttpURLConnection.HTTP_BAD_REQUEST:
                return "Bad Request";
            case HttpURLConnection.HTTP_CLIENT_TIMEOUT:
                return "Request Time-out";
            case HttpURLConnection.HTTP_CONFLICT:
                return "Conflict";
            case HttpURLConnection.HTTP_CREATED:
                return "Created";
            case HttpURLConnection.HTTP_ENTITY_TOO_LARGE:
                return "Request Entity Too Large";
            case HttpURLConnection.HTTP_FORBIDDEN:
                return "Forbidden";
            case HttpURLConnection.HTTP_GATEWAY_TIMEOUT:
                return "Gateway Timeout";
            case HttpURLConnection.HTTP_GONE:
                return "Gone";
            case HttpURLConnection.HTTP_INTERNAL_ERROR:
                return "Internal Server Error";
            case HttpURLConnection.HTTP_LENGTH_REQUIRED:
                return "Length Required";
            case HttpURLConnection.HTTP_MOVED_PERM:
                return "Moved Permanently";
            case HttpURLConnection.HTTP_MOVED_TEMP:
                return "Temporary Redirect";
            case HttpURLConnection.HTTP_MULT_CHOICE:
                return "Multiple Choices";
            case HttpURLConnection.HTTP_NO_CONTENT:
                return "No Content";
            case HttpURLConnection.HTTP_NOT_ACCEPTABLE:
                return "Not Acceptable";
            case HttpURLConnection.HTTP_NOT_AUTHORITATIVE:
                return "Non-Authoritative Information";
            case HttpURLConnection.HTTP_NOT_FOUND:
                return "Not Found";
            case HttpURLConnection.HTTP_NOT_IMPLEMENTED:
                return "Not Implemented";
            case HttpURLConnection.HTTP_NOT_MODIFIED:
                return "Not Modified";
            case HttpURLConnection.HTTP_PARTIAL:
                return "Partial Content";
            case HttpURLConnection.HTTP_PAYMENT_REQUIRED:
                return "Payment Required";
            case HttpURLConnection.HTTP_PRECON_FAILED:
                return "Precondition Failed";
            case HttpURLConnection.HTTP_PROXY_AUTH:
                return "Proxy Authentication Required";
            case HttpURLConnection.HTTP_REQ_TOO_LONG:
                return "Request-URI Too Large";
            case HttpURLConnection.HTTP_RESET:
                return "Reset Content";
            case HttpURLConnection.HTTP_SEE_OTHER:
                return "See Other";
            case HttpURLConnection.HTTP_UNAUTHORIZED:
                return "Unauthorised";
            case HttpURLConnection.HTTP_UNAVAILABLE:
                return "Service Unavailable";
            case HttpURLConnection.HTTP_UNSUPPORTED_TYPE:
                return "Unsupporteed Media Type";
            case HttpURLConnection.HTTP_USE_PROXY:
                return "Use Proxy";
            case HttpURLConnection.HTTP_VERSION:
                return "HTTP Version Not Supported";
            default:
                return "Unrecognised HTTP response code";
        }
    }
}
