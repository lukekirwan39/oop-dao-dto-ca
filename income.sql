CREATE TABLE income
(
    incomeID   INT AUTO_INCREMENT PRIMARY KEY,
    title      VARCHAR(255) NOT NULL,
    amount DOUBLE NOT NULL,
    dateEarned DATE         NOT NULL
);