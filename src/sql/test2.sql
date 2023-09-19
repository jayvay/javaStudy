select * from test1;

show tables;

create table test1 (
	idx int not null auto_increment primary key,
	name varchar(20) not null
);

drop table test1;	--테이블의 구조까지 완전히 삭제(데이터도 삭제)

desc test1;
select * from test1;

insert into test1 values (default, '나미리');
insert into test1 values (default, '채성아');
insert into test1 values (default, '차은주');
insert into test1 values (default, '원장선생님');

insert into test1 values (default, '부원장선생님',50, '떡잎유치원',default);	--age 추가 후 삽입한 레코드라서 age 따로 추가해줘야 함
insert into test1 values (default, '유리', 5, '떡잎마을', '여자');
insert into test1 values (default, '훈이', 5, '떡잎마을', '남자');
insert into test1 values (default, '맹구', 5, '떡잎마을', '남자');
insert into test1 values (default, '짱구', 5, '떡잎마을', '남자');
insert into test1 values (default, '봉미선', 29, '떡잎마을', '여자');
insert into test1 values (default, '신형만', 37, '떡잎마을', '남자');
insert into test1 values (default, '신짱아', 1, '떡잎마을', '여자');
insert into test1 values (default, '흰둥이', 2, '떡잎마을', '남자');
insert into test1 values (default, '철수엄마', 32, '떡잎마을', '여자');
insert into test1 values (default, '유리엄마', 29, '떡잎마을', '여자');
insert into test1 values (default, '훈이엄마', 32, '떡잎마을', '여자');
insert into test1 values (default, '오수', 25, '와르르맨션', '남자');



--DDL (데이터 정의어)
--add column : test1 테이블에 age 컬럼을 추가(int타입, default 15)
alter table test1 add column age int default 15	 --테이블에 필드 추가(add column) //alter table : 필드의 구조를 바꾸는 명령어

--test1 테이블에 addr 컬럼을 추가(varchar(50)타입)
alter table test1 add column addr varchar(50);

--change/modify column :test1 테이블에 address 컬럼을 address로 변경(change/modify)하세요. --필드명을 바꿀 때는 change 
alter table test1 change column addr address varchar(50);

--test1 테이블에 address 컬럼의 varchar(50)을 30Byte로 변경(change/modify)하세요. --구조의 옵션 변경할 때는 modify가 낫다.
alter table test1 modify column address varchar(30);

--drop column : 컬럼 삭제
alter table test1 drop column address;

--address 컬럼 추가
alter table test1 add column address varchar(30) default '서울';

--gender 컬럼 추가
alter table test1 add column gender char(2) default '여자';

--rename : test1 테이블 -> exam 테이블로 이름 변경(rename)
alter table test1 rename exam;
alter table exam rename test1;

--drop table : exam 테이블 삭제(구조를 완전 삭제)
drop table exam;


----------------------------------------------------------------------------------------
--DML (데이터 조작어)

desc test1;

--test1 테이블 내용 보기
select * from test1;

insert into test1 values (default, '철수', 5, '떡잎마을', '남자');

--test1테이블의 '성명/나이' 정보의 모든 레코드를 보여주세요.
select name, age from test1;

--나미리의 나이를 25세로 변경(update 테이블명 set 필드명 = '변경내용' where 조건)
update test1 set age = 25 where name = '나미리';

--원장선생님의 성별을 '남자'로 변경
update test1 set gender = '남자' where name = '원장선생님';
--update test1 set gender = '남자'; --조건을 안 주면 모든 데이터가 바뀌니까 조심해야 해...!

--철수,훈이,맹구,짱구,흰둥이,오수의 성별을 '남자'로 변경
update test1 set gender = '남자' where name = '철수' or name = '훈이' or name = '맹구' or name = '짱구' or name = '흰둥이' or name = '오수';

--나미리,채성아,차은주,원장선생님,부원장선생님의 주소를 '떡잎마을'로 변경 (한번에 바꾸기)
update test1 set address = '떡잎유치원' where name in ('채성아','차은주','원장선생님','나미리'); 
update test1 set age = '52' where name = '원장선생님';
update test1 set age = '25' where name in ('채성아','차은주');

--정렬 : order by 필드명 옵션 		//옵션 생략하면 오름차순(asc)으로 정렬된다. 내림차순은 (desc)
--성명을 오름차순으로 출력하세요.
select * from test1 order by name;
select * from test1 order by name desc;

--나이 내림차순
select * from test1 order by age desc;

--성별 오름차순
select * from test1 order by gender;

--성별 오름차순인데 성별이 같으면 두 번째 키는 성명 내림차순 정렬
select * from test1 order by gender, name desc;

--성별 내림차순 단, 성별 같으면 나이가 적은 사람을 우선적으로 출력하세요.
select * from test1 order by gender desc, age;

--1차 성별 내림차순, 2차 주소 오름차순, 3차 나이 내림차순, 4차 idx 내림차순
select * from test1 order by gender desc, address, age desc, idx desc;

--나이 30대만 출력하세요. : between __ and __
select * from test1 where age >= 30 and age < 40;
select * from test1 where age between 30 and 39;

--30대 남자만 출력하세요.
select * from test1 where age between 30 and 39 and gender = '남자';

--20대 여자를 이름 내림차순으로 출력하세요.
select * from test1 where gender = '여자' and age between 20 and 29 order by name desc;

--나이가 30대이거나 50대인 자료만 출력하세요.
select * from test1 where (age between 30 and 39) or (age between 50 and 59);

--떡잎마을에 살거나 와르르맨션에 사는 사람을 출력하세요. 
select * from test1 where address = '떡잎마을' or address = '와르르맨션' order by address desc;
select * from test1 where address in ('떡잎마을', '와르르맨션');

--떡잎마을에 살거나 와르르맨션에 사는 사람 중에서 나이 10대 이하만 출력하세요.
select * from test1 where (address = '떡잎마을' or address = '와르르맨션') and (age between 1 and 19);

--떡잎마을에 살거나 나이가 20대인 남자만 출력하세요.
select * from test1 where (address = '떡잎마을') or (age between 20 and 29) and (gender = '남자');

--성이 '신'씨만 출력하세요. : like 연산자 - %(복수 개의 와일드카드(여러 개를 대변한다)), _(단수 개의 와일드 카드)
update test1 set name = '신짱구' where name = '짱구';
select * from test1 where name like '신%';

--주소가 '원'으로 끝나는 자료를 출력하세요.
select * from test1 where address like '%원';

--이름 중에서 '짱'을 포함한 모든 자료를 출력하세요.
select * from test1 where name like '%짱%';

--이름 중에서 두 번째 글자가 '미'를 포함한 자료를 출력하세요.
select * from test1 where name like '_미%'

--이름 중에서 두 번째 글자가 '미'를 포함한 자료의 '성명/주소'를 출력하세요.	
select name, address from test1 where name like '_미%';

--자료를 10개만 출력하세요. 제한 : limit
select * from test1 limit 10;

--인덱스번호 4번 자료부터 5개를 출력하세요.(인덱스 번호로 4,5,6,7,8번 자료)
select * from test1 limit 4,5;

--주소가 '원'으로 끝나는 자료의 나이를 1살씩 추가하세요.
update test1 set age = age + 1 where address like '%원';

--떡잎마을에 사는 남자
select * from test1 where address = '떡잎마을' and gender = '남자';

--떡잎마을에 사는 남자를 삭제하세요.
delete from test1 where address = '떡잎마을' and gender = '남자';

--나이가 많은 사람 5명만 출력하세요.
select * from test1 order by age desc limit 5;