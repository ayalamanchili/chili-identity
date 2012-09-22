package info.yalamanchili.office;

import info.yalamanchili.office.profile.ReadAllEmployees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class OfficeWelcome extends ListActivity {

    public static String baseURL = "http://10.0.2.2:9080/office/resources/";
    public static String TAG = "office-android";
    private SimpleAdapter notes;
    public static Map<String, String> headers = new HashMap<String, String>();

    /**
     * Called when the activity is first created.
     *
     * @param savedInstanceState If the activity is being re-initialized after
     * previously being shut down then this Bundle contains the data it most
     * recently supplied in onSaveInstanceState(Bundle). <b>Note: Otherwise it
     * is null.</b>
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO externalize this to grab from xml.
        notes = new SimpleAdapter(this, getData(), R.layout.list_item,
                new String[]{"text"}, new int[]{R.id.list_item_view});
        setListAdapter(notes);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Map map = (Map) l.getItemAtPosition(position);
        Intent intent = (Intent) map.get("intent");
        startActivity(intent);
    }

    protected ArrayList<HashMap<String, Object>> getData() {
        ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();

        HashMap<String, Object> manufacturerMaintainence = new HashMap<String, Object>();
        manufacturerMaintainence.put("text", "My Office");
        Intent readAllEmployeesIntent = new Intent(this, ReadAllEmployees.class);
        manufacturerMaintainence.put("intent", readAllEmployeesIntent);
        list.add(manufacturerMaintainence);

        HashMap<String, Object> carMaintainence = new HashMap<String, Object>();
        carMaintainence.put("text", "Social");
        // Intent carIntent = new Intent(this, ReadAllCars.class);
        // carMaintainence.put("intent", carIntent);
        list.add(carMaintainence);

        HashMap<String, Object> truckMaintainence = new HashMap<String, Object>();
        truckMaintainence.put("text", "Profile");
        // Intent truckIntent = new Intent(this, ReadAllTrucks.class);
        // truckMaintainence.put("intent", truckIntent);
        list.add(truckMaintainence);

        return list;
    }

    public static Map<String, String> getHeaders() {
        return headers;
    }
}
