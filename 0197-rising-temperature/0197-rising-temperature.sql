# Write your MySQL query statement below

SELECT w1.id FROM Weather as w1 INNER JOIN Weather as w2 ON w2.recordDate = DATE_SUB(w1.recordDate, INTERVAL 1 DAY) AND w1.temperature > w2.temperature;