package console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadOldSchool {

    public static void main(String[] args) {
        readFromConsoleTraditional();
    }

    private static void readFromConsoleTraditional() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            String userInput;
            // Um in der Konsole das Ende der Eingabe zu markieren muss ^D (Windows)
            // ^Z(Linux) eingegeben werden
            while ((userInput = br.readLine()) != null) {
                System.out.println(userInput);
            }


        } catch (IOException ioe) {
            System.out.println("Something went wrong while reading from console. Please restart programm");
        }
        System.out.println("bye");
    }

}
