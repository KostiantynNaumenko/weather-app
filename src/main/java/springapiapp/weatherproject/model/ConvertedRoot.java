package springapiapp.weatherproject.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ConvertedRoot that = (ConvertedRoot) o;

        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return 1865687699;
    }
}
