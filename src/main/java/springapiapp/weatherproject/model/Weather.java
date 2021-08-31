package springapiapp.weatherproject.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Weather weather = (Weather) o;

        return Objects.equals(id, weather.id);
    }

    @Override
    public int hashCode() {
        return 907319617;
    }
}
