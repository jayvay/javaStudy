show tables;

desc sawon;
desc bonbong;
select * from sawon;
select * from bonbong;

create table sawon (
	sabun int not null auto_increment primary key, 
	name varchar(20) not null,
	jikkub char(2) default '사원',
	night	int default 0
);

insert into sawon values (default,'홍길동','대리',1);

create table bonbong (
	jikkub char(2) default '사원',
	bonbong int default 0
);

insert into bonbong values ('대리','300');

alter table bonbong add column sabun int not null auto_increment primary key;

insert into bonbong values ('과장','350',2);

