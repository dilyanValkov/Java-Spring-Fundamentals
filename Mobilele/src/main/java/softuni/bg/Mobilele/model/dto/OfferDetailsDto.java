package softuni.bg.Mobilele.model.dto;

import softuni.bg.Mobilele.model.enums.EngineType;

public record OfferDetailsDto(
        Long id,
        String description,
        Integer mileage,
        EngineType engineType
) {
}
