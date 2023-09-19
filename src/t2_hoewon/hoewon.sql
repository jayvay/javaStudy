show tables;

create table hoewon (
	idx int not null auto_increment primary key,
	name varchar(20) not null,
	age int default 20,
	address varchar(50),
	gender char(2) default '여자'
);

desc hoewon;

insert into hoewon values (default, '유리', 5, '떡잎마을', '여자');
insert into hoewon values (default, '훈이', 5, '떡잎마을', '남자');
insert into hoewon values (default, '맹구', 5, '떡잎마을', '남자');
insert into hoewon values (default, '짱구', 5, '떡잎마을', '남자');
insert into hoewon values (default, '봉미선', 29, '떡잎마을', '여자');
insert into hoewon values (default, '신형만', 37, '떡잎마을', '남자');
insert into hoewon values (default, '신짱아', 1, '떡잎마을', '여자');
insert into hoewon values (default, '흰둥이', 2, '떡잎마을', '남자');
insert into hoewon values (default, '철수엄마', 32, '떡잎마을', '여자');
insert into hoewon values (default, '유리엄마', 29, '떡잎마을', '여자');
insert into hoewon values (default, '훈이엄마', 32, '떡잎마을', '여자');
insert into hoewon values (default, '오수', 25, '와르르맨션', '남자');

select * from hoewon;

