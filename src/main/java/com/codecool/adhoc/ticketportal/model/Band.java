package com.codecool.adhoc.ticketportal.model;

import javax.persistence.*;
import com.codecool.adhoc.ticketportal.model.enums.MusicStyle;

import java.util.HashSet;
import java.util.Set;

@Entity
@NamedQueries({
        @NamedQuery(
                name = "Band.findAllBands",
                query = "SELECT b FROM Band b " +
                        "ORDER BY b.id"),
        @NamedQuery(
                name="Band.findBandByName",
                query = "SELECT b FROM Band b " +
                        "WHERE b.name LIKE :bandName"),
        @NamedQuery(
                name="Band.findBandsByMusicStyle",
                query = "SELECT b FROM Band b " +
                        "WHERE b.musicStyle = :musicStyle")
})
public class Band {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @Enumerated(EnumType.STRING)
    private MusicStyle musicStyle;

    @ManyToMany(mappedBy = "bands")
    private Set<Event> events = new HashSet<>();

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

    @Override
    public String toString() {
        return "Band: " +
                "\nid: " + id +
                ",\nname: '" + name + '\'' +
                ",\nmusicStyle: " + musicStyle.toString().toLowerCase();
    }
}
