--190925
--연산자
--합집합(union) : 테이블과 테이블의 데이터를 합쳐서 보여주는 것.(중복값은 배제)
--합집합(union all) : 중복값을 허용.

create table uta(name varchar2(20));
insert into uta(name) values('AAA');
insert into uta(name) values('BBB');
insert into uta(name) values('CCC');
insert into uta(name) values('DDD');
commit;
select * from uta;

create table ut(name varchar2(20));
insert into ut(name) values('AAA');
insert into ut(name) values('BBB');
insert into ut(name) values('CCC');
commit;
select * from ut;

select name from ut
union --ut한테 uta가 가서 합칠껀데 중복값은 한번만
select name from uta;

select name from ut
union all--ut한테 uta가 가서 합칠껀데 중복 모두 출력
select name from uta;

--union 규칙
--★★1. 대응되는 컬럼의 타입이 동일 ( ut name : varchar2 = uta name : varchar2 )
select empno, ename from emp
union --empno nembr != dname varchar2 union 불가
select dname, deptno from dept;

select empno, ename from emp
union 
select deptno, dname from dept;

--★★2. 대응되는 컬럼의 갯수가 동일 (null 필요)
select empno, ename, job, sal from emp
union --위에는 4, 밑에는 3
select deptno, dname, loc from dept;

select empno, ename, job, sal from emp
union --null 로 컬럼의 갯수를 맞춰줌
select deptno, dname, loc, null from dept;

--오라클 함수 PDF 48page (40/340)
/*
4장 단일행함수
1) 문자형 함수 : 문자를 입력 받고 문자와 숫자 값 모두를 RETURN 할 수 있다.
2) 숫자형 함수 : 숫자를 입력 받고 숫자를 RETURN 한다.
3) 날짜형 함수 : 날짜형에 대해 수행하고 숫자를 RETURN 하는 MONTHS_BETWEEN 함수를 제외하고 모두 날짜 데이터형의 값을 RETURN 한다.
4) 변환형 함수 : 어떤 데이터형의 값을 다른 데이터형으로 변환한다.
5) 일반적인 함수 : NVL, DECODE 
*/

--문자열함수 (자바 스트링클래스와 유사)
select initcap('the super man') from dual; --The Super Man 단어의 첫글자를 대문자로
select lower('AAA'),upper('aaa') from dual; --대문자 -> 소문자 / 소문자 -> 대문자
select ename , lower(ename) as "ename" from emp; -- 컬럼을 전체 함수 적용
select * from emp where lower(ename) = 'king'; --검색 시 해당컬럼의 데이터를 소문자로 바꿔서

--문자의 개수(length)
select length('abcd') from dual; --4개
select length('홍길동바보') from dual; --5개
select length('홍길동  바보') from dual; --7개 공백도 문자

--결합연산자 ||
--결합함수 concat
select 'a' || 'b' || 'c' from dual;
select concat('a','b') from dual;
select concat(ename,job) from emp; -- ename+job 합쳐서 출력
select ename||' '||job from emp;

--부분 문자열 추출
--java(substring)
--oracle(substr)
select substr('ABCDE',2,3) from dual; --BCD 2부터 3글자
select substr('ABCDE',1,1) from dual; --A
select substr('ABCDE',3,1) from dual; --C
select substr('ABCDE',3) from dual; --CDE 3번째부터 끝까지
select substr('ABCDE',-2,1) from dual; --D -2는 뒤에서부터 
select substr('ABCDE',-2,2) from dual; --DE -2는 뒤에서부터 

/*
사원테이블에서 ename 컬럼데이터에 대해서 첫글자는 소문자로 나머지는 대문자로 출력하되
하나의 컬럼데이터로 출력
컬럼의 가명칭:fullname
첫글자와 나머지 문자사이에 공백
ex ) SMITH 결과 : s MITH
*/
select lower(substr(ename,1,1))||' '||upper(substr(ename,2)) as fullname
from emp;

--lpad, rpad(채우기)
--왼쪽채우기, 오른쪽채우기
select lpad('abc',10,'*') from dual; --왼쪽 공백 10 *로 채워서
select rpad('abc',10,'#') from dual; --오른쪽 공백 10 *로 채워서 abc####### ( 총 10글자인데 글씨 이외의 나머지는 채워서 )

