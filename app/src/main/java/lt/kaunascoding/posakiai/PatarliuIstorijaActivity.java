package lt.kaunascoding.posakiai;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import lt.kaunascoding.posakiai.model.DarbasSuPatarlemis;

public class PatarliuIstorijaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patarliu_istorija);
        ListView list_view = (ListView) findViewById(R.id.list_view);


        DarbasSuPatarlemis.getInstance().skaitykBookmarks();
    }


    public void carryOn(View view) {
//        Intent intent = new Intent(this, MainActivity.class);
//        startActivity(intent);
        this.finish();
    }
}
