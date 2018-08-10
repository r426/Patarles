package lt.kaunascoding.posakiai.model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
    }

    public String gaukPuslapi() {
        return (index + 1) + " / " + sarasas.size();
    }

    public String gaukAnkstesne() {
        index--;
        if (index < 0) {
            index = sarasas.size() - 1;
        }
        return sarasas.get(index);
    }

    public String gaukVelesne() {
        index++;
        if (index == sarasas.size()) {
            String patarle = VisosPatarles.getInstance().getRandom();
            PatarliuIstorija.getInstance().pridekISarasa(patarle);
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

    public void bookmarkink() {

        String failoVardas = "bookmarks.txt";
        FileWriter writer = null;
        File file = new File(failoVardas);
        try {
            writer = new FileWriter(failoVardas, true);//faile neištrina buvusios informacijos

        } catch (IOException e) {
            e.printStackTrace();
        }
        String prefix = "";

        if (writer != null) {
            try {
                writer.write(prefix + sarasas.get(index));
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        prefix = "\n";

        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String sharink() {
        String string = "";
        return string;

    }

}
