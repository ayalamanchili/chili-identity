How To Onboard An Employee:
----
- [Login to Portal](../../office/forgot-password.html "Login").
- Only **Onboarding Manager** can initiate onboarding by navigating through **My Office** -> **OnBoarding** -> **Employee Onboarding**.
- Or **Prospects Manager** can initiate onboarding by navigating Through **My Office** -> **Prospects**
    - If a prospect status is **Closed Won**, Prospect Manager can initiate Onboarding By Clicking on **Onboarding InviteCode** link.
- **Onboarding Manager** will fill the required information of the candidate to whom he/she onboard and click on **Create**
- The onboarding record status should be **Pending_Initial_Document_Submission**.
- The candidate got an onboarding invitation mail with an invitation code link, by which he / she can fill their information in onboarding form, which will appear upon clicking on invitation link.
- The candidate even can upload the **I9** and **W4** forms while filling the onboarding form, which are received by the candidate in the invitation email.
- Once after complete the form and click on update, **Forms And Data Validation Task** will send to **OnBoarding Manager**. The status should be **Pending_Document_Verification**
- After forms and data validation task approval, if the onboarded employee is of type "Corporate Employee",
    - the status should be **Pending_Background_Check**
    - **Background Drug Screening Manager**  and **E-Verify Manager** will receive a manual task parallely.
    - Once after both teams completes their tasks, the status should be **Pending_Payroll_Registration**
- Else the status should be **Pending E-Verify**
    - E-Verify Manager will receive a task
    - After E-Verify manager approval, the status should be **Pending_Payroll_Registration**
- **Payroll Team** Will receives a manual task
- After the payroll task completion, if the onboarded employee is of type "Corporate Employee",
    - the status should be **Pending_Network_Team_Provisioning**
    - **Network Department** and **Onboarding Manager** will receive manual task parallely
    - After both tasks complete, the status should be "Complete" and an email will send to the employee with **userid** to login to the portal.
-Else the status should be **Pending_Employee_Orientation**
    - **Onboarding Manager** will get **Employee Orientation Task**
    - After  the task completion, the status should be **Complete**
    - Onboarded employee will get an email with **userid** to login to the portal

Employee onboarding Process:
------
![alt text](../../images/onboarding/employee-onboarding-img.png "Employee Onboarding")

Onboarding Manager Will Navigate To My Office -> OnBoarding -> Employee OnBoarding
------
![alt text](../../images/onboarding/initiate-onboarding-panel.png "Employee Onboarding")

Prospect Manager Will Navigate To My Office -> prospect 
----
![alt text](../../images/onboarding/initiate-onboarding-from-prospect.png "Employee Onboarding")

Fill The Required Fields And Initiate Onboarding:
------
![alt text](../../images/onboarding/fill-initiate-onboarding-panel.png "Employee Onboarding")
![alt text](../../images/onboarding/pending-initial-documents-submission.png "Employee Onboarding")

Invitation Email To The Employee:
------
![alt text](../../images/onboarding/onboarding-invitation-email.png "Employee Onboarding")

Click On the Invitation Link And Fill The Form:
------
![alt text](../../images/onboarding/fill-employee-onboarding-panel.png "Employee Onboarding")
![alt text](../../images/onboarding/thank-u-email.png "Employee Onboarding")

You Will get code expiration message, if you use the same link again:
------
![alt text](../../images/onboarding/invalid-invitation-code.png "Employee Onboarding")

Onboarding Manager Will Receive Forms And Data Validation Task:
------
![alt text](../../images/onboarding/forms-data-validation-task.png "Employee Onboarding")

If The Onboaded Employee is Corporate Employee
----
- **Parallel Process for Background And Drug Screening Manager And E-Verify Manager**
- ![alt text](../../images/onboarding/pending-background-check.png "Employee Onboarding")
- ![alt text](../../images/onboarding/parallel-process-background-and-everify.png "Employee Onboarding")
 
Else
----
- **E-Verify Manager Will receive a task**
- ![alt text](../../images/onboarding/pending-everify.png "Employee Onboarding")
- **Once EVerify Manager completes the task, Payroll Team Will get a manual task**

Pending Payroll Registration Task:
----
- ![alt text](../../images/onboarding/pending-payroll-registration.png "Employee Onboarding")

Payroll Team Will get a manual task:
------
![alt text](../../images/onboarding/payroll-registration-task.png "Employee Onboarding")

If The Onboaded Employee is Corporate Employee
----
- **Parallel Process For Network Department And Onboarding Manager**
- ![alt text](../../images/onboarding/pending-network-team-provisioning.png "Employee Onboarding")
- ![alt text](../../images/onboarding/network-dept-task.png "Employee Onboarding")
- ![alt text](../../images/onboarding/employee-orientation-task.png "Employee Onboarding")

Else
----
- **Onboarding Manager Will receive "Employee Orientation" Task**
- ![alt text](../../images/onboarding/pending-employee-orientation.png "Employee Onboarding")
- ![alt text](../../images/onboarding/orientation-task.png "Employee Onboarding")

Onboarding process Complete
-----
![alt text](../../images/onboarding/onboarding-complete.png "Employee Onboarding")

Email To the employee to login to the portal:
-----
![alt text](../../images/onboarding/userid-email.png "Employee Onboarding")