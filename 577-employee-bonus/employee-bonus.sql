# Write your MySQL query statement below
SELECT name, bonus
from Employee e
left join Bonus b on (e.empId=b.empId)
where bonus is null or bonus<1000;