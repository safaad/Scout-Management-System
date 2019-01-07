-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema SMSdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `SMSdb` ;

-- -----------------------------------------------------
-- Schema SMSdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `SMSdb` DEFAULT CHARACTER SET utf8 ;
USE `SMSdb` ;

-- -----------------------------------------------------
-- Table `SMSdb`.`Person`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SMSdb`.`Person` (
  `pid` INT NOT NULL AUTO_INCREMENT,
  `type` VARCHAR(45) NOT NULL,
  `pname` VARCHAR(45) NOT NULL,
  `birthdate` DATE NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `pass` VARCHAR(45) NOT NULL DEFAULT '1234',
  `phone` VARCHAR(45) NOT NULL,
  `deanid` INT NOT NULL,
  PRIMARY KEY (`pid`, `deanid`),
  CONSTRAINT `fk_Person_Person1`
    FOREIGN KEY (`deanid`)
    REFERENCES `SMSdb`.`Person` (`pid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_Person_Person1_idx` ON `SMSdb`.`Person` (`deanid` ASC) ;

alter table Person AUTO_INCREMENT=1000;
-- -----------------------------------------------------
-- Table `SMSdb`.`Members`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SMSdb`.`Members` (
  `mid` INT NOT NULL AUTO_INCREMENT,
  `evaluation` INT NOT NULL,
  `mname` VARCHAR(45) NOT NULL,
  `rank` VARCHAR(45) NOT NULL,
  `birthdate` DATE NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `pass` VARCHAR(45) NOT NULL DEFAULT '1234',
  `phone` VARCHAR(45) NOT NULL,
  `lid` INT NOT NULL,
  PRIMARY KEY (`mid`, `lid`),
  CONSTRAINT `fk_Members_Person1`
    FOREIGN KEY (`lid`)
    REFERENCES `SMSdb`.`Person` (`pid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_Members_Person1_idx` ON `SMSdb`.`Members` (`lid` ASC);

alter table Members AUTO_INCREMENT=2000;
-- -----------------------------------------------------
-- Table `SMSdb`.`Meeting`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SMSdb`.`Meeting` (
  `meid` INT NOT NULL AUTO_INCREMENT,
  `mdate` DATE NOT NULL,
  `objective` VARCHAR(256) NOT NULL,
  PRIMARY KEY (`meid`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SMSdb`.`Items`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SMSdb`.`Items` (
  `itid` INT NOT NULL AUTO_INCREMENT,
  `iname` VARCHAR(45) NOT NULL,
  `quantity` INT NOT NULL,
  PRIMARY KEY (`itid`))
ENGINE = InnoDB;

alter table Items AUTO_INCREMENT=0;
-- -----------------------------------------------------
-- Table `SMSdb`.`AttendMeetings`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SMSdb`.`AttendMeetings` (
  `pid` INT NOT NULL,
  `meid` INT NOT NULL,
  `sid` INT NOT NULL,
  PRIMARY KEY (`pid`, `meid`),
  CONSTRAINT `fk_Person_has_Meeting_Person1`
    FOREIGN KEY (`pid`)
    REFERENCES `SMSdb`.`Person` (`pid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Person_has_Meeting_Meeting1`
    FOREIGN KEY (`meid`)
    REFERENCES `SMSdb`.`Meeting` (`meid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
     CONSTRAINT `fk_Person_has_Meeting_Secretary`
    FOREIGN KEY (`sid`)
    REFERENCES `SMSdb`.`Person` (`pid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_Person_has_Meeting_Meeting1_idx` ON `SMSdb`.`AttendMeetings` (`meid` ASC) ;

CREATE INDEX `fk_Person_has_Meeting_Person1_idx` ON `SMSdb`.`AttendMeetings` (`pid` ASC);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
