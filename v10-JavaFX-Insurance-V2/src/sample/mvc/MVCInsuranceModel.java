package sample.mvc;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Contract;
import modelgenerator.ContractGenerator;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MVCInsuranceModel {

    private static final int MAX_CONTRACTS = 100;
    private ObservableList<Contract> contracts;
    private ObjectProperty<Contract> initialContractProperty;
    private ObjectProperty<Contract> changedContractProperty;

    public MVCInsuranceModel() {
        final List<Contract> generatedContracts = ContractGenerator.generate(MAX_CONTRACTS).stream().sorted(Comparator.comparing(Contract::getContractId)).collect(Collectors.toList());
        this.contracts = FXCollections.observableArrayList(generatedContracts);
        initialContractProperty = new SimpleObjectProperty<>();
        changedContractProperty = new SimpleObjectProperty<>();
    }

    public ObservableList<Contract> getContracts(){
        return contracts;
    }

    public ObjectProperty<Contract> changedContractPropertyProperty() {
        return changedContractProperty;
    }

    public Contract getChangedContract(){
        return changedContractProperty.get();
    }

    public void setChangedContract(Contract contract){
        if (contract != null && !contract.equals(getInitialContract())) {
            Contract toBeReplaced = contracts.stream().filter(c -> c.getContractId().equals(contract.getContractId())).findFirst().orElse(null);
            if (toBeReplaced!= null) {
                int index = contracts.indexOf(toBeReplaced);
                contracts.set(index,contract);
            }
            changedContractProperty.set(contract);
        }
        if (contract==null) {
            changedContractProperty.set(contract);
        }
    }

    public ObjectProperty<Contract> initialContractProperty() {
        return initialContractProperty;
    }

    public Contract getInitialContract(){
        return initialContractProperty.get();
    }

    public void setInitialContract(Contract contract) {
        initialContractProperty.set(contract);
    }

}
