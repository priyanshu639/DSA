# Write your MySQL query statement below
-- SELECT t1.id From weather as t1 , weather as t2  
-- where datediff(t1.recordDate,t2.recordDate)=1 AND t1.temperature>t2.temperature;
SELECT t1.id From weather as t1 , weather as t2  
where datediff(t1.recordDate,t2.recordDate)=1 AND t1.temperature>t2.temperature;