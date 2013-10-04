SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `restaurante` DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish_ci ;
USE `restaurante` ;

-- -----------------------------------------------------
-- Table `restaurante`.`Articulos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `restaurante`.`Articulos` ;

CREATE  TABLE IF NOT EXISTS `restaurante`.`Articulos` (
  `idArticulo` INT NOT NULL AUTO_INCREMENT ,
  `categoriaArticulo` VARCHAR(45) NULL ,
  `nombreArticulo` VARCHAR(45) NULL ,
  `precioArticulo` DECIMAL(6,2) NULL ,
  PRIMARY KEY (`idArticulo`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `restaurante`.`Mesas`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `restaurante`.`Mesas` ;

CREATE  TABLE IF NOT EXISTS `restaurante`.`Mesas` (
  `idMesa` INT NOT NULL AUTO_INCREMENT ,
  `nombreMesa` VARCHAR(45) NULL ,
  PRIMARY KEY (`idMesa`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `restaurante`.`Tickets`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `restaurante`.`Tickets` ;

CREATE  TABLE IF NOT EXISTS `restaurante`.`Tickets` (
  `idTicket` INT NOT NULL AUTO_INCREMENT ,
  `idMesaFK` INT NULL ,
  `cobrado` TINYINT(1) NULL ,
  `fecha` DATETIME NULL ,
  PRIMARY KEY (`idTicket`) ,
  INDEX `idMesaFk_idx` (`idMesaFK` ASC) ,
  CONSTRAINT `idMesaFk`
    FOREIGN KEY (`idMesaFK` )
    REFERENCES `restaurante`.`Mesas` (`idMesa` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `restaurante`.`DetalleTicket`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `restaurante`.`DetalleTicket` ;

CREATE  TABLE IF NOT EXISTS `restaurante`.`DetalleTicket` (
  `idTicketFK` INT NOT NULL ,
  `idArticuloFK` INT NOT NULL ,
  `cantidadArticulo` INT NULL ,
  `precioArticulo` DECIMAL(6,2) NULL ,
  PRIMARY KEY (`idTicketFK`, `idArticuloFK`) ,
  INDEX `idArticuloFK_idx` (`idArticuloFK` ASC) ,
  CONSTRAINT `idTicketFK`
    FOREIGN KEY (`idTicketFK` )
    REFERENCES `restaurante`.`Tickets` (`idTicket` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idArticuloFK`
    FOREIGN KEY (`idArticuloFK` )
    REFERENCES `restaurante`.`Articulos` (`idArticulo` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `restaurante`.`Caja`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `restaurante`.`Caja` ;

CREATE  TABLE IF NOT EXISTS `restaurante`.`Caja` (
  `idMovimiento` INT NOT NULL AUTO_INCREMENT ,
  `idTicketCobradoFK` INT NULL ,
  `importeIngreso` DECIMAL(8,2) NULL ,
  PRIMARY KEY (`idMovimiento`) ,
  INDEX `idTicketFK_idx` (`idTicketCobradoFK` ASC) ,
  CONSTRAINT `idTicketCobradoFK`
    FOREIGN KEY (`idTicketCobradoFK` )
    REFERENCES `restaurante`.`Tickets` (`idTicket` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `restaurante`.`Usuarios`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `restaurante`.`Usuarios` ;

CREATE  TABLE IF NOT EXISTS `restaurante`.`Usuarios` (
  `nombreUsuario` VARCHAR(40) NOT NULL ,
  `passwordUsuario` INT NULL ,
  PRIMARY KEY (`nombreUsuario`) )
ENGINE = InnoDB;

USE `restaurante` ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
