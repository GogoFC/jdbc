package se.lexicon;

import static se.lexicon.model.JDBC.addUser;
import static se.lexicon.model.JDBC.summary;

public class Main {
    public static void main(String[] args) {
        addUser();
        summary();

    }
}