package omid.springframework.sfgpetclinic.controllers;

import omid.springframework.sfgpetclinic.model.Pet;
import omid.springframework.sfgpetclinic.model.Visit;
import omid.springframework.sfgpetclinic.services.PetService;
import omid.springframework.sfgpetclinic.services.VisitService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.beans.PropertyEditorSupport;
import java.time.LocalDate;

@Controller
public class VisitController {
    private final VisitService visitService;
    private final PetService petService;

    public VisitController(VisitService visitService, PetService petService) {
        this.visitService = visitService;
        this.petService = petService;
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder){
        dataBinder.setDisallowedFields("id");
        dataBinder.registerCustomEditor(LocalDate.class, new PropertyEditorSupport() {

            @Override
            public void setAsText(String text) throws IllegalArgumentException {
                setValue(LocalDate.parse(text));
            }
        });
    }
    @ModelAttribute("visit")
    public Visit loadPetVisit(@PathVariable("petId") Long petId, Model model){
        Pet pet = petService.findById(petId);
        model.addAttribute("pet",pet);
        Visit visit = new Visit();
        pet.getVisits().add(visit);
        visit.setPet(pet);
        return visit;
    }
    @GetMapping("/owners/*/pets/{petId}/visits/new")
    public String initNewVisitForm(@PathVariable("petId") Long petId,Model model){
        return "pets/createorupdatevisitform";
    }
    @PostMapping("/owners/{ownerId}/pets/{petId}/visits/new")
    public String processNewVisitForm(@Valid Visit visit, BindingResult result){
        if (result.hasErrors()){
            return "pets/createorupdatevisitform";
        }else {
            visitService.save(visit);
            return "redirect:/owners/{ownerId}";
        }
    }
}
