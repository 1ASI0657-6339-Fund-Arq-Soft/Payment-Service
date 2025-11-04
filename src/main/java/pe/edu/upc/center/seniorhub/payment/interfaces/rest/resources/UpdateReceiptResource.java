package pe.edu.upc.center.seniorhub.payment.interfaces.rest.resources;

import java.util.Date;

public record UpdateReceiptResource(
        Date issueDate,
        Date dueDate,
        Float totalAmount,
        Boolean status,
        Long residentId,
        Long paymentId,
        Date paymentDate,
        Float amountPaid,
        Long paymentMethod,
        String type
) {}