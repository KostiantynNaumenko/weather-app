package springapiapp.weatherproject.model;

import javax.persistence.*;

@Entity
public class Coord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double lat;
    private double lon;

    @OneToOne(mappedBy = "coord")
    private ConvertedRoot root;

    public Coord() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ConvertedRoot getRoot() {
        return root;
    }

    public void setRoot(ConvertedRoot convertedRoot) {
        this.root = convertedRoot;
    }

    public Coord(double lan, double lon) {
        this.lat = lan;
        this.lon = lon;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }
}
