package statements.expressions;

public class ExpressionExamples {
    public static void main(String[] args) {
        // Variablen-Deklarationen;
        int i;
        short sh;
        boolean b;
        String str;
        Object o;
        // arithmetischer Ausdruck
        i = 7 + 5;
        // logischer Ausdruck
        b = true;
        b = b && true;
        b = b || false;
        // Zuweisungen
        str = "";
        o = str;
        // Typprüfung
        b = str instanceof String;
        // Type-Cast
        sh = (short) i;
        str = (String) o;
        // Methoden mit Ergebnis
        str = String.format("ganze Zahl:%d", 15);
    }
}
