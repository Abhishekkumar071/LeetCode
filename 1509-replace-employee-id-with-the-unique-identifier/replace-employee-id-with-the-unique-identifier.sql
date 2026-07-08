# Write your MySQL query statement below
select unique_id, name from Employees e
Left Join EmployeeUNI u
on e.id=u.id;