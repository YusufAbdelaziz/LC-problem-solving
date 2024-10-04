# Write your MySQL query statement below

WITH ProductPricesAtDate AS (
    SELECT
        product_id,
        MAX(change_date) AS last_change_date
    FROM
        Products
    WHERE
        change_date <= '2019-08-16'
    GROUP BY
        product_id
)
SELECT
    p.product_id,
    COALESCE(pd.new_price, 10) AS price
FROM
    (
        SELECT
            DISTINCT product_id
        FROM
            Products
    ) p
    LEFT JOIN (
        SELECT
            p1.product_id,
            p1.new_price
        FROM
            Products p1
            JOIN ProductPricesAtDate pp ON p1.change_date = pp.last_change_date
            AND p1.product_id = pp.product_id
    ) pd ON p.product_id = pd.product_id;