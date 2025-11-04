package pe.edu.upc.center.seniorhub.payment.interfaces.rest.transform;

import pe.edu.upc.center.seniorhub.payment.domain.model.commands.CreateReceiptCommand;
import pe.edu.upc.center.seniorhub.payment.domain.model.valueobjects.ResidentId;
import pe.edu.upc.center.seniorhub.payment.interfaces.rest.resources.CreateReceiptResource;

public class CreateReceiptCommandFromResourceAssembler {
    public static CreateReceiptCommand toCommandFromResource(CreateReceiptResource resource) {
        ResidentId residentId = new ResidentId(resource.residentId());

        return new CreateReceiptCommand(
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