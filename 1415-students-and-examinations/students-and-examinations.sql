# Write your MySQL query statement below
-- Select S.student_id , S.student_name,SS.subject_name,Count(SS.subject_name) AS attended_exams From Students S 
-- left Join Examinations E ON S.student_id = E.student_id
-- cross JOIn Subjects SS ON E.subject_name = SS.subject_name
-- ORder by S.student_id , SS.subject_name;
Select S.student_id , S.student_name,ss.subject_name,count(e.subject_name) as attended_exams From Students S 
cross JOIn Subjects SS 
left Join Examinations E ON S.student_id = E.student_id and ss.subject_name=e.subject_name
group by ss.subject_name,s.student_id,s.student_name
order by s.student_id,ss.subject_name
;

