package uimodelhelper;

import javafx.scene.control.TreeItem;
import model.Contract;
import model.ContractType;
import model.Customer;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TreeModelHelper {
    private static TreeItem<Object> byContractType = null;
    private static TreeItem<Object> byContractCustomer = null;

    public static TreeItem<Object> createContractTreeByContractType(TreeItem<Object> root, List<Contract> contracts){

        if (byContractType==null){
            Stream.of(ContractType.values()).map(ct -> {
                TreeItem<Object> typeNode = new TreeItem<>(ct);
                // 1. nach contractType organisieren, TreeItems erstellen, TreeItems zur typeNode hinzufügen, TypeNode dem root hinzufügen
                typeNode.getChildren().addAll(
                        contracts.stream().
                                filter(cont -> cont.getContractType()==ct).
                                map(cont -> new TreeItem<Object>(cont)).
                                collect(Collectors.toList()));
                return typeNode;
            }).forEach(ct -> root.getChildren().add(ct));
            byContractType = root;
        }
        return byContractType;
    }

    public static TreeItem<Object> createContractTreeByCustomer(TreeItem<Object> root, List<Contract> contracts) {
        if (byContractCustomer == null) {
            List<Customer> customers = contracts.stream().map(contract -> contract.getCustomer()).distinct().collect(Collectors.toList());
            customers.stream().map(cust -> {
                TreeItem<Object> custNode = new TreeItem<>(cust);
                custNode.getChildren().addAll(
                        contracts.stream().
                                filter(ct -> ct.getCustomer().equals(cust)).
                                map(contract ->  new TreeItem<Object>(contract)).collect(Collectors.toList()));
              return custNode;
            }).forEach(cust -> root.getChildren().add(cust));
            byContractCustomer = root;
        }
        return byContractCustomer;
    }

}
