import de.hawhh.informatik.bibliothek.Bibliothek;
import de.hawhh.informatik.bibliothek.Buch;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class BibliotheksTest {

    private static final String RESSOURCE_PREFIX = "classes/production/bai2_pm2/";
    private static final String BIBLIOTHEKS_DATEN = "bibliotheksDaten";

    private Bibliothek biblioBinaerGelesen = new Bibliothek("TINY LIB");
    private Bibliothek bibliothekLeer = new Bibliothek("Empty");
    private List<Buch> bbg = new ArrayList<>();

    private List<Buch> erschienenNach2016 = new ArrayList<>();
    private List<Buch> alleBuecher = new ArrayList<>();
    private Map<Integer,List<Buch>> gruppiertNachJahr = new HashMap<>();
    private Map<String,Buch> isbnTabelle = new HashMap<>();
    private List<Buch> sortiertNachAutorMitTitel = new ArrayList<>();

    private final String frankSchaetzing = "Frank Schaetzing";
    private final String jaronLanier = "Jaron Lanier";

    private Buch buch1;
    private Buch buch2;
    private Buch buch3;


    @Before
    public void fixture() throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(RESSOURCE_PREFIX + BIBLIOTHEKS_DATEN))) {
            biblioBinaerGelesen = (Bibliothek) ois.readObject();
            Set<Buch> buecherBinaerSet = new HashSet<>();

            for (Map.Entry<String, Set<Buch>> entry : biblioBinaerGelesen) {
                buecherBinaerSet.addAll(entry.getValue());
            }
            bbg = new ArrayList<>(buecherBinaerSet);

            buch1 = bbg.get(0);
            buch2 = bbg.get(1);
            buch3 = bbg.get(2);
            System.out.println("\n %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% \n");
            for (int i = 0; i < bbg.size(); i++) {
                System.out.println((i + 1) + ": " + bbg.get(i));
            }

            erschienenNach2016 = Arrays.asList(bbg.get(6), bbg.get(14), bbg.get(9), bbg.get(3), bbg.get(5), bbg.get(4), bbg.get(11));

            alleBuecher = Arrays.asList(bbg.get(7), bbg.get(8), bbg.get(13), bbg.get(1), bbg.get(10), bbg.get(12), bbg.get(0), bbg.get(2), bbg.get(6), bbg.get(14), bbg.get(9), bbg.get(3), bbg.get(5), bbg.get(4), bbg.get(11));

            gruppiertNachJahr.put(2017,Arrays.asList(bbg.get(6)));
            gruppiertNachJahr.put(2018,Arrays.asList(bbg.get(14),bbg.get(9),bbg.get(3),bbg.get(5),bbg.get(4),bbg.get(11)));
            gruppiertNachJahr.put(2006,Arrays.asList(bbg.get(7),bbg.get(8),bbg.get(13),bbg.get(1)));
            gruppiertNachJahr.put(2007,Arrays.asList(bbg.get(10)));
            gruppiertNachJahr.put(2014,Arrays.asList(bbg.get(12),bbg.get(0)));
            gruppiertNachJahr.put(2015,Arrays.asList(bbg.get(2)));

            isbnTabelle.put("978-1-250-19668-2",bbg.get(11));
            isbnTabelle.put("978-3-426-19938-1",bbg.get(12));
            isbnTabelle.put("3-442-45924-9",bbg.get(13));
            isbnTabelle.put("978-3-446-26038-2",bbg.get(14));
            isbnTabelle.put("978-3-8052-5106-8",bbg.get(4));
            isbnTabelle.put("3-89705-451-5",bbg.get(1));
            isbnTabelle.put("978-3-499-26736-9",bbg.get(0));
            isbnTabelle.put("3-0369-5155-5",bbg.get(7));
            isbnTabelle.put("9-783-442-75684-1",bbg.get(6));
            isbnTabelle.put("0-465-03282-6",bbg.get(8));
            isbnTabelle.put("9-783-442-75774-9",bbg.get(9));
            isbnTabelle.put("978-3-442-45879-0",bbg.get(10));
            isbnTabelle.put("978-3-550-08179-8",bbg.get(5));
            isbnTabelle.put("978-3-462-05084-4",bbg.get(3));
            isbnTabelle.put("978-3-8052-5094-8",bbg.get(2));

            sortiertNachAutorMitTitel = Arrays.asList(bbg.get(3), bbg.get(10), bbg.get(13), bbg.get(1), bbg.get(8), bbg.get(11), bbg.get(2), bbg.get(4), bbg.get(0), bbg.get(6), bbg.get(9), bbg.get(14), bbg.get(7), bbg.get(12), bbg.get(5));

        }
    }

  @Test
    public void testIterable(){
        for(Map.Entry<String,Set<Buch>> entry : biblioBinaerGelesen) {
            System.out.println("ITERABLE OK");
        }
    }

    @Test
    public void addElement(){
        assertEquals(0,StreamSupport.stream(bibliothekLeer.spliterator(),false).count());
        bibliothekLeer.add(buch1);
        assertNotNull(bibliothekLeer.get(buch1.getAutor()));
        assertEquals(1,StreamSupport.stream(bibliothekLeer.spliterator(),false).count());
        bibliothekLeer.add(buch2);
        bibliothekLeer.add(buch3);
        assertEquals(2,StreamSupport.stream(bibliothekLeer.spliterator(),false).count());
    }

    @Test
    public void addKeineDubletten() {
        bibliothekLeer.add(buch1);
        bibliothekLeer.add(buch1);
        assertEquals(1,bibliothekLeer.get(buch1.getAutor()).size());
    }

    @Test
    public void produktivsterAutor(){
        assertEquals(frankSchaetzing,biblioBinaerGelesen.produktivsterAutor());
    }

    @Test
    public void produktivsterAutorNeg() {
        assertNotEquals( jaronLanier,biblioBinaerGelesen.produktivsterAutor());
    }

    @Test
    public void produktivsterAutorGrenze() {
        assertEquals( null,bibliothekLeer.produktivsterAutor());
    }

    @Test
    public void erschienenNachPos(){
        List<Buch> lb = new ArrayList<>(biblioBinaerGelesen.erschienenNach(2016));
        Collections.sort(lb, new BuchComparator());
        assertEquals(erschienenNach2016, lb);
    }

    @Test
    public void erschienenNachNeg(){
        assertEquals(new HashSet<Buch>(), biblioBinaerGelesen.erschienenNach(2018));
        assertEquals(new HashSet<Buch>(), bibliothekLeer.erschienenNach(2034));
    }

    @Test
    public void alleBuecherPos(){
        List<Buch> lb = new ArrayList<>(biblioBinaerGelesen.alleBuecher());
        Collections.sort(lb, new BuchComparator());
        assertEquals(alleBuecher,lb);
    }

    @Test
    public void alleBuecherGrenzfall(){
        assertEquals(new HashSet<Buch>(),bibliothekLeer.alleBuecher());
    }


    @Test
    public void gruppiereNachJahrPos(){
        Map<Integer,List<Buch>> milb = biblioBinaerGelesen.gruppiereNachJahr();
        Map<Integer,List<Buch>> milbSorted = new HashMap<>();

        for (Map.Entry<Integer,List<Buch>> eib : milb.entrySet()) {
            List<Buch> lb = eib.getValue();
            Collections.sort(lb,new BuchComparator());
            milbSorted.put(eib.getKey(),lb);
        }
        assertEquals(gruppiertNachJahr, milbSorted);
    }

    @Test
    public void gruppiereNachJahrGrenzfall(){
        assertEquals(new HashMap<String,Buch>(),bibliothekLeer.gruppiereNachJahr());
    }

    @Test
    public void inIsbnTabellePos(){

        assertEquals(isbnTabelle,biblioBinaerGelesen.inIsbnTabelle());
    }

    @Test
    public void inIsbnTabelleGrenzfall(){
        assertEquals(new HashMap<String,Buch>(),bibliothekLeer.inIsbnTabelle());
    }

    @Test
    public void sortiereNachAutorMitTitelPos(){
        assertEquals(sortiertNachAutorMitTitel,biblioBinaerGelesen.sortiereNachAutorMitTitel());
    }

    @Test
    public void sortiereNachAutorMitTitelGrenzfall(){
        assertEquals(new ArrayList<Buch>(),bibliothekLeer.sortiereNachAutorMitTitel());
    }
}

class BuchComparator implements Comparator<Buch>{
    @Override
    public int compare(Buch b1,Buch b2) {
        if (b1.getErschienen()==b2.getErschienen()) {
           return  b1.getTitel().compareTo(b2.getTitel());
        }
        return b1.getErschienen()-b2.getErschienen();
    }
}
