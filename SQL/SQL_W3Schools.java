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
    SELECT column1, column2, ...FROM table_name WHERE NOT condition;

The SQL ORDER BY Keyword
    SELECT column1, column2, ...FROM table_namec ORDER BY column1, column2, ... ASC|DESC;

The SQL INSERT INTO Statement
    INSERT INTO table_name (column1, column2, column3, ...) VALUES (value1, value2, value3, ...);
    INSERT INTO table_name VALUES (value1, value2, value3, ...);
    INSERT INTO Customers (CustomerName, ContactName, Address, City, PostalCode, Country) VALUES ('Cardinal', 'Tom B. Erichsen', 'Skagen 21', 'Stavanger', '4006', 'Norway');

SQL NULL Values
    It is not possible to test for NULL values with comparison operators, such as =, <, or <>.We will have to use the IS NULL and IS NOT NULL operators instead.
    SELECT column_names FROM table_name WHERE column_name IS NULL;
    SELECT column_names FROM table_name WHERE column_name IS NOT NULL;
    The IS NOT NULL operator is used to test for non-empty values (NOT NULL values).
    SELECT CustomerName, ContactName, Address FROM Customers WHERE Address IS NOT NULL;

The SQL UPDATE Statement
    UPDATE table_name SET column1 = value1, column2 = value2, ...WHERE condition;

The SQL DELETE Statement
    DELETE FROM table_name WHERE condition;

The SQL LIMIT Statement
    SELECT column_name(s) FROM table_name WHERE condition LIMIT number;

The SQL MIN() and MAX() Functions
    The MIN() function returns the smallest value of the selected column.The MAX() function returns the largest value of the selected column.
    SELECT MAX(column_name) FROM table_name WHERE condition;
    SELECT MIN(column_name) FROM table_name WHERE condition;

The SQL COUNT(), AVG() and SUM() Functions
    The COUNT() function returns the number of rows that matches a specified criterion.
    SELECT COUNT(column_name) FROM table_name WHERE condition;
    SELECT AVG(column_name) FROM table_name WHERE condition;
    SELECT SUM(column_name) FROM table_name WHERE condition;

The SQL LIKE Operator
    The LIKE operator is used in a WHERE clause to search for a specified pattern in a column.There are two wildcards often used in conjunction with the LIKE operator:The percent sign (%) represents zero, one, or multiple characters.The underscore sign (_) represents one, single character.
    SELECT column1, column2, ...FROM table_name WHERE columnN LIKE pattern;
