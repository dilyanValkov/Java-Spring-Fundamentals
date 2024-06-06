package softuni.bg.Mobilele.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.bg.Mobilele.model.dto.AddOfferDto;
import softuni.bg.Mobilele.model.dto.OfferDetailsDto;
import softuni.bg.Mobilele.model.entity.OfferEntity;
import softuni.bg.Mobilele.repository.OfferRepository;
import softuni.bg.Mobilele.service.OfferService;

import java.util.Optional;
@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;
    private final ModelMapper modelMapper;

    public OfferServiceImpl(OfferRepository offerRepository, ModelMapper modelMapper) {
        this.offerRepository = offerRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public long createOffer(AddOfferDto addOfferDto) {
        OfferEntity offerEntity = modelMapper.map(addOfferDto, OfferEntity.class);
        return this.offerRepository.save(offerEntity).getId();
    }

    @Override
    public OfferDetailsDto getOfferDetails(Long id) {
        OfferEntity offerEntity = this.offerRepository.findById(id).orElseThrow();
        return modelMapper.map(offerEntity, OfferDetailsDto.class);
    }
}
