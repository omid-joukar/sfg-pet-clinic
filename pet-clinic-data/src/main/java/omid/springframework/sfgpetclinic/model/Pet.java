package omid.springframework.sfgpetclinic.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by omid on 12/12/2020.
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "pets")
public class Pet extends BaseEntity {
    @Column(name = "name")
    private String name;
    @ManyToOne
    @JoinColumn(name = "type_id")
    private PetType petType;
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;
    @Column(name = "birthDate")
    private LocalDate birthDate;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "pet")
    private Set<Visit> visits = new HashSet<>();
}
