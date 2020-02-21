
CREATE TABLE `seah_spring`.`mvc_board` (
  `bno` INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '���� ���̵�' ,
  `writer` VARCHAR(100) NULL COMMENT '�ۼ���',
  `title` VARCHAR(100) NULL COMMENT '�Խñ� ����',
  `content` VARCHAR(1000) NULL COMMENT '�Խñ� ����',
  `hit` INT NULL DEFAULT 0 COMMENT '���� Ŭ�� ī��Ʈ',
  `write_date` DATETIME NULL DEFAULT now() COMMENT '�ۼ���',
  `update_date` DATETIME NULL DEFAULT null ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`bno`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = 'board �ۼ� ���̺�';

insert into mvc_board(writer, title, content) values ('ȫ�浿', '����1', '����1�Դϴ�');

CREATE TABLE `seah_spring`.`member` (
  `mid` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id` VARCHAR(50) NOT NULL,
  `name` VARCHAR(50) NOT NULL,
  `password` VARCHAR(200) NOT NULL,
  `created` DATETIME NULL DEFAULT now(),
  `modified` DATETIME NULL DEFAULT null ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`mid`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

insert into member (user_id, `name`, `password`) values ('test', 'ȫ�浿', password('password123'));