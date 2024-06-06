package softuni.bg.Mobilele.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import softuni.bg.Mobilele.model.enums.EngineType;

@Entity
@Table(name = "offers")
public class OfferEntity extends BaseEntity {
    private String description;

    private Integer mileage;
    @Enumerated(EnumType.STRING)
    private EngineType engine;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public EngineType getEngine() {
        return engine;
    }

    public void setEngine(EngineType engine) {
        this.engine = engine;
    }

}
