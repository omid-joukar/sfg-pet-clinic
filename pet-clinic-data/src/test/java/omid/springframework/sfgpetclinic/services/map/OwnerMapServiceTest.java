package omid.springframework.sfgpetclinic.services.map;

import omid.springframework.sfgpetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceTest {
    OwnerMapService ownerMapService;
    final Long ownerId = 1L;
    final String lastName = "salita";

    @BeforeEach
    void setUp() {
    ownerMapService = new OwnerMapService(new PetTypeMapService(),new PetMapService());
    ownerMapService.save(Owner.builder().id(ownerId).lastName(lastName).build());
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = ownerMapService.findAll();
        assertEquals(1,ownerSet.size());
    }

    @Test
    void deleteById() {
        ownerMapService.deleteById(ownerId);
        assertEquals(0,ownerMapService.findAll().size());
    }

    @Test
    void findById() {
    Owner owner = ownerMapService.findById(ownerId);
    assertEquals(ownerId,owner.getId());
    }

    @Test
    void save() {
        Long id = 2L;
        Owner owner = Owner.builder().id(id).build();
        Owner owner1 = ownerMapService.save(owner);
        assertEquals(id,owner1.getId());

    }

    @Test
    void delet() {
        ownerMapService.delet(ownerMapService.findById(ownerId));
        assertEquals(0,ownerMapService.findAll().size());
    }

    @Test
    void findByLastName() {
        Owner owner = ownerMapService.findByLastName(lastName);
        assertNotNull(owner);

    }
    @Test
    void findByLastNameNot() {
        Owner owner = ownerMapService.findByLastName("foof");
        assertNull(owner);

    }
}