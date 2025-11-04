package pe.edu.upc.center.seniorhub.payment.interfaces.rest.transform;

import pe.edu.upc.center.seniorhub.payment.domain.model.commands.UpdateReceiptCommand;
import pe.edu.upc.center.seniorhub.payment.domain.model.valueobjects.ResidentId;
import pe.edu.upc.center.seniorhub.payment.interfaces.rest.resources.UpdateReceiptResource;

public class UpdateReceiptCommandFromResourceAssembler {
    public static UpdateReceiptCommand toCommandFromResource(Long receiptId, UpdateReceiptResource resource) {
        ResidentId residentId = new ResidentId(resource.residentId());

        return new UpdateReceiptCommand(
                receiptId,
                resource.issueDate(),
                resource.dueDate(),
                resource.totalAmount(),
                resource.status(),
                residentId,
                resource.paymentId(),
                resource.paymentDate(),
                resource.amountPaid(),
                resource.paymentMethod(),
                resource.type()
        );
    }
}