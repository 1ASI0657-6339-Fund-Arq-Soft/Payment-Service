package pe.edu.upc.center.seniorhub.payment.interfaces.rest.transform;

import pe.edu.upc.center.seniorhub.payment.domain.model.aggregates.Receipt;
import pe.edu.upc.center.seniorhub.payment.interfaces.rest.resources.ReceiptResource;

public class ReceiptResourceFromEntityAssembler {
    public static ReceiptResource toResourceFromEntity(Receipt entity) {
        return new ReceiptResource(
                entity.getId(),
                entity.getIssueDate(),
                entity.getDueDate(),
                entity.getTotalAmount(),
                entity.getStatus(),
                entity.getResidentId().residentId(),
                entity.getPaymentId(),
                entity.getPaymentDate(),
                entity.getAmountPaid(),
                entity.getPaymentMethod(),
                entity.getType()
        );
    }
}