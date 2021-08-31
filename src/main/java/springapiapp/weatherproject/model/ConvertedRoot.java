package springapiapp.weatherproject.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class ConvertedRoot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "city")
    private String name;

    @Column(name = "date")
    private LocalDate date;

    @OneToOne(cascade = CascadeType.ALL)
    private Coord coord;

    @OneToOne(cascade = CascadeType.ALL)
    private Weather weather;

    public ConvertedRoot() {
    }

    public ConvertedRoot(String cityName, LocalDate date, Coord coord, Weather weather) {
        this.name = cityName;
        this.date = date;
        this.coord = coord;
        this.weather = weather;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }
}
