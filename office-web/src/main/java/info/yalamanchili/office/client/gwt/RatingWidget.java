/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.gwt;

import com.google.gwt.core.client.GWT;
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
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Widget;
import info.yalamanchili.office.client.resources.OfficeImages;

/**
 *
 * @author ayalamanchili
 */
public class RatingWidget extends Composite {

    static public interface Presenter {

        void onRatingChanged(int value);
    }

    private Integer rating;

    private Presenter presenter;

    private HTMLPanel container;

    public RatingWidget() {
        this(5);
    }

    public RatingWidget(final int starCount) {
        container = new HTMLPanel("");
        initWidget(container);
        getElement().getStyle().setDisplay(Display.INLINE_BLOCK);
        getElement().getStyle().setCursor(Cursor.POINTER);
        getElement().getStyle().setPadding(2, Unit.PX);
        for (int index = 0; index < starCount; index++) {
            Image starImage = new Image();
            container.add(starImage);
        }
        setRating(0);
        sinkEvents(Event.ONMOUSEMOVE | Event.ONMOUSEOUT | Event.ONMOUSEDOWN);
        addDomHandler(new MouseMoveHandler() {

            @Override
            public void onMouseMove(MouseMoveEvent event) {
                int rating = (int) Math.ceil((double) event.getRelativeX(getElement()) / getOffsetWidth() * starCount);
                displayRating(rating);
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
                setRating((int) Math.ceil((double) event.getRelativeX(getElement()) / getOffsetWidth() * starCount));
                if (presenter != null) {
                    presenter.onRatingChanged(RatingWidget.this.rating);
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
    }

    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
        displayRating(rating);
    }

}
