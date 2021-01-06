package omid.springframework.sfgpetclinic.controllers;

import omid.springframework.sfgpetclinic.model.Pet;
import omid.springframework.sfgpetclinic.model.Visit;
import omid.springframework.sfgpetclinic.services.PetService;
import omid.springframework.sfgpetclinic.services.VisitService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class VisitControllerTest {
    @Mock
    PetService petService;
    @Mock
    VisitService visitService;
    @InjectMocks
    VisitController visitController;
    MockMvc mockMvc;
    @BeforeEach
    public void init(){

        mockMvc = MockMvcBuilders.standaloneSetup(visitController).build();
    }
    @Test
    void initNewVisitForm() throws Exception {
        Pet pet = new Pet();
        pet.setId(1L);
        when(petService.findById(anyLong())).thenReturn(pet);
        mockMvc.perform(MockMvcRequestBuilders.get("/owners/1/pets/1/visits/new"))
                .andExpect(view().name("pets/createorupdatevisitform"))
                .andExpect(model().attributeExists("pet"))
                .andExpect(model().attributeExists("visit"));
    }

    @Test
    void processNewVisitForm() throws Exception {
        ArgumentCaptor<Visit> captor = ArgumentCaptor.forClass(Visit.class);
        Pet pet = new Pet();
        pet.setId(1L);
        Visit visit = new Visit();
        visit.setId(1L);
        visit.setPet(pet);
        when(petService.findById(anyLong())).thenReturn(pet);
        when(visitService.save(any())).thenReturn(visit);
        mockMvc.perform(MockMvcRequestBuilders.post("/owners/1/pets/1/visits/new")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("description","any description")
                .param("date" , "2018-11-02")
        ).andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/owners/{ownerId}"))
                .andExpect(model().attributeExists("visit"));
        verify(visitService,times(1)).save(captor.capture());

        Visit savedVisit = captor.getValue();
        assertNotNull(savedVisit);
    }
}