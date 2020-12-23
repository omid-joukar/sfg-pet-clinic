package omid.springframework.sfgpetclinic.services.map;

import omid.springframework.sfgpetclinic.model.Pet;
import omid.springframework.sfgpetclinic.model.Visit;
import omid.springframework.sfgpetclinic.services.PetService;
import omid.springframework.sfgpetclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Service
@Profile({"default","map"})
public class VisitMapService extends AbstractMapService<Visit,Long> implements VisitService {
    private final PetService petService;

    public VisitMapService(PetService petService) {
        this.petService = petService;
    }

    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
          super.deleteById(id);
    }

    @Override
    public Visit save(Visit visit) {
            if (visit.getPet()!= null) {
                if (visit.getPet().getId() == null) {
                    Pet pet = petService.save(visit.getPet());
                    visit.getPet().setId(pet.getId());
                } else {
                    throw new RuntimeException("Initialize visit");
                }
            }
        return super.save(visit);
    }

    @Override
    public void delet(Visit object) {
        super.delete(object);
    }

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }
}
