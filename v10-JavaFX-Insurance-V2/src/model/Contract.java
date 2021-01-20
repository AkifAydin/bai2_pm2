package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Contract implements Cloneable {

    private String contractId;
    private ContractType contractType;
    private Customer customer;
    private LocalDate contractDate;
    private PaymentModel paymentModel;
    public static final Contract EMPTYCONTRACT = new Contract(-1,null,null,null,null);

    public Contract(int contractId, ContractType contractType,Customer customer,LocalDate contractDate, PaymentModel paymentModel){
        this.contractId = "Cn" +contractId;
        this.contractType = contractType;
        this.customer = customer;
        this.contractDate = contractDate;
        this.paymentModel = paymentModel;
    }

    @Override
    public Contract clone() throws CloneNotSupportedException {
        Contract cloned = (Contract)super.clone();
        this.customer = cloned.getCustomer().clone();
        return cloned;
    }

    @Override
    public String toString() {
        return String.format("%s|%s|%s|:[%s],(%s)", contractId,contractType,customer,contractDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")), paymentModel);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contract contract = (Contract) o;
        return contractType == contract.contractType &&
                Objects.equals(customer, contract.customer) &&
                Objects.equals(contractDate, contract.contractDate) &&
                Objects.equals(paymentModel, contract.paymentModel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contractType, customer, contractDate, paymentModel);
    }

    public String getContractId(){
        return contractId;
    }

    public void setContractType(ContractType contractType) {
        this.contractType = contractType;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setContractDate(LocalDate contractDate) {
        this.contractDate = contractDate;
    }

    public void setPaymentModel(PaymentModel paymentModel) {
        this.paymentModel = paymentModel;
    }

    public ContractType getContractType() {
        return this.contractType;
    }

    public Customer getCustomer(){
        return customer;
    }

    public LocalDate getContractDate() {
        return contractDate;
    }

    public PaymentModel getPaymentModel() {
        return paymentModel;
    }
}
