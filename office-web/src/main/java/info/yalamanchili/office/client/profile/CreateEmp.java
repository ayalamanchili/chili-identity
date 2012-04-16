package info.yalamanchili.office.client.profile;

import info.yalamanchili.gwt.fields.DateField;
import info.yalamanchili.gwt.fields.EnumField;
import info.yalamanchili.gwt.fields.StringField;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;

public class CreateEmp extends Composite implements ClickHandler {
    /*
     * Root panel for Create Employee
     */

    protected FlowPanel panel = new FlowPanel();
    /*
     * Fields
     */
    StringField firstNameF = new StringField("First Name", "firstName",
            "Employee", false, true);
    StringField middleNameF = new StringField("MiddleInitial", "middleInitial",
            "Employee", false, false);
    StringField lastNameF = new StringField("First Name", "firstName",
            "Employee", false, true);
    DateField dobF = new DateField("Date of Birth", "dateOfBirth", "Employee",
            false, false);
    String[] strs = {"MALE", "FEMALE"};
    EnumField sexF = new EnumField("Date of Birth", "dateOfBirth", "Employee",
            false, false, strs);
    DateField startDateF = new DateField("Start Date", "startDate", "Employee",
            false, false);
    StringField ssnF = new StringField("SSN", "ssn", "Employee", false, false);
    Button createB = new Button("Create Employee");

    public void CreateEmp() {
        initWidget(panel);
        addWidgets();
        addListeners();
    }

    protected void addWidgets() {
        panel.add(firstNameF);
        panel.add(middleNameF);
        panel.add(lastNameF);
        panel.add(dobF);
        panel.add(sexF);
        panel.add(startDateF);
        panel.add(ssnF);
        panel.add(createB);

    }

    protected void addListeners() {
        createB.addClickHandler(this);
    }

    @Override
    public void onClick(ClickEvent arg0) {
        doPost(getBaseURI(), getEmployee());
    }

    protected String getEmployee(){
        JSONObject obj= new JSONObject();
        obj.put("firstName", JSONParser.parseLenient(firstNameF.getText()));
        return obj.toString();
    }
    protected String getBaseURI() {
        return "http://localhost:8080/office/resources/employee";
    }

    public void doPost(String url, String postData) {
        RequestBuilder builder = new RequestBuilder(RequestBuilder.PUT, url);

        try {
            Request response = builder.sendRequest(postData, new RequestCallback() {

                public void onError(Request request, Throwable exception) {
                    Window.alert("Failed to send the request: " + exception.getMessage());
                }

                public void onResponseReceived(Request request, Response response) {
                    Window.alert("success");
                }
            });
        } catch (RequestException e) {
            Window.alert("Failed to send the request: " + e.getMessage());
        }
    }
}
