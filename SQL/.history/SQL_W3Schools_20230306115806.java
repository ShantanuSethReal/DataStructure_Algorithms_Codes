The SQL SELECT Statement
    SELECT column1, column2, ...FROM table_name;
    SELECT * FROM table_name;


SQL SELECT DISTINCT Statement
    SELECT DISTINCT column1, column2, ...FROM table_name;
    SELECT COUNT(DISTINCT Country) FROM Customers;


The SQL WHERE Clause
    SELECT column1, column2, ...FROM table_name WHERE condition;
    SELECT * FROM Customers WHERE Country='Mexico';
    SQL requires single quotes around text values (most database systems will also allow double quotes).However, numeric fields should not be enclosed in quotes
    Operators - =,>,<,>=,<=,<>,!=,BETWEEN,LIKE,IN

The SQL AND, OR and NOT Operators
    AND,OR,NOT Operators
    SELECT column1, column2, ...FROM table_name WHERE condition1 AND condition2 AND condition3 ...;
    SELECT column1, column2, ...FROM table_name WHERE condition1 OR condition2 OR condition3 ...;
    SELECT column1, column2, ...FROM table_name WHERE NOT condition
    The SQL ORDER BY Keyword