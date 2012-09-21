package info.yalamanchili.office.profile;

import info.yalamanchili.office.OfficeWelcome;
import info.yalamanchili.office.R;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import info.chili.android.http.AsyncHttpGet;
import info.chili.android.widgets.ReadAllPageBar;

public class ReadAllEmployees extends Activity implements OnItemClickListener,
		OnClickListener {
	private Integer pageOffSet = 0;
	private ArrayList<JSONObject> cars = new ArrayList<JSONObject>();
	private ListView carListView;
	private Button create;
	private Button nextPage;
	private Button previousPage;
	private EmployeeAdapter employeeAdapter;

	@Override
	// TODO move common logic to generic class ReadAllEntity
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.entity_readall);
		customizeTitle();
		getControls();
		setListeners();
		int resID = R.layout.readall_list;
		employeeAdapter = new EmployeeAdapter(ReadAllEmployees.this, resID, cars);
		carListView.setAdapter(employeeAdapter);
	}

	public void setListeners() {
		create.setOnClickListener(this);
		nextPage.setOnClickListener(this);
		previousPage.setOnClickListener(this);
		carListView.setOnItemClickListener(this);
	}

	public void getControls() {
		ReadAllPageBar pageBar = (ReadAllPageBar) findViewById(R.id.read_all_page_bar);
		create = pageBar.getCreateButton();
		nextPage = pageBar.getNextPageButton();
		previousPage = pageBar.getPreviousPageButton();
		carListView = (ListView) findViewById(R.id.readall_listview);
	}

	public void customizeTitle() {
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE,
				R.layout.office_title_bar);
		TextView mytitletext = (TextView) findViewById(R.id.office_title_text);
		mytitletext.setText("Read All Cars Panel");
	}

	public void onItemClick(AdapterView<?> parent, View arg1, int position,
			long id) {
		JSONObject employee = (JSONObject) parent.getItemAtPosition(position);
//		Intent intent = new Intent(this, ReadCar.class);
//		try {
//			intent.putExtra("id", car.getLong("id"));
//		} catch (JSONException e) {
//			// TODO
//			e.printStackTrace();
//		}
//		startActivity(intent);
	}

	public String getReadALLURL(Integer pageOffSet, Integer pageSize) {
		return OfficeWelcome.baseURL + "employee/0/10";
	}

	protected void loadNextPage() {
		pageOffSet = pageOffSet + new Integer(getString(R.string.page_size));
		loadPage(pageOffSet, new Integer(getString(R.string.page_size)));
	}

	protected void loadPreviousPage() {
		if (pageOffSet >= new Integer(getString(R.string.page_size))) {
			pageOffSet = pageOffSet
					- new Integer(getString(R.string.page_size));
			loadPage(pageOffSet, new Integer(getString(R.string.page_size)));
		}
	}

	protected void loadPage(int pageOffSet, int pageSize) {
		new AsyncHttpGet(this) {
			@Override
			protected void onResponse(String result) {
				Log.i(ReadAllEmployees.class.getName(),result);
				try {
					JSONArray employees = new JSONArray(result);
					int i = 0;
					while (!employees.isNull(i)) {
						JSONObject car = (JSONObject) employees
								.getJSONObject(i).get("employee");
						employeeAdapter.add(car);
						i++;
					}
				} catch (Exception e) {
					// TODO navigate back notify user?
					throw new RuntimeException(e);
				}
			}
		}.execute(getReadALLURL(pageOffSet, pageSize));
	}

	@Override
	public void onStart() {
		super.onStart();
		Log.d(OfficeWelcome.TAG, "in start");
		main();
	}

	public void main() {
		employeeAdapter.clear();
		loadPage(0, new Integer(getString(R.string.page_size)));
	}

	public void onClick(View arg0) {
		// TODO support add ....
		if (arg0.getId() == create.getId()) {
//			Intent createIntent = new Intent(this, CreateCar.class);
//			startActivity(createIntent);
		}
		if (arg0.getId() == nextPage.getId()) {
			loadNextPage();
		}
		if (arg0.getId() == previousPage.getId()) {
			loadPreviousPage();
		}
	}

	public class EmployeeAdapter extends ArrayAdapter<JSONObject> {
		int listItemTextView;

		public EmployeeAdapter(Context context, int textViewResourceId,
				List<JSONObject> objects) {
			super(context, textViewResourceId, objects);
			listItemTextView = textViewResourceId;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			LinearLayout todoView;
			JSONObject engine = getItem(position);
			if (convertView == null) {
				todoView = new LinearLayout(getContext());
				String inflater = Context.LAYOUT_INFLATER_SERVICE;
				LayoutInflater vi = (LayoutInflater) getContext()
						.getSystemService(inflater);
				vi.inflate(listItemTextView, todoView, true);
			} else {
				todoView = (LinearLayout) convertView;
			}
			TextView textViewOne = (TextView) todoView
					.findViewById(R.id.readall_list_item_one);
			textViewOne.setText(engine.toString());
			return todoView;
		}
	}
}
