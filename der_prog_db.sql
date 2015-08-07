
-- -----------------------------------------------------
-- Table `sql286097`.`Yerleske`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sql286097`.`Yerleske` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `yerleske_kodu` VARCHAR(45) NOT NULL,
  `yerleske_adi` VARCHAR(45) NOT NULL,
  `adres` VARCHAR(100) NULL,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) ,
  UNIQUE INDEX `yerleske_kodu_UNIQUE` (`yerleske_kodu` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sql286097`.`Fakulte`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sql286097`.`Fakulte` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `fakulte_kodu` VARCHAR(45) NOT NULL,
  `fakulte_adi` VARCHAR(45) NOT NULL,
  `yerleske_kodu` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) ,
  UNIQUE INDEX `fakulte_kodu_UNIQUE` (`fakulte_kodu` ASC) ,
  INDEX `fk_Fakulte_Yerleske1_idx` (`yerleske_kodu` ASC) ,
  CONSTRAINT `fk_Fakulte_Yerleske1`
    FOREIGN KEY (`yerleske_kodu`)
    REFERENCES `sql286097`.`Yerleske` (`yerleske_kodu`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sql286097`.`Bolum`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sql286097`.`Bolum` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `bolum_kodu` VARCHAR(45) NOT NULL,
  `bolum_adi` VARCHAR(70) NOT NULL,
  `fakulte_kodu` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) ,
  UNIQUE INDEX `bolum_kodu_UNIQUE` (`bolum_kodu` ASC) ,
  INDEX `fk_Bolum_Fakulte1_idx` (`fakulte_kodu` ASC) ,
  CONSTRAINT `fk_Bolum_Fakulte1`
    FOREIGN KEY (`fakulte_kodu`)
    REFERENCES `sql286097`.`Fakulte` (`fakulte_kodu`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sql286097`.`Derslik`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sql286097`.`Derslik` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `derslik_kodu` VARCHAR(45) NOT NULL,
  `derslik_adi` VARCHAR(45) NOT NULL,
  `bolum_kodu` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`) ,
  INDEX `fk_Derslik_Bolum1_idx` (`bolum_kodu` ASC) ,
  UNIQUE INDEX `derslik_kodu_UNIQUE` (`derslik_kodu` ASC) ,
  CONSTRAINT `fk_Derslik_Bolum1`
    FOREIGN KEY (`bolum_kodu`)
    REFERENCES `sql286097`.`Bolum` (`bolum_kodu`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sql286097`.`Donem`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sql286097`.`Donem` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `donem_kodu` VARCHAR(45) NOT NULL,
  `donem_adi` VARCHAR(90) NOT NULL,
  `baslangic_tarihi` DATETIME NULL,
  `bitis_tarihi` DATETIME NULL,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `donem_kodu_UNIQUE` (`donem_kodu` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sql286097`.`Ders`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sql286097`.`Ders` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `ders_kodu` VARCHAR(45) NOT NULL,
  `donem_kodu` VARCHAR(45) NOT NULL,
  `bolum_kodu` VARCHAR(45) NOT NULL,
  `ders_adi` VARCHAR(90) NOT NULL,
  `kredi` INT NULL,
  `akts` INT NULL,
  PRIMARY KEY (`id`) ,
  INDEX `fk_Ders_Bolum1_idx` (`bolum_kodu` ASC) ,
  INDEX `fk_Ders_Donem1_idx` (`donem_kodu` ASC) ,
  UNIQUE INDEX `ders_kodu_UNIQUE` (`ders_kodu` ASC) ,
  CONSTRAINT `fk_Ders_Bolum1`
    FOREIGN KEY (`bolum_kodu`)
    REFERENCES `sql286097`.`Bolum` (`bolum_kodu`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Ders_Donem1`
    FOREIGN KEY (`donem_kodu`)
    REFERENCES `sql286097`.`Donem` (`donem_kodu`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sql286097`.`Ders_tarihi`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sql286097`.`Ders_tarihi` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `ders_kodu` VARCHAR(45) NOT NULL,
  `derslik_kodu` VARCHAR(45) NOT NULL,
  `baslangic_tarihi` DATETIME NULL,
  `bitis_tarihi` DATETIME NULL,
  `donem_kodu` VARCHAR(45) NULL,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `Derslik_kodu_UNIQUE` (`derslik_kodu` ASC) ,
  INDEX `fk_Ders_tarihi_Ders1_idx` (`ders_kodu` ASC) ,
  CONSTRAINT `fk_Ders_tarihi_Derslik1`
    FOREIGN KEY (`derslik_kodu`)
    REFERENCES `sql286097`.`Derslik` (`derslik_kodu`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Ders_tarihi_Ders1`
    FOREIGN KEY (`ders_kodu`)
    REFERENCES `sql286097`.`Ders` (`ders_kodu`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sql286097`.`Yonetici`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sql286097`.`Yonetici` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `yonetici_kodu` VARCHAR(45) NOT NULL,
  `adi` VARCHAR(45) NOT NULL,
  `soyadi` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `parola` VARCHAR(45) NOT NULL,
  `yetki` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `yonetici_kodu_UNIQUE` (`yonetici_kodu` ASC) ,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sql286097`.`Akademisyen`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sql286097`.`Akademisyen` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `akademisyen_kodu` VARCHAR(45) NOT NULL,
  `adi` VARCHAR(45) NOT NULL,
  `soyadi` VARCHAR(45) NOT NULL,
  `unvani` VARCHAR(45) NULL,
  `email` VARCHAR(45) NOT NULL,
  `parola` VARCHAR(45) NOT NULL,
  UNIQUE INDEX `akademisyen_kodu_UNIQUE` (`akademisyen_kodu` ASC) ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sql286097`.`Ogrenci`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sql286097`.`Ogrenci` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `ogrenci_no` VARCHAR(45) NOT NULL,
  `adi` VARCHAR(45) NOT NULL,
  `soyadi` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `parola` VARCHAR(45) NOT NULL,
  `donem_kodu` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) ,
  INDEX `fk_Ogrenci_Donem1_idx` (`donem_kodu` ASC) ,
  CONSTRAINT `fk_Ogrenci_Donem1`
    FOREIGN KEY (`donem_kodu`)
    REFERENCES `sql286097`.`Donem` (`donem_kodu`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sql286097`.`Akademisyen_ders`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sql286097`.`Akademisyen_ders` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `akademisyen_kodu` VARCHAR(45) NOT NULL,
  `ders_kodu` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`) ,
  INDEX `fk_Akademisyen_ders_Akademisyen1_idx` (`akademisyen_kodu` ASC) ,
  INDEX `fk_Akademisyen_ders_Ders1_idx` (`ders_kodu` ASC) ,
  CONSTRAINT `fk_Akademisyen_ders_Akademisyen1`
    FOREIGN KEY (`akademisyen_kodu`)
    REFERENCES `sql286097`.`Akademisyen` (`akademisyen_kodu`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Akademisyen_ders_Ders1`
    FOREIGN KEY (`ders_kodu`)
    REFERENCES `sql286097`.`Ders` (`ders_kodu`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sql286097`.`Ogrenci_ders`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sql286097`.`Ogrenci_ders` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `ders_kodu` VARCHAR(45) NOT NULL,
  `ogrenci_no` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`) ,
  INDEX `fk_Ogrenci_ders_Ders1_idx` (`ders_kodu` ASC) ,
  INDEX `fk_Ogrenci_ders_Ogrenci1_idx` (`ogrenci_no` ASC) ,
  CONSTRAINT `fk_Ogrenci_ders_Ders1`
    FOREIGN KEY (`ders_kodu`)
    REFERENCES `sql286097`.`Ders` (`ders_kodu`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Ogrenci_ders_Ogrenci1`
    FOREIGN KEY (`ogrenci_no`)
    REFERENCES `sql286097`.`Ogrenci` (`ogrenci_no`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sql286097`.`Ogrenci_bolum`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sql286097`.`Ogrenci_bolum` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `ogrenci_no` VARCHAR(45) NOT NULL,
  `bolum_kodu` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`) ,
  INDEX `fk_ogrenci_bolum_Bolum1_idx` (`bolum_kodu` ASC) ,
  INDEX `fk_ogrenci_bolum_Ogrenci1_idx` (`ogrenci_no` ASC) ,
  CONSTRAINT `fk_ogrenci_bolum_Bolum1`
    FOREIGN KEY (`bolum_kodu`)
    REFERENCES `sql286097`.`Bolum` (`bolum_kodu`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ogrenci_bolum_Ogrenci1`
    FOREIGN KEY (`ogrenci_no`)
    REFERENCES `sql286097`.`Ogrenci` (`ogrenci_no`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
