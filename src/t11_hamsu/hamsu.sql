select * from sungjuk;
select * from test1;
insert into test1 values (default, '강형욱', 25, '남자');

/* 집계함수 */
-- count(필드) : 레코드 개수 구하기
select count(*) from sungjuk;
select count(*) from test1;
select count(idx) from test1;
select count(address) from test1; -- 입력한 address 레코드의 개수만 셈
select count(gender) from test1;
select count(name) from test1;

select count(gender) from test1 where gender = '남자'; -- 남자의 수
select count(gender) from test1 where gender = '여자'; 

select count(address) from test1 where gender = '남자'; -- 남자 중에서 주소의 개수
select count(address) from test1 where gender = '여자';

-- sum() : 합계 (수치 필드만 가능)
select sum(kor) from sungjuk;
select sum(age) from test1 where gender = '남자';

-- avg() : 평균 
select avg(kor) from sungjuk;
select avg(age) from test1 where gender = '남자';

-- max() : 최대
select max(kor) from sungjuk;
select max(age) from test1 where gender = '남자';

-- greatest() : 주어진 수 중에서 가장 큰 값
select greatest(10,20,5,8,45) as 최대값;
select greatest(kor,eng,mat) as '최대점수' from sungjuk;

-- min() : 최소
select min(kor) from sungjuk;
select min(age) from test1 where gender = '남자';

-- least() : 주어진 수 중에서 가장 작은 값
select least(10,20,5,8,45) as 최소값;

-- 집계함수 예제
select avg(kor), avg(eng), avg(mat) from sungjuk;
select max(kor), min(eng), avg(mat) from sungjuk;
select max(kor), min(eng), avg(mat) from sungjuk where kor >= 60;

-- 필드명 as 변수명 : 별명 처리
select max(kor) as 국어최대점수, min(eng) as 영어최소점수, avg(mat) as 수학평균 from sungjuk;

select name, (kor+eng+mat) as tot, (kor+eng+mat)/3 as avg from sungjuk;
select name, (kor+eng+mat) as tot, (kor+eng+mat)/3 as avrg from sungjuk;

-- format(_,소수점 n번 째까지) : 
select max(kor), min(eng), format(avg(mat), 1) from sungjuk;
select format(123.4567, 2);
select format(123.4567, 0);

-- concat() : 문자 결합
select concat('최대 : ',max(kor),'점'), min(eng), format(avg(mat), 1) from sungjuk;
select concat('최대 : ',max(kor),'점') as maxKor, min(eng), format(avg(mat), 1) from sungjuk;

/* 수치함수 */
select 123.456 as su;

-- round() : 반올림
select round(123.456) as su;
select round(123.456) as su1, round(123.556) as su2;
select round(123.456, 1) as su; -- 소수 이하 둘째 자리에서 반올림
select round(123.456, 2) as su; -- 소수 이하 셋째 자리에서 반올림
select round(123.456, -1) as su; -- 정수부 첫째 자리(1의 자리)에서 반올림
select name, (kor+eng+mat)/3 as avg from sungjuk;
select name, round((kor+eng+mat)/3,1) as avg from sungjuk;

-- truncate(_,절삭할 위치) : 절삭 
select truncate(123.456,1) as su; -- 소수 이하 둘째 자리 버림
select truncate(123.456,-1) as su; -- 정수부 첫째 자리(1의 자리) 버림
select truncate(123.456,0) as su; -- 정수부까지만 

-- ceil() : 무조건 올림, floor() : 무조건 버림 //정수부만 나옴
select ceil(123.456), floor(123.456);

-- abs() : 절대값 (무조건 양수)
select abs(123),abs(-123),abs(123.456), abs(-123.456); 

-- mod(_,_) : 나머지
select mod(10,3);

-- 10/3의 몫과 나머지
select truncate(10/3,0) as 몫, mod(10,3) as 나머지;
select floor(10/3) as 몫, mod(10,3) as 나머지;

