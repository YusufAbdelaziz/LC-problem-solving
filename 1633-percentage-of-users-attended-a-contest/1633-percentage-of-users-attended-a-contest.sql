# Write your MySQL query statement below
SELECT 
    contest_id, 
    ROUND(COUNT(contest_id) * 100.0 / (SELECT COUNT(*) FROM Users), 2) AS percentage 
FROM 
    Users u 
LEFT JOIN 
    Register r 
ON 
    u.user_id = r.user_id 
GROUP BY 
    contest_id 
HAVING 
    percentage != 0 
ORDER BY 
    percentage DESC, 
    contest_id ASC;
