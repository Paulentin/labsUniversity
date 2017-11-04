-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema practiceDB
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema practiceDB
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `practiceDB` DEFAULT CHARACTER SET utf8 ;
USE `practiceDB` ;

-- -----------------------------------------------------
-- Table `practiceDB`.`User`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `practiceDB`.`User` ;

CREATE TABLE IF NOT EXISTS `practiceDB`.`User` (
  `idUser` INT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(45) NULL,
  PRIMARY KEY (`idUser`),
  UNIQUE INDEX `idUser_UNIQUE` (`idUser` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `practiceDB`.`Group`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `practiceDB`.`Group` ;

CREATE TABLE IF NOT EXISTS `practiceDB`.`Group` (
  `idGroup` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`idGroup`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `practiceDB`.`User_has_Group`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `practiceDB`.`User_has_Group` ;

CREATE TABLE IF NOT EXISTS `practiceDB`.`User_has_Group` (
  `User_idUser` INT NOT NULL,
  `Group_idGroup` INT NOT NULL,
  PRIMARY KEY (`User_idUser`, `Group_idGroup`),
  INDEX `fk_User_has_Group_Group1_idx` (`Group_idGroup` ASC),
  INDEX `fk_User_has_Group_User_idx` (`User_idUser` ASC),
  CONSTRAINT `fk_User_has_Group_User`
    FOREIGN KEY (`User_idUser`)
    REFERENCES `practiceDB`.`User` (`idUser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_User_has_Group_Group1`
    FOREIGN KEY (`Group_idGroup`)
    REFERENCES `practiceDB`.`Group` (`idGroup`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `practiceDB` ;

-- -----------------------------------------------------
-- Placeholder table for view `practiceDB`.`view1`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `practiceDB`.`view1` (`id` INT);

-- -----------------------------------------------------
-- View `practiceDB`.`view1`
-- -----------------------------------------------------
DROP VIEW IF EXISTS `practiceDB`.`view1` ;
DROP TABLE IF EXISTS `practiceDB`.`view1`;
USE `practiceDB`;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `practiceDB`.`User`
-- -----------------------------------------------------
START TRANSACTION;
USE `practiceDB`;
INSERT INTO `practiceDB`.`User` (`idUser`, `login`) VALUES (1, 'Petr');
INSERT INTO `practiceDB`.`User` (`idUser`, `login`) VALUES (2, 'Gena');
INSERT INTO `practiceDB`.`User` (`idUser`, `login`) VALUES (3, 'Igor');
INSERT INTO `practiceDB`.`User` (`idUser`, `login`) VALUES (4, 'Semen');
INSERT INTO `practiceDB`.`User` (`idUser`, `login`) VALUES (5, 'Iliya');

COMMIT;


-- -----------------------------------------------------
-- Data for table `practiceDB`.`Group`
-- -----------------------------------------------------
START TRANSACTION;
USE `practiceDB`;
INSERT INTO `practiceDB`.`Group` (`idGroup`, `name`) VALUES (1, 'First');
INSERT INTO `practiceDB`.`Group` (`idGroup`, `name`) VALUES (2, 'Second');
INSERT INTO `practiceDB`.`Group` (`idGroup`, `name`) VALUES (3, 'Third');
INSERT INTO `practiceDB`.`Group` (`idGroup`, `name`) VALUES (4, 'Fourth');
INSERT INTO `practiceDB`.`Group` (`idGroup`, `name`) VALUES (5, 'Fifth');

COMMIT;


-- -----------------------------------------------------
-- Data for table `practiceDB`.`User_has_Group`
-- -----------------------------------------------------
START TRANSACTION;
USE `practiceDB`;
INSERT INTO `practiceDB`.`User_has_Group` (`User_idUser`, `Group_idGroup`) VALUES (1, 1);
INSERT INTO `practiceDB`.`User_has_Group` (`User_idUser`, `Group_idGroup`) VALUES (1, 2);
INSERT INTO `practiceDB`.`User_has_Group` (`User_idUser`, `Group_idGroup`) VALUES (1, 3);
INSERT INTO `practiceDB`.`User_has_Group` (`User_idUser`, `Group_idGroup`) VALUES (2, 2);
INSERT INTO `practiceDB`.`User_has_Group` (`User_idUser`, `Group_idGroup`) VALUES (2, 5);
INSERT INTO `practiceDB`.`User_has_Group` (`User_idUser`, `Group_idGroup`) VALUES (2, 4);
INSERT INTO `practiceDB`.`User_has_Group` (`User_idUser`, `Group_idGroup`) VALUES (2, 3);
INSERT INTO `practiceDB`.`User_has_Group` (`User_idUser`, `Group_idGroup`) VALUES (3, 3);
INSERT INTO `practiceDB`.`User_has_Group` (`User_idUser`, `Group_idGroup`) VALUES (3, 1);
INSERT INTO `practiceDB`.`User_has_Group` (`User_idUser`, `Group_idGroup`) VALUES (4, 5);

COMMIT;

