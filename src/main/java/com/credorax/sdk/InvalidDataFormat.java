package com.credorax.sdk;

/**
 * Custom Exception which must be handled (i.e extends Exception, not 
 * RuntimeException).  Supports the passing of the fieldName and requiredFormat
 * @author Steve Nester
 */
public class InvalidDataFormat extends Exception {
    private String fieldName;
    private String requiredFormat;
    
    /**
     * Class Constructor
     */
    public InvalidDataFormat() {
        super();
    }

    /**
     * @return the fieldName of the field which contains invalid data
     */
    public String getFieldName() {
        return fieldName;
    }

    /**
     * @param fieldName the fieldName of the field which contains invalid data 
     *                  to set
     */
    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    /**
     * @return the requiredFormat that should have been sent in the field.
     */
    public String getRequiredFormat() {
        return requiredFormat;
    }

    /**
     * @param requiredFormat the requiredFormat to set
     */
    public void setRequiredFormat(String requiredFormat) {
        this.requiredFormat = requiredFormat;
    }
}
