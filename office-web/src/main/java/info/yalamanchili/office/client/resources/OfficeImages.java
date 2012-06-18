/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.resources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor.Path;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;

/**
 *
 * @author yalamanchili
 */
public interface OfficeImages extends ClientBundle {

    public static final OfficeImages INSTANCE = GWT.create(OfficeImages.class);

    @Source("images/default-image.gif")
    ImageResource defaultImage();
}
