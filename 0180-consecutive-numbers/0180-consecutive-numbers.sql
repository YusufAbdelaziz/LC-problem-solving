# Write your MySQL query statement below
WITH numbered_logs AS (
    SELECT
        id,
        num,
        LAG(num, 1) OVER (
            ORDER BY
                id
        ) AS prev_num,
        LAG(num, 2) OVER (
            ORDER BY
                id
        ) AS prev_prev_num
    FROM
        Logs
)
SELECT
    DISTINCT num as ConsecutiveNums
FROM
    numbered_logs 
WHERE
    num = prev_num
    AND num = prev_prev_num;