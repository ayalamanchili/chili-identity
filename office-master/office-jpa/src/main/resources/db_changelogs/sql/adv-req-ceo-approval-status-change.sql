--
-- System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
--

update AdvanceRequisition set status='Pending_CEO_Approval' where status='Pending_Final_Approval';
update AdvanceRequisition_aud set status='Pending_CEO_Approval' where status='Pending_Final_Approval';