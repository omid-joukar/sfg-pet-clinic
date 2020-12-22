package omid.springframework.sfgpetclinic.services.map;

import omid.springframework.sfgpetclinic.model.Visit;
import omid.springframework.sfgpetclinic.services.VisitService;

import java.util.HashSet;
import java.util.Set;

public class VisitMapService extends AbstractMapService<Visit,Long> implements VisitService {


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
        if (visit.getPet() == null || visit.getPet().getOwner() == null || visit.getPet().getId() == null || visit.getPet().getOwner().getId() == null){
            throw new RuntimeException("Initialize visit");
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
