package omid.springframework.sfgpetclinic.bootstrap;

import omid.springframework.sfgpetclinic.model.Owner;
import omid.springframework.sfgpetclinic.model.Vet;
import omid.springframework.sfgpetclinic.services.OwnerService;
import omid.springframework.sfgpetclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1l);
        owner1.setFirstName("Michaeal");
        owner1.setLastName("Weston");
        ownerService.save(owner1);
        Owner owner2 = new Owner();
        owner2.setId(2l);
        owner2.setFirstName("Piong");
        owner2.setLastName("Gelnanng");
        ownerService.save(owner2);
        System.out.println("Loaded Owners");
        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Jessie");
        vet1.setLastName("Porter");
        vetService.save(vet1);
        Vet vet2 = new Vet();
        vet2.setId(1L);
        vet2.setFirstName("Sam");
        vet2.setLastName("Axe");
        vetService.save(vet2);
        System.out.println("Loaded Vets");


    }
}