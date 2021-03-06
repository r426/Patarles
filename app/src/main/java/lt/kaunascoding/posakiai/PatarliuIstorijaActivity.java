package lt.kaunascoding.posakiai;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.ArrayAdapter;


import java.util.Collections;

import lt.kaunascoding.posakiai.controller.ItemArrayAdapter;
import lt.kaunascoding.posakiai.model.DarbasSuPatarlemis;

public class PatarliuIstorijaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patarliu_istorija);


        ItemArrayAdapter adapter = new ItemArrayAdapter(this,
                R.layout.activity_listview, DarbasSuPatarlemis.getInstance().skaitykBookmarks());


        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
    }


    public void carryOn(View view) {
//        Intent intent = new Intent(this, MainActivity.class);
//        startActivity(intent);
        DarbasSuPatarlemis.getInstance().saugokNaujaSarasa();
        this.finish();
    }
}
