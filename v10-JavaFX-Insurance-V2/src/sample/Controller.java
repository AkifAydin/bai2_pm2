package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.Axis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTreeCell;
import javafx.scene.layout.AnchorPane;
import javafx.util.converter.IntegerStringConverter;
import model.*;
import sample.mvc.MVCInsuranceModel;
import uimodelhelper.TreeModelHelper;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Controller {

    private ContractDetailView contractDetail;
    private ContractScatterView contractScatterView;
    private ContractTreeView contractTreeView;

    @FXML
    private TreeView<Object> contractTree;

    @FXML
    private TitledPane contractTitledPane;

    @FXML
    private TextField contractNrField;

    @FXML
    private DatePicker contractDateField;

    @FXML
    private TextField contractAmountField;

    @FXML
    private ComboBox<ContractType> contractTypeBox;

    @FXML
    private ComboBox<Rate> contractRateBox;

    @FXML
    private TitledPane customerTitledPane;

    @FXML
    private TextField customerNrField;

    @FXML
    private TextField customerSurNameField;

    @FXML
    private TextField customerFirstNameField;

    @FXML
    private TextField customerAddressField;

    @FXML
    private Button saveButton;

    @FXML
    private AnchorPane scatterParent;

    @FXML
    protected void initialize() {

        final MVCInsuranceModel mvcInsuranceModel = new MVCInsuranceModel();

        contractTreeView = new ContractTreeView(mvcInsuranceModel);
        contractTreeView.initialize();
        contractDetail = new ContractDetailView(mvcInsuranceModel);
        contractScatterView = new ContractScatterView(mvcInsuranceModel);
    }


    private class ContractTreeView {
        private boolean switchToCustomer = true;
        private final String switchToCustomerText = "nach Kunden";
        private final String switchToContractTypeText = "nach Vertragstyp";
        private MVCInsuranceModel mvcInsuranceModel;

        public ContractTreeView(MVCInsuranceModel mvcInsuranceModel) {
            this.mvcInsuranceModel = mvcInsuranceModel;
            this.mvcInsuranceModel.changedContractPropertyProperty().addListener(new ChangeListener<Contract>() {
                @Override
                public void changed(ObservableValue<? extends Contract> observable, Contract oldValue, Contract newValue) {
                    if (oldValue == null || (newValue != null && !oldValue.equals(newValue))) {
                        updateView();
                    }
                }
            });
        }

        public void initialize() {
        /*
         Erzeugen der TreeView auf Basis einer generierten Vertragsliste
         */
            TreeItem<Object> treeItemRoot = TreeModelHelper.createContractTreeByContractType(new TreeItem<>("Verträge nach Vertragstyp"), mvcInsuranceModel.getContracts());

            // Verknüpfung
            contractTree.setRoot(treeItemRoot);
            contractTree.setShowRoot(true);
            contractTree.getRoot().setExpanded(true);

            contractTree.getSelectionModel().selectedItemProperty().addListener(
                    (observable, oldValue, newValue) -> {
                        if (newValue != null && newValue.getValue() instanceof Contract) {
                            mvcInsuranceModel.setInitialContract((Contract) newValue.getValue());
                            mvcInsuranceModel.setChangedContract(null);
                        }
                    });

            contractTree.setEditable(true);

            contractTree.setCellFactory((TreeView<Object> tv) -> new TextFieldTreeCell<>() {
                private final MenuItem switchItem;

                private final ContextMenu switchViewMenu = new ContextMenu();

                {
                    switchItem = new MenuItem();
                    switchViewMenu.getItems().add(switchItem);
                    switchItem.setOnAction((ActionEvent e) -> {
                        if (switchToCustomer) {
                            contractTree.setRoot(TreeModelHelper.createContractTreeByCustomer(new TreeItem<>("Verträge " + switchToCustomerText), mvcInsuranceModel.getContracts()));
                            switchToCustomer = false;
                        } else {
                            contractTree.setRoot(TreeModelHelper.createContractTreeByContractType(new TreeItem<>("Verträge " + switchToContractTypeText), mvcInsuranceModel.getContracts()));
                            switchToCustomer = true;
                        }
                        mvcInsuranceModel.setInitialContract(null);
                        mvcInsuranceModel.setChangedContract(null);
                        contractTree.setShowRoot(true);
                        contractTree.getRoot().setExpanded(true);
                        return;
                    });
                    setEditable(false);
                    setContextMenu(switchViewMenu);
                }

                @Override
                public void updateSelected(boolean selected) {
                    if (switchItem != null) {
                        switchItem.setText(switchToCustomer ? switchToCustomerText : switchToContractTypeText);
                    }
                }
            });
        }

        public void updateView() {
            int currentSelection = contractTree.getSelectionModel().getSelectedIndex();
            contractTree.getSelectionModel().getSelectedItem().setValue(mvcInsuranceModel.getChangedContract());
            contractTree.refresh();
            contractTree.getSelectionModel().select(currentSelection);
        }

    }

    private class ContractScatterView {

        private MVCInsuranceModel mvcInsuranceModel;
        private int minX, maxX, minY, maxY;
        private ContractType contractType = null;
        private final String VERTRAGS_HOEHE = "Vertragshöhe in (€)";
        private final String VERTRAGS_ABSCHLUSS = "Vertragsabschluss (Jahr)";
        private final String ABSCHLUESSE_NACH_VERTRAGS_TYP = "Abschlüsse nach Vertragstyp";


        public ContractScatterView(MVCInsuranceModel mvcInsuranceModel) {
            this.mvcInsuranceModel = mvcInsuranceModel;
            this.mvcInsuranceModel.changedContractPropertyProperty().addListener((observable, oldValue,  newValue) -> {
                    if (oldValue == null || !oldValue.equals(newValue)) {
                        if (newValue != null) {
                            int newAmount = newValue.getPaymentModel().getAmount().getEuro();
                            int newYear = newValue.getContractDate().getYear();
                            if (newAmount < minX || newAmount > maxX || newYear < minY || newYear > maxY || !newValue.getContractType().equals(contractType)) {
                                contractType = newValue.getContractType();
                                updateView();
                            }
                        }
                    }
            });
            initialize();
        }

        private LocalDate minDate() {
            Contract minContract = mvcInsuranceModel.getContracts().stream().min(Comparator.comparing(Contract::getContractDate)).orElse(null);
            return minContract != null ? minContract.getContractDate() : null;
        }

        private LocalDate maxDate() {
            Contract maxContract = mvcInsuranceModel.getContracts().stream().max(Comparator.comparing(Contract::getContractDate)).orElse(null);
            return maxContract != null ? maxContract.getContractDate() : null;
        }

        private Amount maxAmount() {
            Contract maxContract = mvcInsuranceModel.getContracts().stream().max(Comparator.comparing(c -> c.getPaymentModel().getAmount())).orElse(null);
            return maxContract != null ? maxContract.getPaymentModel().getAmount() : null;
        }

        private Amount minAmount() {
            Contract minContract = mvcInsuranceModel.getContracts().stream().min(Comparator.comparing(c -> c.getPaymentModel().getAmount())).orElse(null);
            return minContract != null ? minContract.getPaymentModel().getAmount() : null;
        }

        public void updateView() {
            if (scatterParent.getChildren().size() > 0) {
                scatterParent.getChildren().clear();
            }
            initialize();
        }

        private void initialize() {

            // Befüllen des ScatterCharts

            // Min Max Werte für die Achse bestimmen
            minX = minAmount().getEuro();
            maxX = maxAmount().getEuro();
            int tickUnitX = (maxX - minX) / 10;

            // Min Max Werte für die Y-Achse bestimmen
            minY = minDate().getYear();
            maxY = maxDate().getYear();
            int tickUnitY = 1;

            // Achsen des ScatterCharts
            final Axis xAxis = new NumberAxis(minX - tickUnitX, maxX + tickUnitX, tickUnitX);
            final Axis yAxis = new NumberAxis(minY - tickUnitY, maxY + tickUnitY, tickUnitY);

            // Beschriftung des Achsen
            xAxis.setLabel(VERTRAGS_HOEHE);
            yAxis.setLabel(VERTRAGS_ABSCHLUSS);

            // Erzeugen des ScatterCharts mit den Achsen
            ScatterChart<Integer, Integer> contractScatter = new ScatterChart<>(xAxis, yAxis);
            contractScatter.setTitle(ABSCHLUESSE_NACH_VERTRAGS_TYP);

            // programmatisches Hinzufügen des ScatterCharts zu dem ParentContainer scatterParent (Typ AnchorPane)
            scatterParent.getChildren().add(contractScatter);
            // Verankern des ScatterCharts in der AnchorPane
            AnchorPane.setTopAnchor(contractScatter, 1.0);
            AnchorPane.setLeftAnchor(contractScatter, 1.0);
            AnchorPane.setRightAnchor(contractScatter, 1.0);
            AnchorPane.setBottomAnchor(contractScatter, 1.0);

            // Gruppieren nach contractTypeBox
            Map<ContractType, List<Contract>> contractsByType = mvcInsuranceModel.getContracts().stream().collect(Collectors.groupingBy(Contract::getContractType));

            // Für jeden ContractType wird hier eine Serie von Daten berechnet (die Kombination aus Kosten des Vertrags und Abschlussdatum)
            for (Map.Entry<ContractType, List<Contract>> typeContracts : contractsByType.entrySet()) {

                // Serie für einen Vertragstyp
                XYChart.Series<Integer, Integer> series = new XYChart.Series();
                // Name = Typ des Vertrags
                series.setName(typeContracts.getKey().toString());
                // Calendar für das Ermitteln des Jahres
                Calendar cal = Calendar.getInstance();
                // für Verträge des selben Vertragstyps werden die Daten (x,y) - Koordinaten eingetragen. An dieser Position erscheint dann das Symbol des ContractType
                typeContracts.getValue().forEach(con -> {
                    series.getData().
                            add(new XYChart.Data(con.getPaymentModel().getAmount().getEuro(),
                                    con.getContractDate().getYear()));
                });
                contractScatter.getData().add(series);
            }
        }
    }


    private class ContractDetailView {

        private MVCInsuranceModel mvcInsuranceModel;
        //private Contract contract;
        private static final String contractTitel = "Vertrag";
        private static final String customerTitel = "Kunde";

        public ContractDetailView(MVCInsuranceModel mvcInsuranceModel) {
            this.mvcInsuranceModel = mvcInsuranceModel;
            this.initialize();
            if (mvcInsuranceModel.getInitialContract() != null) {
                update(mvcInsuranceModel.getInitialContract());
            }
            this.mvcInsuranceModel.initialContractProperty().addListener((observable, oldValue, newValue) -> {
                mvcInsuranceModel.setChangedContract(null);
                if (newValue == null) {
                    clear();
                }
                if (oldValue == null || !oldValue.equals(newValue)) {
                    update(newValue);
                }
            });

        }

        public void initialize() {

            contractTitledPane.setText(contractTitel);
            customerTitledPane.setText(customerTitel);

            contractTypeBox.setItems(FXCollections.observableArrayList(ContractType.values()));
            contractRateBox.setItems(FXCollections.observableArrayList(Rate.values()));

            contractAmountField.setTextFormatter(new TextFormatter<>(new IntegerStringConverter()));

            saveButton.setOnAction((ActionEvent e) -> {
                try {
                    Contract contract;
                    if (mvcInsuranceModel.getChangedContract() != null) {
                        contract = mvcInsuranceModel.getChangedContract().clone();
                    } else {
                        contract = mvcInsuranceModel.getInitialContract().clone();
                    }
                    if (contract != null) {
                        contract.setContractType(contractTypeBox.getValue());
                        contract.setContractDate(contractDateField.getValue());
                        contract.setPaymentModel(new PaymentModel(
                                contractRateBox.getValue(), new Amount(Integer.parseInt(contractAmountField.getText()))));
                        contract.getCustomer().setFirstName(customerFirstNameField.getText());
                        contract.getCustomer().setSurName(customerSurNameField.getText());
                        contract.getCustomer().setAddress(customerAddressField.getText());
                        mvcInsuranceModel.setChangedContract(contract);
                    }
                } catch (CloneNotSupportedException e1) {
                    e1.printStackTrace();
                }
            });
        }


        public void clear() {
            contractNrField.clear();
            contractTypeBox.getSelectionModel().select(null);
            contractDateField.setValue(null);
            contractAmountField.clear();
            contractRateBox.getSelectionModel().select(null);

            customerNrField.clear();
            customerFirstNameField.clear();
            customerSurNameField.clear();
            customerAddressField.clear();
        }

        public void update(Contract contract) {
            if (contract != null) {
                contractNrField.setText(contract.getContractId());
                contractTypeBox.getSelectionModel().select(contract.getContractType().ordinal());
                contractDateField.setValue(contract.getContractDate());
                contractAmountField.setText(contract.getPaymentModel().getAmount().getEuro() + " ");
                contractRateBox.getSelectionModel().select(contract.getPaymentModel().getRate().ordinal());

                Customer customer = contract.getCustomer();
                customerNrField.setText(customer.getCustomerId());
                customerFirstNameField.setText(customer.getFirstName());
                customerSurNameField.setText(customer.getSurName());
                customerAddressField.setText(customer.getAddress());
            }
        }

    }

}
