package omid.springframework.sfgpetclinic.services;

import omid.springframework.sfgpetclinic.model.Owner;


public interface OwnerService extends CrudService<Owner , Long> {
    Owner findByLastName(String lastName);
}
