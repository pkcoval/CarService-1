CREATE TABLE status (
  id  INT AUTO_INCREMENT PRIMARY KEY,
  typ text not null
);

CREATE TABLE employees (
  id            INT                   AUTO_INCREMENT PRIMARY KEY,
  name          VARCHAR(255) NOT NULL,
  surname      VARCHAR(255) NOT NULL,
  email         VARCHAR(255) NOT NULL UNIQUE,
  password      VARCHAR(255) NOT NULL,
  perrmision    INT          NOT NULL DEFAULT 1,
  address       TEXT,
  phone         INT,
  notice        TEXT,
  salaryforhour DECIMAL(10, 2)
);

CREATE TABLE vehicles (
  id              INT AUTO_INCREMENT PRIMARY KEY,
  model           VARCHAR(255) NOT NULL,
  brand           VARCHAR(255) NOT NULL,
  productionYear  INT          NOT NULL,
  regNumber       VARCHAR(15),
  nextServiceDate DATE,
  customer_id     INT          NOT NULL,
  FOREIGN KEY (customer_id) REFERENCES customers (id)
);

CREATE TABLE customers (
  id      INT AUTO_INCREMENT PRIMARY KEY,
  name    varchar(255) NOT NULL,
  surname VARCHAR(255) NOT NULL,
  birthday DATE
);

CREATE TABLE orders (
  id               INT AUTO_INCREMENT PRIMARY KEY,
  takecar          DATE NOT NULL,
  planstartrepair  DATE,
  startrepair      DATE,
  descriptionfault TEXT,
  descripionrepair TEXT,
  employee_id      INT,
  vehicles_id      INT NOT NULL ,
  status_id        INT NOT NULL ,
  costforcustomer  DECIMAL(10, 2),
  costparts        DECIMAL(10, 2),
  salaryforhour    DECIMAL(10, 2),
  amountofhour     INT,
  FOREIGN KEY (employee_id) REFERENCES employees (id),
  FOREIGN KEY (vehicles_id) REFERENCES vehicles (id),
  FOREIGN KEY (status_id) REFERENCES employees (id)
);