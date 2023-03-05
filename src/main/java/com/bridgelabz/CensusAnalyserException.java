package com.bridgelabz;

public class CensusAnalyserException extends Throwable {
    public enum ExceptionType
    {
        CENSUS_FILE_PROBLEM, UNABLE_TO_PARSE, INCORRECT_HEADER_OR_DELIMITER
    }

    public ExceptionType type;

    public CensusAnalyserException(String message, ExceptionType type)
    {
        super(message);
        this.type = type;
    }

    public CensusAnalyserException(String message, ExceptionType type, Throwable cause)
    {
        super(message, cause);
        this.type = type;
    }
}
