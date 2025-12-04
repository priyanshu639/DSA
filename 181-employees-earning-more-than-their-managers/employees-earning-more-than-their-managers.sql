# Write your MySQL query statement below
SELECT e.name as Employee from Employee e join Employee M on e.managerId=m.id And e.salary>M.salary;