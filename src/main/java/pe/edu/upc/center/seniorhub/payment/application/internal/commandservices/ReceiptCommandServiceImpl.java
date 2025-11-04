package pe.edu.upc.center.seniorhub.payment.application.internal.commandservices;

import org.springframework.stereotype.Service;
import pe.edu.upc.center.seniorhub.payment.domain.model.aggregates.Receipt;
import pe.edu.upc.center.seniorhub.payment.domain.model.commands.CreateReceiptCommand;
import pe.edu.upc.center.seniorhub.payment.domain.model.commands.DeleteReceiptCommand;
import pe.edu.upc.center.seniorhub.payment.domain.model.commands.UpdateReceiptCommand;
import pe.edu.upc.center.seniorhub.payment.domain.services.ReceiptCommandService;
import pe.edu.upc.center.seniorhub.payment.infrastructure.persistence.jpa.repositories.ReceiptRepository;

import java.util.Optional;

@Service
public class ReceiptCommandServiceImpl implements ReceiptCommandService {
    private final ReceiptRepository receiptRepository;

    public ReceiptCommandServiceImpl(ReceiptRepository receiptRepository) {
        this.receiptRepository = receiptRepository;
    }

    @Override
    public Long handle(CreateReceiptCommand command) {
        if (this.receiptRepository.existsByResidentId(command.residentId())) {
            throw new IllegalArgumentException("Receipt with Resident ID " + command.residentId() + " already exists");
        }

        Receipt receipt = new Receipt(command);
        try {
            this.receiptRepository.save(receipt);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while saving receipt: " + e.getMessage());
        }
        return receipt.getId();
    }

    @Override
    public Optional<Receipt> handle(UpdateReceiptCommand command) {
        var receiptId = command.receiptId();

        if (!this.receiptRepository.existsById(receiptId)) {
            throw new IllegalArgumentException("Receipt " + command.receiptId() + " does not exist");
        }

        var receiptToUpdate = this.receiptRepository.findById(receiptId).get();
        receiptToUpdate.updateInformation(
                command.issueDate(),
                command.dueDate(),
                command.totalAmount(),
                command.status(),
                command.residentId(),
                command.paymentId(),
                command.paymentDate(),
                command.amountPaid(),
                command.paymentMethod(),
                command.type()
        );

        try {
            var updatedReceipt = this.receiptRepository.save(receiptToUpdate);
            return Optional.of(updatedReceipt);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while updating receipt: " + e.getMessage());
        }
    }

    @Override
    public void handle(DeleteReceiptCommand command){
        if (!this.receiptRepository.existsById(command.receiptId())){
            throw new IllegalArgumentException("Receipt with id " + command.receiptId() + " does not exist");
        }

        try {
            this.receiptRepository.deleteById(command.receiptId());
        }catch (Exception e){
            throw new IllegalArgumentException("Error while deleting receipt: "+ e.getMessage());
        }
    }
}