-- div 연산자 : 몫
select 10 div 3 as 몫;

-- power(_,_) : 거듭제곱(승수)
select power(2,5); -- 2를 5번 곱한다.

/* 문자열 함수 */
-- length() : 문자열 길이
select length('seoul') as 문자열길이;
select length('서울') as 문자열길이; -- 유니코드 utf8 한글 한 글자 당 3개(3byte)
select length('s eoul') as 문자열길이;
select length('서 울') as 문자열길이;	-- 서:3 공백:1 울:3 해서 7

-- char_length() : 문자 길이를 문자 개수로 반환
select char_length('seoul') as 문자열길이;
select char_length('서울') as 문자열길이; 
select char_length('s eoul') as 문자열길이;
select char_length('서 울') as 문자열길이; -- 서:1 공백:1 울:1

-- upper() : 대문자로 변경, lower() : 소문자로 변경
select upper('seOul');
select lower('seOul');
select name, upper(gender) as gender from test1 order by idx desc;

-- substring(필드명이나 변수, 시작위치, 추출할 문자 개수) : 문자열 발췌
select substring('seoul',2); -- 시작 위치(인덱스)가 1부터 (java는 0부터)
select substring('seoul', 2,3); -- 2번째부터 3글자 (java는 2번 인덱스부터 3번 인덱스 전까지) 
select substring('안녕하세요',2);	-- 2번째 글자부터 끝까지 꺼내줘
select substring('안녕하세요',2,3);
select substring(pDate, 1,10) as pDate from sale; -- sale의 pDate 1부터 10글자	(날짜만)
select substring(pDate, 11) as pDate from sale; -- sale의 pDate 11부터 (시간만)

-- substring_index() : 지정된 문자 위치부터 뒤쪽을 모두 버린다
select substring_index('ab.cd.efg','.',2); -- 2번째 .부터 뒤(efg)를 버림

-- left() : 왼쪽 문자열 발췌, right() : 오른쪽 문자열 발췌
select substring('안녕하세요',1,2);
select substring('안녕하세요',2);
select substring('안녕하세요', 3,3); -- 3번째부터 3글자
select right('안녕하세요', 3); -- 오른쪽부터 3글자

-- mid() : 중간 문자 발췌
select mid('abcdefg',3,2); -- 3번째부터 2개
select substring('abcdefg',3,2); -- 3번째부터 2개
select mid('abcdefg',3); 
select substring('abcdefg',3);

-- instr() : 특정문자의 유무, 값이 있으면 인덱스값을, 없으면 0을 반환 (마치 자바의 indexOf)
select instr('abcdefg','c');
select instr('abcdefg','z');
select name, instr(name, '나') from test1; -- 이름에 '나' 들어간 개수

-- replace() : 문자 치환
select replace('Welcome to Korea','Korea','USA');
select replace('Welcome to Korea','korea','USA'); -- 명령어는 대소문자 상관 없지만, 검색하는 문자열은 대소문자 구분해야 함
select replace('Welcome to Korea',' ','');
select replace('Welcome to Korea',' ','_');
select name, address, replace(address,'떡잎마을',' ') from test1;
select name, address, replace(address,'떡잎마을',' ') as address2 from test1;

-- trim() : 문자의 공백 삭제
select trim('  aaabbbccc    ');
select concat('시작','  aaabbbccc    ','끝');
select concat('시작',trim('  aaabbbccc    '),'끝');

-- ltrim() : 왼쪽 공백 무시, rtrim() : 오른쪽 공백 무시
select concat('시작',ltrim('  aaabbbccc    '),'끝');
select concat('시작',rtrim('  aaabbbccc    '),'끝');

-- ascii() : 문자의 아스키 코드값을 출력
select ascii('A'), ascii('a');
select ascii('Apple'), ascii('apple'); -- 첫번째 글자만 비교한다

