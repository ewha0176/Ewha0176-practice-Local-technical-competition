package jdbc;

public class DbCreateManager {
	public DbCreateManager() {
		try {
			DbManager dbmgr = new DbManager();
			dbmgr.setUpdate("CREATE SCHEMA IF NOT EXISTS `2023지방_2` DEFAULT CHARACTER SET utf8 ");
			dbmgr.setUpdate("USE `2023지방_2` ");
			dbmgr.setUpdate(
					"CREATE TABLE IF NOT EXISTS `2023지방_2`.`division` (  `d_no` INT(11) NOT NULL AUTO_INCREMENT COMMENT '고유번호',  `d_name` VARCHAR(50) NULL DEFAULT NULL,  PRIMARY KEY (`d_no`))  ENGINE = InnoDB  AUTO_INCREMENT = 11  DEFAULT CHARACTER SET = utf8");
			dbmgr.setUpdate(
					"CREATE TABLE IF NOT EXISTS `2023지방_2`.`book` (  `b_no` INT(11) NOT NULL AUTO_INCREMENT COMMENT '고유번호',  `b_name` VARCHAR(50) NULL DEFAULT NULL,  `d_no` INT(11) NULL DEFAULT NULL COMMENT 'division',  `b_author` VARCHAR(50) NULL DEFAULT NULL COMMENT '저자',  `b_count` INT(11) NULL DEFAULT NULL COMMENT '재고 권수',  `b_page` INT(11) NULL DEFAULT NULL COMMENT '총 페이지수',  `b_exp` VARCHAR(500) NULL DEFAULT NULL COMMENT '설명',  `b_img` LONGBLOB NULL DEFAULT NULL COMMENT '사진',  PRIMARY KEY (`b_no`),  INDEX `division_idx` (`d_no` ASC) VISIBLE,  CONSTRAINT `division`    FOREIGN KEY (`d_no`)    REFERENCES `2023지방_2`.`division` (`d_no`))  ENGINE = InnoDB  AUTO_INCREMENT = 101  DEFAULT CHARACTER SET = utf8");
			dbmgr.setUpdate(
					"CREATE TABLE IF NOT EXISTS `2023지방_2`.`user` (  `u_no` INT(11) NOT NULL AUTO_INCREMENT COMMENT '고유번호',  `u_name` VARCHAR(5) NULL DEFAULT NULL,  `u_id` VARCHAR(10) NULL DEFAULT NULL,  `u_pw` VARCHAR(10) NULL DEFAULT NULL,  PRIMARY KEY (`u_no`))  ENGINE = InnoDB  AUTO_INCREMENT = 21  DEFAULT CHARACTER SET = utf8");
			dbmgr.setUpdate(
					"CREATE TABLE IF NOT EXISTS `2023지방_2`.`likebook` (  `I_no` INT(11) NOT NULL AUTO_INCREMENT COMMENT '고유번호',  `u_no` INT(11) NULL DEFAULT NULL COMMENT 'user',  `b_no` INT(11) NULL DEFAULT NULL COMMENT 'book',  PRIMARY KEY (`I_no`),  INDEX `user_idx` (`u_no` ASC) VISIBLE,  INDEX `book_idx` (`b_no` ASC) VISIBLE,  CONSTRAINT `book`    FOREIGN KEY (`b_no`)    REFERENCES `2023지방_2`.`book` (`b_no`),  CONSTRAINT `user`    FOREIGN KEY (`u_no`)    REFERENCES `2023지방_2`.`user` (`u_no`))  ENGINE = InnoDB  AUTO_INCREMENT = 203  DEFAULT CHARACTER SET = utf8");
			dbmgr.setUpdate(
					"CREATE TABLE IF NOT EXISTS `2023지방_2`.`rental` (  `r_no` INT(11) NOT NULL AUTO_INCREMENT COMMENT '고유번호',  `u_no` INT(11) NULL DEFAULT NULL COMMENT 'user',  `b_no` INT(11) NULL DEFAULT NULL COMMENT 'book',  `r_date` DATE NULL DEFAULT NULL COMMENT '대출일',  `r_count` INT(11) NULL DEFAULT NULL COMMENT '연장일수(1~14)\\\\\\\\n0 : 미연장',  `r_reading` INT(11) NULL DEFAULT NULL COMMENT '책 읽은 페이지',  `r_returnday` DATE NULL DEFAULT NULL COMMENT '반납일',  PRIMARY KEY (`r_no`),  INDEX `user_idx` (`u_no` ASC) VISIBLE,  INDEX `book_idx` (`b_no` ASC) VISIBLE,  CONSTRAINT `book1`    FOREIGN KEY (`b_no`)    REFERENCES `2023지방_2`.`book` (`b_no`),  CONSTRAINT `user1`    FOREIGN KEY (`u_no`)    REFERENCES `2023지방_2`.`user` (`u_no`))  ENGINE = InnoDB  AUTO_INCREMENT = 158  DEFAULT CHARACTER SET = utf8");
			dbmgr.setUpdate(
					"load data local infile 'C:\\Users\\PCS\\Desktop\\datafiles\\division.csv' into table division");
			dbmgr.setUpdate("load data local infile 'C:\\Users\\PCS\\Desktop\\datafiles\\book.csv' into table book");
			dbmgr.setUpdate(
					"load data local infile 'C:\\Users\\PCS\\Desktop\\datafiles\\likebook.csv' into table likebook");
			dbmgr.setUpdate(
					"load data local infile 'C:\\Users\\PCS\\Desktop\\datafiles\\rental.csv' into table rental");
			dbmgr.setUpdate("load data local infile 'C:\\Users\\PCS\\Desktop\\datafiles\\user.csv' into table user");
			System.out.println("셋팅 성공");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

	}
}