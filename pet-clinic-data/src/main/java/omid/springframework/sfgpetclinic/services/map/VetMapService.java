package omid.springframework.sfgpetclinic.services.map;

import omid.springframework.sfgpetclinic.model.Specialty;
import omid.springframework.sfgpetclinic.model.Vet;
import omid.springframework.sfgpetclinic.services.SpecialtyService;
import omid.springframework.sfgpetclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
@Profile({"default","map"})
public class VetMapService extends AbstractMapService<Vet,Long> implements VetService {
    private final SpecialtyService specialtyService;
    @Autowired
    public VetMapService(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet object) {
       if(object.getSpecialities().size()>0){
           object.getSpecialities().forEach(specialty->{
               if (specialty.getId() == null){
                    Specialty vetSpecialty = specialtyService.save(specialty);
                   specialty.setId(vetSpecialty.getId());
               }

           });
       }
        return super.save(object);
    }

    @Override
    public void delet(Vet object) {
        super.delete(object);
    }
}
