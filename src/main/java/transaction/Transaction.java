package transaction;

import java.time.LocalDate;
import java.time.LocalTime;


/**
 * Typical "data" class with just getters and setters.
 */
public class Transaction {
    private String receiverAccountNumber;
    private String senderAccountNumber;
    private double transferAmount;
    private LocalDate sendingDate;
    private LocalTime sendingTime;

    public Transaction() {}

    public void setReceiverAccountNumber(String receiverAccountNumber) {
        this.receiverAccountNumber = receiverAccountNumber;
    }

    public void setSenderAccountNumber(String senderAccountNumber) {
        this.senderAccountNumber = senderAccountNumber;
    }

    public void setTransferAmount(double transferAmount) {
        this.transferAmount = transferAmount;
    }

    public void setSendingDate(LocalDate sendingDate) {
        this.sendingDate = sendingDate;
    }

    public String getReceiverAccountNumber() {
        return receiverAccountNumber;
    }

    public String getSenderAccountNumber() {
        return senderAccountNumber;
    }

    public double getTransferAmount() {
        return transferAmount;
    }

    public LocalDate getSendingDate() {
        return sendingDate;
    }

    public void setSendingTime(LocalTime sendingTime) {
        this.sendingTime = sendingTime;
    }

    public LocalTime getSendingTime() {
        return sendingTime;
    }

    @Override
    public String toString() {
        return senderAccountNumber + " to " + receiverAccountNumber + " <" + transferAmount + ">";
    }
}
