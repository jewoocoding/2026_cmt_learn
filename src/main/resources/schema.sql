--게시글 테이블
create table tb_board(
                         id int PRIMARY KEY AUTO_INCREMENT,
                         title varchar(100),
                         author varchar(20),
                         contents text,
                         viewCount int,
                         regdate DATE NOT NULL
);