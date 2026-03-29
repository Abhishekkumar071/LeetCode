# Write your MySQL query statement below
-- SELECT MAX(salary) AS SecondHighestSalary
-- FROM Employee E1

-- WHERE salary< (SELECT MAX(salary) FROM Employee E2);

-- SELECT(
--     SELECT DISTINCT salary
--     FROM Employee
--     ORDER BY salary DESC
--     LIMIT 1 OFFSET 1    --TAKE ONE AND SKIP FIRST ONE
-- ) AS SecondHighestSalary;


SELECT(
    SELECT DISTINCT salary
    FROM(
        SELECT
            salary,
            DENSE_RANK() OVER (ORDER BY salary DESC) AS rnk
        FROM Employee
    )AS RankS
    WHERE rnk=2
) AS SecondHighestSalary;