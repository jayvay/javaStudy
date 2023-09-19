-- 18. 'sample' 데이터베이스로 이동한다.(use 데이터베이스명령으로 처리할것)
use sample;
-- 19. 아래와 같은 구조로 테이블을 설계하시오. 테이블명 : hoewon
create table hoewon (
mid varchar(15) not null,
pwd varchar(15) not null,
name varchar(20) not null,
age int default 20,
sex char(2) default '남자',
ipsail datetime default now(),
address varchar(50));
-- 20. hoewon테이블 구조보기
desc hoewon;	
-- 21. hoewon테이블을 삭제한다.
drop table hoewon;	
-- 22. hoewon테이블의 이름을 'sinsang' 테이블로 변경한다.
alter table hoewon rename sinsang;	
-- 23. 모든 테이블 목록보기
show tables;	
-- 24. sinsang테이블에 content 필드를 text 타입으로 추가하시오.
alter table sinsang add column content text; 
-- 25. sinsang테이블 구조보기
desc sinsang;	
-- 26. sinsang테이블에 content 필드를 soge필드로 변경하시오. 타입은 똑같은 text타입이다.
alter table sinsang change column content soge text; 
-- 27. sinsang테이블의 soge필드의 타입을 가변길이 100Byte로 변경하시오.(null값은 허용한다)
alter table sinsang modify column soge varchar(100); 
-- 28. sinsang테이블에 content 필드를 삭제하시오.
alter table sinsang drop column content; 
-- 29. sinsang테이블 구조보기
desc sinsang; 
-- 30. sinsang테이블의 sex필드명을 gender필드명으로 변경하시오.(고정길이문자(2), 기본값(여자))
alter table sinsang change column sex gender char(2) default '여자'; 
-- 31. sinsang테이블 구조보기
desc sinsang;
-- 32. 아래와 같은 자료를 입력시키시오.(순서는 '아이디/비밀번호/성명/나이/성별/입사일/주소') - 입력되는 내용은 복사해서 추가하시오.
insert into sinsang (mid,pwd,name,age,gender,ipsail,address) values ('hong','1234','홍길동',25,'남자','1990-10-05','서울');
insert into sinsang (mid,pwd,name,age,gender,ipsail,address) values ('kim','1234','김말숙',33,'여자','1997-12-3','부산');
insert into sinsang (mid,pwd,name,age,gender,ipsail,address) values ('lee','1234','이순자',24,'여자','1985-7-25','광주');
insert into sinsang (mid,pwd,name,age,gender,ipsail,address) values ('lee1','1234','이기자',40,'남자','1999-10-3','울산');
insert into sinsang (mid,pwd,name,age,gender,ipsail,address) values ('park','1234','박찬호',32,'남자','1980-6-08','대전');
insert into sinsang (mid,pwd,name,age,gender,ipsail,address) values ('bae','1234','배은숙',19,'여자','1993-11-22','마산');
insert into sinsang (mid,pwd,name,age,gender,ipsail,address) values ('son','1234','손기정',45,'남자','1987-12-15','제주');
insert into sinsang (mid,pwd,name,age,gender,ipsail,address) values ('kim1','1234','김영숙',36,'여자','2002-10-5','부천');
insert into sinsang (mid,pwd,name,age,gender,ipsail,address) values ('kim2','1234','김영철',39,'남자','1988-10-05','인천');
insert into sinsang (mid,pwd,name,age,gender,ipsail,address) values ('lee2','1234','이겨라',29,'남자','2000-10-09','서울');
insert into sinsang (mid,pwd,name,age,gender,ipsail,address) values ('son2','1234','손오공',23,'남자','2005-12-15','서울');
-- 33. sinsang테이블의 입력된 모든자료의 내용을 출력하시오.
select * from sinsang;	
-- 34. 32번에서 입력한 모든 자료를 삭제시키는 명령어를 기술하시오.
drop table sinsang;
-- 35. sinsang테이블의 입력된 모든자료의 내용을 출력하시오.(자료가 없으면 다시 입력후 작업할것)
select * from sinsang;
-- 36. 아이디가 'kim'인 자료를 보여주시오.
select * from sinsang where mid = 'kim';
-- 37. 성별이 남자만 보여주시오.
select * from sinsang where gender = '남자';
-- 38. 주소가 '서울'을 보여주시오
select * from sinsang where address = '서울';
-- 39. 주소가 '서울'과 '인천'을 보여주시오
select * from sinsang where address in ('서울','인천');
-- 40. '서울'에 살고있는 '남자'들을 출력하시오.
select * from sinsang where address = '서울' and gender = '남자';
-- 41. sinsang테이블에 'point' 필드를 추가하시오(타입:int, 기본값:1000)
alter table sinsang add column point int default 1000;
-- 42. sinsang 테이블 구조확인?
desc sinsang;
-- 43. sinsang 테이블 내용(모든 레코드) 확인?
select * from sinsang;
-- 44. 여자회원들에 대하여 모두 100 포인씩 추가지급한다.
update sinsang set point = point + 100 where gender = '여자';
-- 45. sinsang 테이블 내용 확인(모든 레코드)?
select * from sinsang;
-- 46. 나이가 35살 이상인 남자회원들만 point를 50포인트씩 추가 지급한다.
update sinsang set point = point + 50 where age >= 35 and gender = '남자';
-- 47. sinsang 테이블 내용 확인(모든 레코드)?
select * from sinsang;
-- 48. 아이디가 'kim1'회원의 주소를 '서울'로 변경처리하시오.
update sinsang set address = '서울' where mid = 'kim1';
-- 49. sinsang 테이블 '아이디'와 '나이'와 '주소' 내용만 확인?
select mid, age, address from sinsang;
-- 50. 2000년 1월 1일 이후(포함)에 입사한 사람들에 대하여 '아이디' 와 '성별', '입사일'을 출력하되, 'mid'는 '아이디'로, 'gender'는 '성별'로, 'ipsail'은 '입사일'이란 필드명으로 출력되게 하시오?
select mid as '아이디', gender as '성별', ipsail as '입사일' from sinsang where date(ipsail) >= '2000-01-01';
-- 51. 다음자료를 추가 입력하시오. : 아이디:park, 비밀번호:1234, 성명:박세리, 나이:35,성별:여자,입사일과 포인트는 기본값으로, 주소: 인천
insert into sinsang values ('park','1234','박세리',35,'여자',default,'인천','',default);
-- 52. 30대인 '여자'의 '아이디'와 '나이'와 '성별'과 '주소'를 출력하시오.
select mid, age, gender, address from sinsang where (age between 30 and 39) and gender = '여자';
-- **참고 :  53번문제를 먼저 풀이하기 전에 sinsang 테이블 내용을 확인하고, 53번 문제와 54번문제 풀이후에 sinsang테이블의 내용을 확인해본다.
select * from sinsang;
-- 53. 서울과 인천지역에 살지 않는 여자회원들에 대하여 포인트를 500씩 더 지급하시오.('같다'의 연산자는 '='이고, '같지않다'의 연산자는 '!=' 입니다.)
update sinsang set point = point + 500 where address != '서울' or address != '인천';
-- 54. 1990년 이전에 입사한 남자회원들에 대하여는 모든 포인트를 회수하시오.
update sinsang set point = 0 where gender = '남자' and date(ipsail) < '1990-01-01';
-- 55. 포인트가 전혀 없는 회원중에서 나이가 40이상인 회원의 '성별'을 '여자'로 변경하시오.
update sinsang set gender = '여자' where point = 0 and age >= 40;
-- 56. '서울'지역 사용자는 비밀번호를 '0000'으로, 포인트는 300점을 추가로 지급하시오.
update sinsang set point = point + 300, pwd = '0000' where address = '서울'; 
-- 57. 포인트가 없고, 남자이면서 1985년 이전에 입사한 회원을 삭제처리하시오.
delete from sinsang where point = 0 and gender = '남자' and date(ipsail) < '1985-01-01';
-- 58. 30대 여자인 자료만 출력하시오.(2가지 방법 모두 기술하기)
select * from sinsang where age between 30 and 39;
select * from sinsang where age >= 30 and age < 40;
-- 59. 주소가 '서울'이거나 '부산'인 사람들의 '이름/나이/성별/주소'필드만을 출력하시오.(2가지 방법 모두 기술하기)
select name,age,gender,address from sinsang where address = '서울' or address = '부산';
-- 60. sinsang 테이블에 자동으로 숫자가 증가할 수 있는 idx필드를 추가해 주시오.
alter table sinsang add column idx int not null auto_increment primary key;
-- 61. 나이 내림차순으로 출력하되, 나이가 같으면, 이름 오름차순으로 출력하고, 만약 이름도 같다면 고유번호 오름차순으로 출력하시오.
select * from sinsang order by age desc , name, idx;
-- 62. sinsang 테이블에 주어진 필드순서대로 다음 레코드를 추가하시오.(성명:홍길공자 , 아이디:hkgj , 비밀번호:1234)
insert into sinsang (name,mid,pwd) values ('홍길공자','hkgj','1234');
-- 63.  sinsang 테이블에서 '홍'씨성을 가진 모든 레코드를 출력하시오.
select * from sinsang where name like '홍%';
-- 64. sinsang 테이블에서 성명이 '자'로 끝나는 모든 레코드를 출력하시오.
select * from sinsang where name like '%자';
-- 65. sinsang 테이블에서 이름중에서 '공'자가 들어있는 모든 레코드를 출력하시오.
select * from sinsang where name like '%공%';
-- 66. sinsang 테이블에서 이름중에서 2번째 글자가 '기' 자를 가진 모든 레코드의 '아이디/이름/성별'필드를 출력하시오.(단, 출력되는 필드명은 mid필드는 '아이디'로, name필드는 '이름', 'gender'필드는 '성별'로 출력하시오.)
select mid as '아이디', name as '이름', gender as '성별' from sinsang where name like '_기%';
-- 67. sinsang 테이블에서 이름중에서 뒤에서 2번째 글자가 '공'인 레코드를 검색하시오.
select * from sinsang where name like '%공_';
-- 68. sinsang 테이블에서 모든자료의 '아이디/성명/성별'을 처음부터 5개만 출력하시오.
select mid, name, gender from sinsang limit 5;
-- 68-2. sinsang 테이블에서 모든자료의 '아이디/성명/성별'을 5번레코드부터 5개만 출력하시오.(단, 출력되는 필드명은 mid필드는 '아이디'로, name필드는 '이름', 'gender'필드는 '성별'로 출력하시오.)
select mid as '아이디', name as '이름', gender as '성별' from sinsang limit 5,5;
-- 69. 68번과 같이 출력하되, 첫번째로 성별 내림차순 출력, 두번째로 이름 오름차순으로 출력하시오.
select mid, name, gender from sinsang order by gender desc, name limit 5;
-- 70. sinsang 테이블에서 나이가 많은 사람순으로 3명만 출력하시오.
select * from sinsang order by age desc limit 3;