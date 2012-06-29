/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.social; 
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import info.yalamanchili.gwt.composite.ALComposite;
import info.yalamanchili.office.client.OfficeWelcome;
import java.util.Calendar;
 
/**
 *
 * @author ramana
 */
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.yalamanchili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.profile.employee.TreeEmployeePanel;
import info.yalamanchili.office.client.rpc.HttpService.HttpServiceAsync;
import java.util.Date;
public class CreatePost extends  Composite {
    
     public CreatePost()
     {
         RootPanel rp = RootPanel.get();
         initWidget(rp);
         VerticalPanel vp = new VerticalPanel();
         Label lbHeading = new Label("Create New Post");
         vp.add(lbHeading);
         HorizontalPanel hp1 = new HorizontalPanel();
         Label lblTitle = new Label("Title");
         TextBox txtTitle = new TextBox();
         hp1.add(lblTitle);
         hp1.add(txtTitle);
         vp.add(hp1);
         hp1 = new HorizontalPanel();
         Label lblPost = new Label("Body");
        final TextArea taContent = new TextArea();
         taContent.setCharacterWidth(80);
         taContent.setVisibleLines(50);
         hp1.add(lblPost);
         hp1.add(taContent);
         vp.add(hp1);
         hp1 = new HorizontalPanel();
         Button btnSubmitPost = new Button("Submit");
         btnSubmitPost.addClickHandler(new ClickHandler() {
             @Override
             public void onClick(ClickEvent e) {
                 //Code for Adding new Post
                JSONObject entity = new JSONObject();
                
                 entity.put("postContent", new JSONString(taContent.getText()));
                 entity.put("postTimeStamp", new JSONString(new Date().toString())  );
                 entity.put("Employee", OfficeWelcome.instance().employee);
                 entity.put("company", null );
                 HttpServiceAsync.instance().doPut(getURI(), entity.toString(), OfficeWelcome.instance().getHeaders(), true,
                new AsyncCallback<String>() {

                    @Override
                    public void onFailure(Throwable arg0) {
                        //handleErrorResponse(arg0);

                    }

                    @Override
                    public void onSuccess(String arg0) {
                        postCreateSuccess(arg0);
                    }
                });
             }
         });
         hp1.add(btnSubmitPost);
         vp.add(hp1);
         rp.add(vp);
          
     }
     
   
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "social/createPost";
    }
    
    protected void postCreateSuccess(String result) {
        new ResponseStatusWidget().show("successfully  created a post");
        //TabPanel.instance().myOfficePanel.entityPanel.clear();
        //TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllPhonesPanel(TreeEmployeePanel.instance().getEntityId()));
       // TabPanel.instance().myOfficePanel.entityPanel.add(new PhoneOptionsPanel());

    }
}
