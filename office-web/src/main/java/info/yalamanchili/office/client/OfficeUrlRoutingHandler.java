/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import java.util.logging.Logger;

/**
 *
 * @author phani
 */
public class OfficeUrlRoutingHandler implements ValueChangeHandler<String> {

    public static Logger logger = Logger.getLogger(OfficeUrlRoutingHandler.class.getName());

    @Override
    public void onValueChange(ValueChangeEvent<String> event) {
        String urltoken = event.getValue();
        logger.info("------------urltoken:" + urltoken + ":");
        if (urltoken.contains("mytasks")) {
            TabPanel.instance().selectHomeTab();

        }
    }

}
