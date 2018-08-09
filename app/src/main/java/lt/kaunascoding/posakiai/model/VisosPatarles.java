package lt.kaunascoding.posakiai.model;

import java.util.ArrayList;

public class VisosPatarles {

    private ArrayList<String> sarasas;


    private static VisosPatarles instance = null;

    public static VisosPatarles getInstance() {
        if (instance == null) {
            instance = new VisosPatarles();
        }
        return instance;
    }

    private VisosPatarles() {
        sarasas = new ArrayList<>();
        sarasas.add("...kaip ant juoko");
        sarasas.add(" žodis – ne darbas");
        sarasas.add(" žodis tvirtas – darbais paspirtas");
        sarasas.add("žmogaus vertė darbu matuojama");
        sarasas.add("yra darbo, yra ir naudos");
    }

    public String getRandom(){
        String result = "";

        int i =(int) Math.floor(Math.random()*sarasas.size());

        result = sarasas.get(i);
        return result;
    }
}

