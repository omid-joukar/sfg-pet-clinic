package omid.springframework.sfgpetclinic.model;

import java.util.Set;

/**
 * Created by omid on 12/12/2020.
 */
public class Owner extends Person {
    private Set<Pet> pets;

    public Set<Pet> getPets() {
        return pets;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }
}
