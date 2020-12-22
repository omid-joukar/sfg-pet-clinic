package omid.springframework.sfgpetclinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by omid on 12/12/2020.
 */
@Entity
public class PetType extends BaseEntity {
    @Column(name = "name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
