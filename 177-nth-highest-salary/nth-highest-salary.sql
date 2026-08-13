CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN (
      # Write your MySQL query statement below.
      with nthhighest as(Select Distinct salary ,dense_rank()over(order by salary desc) as rnk from employee)
      select salary from nthhighest where rnk = N

  );
END