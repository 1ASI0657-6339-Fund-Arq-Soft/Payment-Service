package pe.edu.upc.center.seniorhub.payment.domain.model.aggregates;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import pe.edu.upc.center.seniorhub.payment.domain.model.commands.CreateReceiptCommand;
import pe.edu.upc.center.seniorhub.payment.domain.model.valueobjects.ResidentId;
import pe.edu.upc.center.seniorhub.payment.shared.domain.aggregates.AuditableAbstractAggregateRoot;

import java.util.Date;

@Entity
@Table(name = "receipt")
public class Receipt extends AuditableAbstractAggregateRoot<Receipt> {

    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "issueDate", nullable = false)
    private Date issueDate;

    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "dueDate", nullable = false)
    private Date dueDate;

    @NotNull
    @Column(nullable = false)
    private Float totalAmount;

    @NotNull
    @Column(nullable = false)
    private Boolean status;

    @Embedded
    @NotNull
    private ResidentId residentId;

    @Column(name = "paymentId", nullable = true)
    private Long paymentId;

    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "paymentDate", nullable = false)
    private Date paymentDate;

    @NotNull
    @Column(nullable = false)
    private Float amountPaid;

    @NotNull
    @Column(nullable = false)
    private Long paymentMethod;

    @NotNull
    @Column(nullable = false)
    private String type;

    // Constructor completo
    public Receipt(Date issueDate, Date dueDate, Float totalAmount, Boolean status, ResidentId residentId, Long paymentId,
                   Date paymentDate, Float amountPaid, Long paymentMethod, String type){
     this.issueDate = issueDate;
     this.dueDate = dueDate;
     this.totalAmount = totalAmount;
     this.status = status;
     this.residentId = residentId;
     this.paymentId = paymentId;
     this.paymentDate = paymentDate;
     this.amountPaid = amountPaid;
     this.paymentMethod = paymentMethod;
     this.type = type;
    }

    // Constructor desde CreateReceiptCommand
    public Receipt(){}
    
    public Receipt(CreateReceiptCommand command) {
        this(
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
    }

    // Método para actualizar información básica
    public void updateInformation(Date issueDate, Date dueDate, Float totalAmount, Boolean status, ResidentId residentId,
                                  Long paymentId,
                                  Date paymentDate, Float amountPaid, Long paymentMethod, String type){
        this.issueDate = issueDate;
        this.dueDate = dueDate;
        this.totalAmount = totalAmount;
        this.status = status;
        this.residentId = residentId;
        this.paymentId = paymentId;
        this.paymentDate = paymentDate;
        this.amountPaid = amountPaid;
        this.paymentMethod = paymentMethod;
        this.type = type;
    }

    // Getters
    public Date getIssueDate() { return issueDate; }
    public Date getDueDate() { return dueDate; }
    public Float getTotalAmount() { return totalAmount; }
    public Boolean getStatus() { return status; }
    public ResidentId getResidentId() { return residentId; }
    public Long getPaymentId() { return paymentId; }
    public Date getPaymentDate() { return paymentDate; }
    public Float getAmountPaid() { return amountPaid; }
    public Long getPaymentMethod() { return paymentMethod; }
    public String getType() { return type; }
}