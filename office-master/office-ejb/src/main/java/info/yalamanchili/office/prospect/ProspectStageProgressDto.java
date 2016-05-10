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
    protected long inprogress;
    protected long recruiting;
    protected long bench;
    protected long onhold;
    protected long closedwon;
    protected long closedlost;

    public String getAssociateName() {
        return associateName;
    }

    public void setAssociateName(String associateName) {
        this.associateName = associateName;
    }

    public long getInprogress() {
        return inprogress;
    }

    public void setInprogress(long inprogress) {
        this.inprogress = inprogress;
    }

    public long getRecruiting() {
        return recruiting;
    }

    public void setRecruiting(long recruiting) {
        this.recruiting = recruiting;
    }

    public long getBench() {
        return bench;
    }

    public void setBench(long bench) {
        this.bench = bench;
    }

    public long getOnhold() {
        return onhold;
    }

    public void setOnhold(long onhold) {
        this.onhold = onhold;
    }

    public long getClosedwon() {
        return closedwon;
    }

    public void setClosedwon(long closedwon) {
        this.closedwon = closedwon;
    }

    public long getClosedlost() {
        return closedlost;
    }

    public void setClosedlost(long closedlost) {
        this.closedlost = closedlost;
    }
    
}
