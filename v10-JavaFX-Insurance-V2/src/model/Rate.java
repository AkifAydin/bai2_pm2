package model;

public enum Rate {

    MONTHLY("monatlich"),QUATERLY("vierteljährlich"),YEARLY("jährlich");

    private final String name;

    Rate(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
