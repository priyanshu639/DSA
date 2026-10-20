-- # Write your MySQL query statement below
-- select s.student_id,s.student_name,e.subject_name,count(e.subject_name) as attended_exams from Students as s left join Examinations as e on s.student_id=e.student_id 
--  left join Subjects as sub on sub.subject_name=e.subject_name  group by s.student_id,e.subject_name order by s.student_id,s.student_name;


select s.student_id,s.student_name,sub.subject_name,count(e.subject_name) 
as attended_exams from Students as s 
cross join Subjects as sub
left join Examinations as e 
on s.student_id=e.student_id 
and sub.subject_name=e.subject_name
group by student_id,student_name,subject_name
order by student_id,student_name;