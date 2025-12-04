package com.example.Pojo.RealStateProject;

import java.util.List;

public class ExtractRequest {

    private int unitId;
    private int realStateProjectId;
    private int developerId;
    private double invoiceAmount;
    private String description;
    private String extractDate;
    private List<Integer> attachments;
    private int payType;

    public ExtractRequest() {
    }

    public int getUnitId() { return unitId; }
    public void setUnitId(int unitId) { this.unitId = unitId; }

    public int getRealStateProjectId() { return realStateProjectId; }
    public void setRealStateProjectId(int realStateProjectId) { this.realStateProjectId = realStateProjectId; }

    public int getDeveloperId() { return developerId; }
    public void setDeveloperId(int developerId) { this.developerId = developerId; }

    public double getInvoiceAmount() { return invoiceAmount; }
    public void setInvoiceAmount(double invoiceAmount) { this.invoiceAmount = invoiceAmount; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getExtractDate() { return extractDate; }
    public void setExtractDate(String extractDate) { this.extractDate = extractDate; }

    public List<Integer> getAttachments() { return attachments; }
    public void setAttachments(List<Integer> attachments) { this.attachments = attachments; }

    public int getPayType() { return payType; }
    public void setPayType(int payType) { this.payType = payType; }
}
