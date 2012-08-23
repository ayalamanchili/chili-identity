package info.yalamanchili.office.client;

import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.Window;
import info.yalamanchili.gwt.utils.JSONUtils;
import info.yalamanchili.gwt.widgets.AbstractStatusPanel;
import info.yalamanchili.office.client.resources.OfficeImages;

import java.util.logging.Logger;

//TODO convert to UIbinder
public class StatusPanel extends AbstractStatusPanel {

    private static Logger logger = Logger.getLogger(StatusPanel.class.getName());
    private static StatusPanel instance;

    public static StatusPanel instance() {
        return instance;
    }

    public StatusPanel() {
        instance = this;
        userLink.ensureDebugId("welcomeL");
        super.setLogo(OfficeImages.INSTANCE.logo());
    }

    @Override
    protected void loginClicked() {
    }

    @Override
    public void logoutSuccessfull() {
        statusBar.remove(logoutLink);
        statusBar.setWidget(1, 2, loginLink);

    }

    public void loginSuccessfull() {
        statusBar.remove(loginLink);
        statusBar.setWidget(1, 2, logoutLink);

    }

    @Override
    protected void logoutClicked() {
        Window.Location.reload();
    }

    @Override
    protected void createUserClicked() {
    }

    /**
     * @generated
     */
    @Override
    protected void setUser() {
        this.userLink.setText("Welcome " + JSONUtils.toString(OfficeWelcome.instance().employee, "firstName"));
        loginSuccessfull();
    }
}
