package omid.springframework.sfgpetclinic.bootstrap;

import omid.springframework.sfgpetclinic.model.Owner;
import omid.springframework.sfgpetclinic.model.PetType;
import omid.springframework.sfgpetclinic.model.Vet;
import omid.springframework.sfgpetclinic.services.OwnerService;
import omid.springframework.sfgpetclinic.services.PetTypeService;
import omid.springframework.sfgpetclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }



    @Override
    public void run(String... args) throws Exception {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michaeal");
        owner1.setLastName("Weston");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Piong");
        owner2.setLastName("Gelnanng");
        ownerService.save(owner2);
        System.out.println("Loaded Owners");

        Vet vet1 = new Vet();
        vet1.setFirstName("Jessie");
        vet1.setLastName("Porter");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Sam");
        vet2.setLastName("Axe");
        vetService.save(vet2);
        System.out.println("Loaded Vets");


    }
}
