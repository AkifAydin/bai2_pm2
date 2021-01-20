package model;

public enum ContractType {
    HAFT("Privat Haftpflicht"), RECHT("Rechtschutz"), KFZHAFT("KFZ-Haftplicht"), TEILKASKO("Kasko"),  BERUFSHAFT("Berufshaftpflicht");

    private String name;

    ContractType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
