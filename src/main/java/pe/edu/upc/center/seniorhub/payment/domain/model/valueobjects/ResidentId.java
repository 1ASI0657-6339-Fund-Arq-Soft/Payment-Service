package pe.edu.upc.center.seniorhub.payment.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record ResidentId(Long residentId) {

    public ResidentId() {
        this(null);
    }

    public ResidentId {
        if (residentId == null || residentId <= 0) {
            throw new IllegalArgumentException("ResidentId must be positive and not null");
        }
    }

    public Long getValue(){
        return residentId;
    }
}