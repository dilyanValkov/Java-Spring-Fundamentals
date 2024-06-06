package softuni.bg.Mobilele.model.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import softuni.bg.Mobilele.model.enums.EngineType;

public record AddOfferDto (
        @NotEmpty(message = "{add.offer.description.not.empty}")
        @Size(message = "{Description should be between 5 and 500 symbols.}",
        min = 5, max = 500)
        String description,
        @NotNull
        @Positive
        Integer mileage,
        @NotNull
        EngineType engineType
){
    public static AddOfferDto empty (){
       return  new AddOfferDto(null,null,null);
    }
}
