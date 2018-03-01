package com.codecool.adhoc.ticketportal.model.excepitons;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No data in db")
public class NoObjectInDatabaseException extends Exception {
    public NoObjectInDatabaseException(String message) {
        super(message);
    }
}
