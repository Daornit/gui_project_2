DROP DATABASE IF EXISTS lombard;
CREATE DATABASE IF NOT EXISTS lombard;

USE lombard;

CREATE TABLE customers
(
  register   VARCHAR(20)  NOT NULL,
  first_name VARCHAR(30)  NOT NULL,
  last_name  VARCHAR(30)  NOT NULL,
  address    VARCHAR(255) NOT NULL,
  phone      INT          NOT NULL,
  phone_add  INT          NOT NULL,
  PRIMARY KEY (register)
);

CREATE TABLE items
(
  item_id     VARCHAR(30)   NOT NULL,
  category    VARCHAR(30)   NOT NULL,
  type        VARCHAR(30)   NOT NULL,
  description VARCHAR(255)  NOT NULL,
  gram        NUMERIC(5, 2) NOT NULL,
  purity      INT           NOT NULL,
  quantity    INT           NOT NULL,
  begin_date  DATE          NOT NULL,
  register    VARCHAR(20)   NOT NULL,
  PRIMARY KEY (item_id),
  FOREIGN KEY (register) REFERENCES customers (register)
);

CREATE TABLE loans
(
  interest_rate NUMERIC(2, 1) NOT NULL,
  start_date    DATE          NOT NULL,
  end_date      DATE          NOT NULL,
  status        INT           NOT NULL,
  loan_id       VARCHAR(30)   NOT NULL,
  item_id       VARCHAR(30)   NOT NULL,
  amount        INT           NOT NULL,
  PRIMARY KEY (loan_id, item_id),
  FOREIGN KEY (item_id) REFERENCES items (item_id)
);

CREATE TABLE history
(
  history_id VARCHAR(30) NOT NULL,
  loan_id    VARCHAR(30) NOT NULL,
  item_id    VARCHAR(30) NOT NULL,
  amount     INT         NOT NULL,
  status     INT         NOT NULL,
  date       DATE        NOT NULL,
  PRIMARY KEY (history_id),
  FOREIGN KEY (item_id) REFERENCES loans (item_id),
  FOREIGN KEY (loan_id) REFERENCES loans (loan_id)
);

# Dummy Datas
#
# Customers
#
INSERT INTO `customers` (`register`, `first_name`, `last_name`, `address`, `phone`, `phone_add`)
VALUES ('c1', 'Tia', 'Kessler', '827 Noble Dale Suite 882\nBradtkeside, NJ 13734', 22648, 266),
       ('c2', 'Korbin', 'Orn', '718 Jacobson Knolls\nWest Jan, NH 38208-5136', 800, 2147483647),
       ('c3', 'Nicola', 'Veum', '8994 Alessandro Mission\nNew Perry, NE 96823-4084', 87, 367),
       ('c4', 'Ceasar', 'Parker', '67231 Elsa Ports\nWest Leliaberg, ME 37125-3614', 709, 268),
       ('c5', 'Keara', 'Kassulke', '28264 Jacobi Tunnel Suite 668\nWest Imogene, CT 77269', 1, 652);

#
# Items
#
INSERT INTO `items` (`item_id`, `category`, `type`, `description`, `gram`, `purity`, `quantity`, `begin_date`,
                     `register`)
VALUES ('i1', '', '',
        'Placeat molestiae consequatur sint dolores atque hic. Autem sint deleniti nesciunt sed expedita id et placeat. Quisquam aut optio optio veniam nisi.',
        '0.00', 0, 414185, '2013-08-01', 'c1'),
       ('i2', '', '',
        'Sed voluptatem saepe rem error delectus occaecati in. Qui quidem consequatur aperiam vero. Qui voluptates commodi aspernatur nihil et dicta vero. Sint earum officia deserunt rem aut delectus qui beatae. Dolores illum vero velit sequi et corrupti est.',
        '0.00', 0, 1721080, '2000-06-10', 'c2'),
       ('i3', '', '',
        'Molestiae illum ex eaque necessitatibus sed. Qui doloribus error maiores totam. Est repellendus deserunt unde atque voluptatem eaque unde. Ratione qui culpa laborum non amet sapiente ut. Corrupti vel et libero reiciendis quam et aliquam aut.',
        '0.00', 0, 0, '2016-06-01', 'c3'),
       ('i4', '', '',
        'Ipsum maiores labore ex rerum earum qui sint. Aut eos molestias hic dicta. Autem ea omnis molestiae dolores nobis quod quo. Dolores ipsum dolores suscipit error.',
        '0.00', 0, 3, '1988-02-07', 'c4'),
       ('i5', '', '',
        'Reiciendis est sint autem ut voluptas a. Fuga quo dignissimos excepturi totam consequatur sint. Hic rerum eos esse fugit.',
        '0.00', 0, 318647959, '2007-01-05', 'c5');

#
# Loans
#
INSERT INTO `loans` (`interest_rate`, `start_date`, `end_date`, `status`, `loan_id`, `item_id`, `amount`)
VALUES ('6.7', '2019-04-29', '2019-05-09', 1, 'l1', 'i1', 1000),
       ('9.9', '2019-04-29', '2019-05-07', 1, 'l2', 'i2', 8483),
       ('9.9', '2019-04-29', '2019-05-11', 9, 'l3', 'i3', 0),
       ('9.9', '2019-05-02', '2019-05-07', 6, 'l4', 'i4', 13),
       ('9.9', '2019-04-29', '2019-05-04', 2, 'l5', 'i5', 352);


#
# History
#
INSERT INTO `history` (`history_id`, `loan_id`, `item_id`, `amount`, `status`, `date`)
VALUES ('h1', 'l1', 'i1', 0, 1, date_sub(NOW(), INTERVAL 5 DAY)),
       ('h2', 'l1', 'i1', 3031417, 4, date_sub(NOW(), INTERVAL 3 DAY)),
       ('h3', 'l2', 'i2', 8, 1, date_sub(NOW(), INTERVAL 3 DAY));

INSERT INTO `history` (`history_id`, `loan_id`, `item_id`, `amount`, `status`, `date`)
VALUES ('h4', 'l3', 'i3', 0, 1, NOW()),
       ('h5', 'l4', 'i4', 0, 4, NOW());

# GET max count of history lend and paid for home graph
SELECT COUNT(*) as `count`
FROM history
WHERE (status = '4' OR status = '1')
  AND (`date` BETWEEN '2019-05-01' AND '2019-05-05')
GROUP BY `date`, `status`
ORDER BY `count` DESC
LIMIT 1;

SELECT *
FROM loans;
