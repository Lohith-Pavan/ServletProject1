package com.lohith;

import java.sql.Date;

public class TransactionDto {
    private int txnId;
    private Date txnDate;
    private int sourceId;
    private int destinationId;
    private String sourceType;
    private String destinationType;
    private double txnAmount;
	public TransactionDto(int txnId, Date txnDate, int sourceId, int destinationId, String sourceType,
			String destinationType, double txnAmount) {
		super();
		this.txnId = txnId;
		this.txnDate = txnDate;
		this.sourceId = sourceId;
		this.destinationId = destinationId;
		this.sourceType = sourceType;
		this.destinationType = destinationType;
		this.txnAmount = txnAmount;
	}
	public int getTxnId() {
		return txnId;
	}
	public void setTxnId(int txnId) {
		this.txnId = txnId;
	}
	public Date getTxnDate() {
		return txnDate;
	}
	public void setTxnDate(Date txnDate) {
		this.txnDate = txnDate;
	}
	public int getSourceId() {
		return sourceId;
	}
	public void setSourceId(int sourceId) {
		this.sourceId = sourceId;
	}
	public int getDestinationId() {
		return destinationId;
	}
	public void setDestinationId(int destinationId) {
		this.destinationId = destinationId;
	}
	public String getSourceType() {
		return sourceType;
	}
	public void setSourceType(String sourceType) {
		this.sourceType = sourceType;
	}
	public String getDestinationType() {
		return destinationType;
	}
	public void setDestinationType(String destinationType) {
		this.destinationType = destinationType;
	}
	public double getTxnAmount() {
		return txnAmount;
	}
	public void setTxnAmount(double txnAmount) {
		this.txnAmount = txnAmount;
	}
    
}
