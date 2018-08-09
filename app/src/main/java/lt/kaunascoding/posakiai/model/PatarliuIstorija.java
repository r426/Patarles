package lt.kaunascoding.posakiai.model;

import java.util.ArrayList;

public class PatarliuIstorija {

    private int index = -1;

    private ArrayList<String> sarasas;


    private static PatarliuIstorija instance = null;

    public static PatarliuIstorija getInstance() {
        if (instance == null) {
            instance = new PatarliuIstorija();
        }
        return instance;
    }

    private PatarliuIstorija() {
        sarasas = new ArrayList<>();

    }

    public void pridekISarasa(String patarle) {
        sarasas.add(patarle);
        index++;

    }

    public String gaukPuslapi() {

        return (index + 1) + "/" + sarasas.size();
    }

    public String gaukAnkstesne() {
        index--;
        if (index < 0) {
            index = sarasas.size() - 1;
        }
        return sarasas.get(index);
    }

    public String gaukPirma() {
        index = 0;
        return sarasas.get(index);
    }

    public String gaukPaskutini() {
        index = sarasas.size() - 1;
        return sarasas.get(index);
    }

}
