package springapiapp.weatherproject.model;

import javax.persistence.*;

@Entity
public class Weather {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String main;
    private String description;
    private String icon;

    @OneToOne(mappedBy = "weather")
    private ConvertedRoot root;

    public Weather() {
    }

    public Weather(String main, String description, String icon) {
        this.main = main;
        this.description = description;
        this.icon = icon;
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

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
