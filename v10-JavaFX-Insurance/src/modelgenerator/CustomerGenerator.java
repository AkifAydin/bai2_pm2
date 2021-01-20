package modelgenerator;

import model.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CustomerGenerator {

    private static final String[] FIRSTNAMES ={"Tom","Grobi","Anna","Lisa","Tim","Dana","Aura","Bruno","Struppi","Lotta"} ;
    private static final String[] SURNAMES = {"Eins","Zwei","Drei","Vier","Fuenf","Sechs","Sieben","Acht","Neun","Zehn"} ;
    private static final String[] STREETS = {"Grundstrasse", "Hohenzollernring","Diebsteich","Armgartstrasse", "Bremer Strasse", "Berliner Tor", "Steindamm", "Friedensallee", "Stresemannstrasse","Finkenau"};
    private static final String[] ZIPCODES = {"20257", "22763", "22761", "22087", "21073", "20099", "20099", "22767", "22769", "22081"};
    private static final int MAXHOUSENUMBER = 120;
    private static final String AREA = "Hamburg";

    private static int nextCustomerId;

    public static int getNextCustomerId() {
        return nextCustomerId++;
    }

    public static List<Customer> generate(int number){
        Random rand = RandomUtil.getRandom();
        var firstNamesLength = FIRSTNAMES.length;
        var surNamesLength = SURNAMES.length;
        return new ArrayList<>(IntStream.range(1,number).mapToObj(i->
                new Customer(getNextCustomerId(),FIRSTNAMES[rand.nextInt(firstNamesLength)],
                        SURNAMES[rand.nextInt(surNamesLength)], createAddress(rand))).collect(Collectors.toSet()));
    }

    private static String createAddress(Random rand) {
        var streetsLength = STREETS.length;
        var index = rand.nextInt(streetsLength);
        return String.format("%s %s, %s %s", STREETS[index], rand.nextInt(MAXHOUSENUMBER)+1,ZIPCODES[index],AREA);
    }


}
