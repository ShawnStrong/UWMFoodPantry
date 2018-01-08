
CREATE TABLE IF NOT EXISTS `user_table` (
	user_id int(5) NOT NULL AUTO_INCREMENT, 
	username TINYTEXT NOT NULL, 
	password TINYTEXT NOT NULL, 
	super_user int(1),
	PRIMARY KEY (user_id) 
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `donation_table` (
	`donation_id` int(5) NOT NULL AUTO_INCREMENT,
	`donation_type` int(1) NOT NULL,
	`category_name` TINYTEXT NOT NULL,
	`category_size` int(7) NOT NULL,
	`category_weight` float(10,1) NOT NULL,
	`category_amount` int(7) NOT NULL,
	`user_name` TINYTEXT NOT NULL,
	`ts` TIMESTAMP,
	PRIMARY KEY (donation_id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `inventory_table` (
	`donation_id` int(5) NOT NULL AUTO_INCREMENT,
	`donation_type` int(1) NOT NULL,
	`category_name` TINYTEXT NOT NULL,
	`category_size` int(7) NOT NULL,
	`category_weight` float(10,1) NOT NULL,
	`category_amount` int(7) NOT NULL,
	`user_name` TINYTEXT NOT NULL,
	`ts` TIMESTAMP,
	PRIMARY KEY (donation_id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `category_table` (
  `category_id` int(5) NOT NULL AUTO_INCREMENT,
  `category_name` TINYTEXT NOT NULL,
  `category_size` TINYTEXT NOT NULL,
  `category_weight` float(10,1) NOT NULL,
  PRIMARY KEY (category_id)
)ENGINE=InnoDB DEFAULT CHARSET=latin1;