package mypack.sub;

public class KommandoZeilenParameter {



    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("Programm wurde ohne Parameter gestartet");
        } else {
            System.out.println("Programm Parameter:");
            for (int i = 0; i < args.length; i++) {
                System.out.println(i + ":" + args[i]);
            }
        }
    }
}
