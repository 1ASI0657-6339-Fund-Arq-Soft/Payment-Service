package pe.edu.upc.center.seniorhub.payment.domain.services;

import pe.edu.upc.center.seniorhub.payment.domain.model.aggregates.Receipt;
import pe.edu.upc.center.seniorhub.payment.domain.model.queries.GetAllReceiptsQuery;
import pe.edu.upc.center.seniorhub.payment.domain.model.queries.GetReceiptByDateQuery;
import pe.edu.upc.center.seniorhub.payment.domain.model.queries.GetReceiptsByResidentIdQuery;
import pe.edu.upc.center.seniorhub.payment.domain.model.queries.GetReceiptByReceiptIdQuery;

import java.util.List;
import java.util.Optional;

public interface ReceiptQueryService {
    List<Receipt> handle(GetAllReceiptsQuery query);
    List<Receipt> handle(GetReceiptsByResidentIdQuery query);
    Optional<Receipt> handle(GetReceiptByDateQuery query);
    Optional<Receipt> handle(GetReceiptByReceiptIdQuery query);
}