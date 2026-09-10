# Write your MySQL query statement below
SELECT DISTINCT num AS ConsecutiveNums
from  (select num ,lag(num,1) over (order by id) as prev1,lag(num,2) over (order by id) as prev2 from logs) a
where num=prev1 and num=prev2;
