--190924
---[1일차]
SELECT [DISTINCT]  {*, column [alias], . . .}
FROM  table_name
[WHERE  condition]
[ORDER BY {column, expression} [ASC | DESC]]; 
/*
[] = 대괄호는 생략 가능하다.
{} = 반드시 있어야 한다.

DISTINCT  중복 행 제거 옵션 
*   테이블의 모든 column 출력 
alias   해당 column 에 대한 다른 이름 부여 
table_name 테이블명 질의 대상 테이블 이름 
WHERE   조건을 만족하는 행들만 검색 
condition  column, 표현식, 상수 및 비교 연산자 
ORDER BY  질의 결과 정렬을 위한 옵션(ASC:오름차순(Default),DESC 내림차순)
*/
--1. 사원테이블에 있는 모든 데이터를 출력하세요.
select * from emp;
SELECT * FROM EMP; --쿼리문은 대소문자 구분하지 않음.

--2. 특정 컬럼 데이터 추출하기
select empno, ename, job, sal from emp;
select empno from emp;
select hiredate, deptno from emp;

--3. 컬럼에 가명칭(alias) 부여하기
select empno 사번, ename 이름 from emp;
--select empno 사    번, ename 이    름 from emp;
--위의 띄어쓰기 인식불가
select empno "사    번", ename "이    름" from emp;
--쌍따음표로 묶으면 문자열로 인식(정식표현은 아님..)

--정식문법(ansi 표준) >> 권장사항 as
select empno as "사    번", ename as "이    름" from emp;

--oracle : 문자열 데이터 ( 엄격하게 대소문자 구분 )
--데이터 : a≠A 다른 문자
--문자열(문자) 데이터 : ''
select * from emp where ename='king'; -- 소문자 king 없음
select * from emp where ename='King'; -- King 없음
select * from emp where ename='KING'; -- 대문자 KING 있음

--oracle : 연산자(결합 연산자) >> || >> 'hello' || 'world' >> 결합 'helloworld'
--java : + 산술&결합 10 + 10 (산술) / "A"+"B" (결합)
--TIP) ms-sql : + 연산&결합

--oracle 에서 "" 쓰는 것은 가명칭 밖에 없음..
select '사원의 이름은 ' || ename || ' 입니다.' as "이   름"
from emp;

--java : class Emp {private int empno;}
--POINT : 오라클의 컬럼은 타입 정보를 갖는다.
--현재 내가 가지고 있는 emp 테이블의 정보를 보는 방법
desc emp; -- emp 컬럼의 타입 정보

select empno + ename as "결합" -- 오라클 + 는 무조건 산술연산
from emp; --invalid number ename 데이터가 숫자가 아니라 연산을 못한다...

select empno || ename as "결합" -- 숫자 || 문자 결합 가능 - 실제 내부적으로 자동형변환(숫자 -> 문자) to_char() 함수 동작
from emp;

--직종 종류(직종이 몇개나 있나??)
select job from emp;
--중복 데이터 제거 키워드 : distinct
select distinct job from emp;
select distinct deptno from emp;

----★★distinct 원리 ( 컬럼이 2개 이상 ) -- grouping (그림그려서 이해하기...)
select job,deptno from emp order by job;
select distinct job, deptno from emp order by job;
--두가지 다 맞는 것만 중복으로 취급
--1. job 으로 그룹을 잡고, deptno 로 또 그룹을 잡음.
--order by : 정렬
select distinct deptno, job from emp order by deptno;

--오라클(언어) (SQL 구조화된 질의를 할 수 있는 언어)
--java 도 언어. (연산자)
--오라클도 연산자(자바와 80% 정도 일치)
--java % 나머지 -> 오라클 % 검색의 패턴자원으로 활용 >>
-- 오라클 나머지 연산 함수사용 : Mod()
--oracle (+,-,*,/) + mod()

--사원테이블에서 사원의 급여를 100달러 인상한 결과를 출력하세요.
desc emp;
select empno, ename, sal, sal + 100 as "인상급여"
from emp;

------------재미로~~--------
select 100 + 100 from dual; -- 값을 임시로 담는 테이블 dual(test 시 사용)
select 100 || 100 from dual; -- || 문자열 결합으로 처리. ( 100100 )
select '100' + 100 from dual; -- +는 산술연산이라 문자100을 숫자100으로 형변환
select 'A100'+100 from dual; -- error A는 문자라 산술처리 불가.

--비교연산자
-- > , < , <= ....
--java 같다 == ,  할당 =
--javascript 같다 ===
--오라클 같다 = , 같지않다 !=

--논리연산자
-- AND, OR, NOT

/*
SELECT [DISTINCT]  {*, column [alias], . . .}
FROM  table_name
[WHERE  condition]
[ORDER BY {column, expression} [ASC | DESC]]; 
*/

