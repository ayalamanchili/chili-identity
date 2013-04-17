/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.profile;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import info.yalamanchili.office.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author anuyalamanchili
 */
public class MyOfficeTab extends ListActivity {

    private SimpleAdapter listAdapter;
    public static Map<String, String> headers = new HashMap<String, String>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO externalize this to grab from xml.
        listAdapter = new SimpleAdapter(this, getData(), R.layout.list_item,
                new String[]{"text"}, new int[]{R.id.list_item_view});
        setListAdapter(listAdapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Map map = (Map) l.getItemAtPosition(position);
        Intent intent = (Intent) map.get("intent");
        startActivity(intent);
    }

    protected ArrayList<HashMap<String, Object>> getData() {
        ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();

        HashMap<String, Object> employeesMaintainence = new HashMap<String, Object>();
        employeesMaintainence.put("text", "Employees");
        Intent readAllEmployeesIntent = new Intent(this, ReadAllEmployees.class);
        employeesMaintainence.put("intent", readAllEmployeesIntent);
        list.add(employeesMaintainence);

        HashMap<String, Object> skillsMaintainence = new HashMap<String, Object>();
        employeesMaintainence.put("text", "Skills");
//        Intent readAllEmployeesIntent = new Intent(this, ReadAllEmployees.class);
//        skillsMaintainence.put("intent", readAllEmployeesIntent);
        list.add(skillsMaintainence);

        HashMap<String, Object> certificationsMaintainence = new HashMap<String, Object>();
        certificationsMaintainence.put("text", "Certifications");
//        Intent readAllEmployeesIntent = new Intent(this, ReadAllEmployees.class);
//        certificationsMaintainence.put("intent", readAllEmployeesIntent);
        list.add(certificationsMaintainence);

        return list;
    }
}
