# Write your MySQL query statement below
WITH FirstYearSales AS (
    SELECT
        product_id,
        MIN(year) as first_year
    FROM
        Sales
    GROUP BY
        product_id
)
SELECT
    f.product_id,
    f.first_year,
    s.quantity,
    s.price
FROM
    FirstYearSales f
    INNER JOIN Sales s ON f.product_id = s.product_id
WHERE
    f.first_year = s.year;