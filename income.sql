CREATE TABLE income
(
    incomeID   INT AUTO_INCREMENT PRIMARY KEY,
    title      VARCHAR(255) NOT NULL,
    amount     DOUBLE       NOT NULL,
    dateEarned DATE         NOT NULL
);

INSERT INTO income (title, amount, dateEarned)
VALUES ('Freelance Project', 1200.50, '2024-02-01'),
       ('Part-time Job', 800.00, '2024-02-05'),
       ('Stock Dividends', 450.75, '2024-02-10'),
       ('Online Course Sales', 1500.00, '2024-02-15'),
       ('Consulting Fee', 2200.25, '2024-02-20'),
       ('Gift', 300.00, '2024-02-25'),
       ('Bonus', 1750.00, '2024-02-28'),
       ('Side Hustle', 950.50, '2024-03-03'),
       ('Rental Income', 1800.00, '2024-03-07'),
       ('Affiliate Marketing', 1300.75, '2024-03-12');