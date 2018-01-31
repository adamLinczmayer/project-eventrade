package com.codecool.adhoc.ticketportal.model;

import javax.persistence.*;
import com.codecool.adhoc.ticketportal.model.enums.MusicStyle;

@Entity
public class Band {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @Enumerated(EnumType.STRING)
    private MusicStyle musicStyle;

    public Band() {
    }

    public Band(String name, MusicStyle musicStyle) {
        this.name = name;
        this.musicStyle = musicStyle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MusicStyle getStyle() {
        return musicStyle;
    }

    public void setStyle(MusicStyle musicStyle) {
        this.musicStyle = musicStyle;
    }
}
