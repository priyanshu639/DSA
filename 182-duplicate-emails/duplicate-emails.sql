# Write your MySQL query statement below
Select Email from Person group by email having count(email)>1;