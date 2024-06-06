package softuni.bg.Mobilele.service;

import softuni.bg.Mobilele.model.dto.AddOfferDto;
import softuni.bg.Mobilele.model.dto.OfferDetailsDto;

public interface OfferService {
    long createOffer(AddOfferDto addOfferDto);

    OfferDetailsDto getOfferDetails(Long id);
}
