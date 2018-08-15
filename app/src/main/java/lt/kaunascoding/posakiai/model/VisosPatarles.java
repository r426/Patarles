package lt.kaunascoding.posakiai.model;

import java.util.ArrayList;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import lt.kaunascoding.posakiai.MainActivity;


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


//        sarasas.add("žodis – ne darbas");
//        sarasas.add("žodis tvirtas – darbais paspirtas");
//        sarasas.add("žmogaus vertė darbu matuojama");
//        sarasas.add("yra darbo, yra ir naudos");
//        sarasas.add("veršenikę į darbą davė");
//        sarasas.add("žiema – keliauninkas, pavasaris – gėlininkas, vasara – dainininkas, ruduo – darbininkas");
//        sarasas.add("vesdamas nežiūrėk ant mergos gražumo, tik žiūrėk ant jos darbštumo ir gerumo");
    }

    public String getRandom() {
        String result = "";
        int i = (int) Math.floor(Math.random() * sarasas.size());
        result = sarasas.get(i);
        return result;
    }

    private RequestQueue loadingQue;

    public void setLoadingQue(RequestQueue loadingQue) {
        this.loadingQue = loadingQue;
        JsonArrayRequest arrReq = new JsonArrayRequest(Request.Method.GET, "https://api.myjson.com/bins/1dbohg",
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        // Check the length of our response (to see if the user has any repos)
                        if (response.length() > 0) {
                            // The user does have repos, so let's loop through them all.
                            for (int i = 0; i < response.length(); i++) {
                                try {
                                    JSONObject jsonObject = response.getJSONObject(i);
                                    System.out.println(jsonObject.getString("text"));
                                    sarasas.add(jsonObject.getString("text"));
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                        MainActivity.getInstance().eikPirmyn();
                    }

                },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        System.out.println(error);
                    }
                }
        );
        // Add the request we just defined to our request queue.
        // The request queue will automatically handle the request as soon as it can.
        loadingQue.add(arrReq);

    }
}

