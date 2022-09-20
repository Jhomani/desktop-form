CREATE TABLE Dessert(
  id INT NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `detail` varchar(255),
  `price` DECIMAL(5, 2) NOT NULL,

  PRIMARY KEY(id)
);
