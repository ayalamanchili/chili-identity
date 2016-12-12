/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
package info.yalamanchili.office.client.resources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;

public interface OfficeResources extends ClientBundle {

    public static final OfficeResources INSTANCE = GWT
            .create(OfficeResources.class);
}
