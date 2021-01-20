package sample;

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
import modelgenerator.ContractGenerator;
import uimodelhelper.TreeModelHelper;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Controller {

    private static final int MAX_CONTRACTS = 100;

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
        final List<Contract> generatedContracts = ContractGenerator.generate(MAX_CONTRACTS);
        contractTreeView = new ContractTreeView(generatedContracts);
        contractTreeView.initialize();
        contractDetail = new ContractDetailView();
        contractScatterView = new ContractScatterView(generatedContracts);
    }


    private class ContractTreeView {
        private boolean switchToCustomer = true;
        private final String switchToCustomerText = "nach Kunden";
        private final String switchToContractTypeText = "nach Vertragstyp";
        private List<Contract> contracts;

        public ContractTreeView(List<Contract> contracts) {
            this.contracts = contracts;
        }

        public void initialize() {
        /*
         Erzeugen der TreeView auf Basis einer generierten Vertragsliste
         */
            TreeItem<Object> treeItemRoot =
                    TreeModelHelper.createContractTreeByContractType(new TreeItem<>("Verträge nach Vertragstyp"), contracts);

            // Verknüpfung
            contractTree.setRoot(treeItemRoot);
            contractTree.setShowRoot(true);
            contractTree.getRoot().setExpanded(true);

            // Implementierung mittels anonyme innerere Klasse. Äquivalent zur Lambda-Variante
//            contractTree.getSelectionModel().selectedItemProperty().
//                    addListener(new ChangeListener<TreeItem<Object>>() {
//                @Override
//                public void changed(ObservableValue<? extends TreeItem<Object>> observable, TreeItem<Object> oldValue, TreeItem<Object> newValue) {
//                    if (newValue != null && newValue.getValue() instanceof Contract) {
//                        contractDetail.update((Contract) newValue.getValue());
//                    }
//                }
//            });

            contractTree.getSelectionModel().selectedItemProperty().addListener(
                    (observable, oldValue, newValue) -> {
                        if (newValue != null && newValue.getValue() instanceof Contract) {
                            contractDetail.update((Contract) newValue.getValue());
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
                            contractTree.setRoot(TreeModelHelper.createContractTreeByCustomer(new TreeItem<>("Verträge " + switchToCustomerText), contracts));
                            switchToCustomer = false;
                        } else {
                            contractTree.setRoot(TreeModelHelper.createContractTreeByContractType(new TreeItem<>("Verträge " + switchToContractTypeText), contracts));
                            switchToCustomer = true;
                        }
                        contractDetail.clear();
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
            contractTree.refresh();
            contractTree.getSelectionModel().select(currentSelection);
        }

    }

    private class ContractScatterView {

        private List<Contract> contracts;
        private final String VERTRAGS_HOEHE = "Vertragshöhe in (€)";
        private final String VERTRAGS_ABSCHLUSS = "Vertragsabschluss (Jahr)";
        private final String ABSCHLUESSE_NACH_VERTRAGS_TYP = "Abschlüsse nach Vertragstyp";


        public ContractScatterView(List<Contract> contracts) {
            this.contracts = contracts;
            initialize();
        }

        private LocalDate minDate() {
            Contract minContract = contracts.stream().min(Comparator.comparing(Contract::getContractDate)).orElse(null);
            return minContract != null ? minContract.getContractDate() : null;
        }

        private LocalDate maxDate() {
            Contract maxContract = contracts.stream().max(Comparator.comparing(Contract::getContractDate)).orElse(null);
            return maxContract != null ? maxContract.getContractDate() : null;
        }

        private Amount maxAmount() {
            Contract maxContract = contracts.stream().max(Comparator.comparing(c -> c.getPaymentModel().getAmount())).orElse(null);
            return maxContract != null ? maxContract.getPaymentModel().getAmount() : null;
        }

        private Amount minAmount() {
            Contract minContract = contracts.stream().min(Comparator.comparing(c -> c.getPaymentModel().getAmount())).orElse(null);
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
            int minX = minAmount().getEuro();
            int maxX = maxAmount().getEuro();
            int tickUnitX = (maxX - minX) / 10;

            // Min Max Werte für die Y-Achse bestimmen
            int minY = minDate().getYear();
            int maxY = maxDate().getYear();
            int tickUnitY = 1;

            // Achsen des ScatterCharts
            final Axis xAxis = new NumberAxis(minX, maxX, tickUnitX);
            final Axis yAxis = new NumberAxis(minY, maxY, tickUnitY);

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
            Map<ContractType, List<Contract>> contractsByType = contracts.stream().collect(Collectors.groupingBy(Contract::getContractType));

            // Für jeden ContractType wird hier eine Serie von Daten berechnet (die Kombination aus Kosten des Vertrags und Abschlussdatum)
            for (Map.Entry<ContractType, List<Contract>> typeContracts : contractsByType.entrySet()) {

                // Serie für einen Vertragstyp
                XYChart.Series<Integer, Integer> series = new XYChart.Series();
                // Name = Typ des Vertrags
                series.setName(typeContracts.getKey().toString());
                // Calendar für das Ermitteln des Jahres
                // Calendar cal = Calendar.getInstance();
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

        private Contract contract;
        private static final String contractTitel = "Vertrag";
        private static final String customerTitel = "Kunde";

        public ContractDetailView() {
            this(null);
        }

        public ContractDetailView(Contract contract) {
            this.contract = contract;
            this.initialize();
            if (contract != null) {
                update(contract);
            }
        }

        public void initialize() {

            contractTitledPane.setText(contractTitel);
            customerTitledPane.setText(customerTitel);

            contractTypeBox.setItems(FXCollections.observableArrayList(ContractType.values()));
            contractRateBox.setItems(FXCollections.observableArrayList(Rate.values()));

            contractAmountField.setTextFormatter(new TextFormatter<>(new IntegerStringConverter()));

            saveButton.setOnAction((ActionEvent e) -> {
                if (contract != null) {
                    contract.setContractType(contractTypeBox.getValue());
                    contract.setContractDate(contractDateField.getValue());
                    contract.setPaymentModel(new PaymentModel(
                            contractRateBox.getValue(), new Amount(Integer.parseInt(contractAmountField.getText()))));
                    contract.getCustomer().setFirstName(customerFirstNameField.getText());
                    contract.getCustomer().setSurName(customerSurNameField.getText());
                    contract.getCustomer().setAddress(customerAddressField.getText());
                    contractScatterView.updateView();
                    contractTreeView.updateView();
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
            this.contract = contract;
            contractNrField.setText(contract.getContractId());
            contractTypeBox.getSelectionModel().select(contract.getContractType().ordinal());
            contractDateField.setValue(contract.getContractDate());
            contractAmountField.setText(contract.getPaymentModel().getAmount().getEuro() + "");
            contractRateBox.getSelectionModel().select(contract.getPaymentModel().getRate().ordinal());

            Customer customer = contract.getCustomer();
            customerNrField.setText(customer.getCustomerId());
            customerFirstNameField.setText(customer.getFirstName());
            customerSurNameField.setText(customer.getSurName());
            customerAddressField.setText(customer.getAddress());
        }

    }

}
