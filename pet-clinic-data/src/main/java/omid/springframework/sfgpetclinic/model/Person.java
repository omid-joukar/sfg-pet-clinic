package omid.springframework.sfgpetclinic.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * Created by omid on 12/12/2020.
 */
@Getter
@Setter
//@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class Person extends BaseEntity{
    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
}