--QUIZ
--사용자 비번 : hong1006
--화면에 ho******(앞의 두 글자만 보여주고 나머지는 *로)
select rpad(substr('hong1006',1,2),length('hong1006'),'*') as "password" from dual; --ho****** 총 8자리 중 ho 는 보여주고 나머지는 * 처리

--emp 테이블에서 ename 컬럼의 데이터를 출력하는데 첫글자만 출력하고 나머지는 *로 출력
select rpad(substr(ename,1,1),length(ename),'*') as ename from emp;

create table member2(
id number,
jumin varchar2(14)
);

insert into member2(id,jumin) values (100,'123456-1234567');
insert into member2(id,jumin) values (200,'234567-1234567');
commit;

select * from member2;

--QUIZ 100 : 123456-******* / 200 : 234567-******* 가명칭 : jumin
select id||' : '||rpad(substr(jumin,1,7),length(jumin),'*') as "jumin" from member2;

--rtrim, ltrim
--오른쪽 문자지우기, 왼쪽 문자지우기
select rtrim('MILLER','ER') from dual; --오른쪽에서 뒤의 문자를 찾아서 지우기
select ltrim('MILLLLLLLER','MIL') from dual; -- 왼쪽에서 MIL 을 찾아서 지우는데 중복도 같이 지움. 결과 : ER

--치환함수
--replace
select ename, replace(ename,'A','와우') from emp; -- A를 와우로 변경

--//////////////////////////////////문자열함수 END/////////////////////////////////

--숫자 함수
--round 반올림
--       음수     0    양수
-- (... -3 -2 -1 0 1 2 3 ...)
select round(12.567,0) as "r" from dual; --반올림하는 소수점 자릿수 0 13
select round(12.567,1) as "r" from dual; --반올림하는 소수점 자릿수 1 12.6
select round(12.537,-1) as "r" from dual; --반올림하는 소수점 자릿수 -1 10
select round(15.537,-1) as "r" from dual; --반올림하는 소수점 자릿수 -1 20

--trunc 버림
select trunc(12.567,0) as "t" from dual; --버리는 소수점 자리수 0 12
select trunc(12.567,1) as "t" from dual; --버리는 소수점 자리수 1 12.5
select trunc(12.567,-1) as "t" from dual; --버리는 소수점 자리수 -1 10
select trunc(15.537,-1) as "t" from dual; --버리는 소수점 자리수 -1 10
select trunc(15.537,-2) as "t" from dual; --버리는 소수점 자리수 -2 0

--mod 나머지
select 12/10 from dual; -- 1.2 몫.나머지 함께나옴.

select MOD(12,10) from dual; -- 12를 10로 나눈 나머지 2
select MOD(10,4) from dual; -- 10을 4로 나눈 나머지 2
select MOD(8,4) from dual; -- 8을 4로 나눈 나머지 0
select MOD(0,0) from dual; -- 0을 0로 나눈 나머지 0 ★★ 자바와 다르게 0/0 가능

--////////////////////////////////////숫자함수 END//////////////////////////////////////

--날짜함수
--sysdate
select sysdate from dual;
select hiredate from emp;
--date + number >> date
--date - number >> date
--date - date >> number (일수)

--날짜도 round, trunc 적용가능
select months_between('2019-02-27','2010-02-27') from dual;--개월의 차 108 개월
select round(months_between(sysdate,'2010-01-01'),0) from dual;--117 개월
select trunc(months_between(sysdate,'2010-01-01'),0) from dual;--116 개월

select '2015-01-01' + 1000 from dual; --invalid number 2015-01-01 문자로 취급

select to_date('2015-01-01') + 1000 from dual; --2017-09-27 00:00:00
--to_date 가 날짜로 인식되도록 해줌.

select sysdate + 100 from dual;

--QUIZ
/*
1. 사원테이블에서 사원들의 입사일에서 현재날짜(sysdate) 까지의 근속월수 - 정수만 남기기
2. 한달이 31일 이라고 가정하고 근속월수를 구하세요.
*/

select ename, hiredate, sysdate, trunc(months_between(sysdate, hiredate),0) as "근속월수", trunc((sysdate-hiredate)/31,0) as "근속월수2" from emp;
--                                                                               465                                        456
--///////////////////////////////////////////날짜함수 END/////////////////////////////////////////////////

--변환함수★★★★★★★★★
--oracle : 문자, 숫자, 날짜 데이터
--to_char() : 숫자 10000 -> 문자 $10,000 / 날짜 1900-01-01 -> 문자 1900년01월01일
-- 형식을 정의하는 용도로 사용

