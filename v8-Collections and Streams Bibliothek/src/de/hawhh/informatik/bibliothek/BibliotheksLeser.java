package de.hawhh.informatik.bibliothek;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BibliotheksLeser {
    private static final String RESSOURCE_PREFIX = "classes/production/bai2_pm2/";
    private static final String EMPTY_LINE = "\\s*";

    private String uri;

    public BibliotheksLeser(String resourceName) throws IOException {

        uri = Paths.get( RESSOURCE_PREFIX +resourceName).toAbsolutePath().toUri().toString();
    }

    public List<Buch> leseBuecher() throws IOException {

        Scanner sc = new Scanner(new URL(uri).openStream(), StandardCharsets.UTF_8);
        String delim = ",\\s*";

        // Buch.new("Das Feld","Robert Seethaler","978-3-446-26038-2",2018)
        Pattern buchPattern = Pattern.compile("Buch\\.new\\((.*?),(.*?),(.*?),(.*?)\\)\\s*",Pattern.DOTALL|Pattern.MULTILINE);
        List<Buch> buecher = new ArrayList<>();
        while (sc.hasNextLine() && sc.skip(EMPTY_LINE).hasNextLine()) {
            String next = sc.nextLine();
            Matcher buchMatcher = buchPattern.matcher(next);
            if (buchMatcher.find()) {
                buecher.add(new Buch(buchMatcher.group(2), buchMatcher.group(1), Integer.parseInt(buchMatcher.group(4)), buchMatcher.group(3)));
            }
        }
        sc.close();
        return buecher;
    }

}
