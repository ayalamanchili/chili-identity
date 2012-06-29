/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.social; 
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
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
/**
 *
 * @author ramana
 */
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
         TextArea taPostBody = new TextArea();
         taPostBody.setCharacterWidth(80);
         taPostBody.setVisibleLines(50);
         hp1.add(lblPost);
         hp1.add(taPostBody);
         vp.add(hp1);
         hp1 = new HorizontalPanel();
         Button btnSubmitPost = new Button("Submit");
         btnSubmitPost.addClickHandler(new ClickHandler() {
             @Override
             public void onClick(ClickEvent e) {
                 //Code for Adding new Post
                 
             }
         });
         hp1.add(btnSubmitPost);
         vp.add(hp1);
         rp.add(vp);
          
     }
    
    
}
