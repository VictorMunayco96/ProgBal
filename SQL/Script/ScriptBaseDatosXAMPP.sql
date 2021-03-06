SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Conductor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Conductor` (
  `IdConductor` INT NOT NULL AUTO_INCREMENT,
  `NumDoc` VARCHAR(45) NULL,
  `Nombre` VARCHAR(60) NULL,
  `Apellidos` VARCHAR(60) NULL,
  PRIMARY KEY (`IdConductor`),
  UNIQUE INDEX `NumDoc_UNIQUE` (`NumDoc` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`EmpreTrans`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`EmpreTrans` (
  `Ruc` BIGINT NOT NULL,
  `RazonSocial` VARCHAR(80) NULL,
  `Domicilio` VARCHAR(60) NULL,
  `NumCel` VARCHAR(15) NULL,
  PRIMARY KEY (`Ruc`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Vehiculo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Vehiculo` (
  `Placa` VARCHAR(8) NOT NULL,
  `Marca` VARCHAR(45) NULL,
  `Ruc` BIGINT NOT NULL,
  PRIMARY KEY (`Placa`),
  INDEX `fk_Vehiculo_EmpreTrans1_idx` (`Ruc` ASC),
  CONSTRAINT `fk_Vehiculo_EmpreTrans1`
    FOREIGN KEY (`Ruc`)
    REFERENCES `mydb`.`EmpreTrans` (`Ruc`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`ConductorVehiculo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`ConductorVehiculo` (
  `IdConductorVehiculo` INT NOT NULL AUTO_INCREMENT,
  `Fecha` DATE NULL,
  `IdConductor` INT NOT NULL,
  `Placa` VARCHAR(8) NOT NULL,
  PRIMARY KEY (`IdConductorVehiculo`),
  INDEX `fk_ConductorVehiculo_Conductor1_idx` (`IdConductor` ASC),
  INDEX `fk_ConductorVehiculo_Vehiculo1_idx` (`Placa` ASC),
  CONSTRAINT `fk_ConductorVehiculo_Conductor1`
    FOREIGN KEY (`IdConductor`)
    REFERENCES `mydb`.`Conductor` (`IdConductor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ConductorVehiculo_Vehiculo1`
    FOREIGN KEY (`Placa`)
    REFERENCES `mydb`.`Vehiculo` (`Placa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`ProveClien`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`ProveClien` (
  `IdProveClien` INT NOT NULL AUTO_INCREMENT,
  `RazonSocial` VARCHAR(45) NULL,
  `Ruc` BIGINT NULL,
  PRIMARY KEY (`IdProveClien`),
  UNIQUE INDEX `Ruc_UNIQUE` (`Ruc` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Destino`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Destino` (
  `IdDestino` INT NOT NULL AUTO_INCREMENT,
  `Destino` VARCHAR(45) NULL,
  PRIMARY KEY (`IdDestino`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Categoria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Categoria` (
  `IdCategoria` INT NOT NULL AUTO_INCREMENT,
  `Categoria` VARCHAR(45) NULL,
  PRIMARY KEY (`IdCategoria`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Usuario` (
  `DNI` INT NOT NULL,
  `Nombre` VARCHAR(45) NULL,
  `Apellidos` VARCHAR(45) NULL,
  `Usuario` VARCHAR(45) NULL,
  `Contrasena` VARCHAR(45) NULL,
  PRIMARY KEY (`DNI`),
  UNIQUE INDEX `Usuario_UNIQUE` (`Usuario` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Producto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Producto` (
  `IdProducto` INT NOT NULL AUTO_INCREMENT,
  `Producto` VARCHAR(45) NULL,
  `Descripcion` VARCHAR(80) NULL,
  `IdCategoria` INT NOT NULL,
  PRIMARY KEY (`IdProducto`),
  INDEX `fk_Producto_Categoria_idx` (`IdCategoria` ASC),
  CONSTRAINT `fk_Producto_Categoria`
    FOREIGN KEY (`IdCategoria`)
    REFERENCES `mydb`.`Categoria` (`IdCategoria`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Peso`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Peso` (
  `IdPeso` INT NOT NULL AUTO_INCREMENT,
  `TipoMovimiento` VARCHAR(45) NULL,
  `NumGuia` BIGINT NULL,
  `FechaHoraSal` DATETIME NULL,
  `FechaHoraEnt` DATETIME NULL,
  `PesoCE` INT NULL,
  `PesoCS` INT NULL,
  `NetoC` INT NULL,
  `ObservE` VARCHAR(100) NULL,
  `ObservS` VARCHAR(100) NULL,
  `Estado` VARCHAR(45) NULL,
  `DNI` INT NOT NULL,
  `IdProveClien` INT NOT NULL,
  `IdDestino` INT NOT NULL,
  `IdProducto` INT NOT NULL,
  `IdConductorVehiculo` INT NOT NULL,
  PRIMARY KEY (`IdPeso`),
  INDEX `fk_Peso_Usuario1_idx` (`DNI` ASC),
  INDEX `fk_Peso_ProveClien1_idx` (`IdProveClien` ASC),
  INDEX `fk_Peso_Destino1_idx` (`IdDestino` ASC),
  INDEX `fk_Peso_Producto1_idx` (`IdProducto` ASC),
  INDEX `fk_Peso_ConductorVehiculo1_idx` (`IdConductorVehiculo` ASC),
  CONSTRAINT `fk_Peso_Usuario1`
    FOREIGN KEY (`DNI`)
    REFERENCES `mydb`.`Usuario` (`DNI`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Peso_ProveClien1`
    FOREIGN KEY (`IdProveClien`)
    REFERENCES `mydb`.`ProveClien` (`IdProveClien`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Peso_Destino1`
    FOREIGN KEY (`IdDestino`)
    REFERENCES `mydb`.`Destino` (`IdDestino`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Peso_Producto1`
    FOREIGN KEY (`IdProducto`)
    REFERENCES `mydb`.`Producto` (`IdProducto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Peso_ConductorVehiculo1`
    FOREIGN KEY (`IdConductorVehiculo`)
    REFERENCES `mydb`.`ConductorVehiculo` (`IdConductorVehiculo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Guia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Guia` (
  `IdGuia` INT NOT NULL AUTO_INCREMENT,
  `NumGuia` BIGINT NULL,
  `FechaGuia` DATETIME NULL,
  `PesoGE` INT NULL,
  `PesoGS` INT NULL,
  `NetoG` INT NULL,
  `Observ` VARCHAR(100) NULL,
  `IdProveClien` INT NOT NULL,
  PRIMARY KEY (`IdGuia`),
  INDEX `fk_Guia_ProveClien1_idx` (`IdProveClien` ASC),
  CONSTRAINT `fk_Guia_ProveClien1`
    FOREIGN KEY (`IdProveClien`)
    REFERENCES `mydb`.`ProveClien` (`IdProveClien`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
