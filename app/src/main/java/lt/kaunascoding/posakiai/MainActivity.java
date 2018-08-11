package lt.kaunascoding.posakiai;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import lt.kaunascoding.posakiai.model.DarbasSuPatarlemis;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DarbasSuPatarlemis.getInstance().setContext(this);
        eikPirmyn();

    }

    public void pirmasPuslapis(View view) {
        System.out.println("eiti i index 0 array liste");
        eikIPirma();
    }

    public void paskutinisPuslapis(View view) {
        System.out.println("eiti i paskutini array listo elementa");
        eikIPaskutini();
    }

    public void velesnisPuslapis(View view) {
        System.out.println("eiti i sekanti elementa array liste");
        eikPirmyn();
    }

    public void ankstesnisPuslapis(View view) {
        System.out.println("eiti i ankstesni elementa array liste");
        eikAtgal();
    }

    public void bookmarkink(View view){
        System.out.println("bookmarkina");
        bookmark();
    }

    public void sharink(View view){
        System.out.println("sharina");
        share();
    }


    public void eikPirmyn() {
        TextView laukas = (TextView) findViewById(R.id.laukas);
        TextView puslapis = (TextView) findViewById(R.id.puslapis);
        laukas.setText(DarbasSuPatarlemis.getInstance().gaukVelesne());
        puslapis.setText(DarbasSuPatarlemis.getInstance().gaukPuslapi());
    }

    public void eikAtgal() {
        TextView laukas = (TextView) findViewById(R.id.laukas);
        TextView puslapis = (TextView) findViewById(R.id.puslapis);
        laukas.setText(DarbasSuPatarlemis.getInstance().gaukAnkstesne());
        puslapis.setText(DarbasSuPatarlemis.getInstance().gaukPuslapi());
    }

    public void eikIPaskutini() {
        TextView laukas = (TextView) findViewById(R.id.laukas);
        TextView puslapis = (TextView) findViewById(R.id.puslapis);
        laukas.setText(DarbasSuPatarlemis.getInstance().gaukPaskutini());
        puslapis.setText(DarbasSuPatarlemis.getInstance().gaukPuslapi());
    }

    public void eikIPirma() {
        TextView laukas = (TextView) findViewById(R.id.laukas);
        TextView puslapis = (TextView) findViewById(R.id.puslapis);
        laukas.setText(DarbasSuPatarlemis.getInstance().gaukPirma());
        puslapis.setText(DarbasSuPatarlemis.getInstance().gaukPuslapi());
    }

    public void bookmark() {
        TextView laukas = (TextView) findViewById(R.id.laukas);
        TextView puslapis = (TextView) findViewById(R.id.puslapis);

        DarbasSuPatarlemis.getInstance().bookmarkink();
    }

    public void showBookmarks(View view) {
        Intent intent = new Intent(this, PatarliuIstorijaActivity.class);
        startActivity(intent);
    }

    public void share() {
        TextView laukas = (TextView) findViewById(R.id.laukas);
        TextView puslapis = (TextView) findViewById(R.id.puslapis);
        laukas.setText(DarbasSuPatarlemis.getInstance().sharink());
        puslapis.setText(DarbasSuPatarlemis.getInstance().gaukPuslapi());
    }
}
