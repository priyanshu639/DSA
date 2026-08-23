# Write your MySQL query statement below
-- SELECT student_id,student_name,subject_name,count(subject_name) as attended_exams from examinations group by student_id order by student_id and subject_name;

-- select student_id,student_name,subject_name,count(subject_name) as attended_exams
-- from students s
-- join  examination e
-- on 
-- s.student_id =e.student_id
-- join subjects sub

select s.student_id,s.student_name,sub.subject_name,count(e.student_id) as attended_exams from students s
cross join subjects sub
left join examinations  e
on s.student_id=e.student_id
and sub.subject_name=e.subject_name
group by student_id,student_name,subject_name
order by student_id ,subject_name;

