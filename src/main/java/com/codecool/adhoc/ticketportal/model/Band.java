package com.codecool.adhoc.ticketportal.model;

import javax.swing.text.Style;

public class Band {
    private Long id;
    private String name;
    private Style style;

    public Band() {
    }

    public Band(String name, Style style) {
        this.name = name;
        this.style = style;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Style getStyle() {
        return style;
    }

    public void setStyle(Style style) {
        this.style = style;
    }
}