--조건절 ( 원하는 row만 가지고 온다 )
--실행순서 from -> where -> select 
select *            --3
from emp            --1
where sal >= 3000;  --2

--이상, 이하 ( = 포함 )
--초과, 미만

--사번이 7788번인 사원의 사번, 이름, 직종, 입사일을 출력하세요.
select empno, ename, hiredate -- 3번 쓰고
from emp                      -- 1번 먼저쓰고
where empno=7788;             -- 2번 쓰고

--사원의 이름이 KING 인 사원의 사번, 이름 급여 정보 출력
select empno, ename, sal 
from emp
where ename = 'KING';

--급여가 2000달러 이상이면서 직종이 maneger 인 사원의 모든 정보
--AND OR NOT
select *
from emp
where sal >= 2000 and job='MANAGER';

--급여가 2000달러 이상이거나 직종이 maneger 인 사원의 모든 정보
select *
from emp
where sal >= 2000 or job='MANAGER';

--오라클날짜 = DB서버의 날짜
--시스템 : 날짜를 가지고 있다 >> sysdate
select sysdate from dual; --오라클DB의 시간 19/09/24 (PC의 날짜가 아님)
--표기는 fomating을 통해 바꿀 수 있음.
--게시판 글쓰기 : insert into board(writer, title, content, regdata)
--              values('홍길동', '방가방가', '배고프다', systate);
--TIP) ms-sql >> selest getdate() 함수로 만들어둠.

select hiredate from emp;
desc emp; --DATE
--오라클 [시스템정보] 를 담고 테이블을 별도로 관리
--환경설명
select * from SYS.NLS_SESSION_PARAMETERS;
-- NLS_LANGUAGE	KOREAN
-- NLS_DATE_FORMAT	RR/MM/DD -> 변경도 가능.
-- NLS_DATE_LANGUAGE	KOREAN
-- NLS_TIME_FORMAT	HH24:MI:SSXFF

select * from SYS.NLS_SESSION_PARAMETERS where parameter = 'NLS_DATE_FORMAT';
--POINT
--서버기준에서 설정 변경 가능 (DBA)
--현재 접속한 사용자(session) 를 기준으로 변경적용
--다른 곳에서 bituser 로 접속하면 날짜형식은 변경되지않고 그대로 유지됨..
--재접속시 다시 원상태의 형식으로 돌아옴.

alter session set nls_date_format='YYYY-MM-DD HH24:MI:SS'; -- 변경
select * from SYS.NLS_SESSION_PARAMETERS where parameter = 'NLS_DATE_FORMAT'; -- 변경확인

--NLS_DATE_FORMAT	YYYY-MM-DD HH24:MI:SS
select sysdate from dual; --2019-09-24 11:51:51
select hiredate from emp; --1980-12-17 00:00:00 출력형식변경됨.

select *
from emp
where hiredate='1980-12-17'; --날짜 형식 표현 (문자동일)

select *
from emp
where hiredate='1980/12/17'; -- 구분자 하이픈- 또는 슬러쉬/ 둘다 사용가능

select * from emp;
select *
from emp where hiredate='80-12-17'; -- 날짜 형식을 변경해놨기 때문에 조회 불가.
--RR/MM/DD -> YYYY/MM/DD

-- 사원의 급여가 2000달러 이상이고 4000달러 이하인 모든 사원의 정보
select *
from emp
where 2000<=sal and sal<=4000;
--★★연산자 : 컬럼명 between A and B (** =을 포함, 이상이하만 가능 - 초과미만은 불가)
select *
from emp
where sal between 2000 and 4000;

--사원의 급여가 2000 초과 4000 미만
select *
from emp
where 2000<sal and sal<4000;

--부서번호가 10번 또는 20번 또는 30번인 사원의 사번, 이름, 급여, 부서번호 출력
select empno, ename, sal, deptno
from emp
where deptno=10 or deptno=20 or deptno=30;
--★★IN 연산자 (조건 or 조건 or 조건 or.....)
select empno, ename, sal, deptno
from emp
where deptno in (10,20,30);

--부서번호가 10번 또는 20번이 아닌 사원의 사번, 이름, 급여, 부서번호 출력
--10번도 아니고 20번도 아닌 것.
SELECT empno, ename, sal, deptno
from emp
where deptno!=10 and deptno!=20;
--★★ NOT IN 연산자
SELECT empno, ename, sal, deptno
from emp
where deptno not in (10,20);

--Point : 값이 없다(데이터가 없다) = null
-- null (필요악)

create table member( --table 생성
userid varchar2(20) not null, --한글 10자(20byte), null불가 데이터 반드시 넣어야함.
name varchar2(20) not null,
hobby varchar2(20) -- default >> null (null값 허용) : 필수입력 아님.
);

desc member;

insert into member(userid, name) values('hong','홍길동');
select * from member;

insert into member(userid, hobby) values('kim','농구');
--ORA-01400: cannot insert NULL into 

