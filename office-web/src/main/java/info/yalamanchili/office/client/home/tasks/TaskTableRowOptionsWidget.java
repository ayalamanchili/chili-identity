/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.home.tasks;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import info.chili.gwt.widgets.ClickableLink;
import info.chili.gwt.crud.GenericTableRowOptionsWidget;

/**
 *
 * @author anuyalamanchili
 */
public class TaskTableRowOptionsWidget extends GenericTableRowOptionsWidget implements MouseOverHandler {

    ClickableLink claimLink = new ClickableLink("claim");
    ClickableLink resolveLink = new ClickableLink("resolve");
    ClickableLink completeLink = new ClickableLink("complete");

    public enum OptionsType {

        CLAIM, RESOLVE, COMPLETE, CLAIM_RESOLVE, CLAIM_RESOLVE_COMPLETE, CLAIM_COMPLETE, RESOLVE_COMPLETE
    };
    protected OptionsType type;

    public TaskTableRowOptionsWidget(OptionsType type, String id) {
        super(id);
        this.type = type;
        addWidgets();
        configure();
        addListeners();
    }

    protected void addListeners() {
        claimLink.addMouseOverHandler(this);
        resolveLink.addMouseOverHandler(this);
        completeLink.addMouseOverHandler(this);
    }

    protected void initListeners(ClickHandler handler) {
        claimLink.addClickHandler(handler);
        resolveLink.addClickHandler(handler);
        completeLink.addClickHandler(handler);

    }

    protected void configure() {
        claimLink.addStyleName("readL");
        resolveLink.addStyleName("updateLink");
        completeLink.addStyleName("deleteLink");

    }

    protected void addWidgets() {
        if (OptionsType.CLAIM.equals(type)) {
            panel.add(claimLink);
        }
        if (OptionsType.RESOLVE.equals(type)) {
            panel.add(resolveLink);
        }
        if (OptionsType.COMPLETE.equals(type)) {
            panel.add(completeLink);
        }
        if (OptionsType.CLAIM_RESOLVE.equals(type)) {
            panel.add(claimLink);
            panel.add(resolveLink);
        }
        if (OptionsType.CLAIM_RESOLVE_COMPLETE.equals(type)) {
            panel.add(claimLink);
            panel.add(resolveLink);
            panel.add(completeLink);
        }
        if (OptionsType.CLAIM_COMPLETE.equals(type)) {
            panel.add(claimLink);
            panel.add(completeLink);
        }
        if (OptionsType.RESOLVE_COMPLETE.equals(type)) {
            panel.add(resolveLink);
            panel.add(completeLink);
        }
    }

    public ClickableLink getClaimLink() {
        return claimLink;
    }

    public ClickableLink getResolveLink() {
        return resolveLink;
    }

    public ClickableLink getCompleteLink() {
        return completeLink;
    }

    @Override
    public void onMouseOver(MouseOverEvent event) {
        if (event.getSource().equals(claimLink)) {
        }
        if (event.getSource().equals(resolveLink)) {
        }
        if (event.getSource().equals(completeLink)) {
        }
    }
}
