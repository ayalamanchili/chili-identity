/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.gwt;

import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.Style.Cursor;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.MouseMoveEvent;
import com.google.gwt.event.dom.client.MouseMoveHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import info.yalamanchili.office.client.resources.OfficeImages;
import java.util.logging.Logger;

/**
 *
 * @author ayalamanchili
 */
public class RatingWidget extends Composite implements ClickHandler {

    public static Logger logger = Logger.getLogger(RatingWidget.class.getName());

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(naCB) && naCB.getValue()) {
            setRating(0);
        }
    }

    static public interface Presenter {

        void onRatingChanged(int value);
    }

    private Integer rating;

    private Presenter presenter;

    private HTMLPanel container;
    FlowPanel panel = new FlowPanel();
    protected boolean required;
    protected boolean readOnly;
    protected Label naLabel = new Label("N/A");
    protected CheckBox naCB = new CheckBox();

    public RatingWidget(final int starCount, boolean required, boolean readOnly) {
        this.required = required;
        this.readOnly = readOnly;
        container = new HTMLPanel("");
        initWidget(container);
        getElement().getStyle().setDisplay(Display.INLINE_BLOCK);
        getElement().getStyle().setCursor(Cursor.POINTER);
        getElement().getStyle().setPadding(2, Unit.PX);
        naCB.addClickHandler(this);
        for (int index = 0; index < starCount; index++) {
            Image starImage = new Image();
            container.add(starImage);
        }
        if (!required) {
            panel.add(naLabel);
            naLabel.getElement().getStyle().setFloat(Style.Float.LEFT);
            panel.add(naCB);
            container.add(panel);
        }
        setRating(0);
        sinkEvents(Event.ONMOUSEMOVE | Event.ONMOUSEOUT | Event.ONMOUSEDOWN);
        addDomHandler(new MouseMoveHandler() {

            @Override
            public void onMouseMove(MouseMoveEvent event) {
                if (!naCB.getValue()) {
                    int rating = (int) Math.ceil((double) event.getRelativeX(getElement()) / getOffsetWidth() * starCount);
                    displayRating(rating);
                }
            }
        }, MouseMoveEvent.getType());
        addDomHandler(new MouseOutHandler() {

            @Override
            public void onMouseOut(MouseOutEvent event) {
                // revert to old value
                displayRating(RatingWidget.this.rating);
            }
        }, MouseOutEvent.getType());
        addDomHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                if (!naCB.getValue()) {
                    setRating((int) Math.ceil((double) event.getRelativeX(getElement()) / getOffsetWidth() * starCount));
                    if (presenter != null) {
                        presenter.onRatingChanged(RatingWidget.this.rating);
                    }
                }
            }
        }, ClickEvent.getType());
    }

    protected void displayRating(int rating) {
        int starCounter = 0;
        for (int index = 0; index < container.getWidgetCount(); index++) {
            Widget widget = container.getWidget(index);
            if (widget instanceof Image) {
                ((Image) widget).setResource(starCounter < rating ? OfficeImages.INSTANCE.star() : OfficeImages.INSTANCE.empty_star());
                widget.getElement().getStyle().setPadding(2, Unit.PX);
                starCounter++;
            }
        }
        removeErrorStyle();
    }

    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
        logger.info("rating" + rating);
        displayRating(rating);
    }

    public void setErrorStyle() {
        getElement().getStyle().setBackgroundColor("yellow");
    }

    public void removeErrorStyle() {
        getElement().getStyle().clearBackgroundColor();
    }
}
