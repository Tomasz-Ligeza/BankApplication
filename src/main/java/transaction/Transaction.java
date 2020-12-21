package transaction;

import java.util.Date;

/**
 * We have to think about receiving transactions mechanism:
 *      * we have to set transactionStatus as true after receiving one,
 *      * alse receivingDate has to be set smth like Today() after receiving
 */

public class Transaction {
    private String receiverAccountNumber;
    private String senderAccountNumber;
    private double transferAmount;
    private Date sendingDate;
    private Date receivingDate;
    private boolean transactionStatus;

    Transaction() {
        transactionStatus = false;
    }

    public void setReceiverAccountNumber(String receiverAccountNumber) {
        this.receiverAccountNumber = receiverAccountNumber;
    }

    public void setSenderAccountNumber(String senderAccountNumber) {
        this.senderAccountNumber = senderAccountNumber;
    }

    public void setTransferAmount(double transferAmount) {
        this.transferAmount = transferAmount;
    }

    public void setSendingDate(Date sendingDate) {
        this.sendingDate = sendingDate;
    }

    public void setReceivingDate(Date receivingDate) {
        this.receivingDate = receivingDate;
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

    public Date getSendingDate() {
        return sendingDate;
    }

    public Date getReceivingDate() {
        return receivingDate;
    }

    public boolean isTransactionStatus() {
        return transactionStatus;
    }
}
