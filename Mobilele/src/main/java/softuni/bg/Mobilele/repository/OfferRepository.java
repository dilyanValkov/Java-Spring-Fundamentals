package softuni.bg.Mobilele.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.bg.Mobilele.model.entity.OfferEntity;
@Repository
public interface OfferRepository extends JpaRepository<OfferEntity, Long> {
}
