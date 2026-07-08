# Write your MySQL query statement below
select product_name, year, price from Sales s
left join Product p
on s.product_id=p.product_id;
-- FROM
--  ↓
--   JOIN
--    ↓
--    ON
--    ↓
--  WHERE
--    ↓
-- GROUP BY
--    ↓
-- HAVING
--    ↓
-- SELECT
--    ↓
-- DISTINCT
--    ↓
-- ORDER BY
--    ↓
-- LIMIT