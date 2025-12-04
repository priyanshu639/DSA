# Write your MySQL query statement below
-- USING NOT IN

-- SELECT name as customers 
-- FROM Customers
-- WHERE id NOT IN (SELECT customerId FROM Orders);


-- USING NOT EXISTS

SELECT name as customers
FROM Customers c
WHERE NOT EXISTS (
    SELECT 1
    FROM Orders o
    WHERE o.customerId = c.id
);

