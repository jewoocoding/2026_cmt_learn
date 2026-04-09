--데이터베이스 스키마
create table tb_board(
                         id int PRIMARY KEY AUTO_INCREMENT,
                         title varchar(100),
                         author varchar(20),
                         contents text,
                         viewCount int,
                         regdate DATE NOT NULL,
                         is_deleted bool DEFAULT 0
);
--더미데이터 생성
INSERT INTO tb_board (title, author, contents, viewCount, regdate, is_deleted) VALUES
                                                                                   ('첫 번째 게시글입니다', 'admin', '게시판 API 테스트를 위한 첫 번째 더미 데이터입니다.', 0, '2026-04-09', 0),
                                                                                   ('Spring Boot 게시판', 'jun', 'Spring Boot와 MyBatis를 활용한 게시판 구현 예제입니다.', 3, '2026-04-09', 0),
                                                                                   ('목록 조회 테스트', 'user1', '페이징 및 목록 조회 기능 확인용 데이터입니다.', 5, '2026-04-08', 0),
                                                                                   ('수정 기능 테스트', 'user2', '게시글 수정 API 동작 확인을 위한 샘플 데이터입니다.', 1, '2026-04-08', 0),
                                                                                   ('삭제 기능 테스트', 'tester', '소프트 삭제 또는 삭제 API 테스트용 게시글입니다.', 2, '2026-04-07', 0);
