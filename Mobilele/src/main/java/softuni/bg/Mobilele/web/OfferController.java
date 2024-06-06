package softuni.bg.Mobilele.web;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import softuni.bg.Mobilele.model.dto.AddOfferDto;
import softuni.bg.Mobilele.model.enums.EngineType;
import softuni.bg.Mobilele.service.OfferService;

@Controller
@RequestMapping("/offer")
public class OfferController {

    private final OfferService offerService;

    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }

    @ModelAttribute("allEngineTypes")
    public EngineType[] allEngineTypes(){
        return EngineType.values();
    }

    @GetMapping("/add")
    public String newOffer(Model model){
       if (!model.containsAttribute("addOfferDto")){
           model.addAttribute("addOfferDto", AddOfferDto.empty());
       }
       return "offer-add";
    }

    @PostMapping("/add")
    public String createOffer(@Valid AddOfferDto dto, BindingResult result, RedirectAttributes attributes){

        if (result.hasErrors()){
            attributes.addFlashAttribute("addOfferDto",dto);
            attributes.addFlashAttribute("org.springframework.validation.BindingResult.addOfferDTO", result);
            return "redirect:/offers/add";
        }
        long newOfferId = offerService.createOffer(dto);
        return "redirect:/offers/" + newOfferId;
    }

}
