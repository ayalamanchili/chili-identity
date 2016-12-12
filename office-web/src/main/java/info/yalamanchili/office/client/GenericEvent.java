/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client;

import com.google.gwt.event.shared.GwtEvent;

/**
 *
 * @author ayalamanchili
 */
//AppUtils.EVENT_BUS.fireEvent(new AuthenticationEvent());
public class GenericEvent extends GwtEvent<GenericEventHandler> {

    public static Type<GenericEventHandler> TYPE = new Type<>();

    @Override
    public Type<GenericEventHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(GenericEventHandler handler) {
        handler.onEvent(this);
    }

}
