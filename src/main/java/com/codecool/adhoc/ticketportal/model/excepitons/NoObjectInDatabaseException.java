package com.codecool.adhoc.ticketportal.model.excepitons;

public class NoObjectInDatabaseException extends Exception {
    public NoObjectInDatabaseException(String message)
    {
        super(message);
    }
}
