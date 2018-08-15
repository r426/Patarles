package lt.kaunascoding.posakiai.model;

import android.content.Context;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class DarbasSuPatarlemis {

    private int index = -1;

    private ArrayList<String> sarasas;


    private static DarbasSuPatarlemis instance = null;

    private Context context;

    public static DarbasSuPatarlemis getInstance() {
        if (instance == null) {
            instance = new DarbasSuPatarlemis();
        }
        return instance;
    }

    private DarbasSuPatarlemis() {
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
            DarbasSuPatarlemis.getInstance().pridekISarasa(patarle);
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
        File file = new File(context.getFilesDir(), failoVardas);
        try {
            writer = new FileWriter(file, true);//faile neištrina buvusios informacijos

        } catch (IOException e) {
            e.printStackTrace();
        }
        String prefix = "\n";

        if (writer != null) {
            try {
                writer.write(sarasas.get(index) + prefix);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
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

    public void setContext(Context context) {
        this.context = context;
    }

    ArrayList<String> bookmarkSarasas = null;

    public ArrayList skaitykBookmarks() {

        bookmarkSarasas = new ArrayList<>();
        String failoVardas = "bookmarks.txt";
        File file = new File(context.getFilesDir(), failoVardas);
        try {
            FileReader reader = new FileReader(file);
            Scanner sc = new Scanner(reader);

            while (sc.hasNext()) {
                String eilute = sc.nextLine();
                System.out.println(eilute);
                bookmarkSarasas.add(eilute);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Collections.reverse(bookmarkSarasas);
        return bookmarkSarasas;

    }

    public ArrayList<String> getBookmarks() {
        return bookmarkSarasas;
    }

    public void saugokNaujaSarasa() {

        String failoVardas = "bookmarks.txt";
        FileWriter writer = null;
        File file = new File(context.getFilesDir(), failoVardas);
        try {
            writer = new FileWriter(file, false);//faile ištrina buvusią informaciją

        } catch (IOException e) {
            e.printStackTrace();
        }
        Collections.reverse(bookmarkSarasas);
        for (int index = 0; index < bookmarkSarasas.size(); index++) {
            String prefix = "\n";
            if (writer != null) {
                try {
                    writer.write(bookmarkSarasas.get(index) + prefix);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
