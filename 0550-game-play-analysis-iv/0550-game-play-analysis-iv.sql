# Write your MySQL query statement below
WITH FirstLogin AS (
    SELECT
        player_id,
        MIN(event_date) AS first_login_date
    FROM
        Activity
    GROUP BY
        player_id
)
SELECT
    ROUND(COUNT(DISTINCT f.player_id) / (SELECT COUNT(player_id) FROM FirstLogin), 2) as fraction  
FROM
    FirstLogin f
    INNER JOIN Activity a ON f.player_id = a.player_id
WHERE
    DATEDIFF(a.event_date, f.first_login_date) = 1;