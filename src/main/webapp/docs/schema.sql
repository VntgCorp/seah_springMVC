## Table 스키마

CREATE TABLE `seah_spring`.`mvc_board` (
  `bno` INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '보드 아이디' ,
  `writer` VARCHAR(100) NULL COMMENT '작성자',
  `title` VARCHAR(100) NULL COMMENT '게시글 제목',
  `content` VARCHAR(1000) NULL COMMENT '게시글 내용',
  `hit` INT NULL DEFAULT 0 COMMENT '내용 클릭 카운트',
  `write_date` DATETIME NULL DEFAULT now() COMMENT '작성일',
  `update_date` DATETIME NULL DEFAULT null ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`bno`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = 'board 작성 테이블';

insert into mvc_board(writer, title, content) values ('홍길동', '제목1', '내용1입니다');

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

insert into member (user_id, `name`, `password`) values ('test', '홍길동', password('password123'));