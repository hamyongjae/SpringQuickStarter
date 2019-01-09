CREATE TABLE BOARD(
	SEQ INT PRIMARY KEY,
	TITLE VARCHAR(200),
	WRITER VARCHAR(20),
	CONTENT VARCHAR(2000),
	REGDATE DATETIME DEFAULT CURRENT_TIMESTAMP,
	CNT INT DEFAULT 0
);

CREATE TABLE USERS(
	ID VARCHAR(8) PRIMARY KEY,
	PASSWORD VARCHAR(8),
	NAME VARCHAR(20),
	ROLE VARCHAR(5)
);

insert into USERS value ("gkadydwo", "1234","함용재","1");
insert into USERS value ("yongjae2", "1111","함용재","개발자");
update board set title="테스트글1 바껴라!", content="바껴라!" where seq=15;
insert into 
SELECT * FROM USERS;
select SEQ from board;
desc board;
delete from board where seq=1
DROP TABLE board;

select * from board where title like '%'||'무멜'||'%' order by seq desc;
select * from board where content like '%'||?||'%' order by seq desc;

