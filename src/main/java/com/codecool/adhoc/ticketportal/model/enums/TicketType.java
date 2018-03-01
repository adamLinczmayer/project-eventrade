package com.codecool.adhoc.ticketportal.model.enums;

public enum TicketType {
    NORMAL (1f),
    STUDENT (0.5f),
    GROUP (3.5f);

    private final Float multiplier;

    TicketType(Float multiplier){
        this.multiplier = multiplier;
    }

    public Float getMultiplier(){
        return multiplier;
    }
}
