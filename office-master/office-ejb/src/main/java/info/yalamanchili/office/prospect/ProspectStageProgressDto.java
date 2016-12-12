/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.prospect;

import java.io.Serializable;

/**
 *
 * @author radhika.mukkala
 */
public class ProspectStageProgressDto implements Serializable{
    protected String associateName;
    protected String inprogress;
    protected String recruiting;
    protected String bench;
    protected String onhold;
    protected String closedwon;
    protected String closedlost;

    public String getAssociateName() {
        return associateName;
    }

    public void setAssociateName(String associateName) {
        this.associateName = associateName;
    }

    public String getInprogress() {
        return inprogress;
    }

    public void setInprogress(String inprogress) {
        this.inprogress = inprogress;
    }

    public String getRecruiting() {
        return recruiting;
    }

    public void setRecruiting(String recruiting) {
        this.recruiting = recruiting;
    }

    public String getBench() {
        return bench;
    }

    public void setBench(String bench) {
        this.bench = bench;
    }

    public String getOnhold() {
        return onhold;
    }

    public void setOnhold(String onhold) {
        this.onhold = onhold;
    }

    public String getClosedwon() {
        return closedwon;
    }

    public void setClosedwon(String closedwon) {
        this.closedwon = closedwon;
    }

    public String getClosedlost() {
        return closedlost;
    }

    public void setClosedlost(String closedlost) {
        this.closedlost = closedlost;
    }
    
}
