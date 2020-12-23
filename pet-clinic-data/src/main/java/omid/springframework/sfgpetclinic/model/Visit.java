package omid.springframework.sfgpetclinic.model;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "visits")
public class Visit extends BaseEntity {
    @Column(name = "date")
    private LocalDate date;
    @Column(name = "description")
    private String description;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pet_id")
    private Pet pet;
}
