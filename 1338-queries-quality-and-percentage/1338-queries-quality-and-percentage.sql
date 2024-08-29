# Write your MySQL query statement below

SELECT query_name, ROUND(AVG (rating / position), 2) as quality,
 ROUND(COUNT(CASE WHEN rating < 3 THEN 1 END ) * 100 / COUNT(*), 2) as poor_query_percentage 
FROM Queries WHERE query_name IS NOT NULL GROUP BY query_name;