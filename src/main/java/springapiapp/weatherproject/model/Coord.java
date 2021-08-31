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
public class Coord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double lat;
    private double lon;

    @OneToOne(mappedBy = "coord")
    private ConvertedRoot root;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Coord coord = (Coord) o;

        return Objects.equals(id, coord.id);
    }

    @Override
    public int hashCode() {
        return 260853378;
    }
}
