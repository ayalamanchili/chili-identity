Leave request Process
-----

- When employee submits a leave request is submitted the system performs a validation to see enough hours are available and creates a Task for Employee's Reports_To Manager and HR Admin Team. Otherwise a rejection email is sent to employee.
- Email is then sent to Reports_To Manager and HR team about the new task.
- The Time sheet will be created with PENDING status.
- The Reports_To Manager or any HR team person should claim and take action (approve or reject) the task with in 48 hours.
- Based on the action a approved or rejection email is sent to employee and team. If approved the request is saved as new Time sheet under the employee.
- The available hours in summary are adjusted and the status if the time sheet is updated accordingly
- If the Request Type is Unpaid this will need additional approval from admin after approval from Manager.
- Both Unpaid and JuryDuty leave requests are not validated for hours available.

Time Sheet Approval Process
----
![alt text](../../images/timesheets/corp-emp-leave-request-process.png "Time")

Time Sheet Process Task
----
![alt text](../../images/timesheets/leave-request-approval-task.png "Time")

