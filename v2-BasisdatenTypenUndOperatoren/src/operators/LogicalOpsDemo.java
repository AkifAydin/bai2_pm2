package operators;

import static util.Printer.print;

public class LogicalOpsDemo {

    public static void main(String[] args) {
        int i = 50;
        int j = 230;
        print("i = " + i);
        print("j = " + j);
        print("i > j " + (i > j));
        print("i < j " + (i < j));
        print("i >= j " + (i >= j));
        print("i <= j " + (i <= j));
        print("i == j " + (i == j));
        print("i != j " + (i != j));
        // int darf nicht als boolean interpretiert werden
        // ! print("i && j " + (i && j));
        // ! print("i || j " + (i || j));
        // ! print("!i" + (!i));
        // nur boolesche Werte duerfen mit booleschen Ops verknuepft werden
        print("(i < 10) && (j < 10) " + ((i < 10) && (j < 10)));
        print("(i < 10) & (j < 10) " + ((i < 10) & (j < 10)));
        print("(i < 10) || (j < 10) " + ((i < 10) || (j < 10)));
        print("(i < 10) | (j < 10) " + ((i < 10) | (j < 10)));
    }
}
