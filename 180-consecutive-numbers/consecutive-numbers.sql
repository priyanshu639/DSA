# Write your MySQL query statement below
SELECT DISTINCT a.num AS ConsecutiveNums
from Logs a
join Logs b
on b.id=a.id+1 AND b.num=a.num
join logs c
on c.id=a.id+2 And c.num=a.num