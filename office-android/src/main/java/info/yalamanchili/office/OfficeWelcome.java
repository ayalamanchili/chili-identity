package info.yalamanchili.office;

import info.yalamanchili.office.profile.ReadAllEmployees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class OfficeWelcome extends ListActivity {

    private SimpleAdapter notes;

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

        HashMap<String, Object> homeMaintainence = new HashMap<String, Object>();
        homeMaintainence.put("text", "Home");
        // Intent carIntent = new Intent(this, ReadAllCars.class);
        // carMaintainence.put("intent", carIntent);
        list.add(homeMaintainence);

        HashMap<String, Object> socialMaintainence = new HashMap<String, Object>();
        socialMaintainence.put("text", "Social");
        // Intent carIntent = new Intent(this, ReadAllCars.class);
        // carMaintainence.put("intent", carIntent);
        list.add(socialMaintainence);

        HashMap<String, Object> manufacturerMaintainence = new HashMap<String, Object>();
        manufacturerMaintainence.put("text", "My Office");
        Intent readAllEmployeesIntent = new Intent(this, ReadAllEmployees.class);
        manufacturerMaintainence.put("intent", readAllEmployeesIntent);
        list.add(manufacturerMaintainence);

        HashMap<String, Object> timeMaintainence = new HashMap<String, Object>();
        timeMaintainence.put("text", "Time");
        // Intent carIntent = new Intent(this, ReadAllCars.class);
        // carMaintainence.put("intent", carIntent);
        list.add(timeMaintainence);

        HashMap<String, Object> driveMaintainence = new HashMap<String, Object>();
        driveMaintainence.put("text", "Drive");
        // Intent carIntent = new Intent(this, ReadAllCars.class);
        // carMaintainence.put("intent", carIntent);
        list.add(driveMaintainence);

        HashMap<String, Object> profileMaintainence = new HashMap<String, Object>();
        profileMaintainence.put("text", "Profile");
        // Intent truckIntent = new Intent(this, ReadAllTrucks.class);
        // truckMaintainence.put("intent", truckIntent);
        list.add(profileMaintainence);

        HashMap<String, Object> adminMaintainence = new HashMap<String, Object>();
        adminMaintainence.put("text", "Admin");
        // Intent truckIntent = new Intent(this, ReadAllTrucks.class);
        // truckMaintainence.put("intent", truckIntent);
        list.add(adminMaintainence);

        return list;
    }
}
