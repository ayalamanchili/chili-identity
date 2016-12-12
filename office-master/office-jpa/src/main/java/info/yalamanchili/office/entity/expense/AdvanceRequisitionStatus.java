/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.entity.expense;

/**
 *
 * @author ayalamanchili
 */
public enum AdvanceRequisitionStatus {

    Open,
    //TODO remove pending
    Pending,
    Pending_Initial_Approval,
    Pending_CEO_Approval,
    Pending_Accounts_Payable_Dipatch,
    Approved,
    //TODO remove pending
    Completed,
    Rejected,
}