-- char() : 아스키 코드의 문자값 - MySQL 5.7에서 지원이 안 된대
select char(65), char(97); -- 인터넷에서 검색해봐야겠다

-- elt() : 매개변수(필드)의 위치값을 반환
select elt(2,'a','b','c','d'); -- a, b, c ,d 중에 2번째를 보여줘
select elt(4, kor, eng, mat, (kor+eng+mat)) as tot from sungjuk;

-- insert() : 지정된 위치에 지정한 문자를 대신 채운다.
select insert('가나다라마바사',2,3,'*'); -- 2~3번째 글자가 *로 바뀜
select insert('가나다라마바사',2,3,'***'); -- 바뀌는 글자 개수에 맞춰서 *** 적는 게 좋다

-- repeat() : 반복
select repeat('*',30);
select repeat('abc',10);
select repeat('abc/',10);

-- reverse() : 문자열을 거꾸로 보여줘
select reverse('abcdefg');

-- space() : 공백
select concat('atom',space(10),'btom');

/* 날짜 지정 함수 */
-- now() : 날짜와 시간 표시
select now();

-- year():년, month():월, day():일, hour():시간, minute():분, second():초
select year(now());
select month(now());
select day(now());

select concat(year(now()),'년',month(now()),'월',day(now()),'일');
select concat(year(now()),'년',month(now()),'월',day(now())+1,'일');
select hour(now());
select minute(now());
select second(now());
select pName, pDate from sale;
select pName, pDate, year(pDate) as 년 from sale;
select pName, pDate, concat(year(pDate),'년',month(pDate),'월',day(pDate),'일') as 판매일 from sale;

-- week() : 요일
select week(now()); -- 1월 1일부터 현재까지의 '~주' 표시
select weekday(now()); -- 월:0, 화:1, 수:2, 목:3, 금:4, 토:5, 일:6

-- date_format() : 날짜 형식을 지정한 출력 포멧(%)
-- 서식 기호 - y:연도 2자리, Y:연도 4자리, m:월(숫자), M:월(문자), d:일
-- c: 1자리 월을 1자리로 표시(ex.09를 9로) e: 1자리 일을 1자리로 표시
-- W:영문 요일, w:숫자요일(1:월, 2:화, 3:수, 4:목, 5:금, 6:토, 7:일)
-- h:12시간제, H:24시간제, i:분, s:초
select date_format(now(), '%y%m%d'); 
select date_format(now(), '%Y%m%d'); 
select date_format(now(), '%Y%c%d'); -- 1자리 월
select date_format(now(), '%y-%m-%d'); 
select date_format(now(), '%Y-%m-%d'); 
select date_format('2023-9-5', '%Y-%m-%d');  
select date_format('2023-9-5', '%Y-%c-%e'); -- 1자리 일
select date_format(now(), '%Y-%c-%d'); 
select date_format(now(), '%y년 %m월 %d일');
select date_format(now(), '%Y년 %m월 %d일');
select date_format(now(), '%Y년 %M월 %d일');
select date_format(now(), '%Y년 %M월 %d일 %w요일');
select date_format(now(), '%Y년 %M월 %d일 %w요일 %h시 %i분 %s초');
select date_format(now(), '%Y년 %M월 %d일 %w요일 %H시');
select pName, date_format(pDate, '%Y-%c-%e') from sale;
select date_format(now(), '%h:%i:%s');
select date_format(pDate, '%h:%i:%s') from sale;
select date_format(pDate, '%h:%i %p') from sale;
select date_format(pDate, '%p %h:%i:%s') from sale;
select date_format(pDate, '%H:%i:%s') from sale;

