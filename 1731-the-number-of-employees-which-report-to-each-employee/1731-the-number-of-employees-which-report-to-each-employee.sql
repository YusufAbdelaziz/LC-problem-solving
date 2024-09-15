# Write your MySQL query statement below

SELECT
    e1.employee_id,
    e1.name,
    COUNT(e2.reports_to) as reports_count,
    CEIL(AVG(e2.age)) as average_age
FROM
    Employees e1
    INNER JOIN Employees e2 ON e1.employee_id = e2.reports_to
GROUP BY
    employee_id,
    name
ORDER BY
    employee_id;