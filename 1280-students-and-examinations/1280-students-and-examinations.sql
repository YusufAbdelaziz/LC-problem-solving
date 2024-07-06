# Write your MySQL query statement below
SELECT 
    st.student_id, st.student_name, sub.subject_name, COUNT(e.subject_name) as attended_exams  
FROM 
    Students st
CROSS JOIN
    Subjects sub
LEFT JOIN
    Examinations e
ON
    e.subject_name = sub.subject_name AND st.student_id = e.student_id
GROUP BY
    sub.subject_name, st.student_id
ORDER BY
    st.student_id, sub.subject_name;