package pe.edu.upc.center.seniorhub.payment.domain.model.commands;

import pe.edu.upc.center.seniorhub.payment.domain.model.valueobjects.ResidentId;
import java.util.Date;

public record CreateReceiptCommand(
        Date issueDate,
        Date dueDate,
        Float totalAmount,
        Boolean status,
        ResidentId residentId,
        Long paymentId,
        Date paymentDate,
        Float amountPaid,
        Long paymentMethod,
        String type
) {}