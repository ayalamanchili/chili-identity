package info.yalamanchili.office.client.gwt;

import info.yalamanchili.gwt.composite.ALComposite;
import info.yalamanchili.office.client.OfficeWelcome;

import java.util.logging.Logger;

import com.google.gwt.http.client.URL;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;

//TODO add File/ImageUploadPanel support for this (merge)
public class ImageField extends ALComposite {
	private static Logger logger = Logger.getLogger(ImageField.class.getName());

	FlowPanel panel = new FlowPanel();
	Label label = new Label();
	Image image = new Image();

	public ImageField(String labelName, String url, int width, int height, boolean showLabel) {
		label.setText(labelName);
		label.setVisible(showLabel);
		setPixelSize(width, height);
		logger.info(URL.decode(OfficeWelcome.constants.file_directory_path() + url));
		image.setUrl(URL.decode(OfficeWelcome.constants.file_directory_path() + url));
		init(panel);
	}

	public void setPixelSize(int width, int height) {
		image.setPixelSize(width, height);
	}

	public void setImage(String url) {
		image.setUrl(OfficeWelcome.constants.file_directory_path() + url);
	}

	@Override
	protected void addListeners() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void configure() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void addWidgets() {
		panel.add(label);
		panel.add(image);
	}
}