--to_date() : 문자 -> 날짜 >> selete '2019-12-12'+100 >>select to_date('2019-12-12)...

--to_number : 문자 -> 숫자 (자동형변환이 되기때문에 잘 쓰지 않음)
select '100' + 100 from dual; -- 200 숫자형 문자
select to_number('100')+100 from dual;

/*
오라클 기본 타입(데이터 타입)
create table 테이블명 (컬럼명  타입 ); 
create table member(age number); 100건 데이터 insert
--java > class member { int age } >> member m = new member(); 1건
--java > List<member> list = new ArrayList<>();   list.add(new member()) 여러건

문자 타입
--char(20) >> 20byte >> 한글10자,  영문자,특수문자,공백 20자  >> 고정길이문자열
--varchar2(20) >>  20byte >> 한글10자,  영문자,특수문자,공백 20자  >> 가변길이문자열

char(20) >> '홍길동' >> 20byte 모두 사용 
varchar2(20) >> '홍길동' >> 공간의 크기 >> 6byte

고정된데이터 : 남 , 여   >> 처리  >> char(2)
결국 >> varchar2(2) 

성능 상의 문제))
char() ..... varchar2() 보다 검색상 우선 ...

결국 문제는 한글
unicode (2byte) : 한글 , 영문자 , 특수문자 , 공백 >> 2byte
nchar(20) >> 20은 문자의 개수  >> 실제 byte *2 >> 40byte
nvarchar2(20) >> 20개의 문자 

한글 20자 , 영문자 20자
*/
select 1 + 1 from dual; --2
select '1' + '1' from dual; --2
select '1A' + '1' from dual; -- 숫자가 아니라서 에러
--------------------------------------------------
select sysdate from dual;
select sysdate||'일' from dual;
select to_char(sysdate) || '일' from dual;

select sysdate,
to_char(sysdate, 'YYYY')||'년' as "YYYY",
to_char(sysdate, 'YEAR'),
to_char(sysdate, 'MM'),
to_char(sysdate, 'DD'),
to_char(sysdate, 'DAY'),
to_char(sysdate, 'DY')
from dual;

--Quiz
--입사일이 12월인 사원들의 사번, 이름 입사일, 입사년도, 입사월을 출력하세요.
select * from emp;
select empno as "사번", ename as "이름", to_char(hiredate,'DD') as "입사일", to_char(hiredate,'YYYY') as "입사년도", to_char(hiredate,'MM') as "입사월"
from emp
where to_char(hiredate,'MM')='12';

select to_char(hiredate,'YYYY"년" MM"월" DD"일"') from emp;

--to_char() : 숫자 -> 문자
--why : 1000000000 ->  $1,000,000,000 이런 형식의 문자데이터 to_char()
select '>' || to_char(12345,'999999999999') || '<' from dual; --숫자 이외의 나머지는 공백처리 >        12345<
select '>' || to_char(12345,'0999999999999') || '<' from dual; --숫자 이외의 나머지 0 처리 > 0000000012345<
select '>' || to_char(12345,'0000000000000') || '<' from dual; -- 0처리                 > 0000000012345<

select '>' || to_char(12345,'$9,999,999,999,999') || '<' from dual; --가장 많이 씀. >            $12,345<

select to_char(sal,'$999,999') as "sal" from emp;

-- 현재 접속 계정 : bituser--

-- 접속계정 HR 로 변경 오른쪽 상단 드롭박스..

select * from employees;
/*
QUIZ
사원테이블에서 사원의 이름은 last_name , first_name 합쳐서 fullname 별칭 부여해서 출력하고
입사일은  YYYY-MM-DD 형식으로 출력하고 연봉(급여 *12)을 구하고 연봉의 10%(연봉 * 1.1)인상한 값을 
출력하고 그 결과는 1000단위 콤마 처리해서 출력하세요
단 2005년 이후 입사자들만 출력하세요 그리고 연봉이 높은 순으로  출력하세요
*/
select employee_id, first_name, last_name, hire_date, salary
from EMPLOYEES;

select employee_id,
       last_name||first_name as "fullname",
       to_char(hire_date,'YYYY-MM-DD') as "hire_date",
       salary * 12 as "연봉",
       to_char(salary*12*1.1,'999,999,999') as "salary"
from employees
where to_number(to_char(hire_date,'YYYY')) >= 2005
--where to_char(hire_date,'YYYY') >= '2005'
order by "연봉" desc;