/* 날짜 연산 */
-- date_add(), date_sub(), adddate(), subdate(), addtime(), subtime()
select now();
select date_add(now(), interval 1 day); -- 오늘은 19일인데 +1일
select date_sub(now(), interval 1 day);	-- -1일
select date_add(now(), interval -1 day); -- -1일
select date_add(now(), interval 1 month); -- +1달
select date_add(now(), interval 1 year); -- +1년
select date_add(now(), interval 1 hour); 
select date_add(now(), interval 30 minute); 
select date_add(now(), interval -30 second); 
select date_add(now(), interval 24 hour); 
select date_add(now(), interval -24 hour); 

-- datediff(a,b) : 날짜 비교 (a날짜 형식에서 b날짜 형식을 뺀 결과를 반환)
select datediff(now(),'2023-1-1');
select datediff(now(),'2023-9-1'); -- (19-1)
select datediff('2023-9-1',now()); -- (1-19)
select pName, pDate, datediff(now(), pDate) from sale; -- 판매한지 며칠 됐는지

-- timediff(a,b) : a시간 형식에서 b시간 형식을 뺀 결과를 반환
select timediff(time(now()), '09:20:00');
select timediff('02:41:30', '09:20:00');

-- lastday() : 해당 날짜의 해당 연도의 해당 월의 마지막 일자 구하기
select last_day(now());
select last_day('2023-2-1');

-- time_to_sec() : 현재 시간을 초로 바꾸기 (해당 날짜의 시분초를 초로 바꿈)
select time_to_sec(now());

/* 흐름 제어 함수 */
-- null값 제어 / 비교
-- ifnull(a,b) : a가 null이면 b를 출력하고, null이 아니면 a를 출력
select ifnull(100, 200); 
select ifnull(address, '없음') from test1 order by idx desc; -- 널포인터이셉션 피하기!

-- isnull(), isnotnull() : 결과가 참이면 1, 거짓이면 0을 출력
select name, isnull(address) from test1 order by idx desc;
select name, isnull(address) from test1 where address is null order by idx desc; -- null인 것만 출력
select name, isnull(address) from test1 where address is not null order by idx desc; -- null이 아닌 것만 출력

-- SQL에서 다중 조건 비교
-- select case __ when __ then __ else __ end; //범위는 사용할 수 없음
select case 'S'
	when 'B' then '부장'
    when 'b' then '부장'
	when 'K' then '과장'
	when 'D' then '대리'
	when 'S' then '사원'
	when upper('s') then '사원'
	else '예외'
end as imsi;

select case floor((kor+eng+mat)/(3*10))
	when 10 then 'A'
    when 9 then 'A'
    when 8 then 'B'
    when 7 then 'C'
    when 6 then 'D'
    else 'F'
end as grade;

-- if(조건, 참, 거짓) : 조건비교 (java 삼항연산자처럼 사용)
select if(100>50, '크다', '작다');
select name, if((kor+eng+mat)/3>=60, '합격', '불합격') from sungjuk;
select name, kor, if(kor>=60, 'A', if(kor>=80 , 'B', (if(kor>=70, 'C', if(kor>=60, 'D', 'F'))))) 
as grade from sungjuk;

-- empty 체크 : = '' 같다, != '' 같지 않다
select * from test1 where address = ''; -- 공백 비교
select * from test1 where address is null; -- null비교시에는 isnull
-- select * from test1 where address = null; 은 틀림  
select * from test1 where address = '' or address is null;

-- nullif(수식1,수식2) : 수식1과 수식2가 같다면 null, 아니면 수식1을 반환한다.
select nullif(10,20); -- 10과 20이 다르니까 10
select nullif(10,10); -- 같으니까 null
select * from test1 where nullif(address, '') is null;

/* 시스템 정보 함수 */
select user(); -- DB접속 계정명
select current_user(); -- DB접속 계정명
select session_user();

select database();
show databases;
select schema(); 

select * from test1;

select found_rows(); -- 가장 최근에 검색한 행의 수

select version(); -- mySQL 버전 확인

select sleep(3); -- 바로 수행하지 않고 3초간 정지 후 계속 수행

