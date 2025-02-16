CREATE TABLE expenses
(
    expenseID    INT AUTO_INCREMENT PRIMARY KEY,
    title        VARCHAR(255) NOT NULL,
    category     VARCHAR(100),
    amount       DOUBLE       NOT NULL,
    dateIncurred DATE         NOT NULL
);

INSERT INTO expenses (title, category, amount, dateIncurred)
VALUES ('Weekly shop', 'Groceries', 47.50, '2025-01-07'),
       ('Gym membership', 'Fitness', 30.00, '2025-01-09'),
       ('Netflix Subscription', 'Entertainment', 15.99, '2025-01-12'),
       ('Dinner Out', 'Food & Drink', 60.00, '2025-01-15'),
       ('Electricity Bill', 'Utilities', 120.75, '2025-01-20'),
       ('New Shoes', 'Shopping', 85.00, '2025-01-25'),
       ('Fuel for Car', 'Transport', 50.00, '2025-01-27'),
       ('Coffee', 'Food & Drink', 3.50, '2025-02-01'),
       ('Bus Ticket', 'Transport', 10.00, '2025-02-03'),
       ('Laptop Repair', 'Technology', 200.00, '2025-02-05');