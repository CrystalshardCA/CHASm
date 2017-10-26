CREATE TABLE IF NOT EXISTS `Job` (
  `id` INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
  `name` VARCHAR(250) NOT NULL,
  `createdDateUtc` DATETIME NOT NULL,
  `updatedDateUtc` DATETIME NOT NULL,
  `deletedDateUtc` DATETIME NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;