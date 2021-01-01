package omid.springframework.sfgpetclinic.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by omid on 12/12/2020.
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PetType extends BaseEntity {
    @Builder
    public PetType(Long id ,String name) {
        super(id);
        this.name = name;
    }

    @Column(name = "name")
    private String name;

    @Override
    public String toString() {
        return name;
    }
}
