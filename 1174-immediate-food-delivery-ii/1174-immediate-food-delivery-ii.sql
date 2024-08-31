# Write your MySQL query statement below
WITH FirstOrders AS (
    SELECT
        customer_id,
        MIN(order_date) as first_order_date
    FROM
        Delivery
    GROUP BY
        customer_id
),
ImmediateFirstOrders AS (
    SELECT
        f.customer_id,
        d.delivery_id,
        d.order_date,
        d.customer_pref_delivery_date
    FROM
        FirstOrders f
        JOIN Delivery d ON f.customer_id = d.customer_id
        AND f.first_order_date = d.order_date
    WHERE
        d.order_date = d.customer_pref_delivery_date
)
SELECT
    ROUND(
        (COUNT(ifo.customer_id) * 100.0) / COUNT(DISTINCT f.customer_id),
        2
    ) AS immediate_percentage
FROM
    FirstOrders f
    LEFT JOIN ImmediateFirstOrders ifo ON f.customer_id = ifo.customer_id;