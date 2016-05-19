/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.address;

import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import info.chili.gwt.fields.EnumField;
import info.chili.gwt.fields.StringField;
import static info.yalamanchili.office.client.OfficeWelcome.logger;

/**
 *
 * @author Srinivas
 */
public class AddressByZipService {

    public static void getZipInformationService(String zipCode, StringField cityField, EnumField statesF, EnumField countriesF) {
        String zipCodeServiceUrl = "https://api.zippopotam.us/us/" + zipCode;
        RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, zipCodeServiceUrl);
        try {
            builder.sendRequest(null, new RequestCallback() {

                @Override
                public void onResponseReceived(com.google.gwt.http.client.Request request, com.google.gwt.http.client.Response response) {
                    if (response.getText().length() > 2) {
                        JSONObject resObj = (JSONObject) JSONParser.parse(response.getText());
                        String country = resObj.get("country abbreviation").isString().stringValue();

                        JSONObject placeObj = resObj.get("places").isArray().get(0).isObject();
                        String state = placeObj.get("state abbreviation").isString().stringValue();

                        String city = placeObj.get("place name").isString().stringValue();
                        if (country.equals("US")) {
                            countriesF.selectValue("USA");
                        }
                        statesF.selectValue(state);
                        cityField.setValue(city);
                    }
                    else {
                        cityField.setValue(null);
                        countriesF.setSelectedIndex(0);
                        statesF.setSelectedIndex(0);
                    }
                }

                @Override
                public void onError(com.google.gwt.http.client.Request request, Throwable exception) {
                    logger.info(exception.getLocalizedMessage());
                }
            });
        } catch (RequestException e) {
            logger.info(e.getLocalizedMessage());
        }
    }
}
