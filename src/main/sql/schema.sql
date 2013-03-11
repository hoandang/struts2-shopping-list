DROP TABLE IF EXISTS Products;
DROP TABLE IF EXISTS Categories;
DROP TABLE IF EXISTS Orders;
DROP TABLE IF EXISTS Customers;
DROP TABLE IF EXISTS OrderDetails;

CREATE TABLE Categories
(
    id   INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(40) NOT NULL,
    PRIMARY KEY (id)
) ENGINE = INNODB;

CREATE TABLE Products
(
    id          INT NOT NULL AUTO_INCREMENT,
    category_id INT NOT NULL,
    description VARCHAR(100),
    price       DECIMAL(10, 2) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (category_id) REFERENCES Categories(id)
) ENGINE = INNODB;
CREATE INDEX index_product_category ON Products (category_id);

CREATE TABLE Customers
(
    id               INT NOT NULL AUTO_INCREMENT,
    name             VARCHAR(40) NOT NULL,
    email            VARCHAR(40) NOT NULL,
    shipping_address VARCHAR(100) NOT NULL,
    credit_number    INT NOT NULL,
    expired_date     DATE NOT NULL,
    PRIMARY KEY (id)
) ENGINE = INNODB;

CREATE TABLE Orders
(
    id           INT NOT NULL AUTO_INCREMENT,
    customer_id  INT NOT NULL,
    status       VARCHAR(20) NOT NULL,
    date_created TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    FOREIGN KEY (customer_id) REFERENCES Customers(id)
) ENGINE = INNODB;

CREATE TABLE OrderDetails
(
    id         INT NOT NULL AUTO_INCREMENT,
    product_id INT NOT NULL,
    order_id   INT NOT NULL,
    quantity   INT NOT NULL,
    subtotal   DECIMAL(10, 2) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (product_id) REFERENCES Products(id),
    FOREIGN KEY (order_id)   REFERENCES Orders(id)
) ENGINE = INNODB;