insert into member(userid, name, hobby) values('pqck','박군','축구');
select * from member;

--실제반영
commit;
select * from member;

--수당을 받지 않는 모든 사원의 정보를 출력
--null은 다른 연산자를 갖는다... is null ( comm = null 없음XXXXXXXXXX )
select *
from emp
where comm is null; -- null 비교는 ★is null★

--수당을 받는 모든 사원의 정보 (null 이 아닌 사람)
select *
from emp
where comm is not null;

--사원테이블에서 사번, 이름, 급여, 수당, 총급여 출력 (총급여=급여+수당)
select empno, ename, sal, comm, sal+comm as "총급여" -- null 연산 안됨....
from emp;

--Point(null)
--★★ null 과의 모든 연산은 그 결과가 : null
--★★★★★★ nvl() ★★★★★★★ - nul2()
-- null을 만나면 대체값으로 바꿔라.
--ms-sal : convert() / my-sql : IFNULL()

select 1000 + null from dual;
select 1000 + nvl(null,0) from dual; -- null 을 0으로
select 1000 + nvl(null,1111) from dual; --null 을 1111로

select 'A' || null from dual; -- || 문자열 결합. A

select comm, nvl(comm,0) from emp;
--★★★★★★★★★★★★★★★★
select empno, ename, sal, comm, sal+nvl(comm,0) as "총급여"
from emp;
--★★★★★★★★★★★★★★★★

--사원의 급여가 1000 이상이고 수당을 받지않는 사원의 사번, 이름, 직종, 급여, 수당 출력
select empno, ename, job, sal, comm
from emp
where sal >= 1000 and comm is null;

--DQL (data query language) : select
--DDL : create alter, drop (객체를 생성, 수정, 삭제)

create table board(
boardid number not null,
title varchar2(20) not null, --영문자,특수,공백 : 1byte / 한글 : 2byte
content varchar2(2000) not null,
hp varchar2(20)
);
desc board;

--DML(데이터 조작어) : insert, update, delete
--작업시에는 [실제반영] 이나 취소처리를 위해 (commit, rollback) 반드시 사용
insert into board(boardid, title, content)
values(100,'오라클','참쉽네');
commit;

insert into board(boardid, title, content)
values(200,'오클','참네');

insert into board(boardid, title, content)
values(300,'자바','참네');
ollback;

select * from board;

--insert, update, delete 작업 오라클(무조건 commit, rollback 작업 반드시)
--ms-sql(Auto commit) >> default commit; begin tran ~~~ commit or rollback

select BOARDID,hp, nvl(hp,'핸드폰 없어요') as "hp" -- nvl 문자에도 적용 가능하다.
from board;
-- nvl함수는 숫자,날짜,문자에도 적용 가능하다.

--문자열 검색
--주소검색 : '역삼' 검색하면 역삼 글자에 들어있는 주소가 다 나온다.
--문자열 패턴 검색(LIKE 연산자)

--like 연산자 (와일드 카드 문자 [ % : 모든것, _ : 한문자] 결합

select *
from emp
--where ename like '%A%'; --A 가 들어있는 모든 이름 검색
where ename like 'A%'; --A 로 시작하는.
--where ename like '%A%A%'; --AA , ABA

select *
from emp
--where ename like '_A%'; --첫번째 문자 관계없고, 두번째 문자부터 A가 포함되는 것.
where ename like '__A%'; --1,2 문자 관계없고, 3문자부터 A가 포함되는 것.


--오라클 과제 (regexp_like) 상세한 패턴 검색
--select * from emp where regexp_like (ename, 정규표현식);
--오라클 정규표현사용 검색 패턴 만들기 (조별3개) : 중간프로젝트 반영......


--데이터 정렬하기
--order by 컬럼명 (문자, 숫자, 날짜) asc or desc
--오름차순 : asc 낮은순 정렬 (default)
--내림차순 : desc 높은순 정렬

select * from emp order by sal; --급여가 낮은순으로... asc 기본
--select * from emp order by sal asc;

--급여를 많이 받는 순으로 정렬
select * from emp order by sal desc;

--A 부터...문자열 정렬
select * from emp order by ename asc;

--입사일이 가장 늦은 순으로 정렬 사번, 이름, 급여, 입사일
select empno, ename, sal, hiredate
from emp
order by hiredate desc;

/*
select 3
from 1
where 2
order by 4 --select 한 결과를 정렬
*/

select empno, ename, sal, job, hiredate
from emp
where job='MANAGER'
order by hiredate desc;
-- 직종이 매니저인 데이터의 사번,이름,급여,직종,입사일을 입사일이 늦은 순으로 정렬해서

select deptno, job
from emp
order by deptno desc, job asc; --정렬 2개
-- 사원테이블에서 부서번호, 직종을 출력하되 부서번호 내림차순, 직종을 오름차순으로

select DISTINCT job
from emp;