package pe.edu.upc.center.seniorhub.payment.infrastructure.persistence.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.center.seniorhub.payment.domain.model.aggregates.Receipt;
import pe.edu.upc.center.seniorhub.payment.domain.model.valueobjects.ResidentId;

import java.util.List;
import java.util.Date;
import java.util.Optional;

@Repository
public interface ReceiptRepository extends JpaRepository<Receipt, Long> {

    boolean existsByResidentId(ResidentId residentId);

    boolean existsByIssueDate(Date date);

    Optional<Receipt> findByPaymentDate(Date paymentDate);
    List<Receipt> findByResidentId(ResidentId residentId);

}