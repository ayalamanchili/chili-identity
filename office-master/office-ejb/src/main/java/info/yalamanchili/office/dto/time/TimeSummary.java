/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dto.time;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author anuyalamanchili
 */
@XmlRootElement
@XmlType
public class TimeSummary {

    protected BigDecimal quickBooksHours;
    protected BigDecimal adpHours;
    protected BigDecimal adjustmentHours;
    protected BigDecimal balanceHours;

    public BigDecimal getQuickBooksHours() {
        return quickBooksHours;
    }

    public void setQuickBooksHours(BigDecimal quickBooksHours) {
        this.quickBooksHours = quickBooksHours;
    }

    public BigDecimal getAdpHours() {
        return adpHours;
    }

    public void setAdpHours(BigDecimal adpHours) {
        this.adpHours = adpHours;
    }

    public BigDecimal getAdjustmentHours() {
        return adjustmentHours;
    }

    public void setAdjustmentHours(BigDecimal adjustmentHours) {
        this.adjustmentHours = adjustmentHours;
    }

    public BigDecimal getBalanceHours() {
        return balanceHours;
    }

    public void setBalanceHours(BigDecimal balanceHours) {
        this.balanceHours = balanceHours;
    }

    @Override
    public String toString() {
        return "TimeSummary{" + "quickBooksHours=" + quickBooksHours + ", adpHours=" + adpHours + ", balanceHours=" + balanceHours + '}';
    }
}
