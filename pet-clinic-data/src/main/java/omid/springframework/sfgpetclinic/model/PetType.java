package omid.springframework.sfgpetclinic.model;

/**
 * Created by omid on 12/12/2020.
 */
public class PetType extends BaseEntity {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
