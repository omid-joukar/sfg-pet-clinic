package omid.springframework.sfgpetclinic.controllers;

import omid.springframework.sfgpetclinic.model.Owner;
import omid.springframework.sfgpetclinic.services.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {
    @Mock
    OwnerService ownerService;
    @InjectMocks
    OwnerController ownerController;
    Set<Owner> owners;
    MockMvc mockMvc;
    @BeforeEach
    void setUp() {
        owners = new HashSet<>();
        owners.add(Owner.builder().id(1L).build());
        owners.add(Owner.builder().id(2L).build());
        mockMvc = MockMvcBuilders.standaloneSetup(ownerController).build();
    }


    @Test
    void findOwners()throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/owners/find"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/findowners"))
                .andExpect(model().attributeExists("owner"));
    }
    @Test
    void processFindFormReturnMany()throws Exception{
        when(ownerService.findAllByLastNameLike(anyString())).thenReturn(Arrays.asList(Owner.builder().id(1L).build(),Owner.builder().id(2L).build()));
        mockMvc.perform(MockMvcRequestBuilders.get("/owners"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/ownersList"))
                .andExpect(model().attribute("selections",hasSize(2)));
    }
    @Test
    void processFindFormReturnOne()throws Exception{
        when(ownerService.findAllByLastNameLike(anyString())).thenReturn(Arrays.asList(Owner.builder().id(1L).build()));
        mockMvc.perform(MockMvcRequestBuilders.get("/owners"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/owners/1"));
    }
    @Test
    void displayOwner() throws Exception {
        Owner owner = new Owner();
        owner.setId(1L);
        when(ownerService.findById(anyLong())).thenReturn(owner);
        mockMvc.perform(MockMvcRequestBuilders.get("/owners/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/ownerdetails" ))
                .andExpect(model().attribute("owner",hasProperty("id",is(1L))));

    }
    @Test
    void initCreationForm()throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/owners/new"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/createorupdateownersform"))
                .andExpect(model().attributeExists("owner"));
        verifyZeroInteractions(ownerService);

    }
    @Test
    void processCreationForm()throws Exception{
        when(ownerService.save(any())).thenReturn(Owner.builder().id(1L).build());
        mockMvc.perform(MockMvcRequestBuilders.post("/owners/new"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/owners/1"))
                .andExpect(model().attributeExists("owner"));
        verify(ownerService).save(any());
    }
    @Test
    void initUpdateOwnerForm()throws Exception{
        when(ownerService.findById(anyLong())).thenReturn(Owner.builder().id(1L).build());
        mockMvc.perform(MockMvcRequestBuilders.get("/owners/1/edit"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/createorupdateownersform"))
                .andExpect(model().attributeExists("owner"));
        verifyZeroInteractions(ownerService);
    }
    @Test
    void processOwnerUpdateForm()throws Exception{
        when(ownerService.save(any())).thenReturn(Owner.builder().id(1L).build());
        mockMvc.perform(MockMvcRequestBuilders.post("/owners/1/edit"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/owners/1"))
                .andExpect(model().attributeExists("owner"));
                verify(ownerService).save(any());
    }

}