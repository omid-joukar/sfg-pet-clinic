package omid.springframework.sfgpetclinic.services.map;

import omid.springframework.sfgpetclinic.model.Owner;
import omid.springframework.sfgpetclinic.services.OwnerService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class OwnerServiceMap extends AbstractMapService<Owner,Long> implements OwnerService {
    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
         super.deleteById(id);
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner owner) {
        return super.save(owner);
    }

    @Override
    public void delet(Owner object) {
       super.delete(object);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
