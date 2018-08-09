package lt.kaunascoding.posakiai;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import lt.kaunascoding.posakiai.model.PatarliuIstorija;
import lt.kaunascoding.posakiai.model.VisosPatarles;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rodykSekancia();

    }

    public void pirmasPuslapis(View view) {
        System.out.println("eiti i index 0 array liste");
        eikIPirma();
    }

    public void ankstesnisPuslapis(View view) {
        System.out.println("eiti i ankstesni elementa array liste");
        eikAtgal();
    }

    public void velesnisPuslapis(View view) {
        System.out.println("eiti i sekanti elementa array liste");
        rodykSekancia();
    }

    public void paskutinisPuslapis(View view) {
        System.out.println("eiti i paskutini array listo elementa");
        eikIPaskutini();
    }

    public void rodykSekancia(){
        TextView laukas = (TextView) findViewById(R.id.laukas);
        TextView puslapis = (TextView) findViewById(R.id.puslapis);
        String patarle = VisosPatarles.getInstance().getRandom();
        PatarliuIstorija.getInstance().pridekISarasa(patarle);
        laukas.setText(patarle);
        puslapis.setText(PatarliuIstorija.getInstance().gaukPuslapi());
    }

    public void eikAtgal(){
        TextView laukas = (TextView) findViewById(R.id.laukas);
        TextView puslapis = (TextView) findViewById(R.id.puslapis);
        laukas.setText(PatarliuIstorija.getInstance().gaukAnkstesne());
        puslapis.setText(PatarliuIstorija.getInstance().gaukPuslapi());

    }

    public void eikIPaskutini(){
        TextView laukas = (TextView) findViewById(R.id.laukas);
        TextView puslapis = (TextView) findViewById(R.id.puslapis);
        laukas.setText(PatarliuIstorija.getInstance().gaukPaskutini());
        puslapis.setText(PatarliuIstorija.getInstance().gaukPuslapi());

    }

    public void eikIPirma(){
        TextView laukas = (TextView) findViewById(R.id.laukas);
        TextView puslapis = (TextView) findViewById(R.id.puslapis);
        laukas.setText(PatarliuIstorija.getInstance().gaukPirma());
        puslapis.setText(PatarliuIstorija.getInstance().gaukPuslapi());

    }

}
