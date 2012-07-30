package info.yalamanchili.office.client.resources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;

public interface OfficeResources extends ClientBundle {

    public static final OfficeResources INSTANCE = GWT
            .create(OfficeResources.class);

    @Source("office.css")
    public CssResource officeCss();
}
