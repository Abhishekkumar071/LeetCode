SELECT DISTINCT author_id as id
FROM Views
WHERE author_id = viewer_id
ORDER BY id;

-- SQL upar se neeche nahi chalti. Ye logically is order me kaam karti hai:

-- 1. FROM
-- 2. WHERE
-- 3. GROUP BY
-- 4. HAVING
-- 5. SELECT
-- 6. DISTINCT
-- 7. ORDER BY
-- 8. LIMIT