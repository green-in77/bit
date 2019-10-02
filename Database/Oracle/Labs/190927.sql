--190927
------------------------------------------------------------------------------
-- 초급 개발자 : 함수, 조인
------------------------------------------------------------------------------
--제 7 장 서브쿼리(SUBQUERY)  100p 92/340
-- sql 만능 해결사 >> sql 꽃
/*
select 5
from 1
where 2
group by 3
having 4
order by 6
*/
--사원테이블에서 사원들의 평균 월급보다 더 많은 급여를 받는 사원의 사번, 이름, 급여 출력
--subquery
select avg(sal) from emp; -- 2073
--main query
select empno, ename, sal
from emp
where sal > 2073;

--query 문 안에 query
select empno, ename, sal
from emp
where sal > (select avg(sal) from emp);
--1. 괄호안에 묶여야 한다.
--2. 결과는 하나의 컬럼
--3. 괄호안에 있는 query 가 먼저 실행되고 결과를 가지고 main query 가 실행됨.

-- 함수(단일테이블) -> 조인(2개이상테이블) -> subquery

/*
subquery
종류
하나의 컬럼으로 나온 결과가*/
--1. single row subquery : subquery의 결과가 1개 row(단일값) : 컬럼 1개
select sum(sal) from emp;
--2. multi row subquery : subquery의 결과가 1개 이상의 row(복수값) : 컬럼 1개
select sal from emp;
/*
구분하는 이유 (사용되는 연산자 차이)
연산자(in, not in)(any, all) : 다중 데이터처리
all : sal > 1000 and sal > 2000 and .......
any : sal > 1000 or sal > 2000 or .......

문법(정의)
1. subquery 는 괄호안에 있어야 한다. >> (select sal from emp)
2. subquery 는 단일 컬럼으로 구성되어야 한다. >> select sum(sal), avg(sal) from emp (X)
3. subquery 단독으로 실행 가능해야 한다.

subquery 를 가지는 쿼리문은
1.subquery 선행
2.subquery 결과를 가지고 mainquery 가 실행된다.
*/

--사원테이블에서 jones의 급여보다 더 많은 급여를 받는 사원의 사번, 이름, 급여
select *
from emp
where sal > (select sal from emp where ename='JONES');

--★★IN 연산자 (조건 or 조건 or 조건 or.....)
select *
from emp
where sal in (select sal from emp where deptno=30);
-- where sal=1600 or sal=1250 or sal=2850 sal=1500 or sal=950
--★★★★★★not in -> 10번도 아니고 20번도 아닌 것. (부정의 and)
select *
from emp
where sal not in (select sal from emp where deptno=30);
-- where sal!=1600 and sal!=1250 and sal!=2850 and sal!=1500 and sal!=950

--부하직원이 있는 사원의 사번과 이름을 출력
select empno, ename
from emp where empno in (select mgr from emp);
--or 연산은 null 상관없음.
--부하직원이 없는 사원의 사번과 이름
select empno, ename
from emp where empno not in (select nvl(mgr,0) from emp);
-- empno!=7902 and empno!=7698 and empno is null and...) >> null
-- nvl또는 in not null을 쓰지 않으면 결과값이 나오지 않음.

--king 에게 보고하는 즉 직속 상관이 king 인 사원의 사번, 이름, 직종, 관리자사번
select empno, ename, job, mgr
from emp
where mgr = (select empno from emp where ename='KING');

--20번 부서의 사원중에서 가장 많은 급여를 받는 사원보다 더 많은 급여를 받는 사원의
--사번, 이름, 급여, 부서번호
select empno, ename, sal, deptno
from emp
where sal > (select max(sal)from emp where deptno = 20);

select * from emp
where deptno in (select deptno from emp where job='SALESMAN')
and sal in (select sal from emp where job='SALESMAN');

--시험

--1. 'SMITH'보다 월급을 많이 받는 사원들의 이름과 월급을 출력하라.
select ename, sal
from emp
where sal > (select sal from emp where ename='SMITH');
 
--2. 10번 부서의 사원들과 같은 월급을 받는 사원들의 이름, 월급,
-- 부서번호를 출력하라.
select ename, sal, deptno
from emp
where sal in (select sal from emp where deptno=10);
 
--3. 'BLAKE'와 같은 부서에 있는 사원들의 이름과 고용일을 뽑는데
-- 'BLAKE'는 빼고 출력하라.
select ename, hiredate
from emp
where deptno = (select deptno from emp where ename='BLAKE')
and ename!='BLAKE';

--4. 평균급여보다 많은 급여를 받는 사원들의 사원번호, 이름, 월급을
-- 출력하되, 월급이 높은 사람 순으로 출력하라.
select empno, ename, sal
from emp
where sal > (select avg(sal) from emp)
order by sal desc;
 
--5. 이름에 'T'를 포함하고 있는 사원들과 같은 부서에서 근무하고
-- 있는 사원의 사원번호와 이름을 출력하라.
select empno, ename
from emp
where deptno in (select deptno from emp where ename like '%T%');

--6. 30번 부서에 있는 사원들 중에서 가장 많은 월급을 받는 사원보다
-- 많은 월급을 받는 사원들의 이름, 부서번호, 월급을 출력하라.
--(단, ALL(and) 또는 ANY(or) 연산자를 사용할 것)★★ 시험문제로 잘나옴... min 은 any 로 풀기.
select ename, empno, sal
from emp
where sal > (select max(sal) from emp where deptno=30);
--
select ename, empno, sal
from emp
where sal > all (select sal from emp where deptno=30);
 
--7. 'DALLAS'에서 근무하고 있는 사원과 같은 부서에서 일하는 사원의
-- 이름, 부서번호, 직업을 출력하라.

select ename, deptno, job
from emp
where deptno in (select e.deptno from emp e join dept d on e.deptno=d.deptno where d.loc='DALLAS');

SELECT ENAME, DEPTNO, JOB
FROM EMP
WHERE DEPTNO IN(SELECT DEPTNO    -- = 이 맞는데  IN
                      FROM DEPT
                      WHERE LOC='DALLAS');
                      
--8. SALES 부서에서 일하는 사원들의 부서번호, 이름, 직업을 출력하라.
select deptno, ename, job
from emp
where deptno in (select e.deptno from emp e join dept d on e.deptno = d.deptno where d.dname='SALES');

SELECT DEPTNO, ENAME, JOB
FROM EMP
WHERE DEPTNO IN(SELECT DEPTNO
                      FROM DEPT
                      WHERE DNAME='SALES')

-- 
select e.deptno, e.ename, e.job
from emp e join dept d on e.deptno = d.deptno where d.dname='SALES';
 
--9. 'KING'에게 보고하는 모든 사원의 이름과 급여를 출력하라
--king 이 사수인 사람 (mgr 데이터가 king 사번)
select ename, sal
from emp
where mgr = (select empno from emp where ename='KING');
 
--10. 자신의 급여가 평균 급여보다 많고, 이름에 'S'가 들어가는
-- 사원과 동일한 부서에서 근무하는 모든 사원의 사원번호, 이름,
-- 급여를 출력하라.
select empno, ename, sal
from emp
where sal > (select avg(sal) from emp)
and deptno in (select deptno from emp where ename like '%S%');
 
--11. 커미션을 받는 사원과 부서번호, 월급이 같은 사원의
-- 이름, 월급, 부서번호를 출력하라.
select ename, sal, deptno
from emp
where deptno in (select deptno from emp where comm is not null)
and sal in (select sal from emp where comm is not null);

--12. 30번 부서 사원들과 월급과 커미션이 같지 않은
-- 사원들의 이름, 월급, 커미션을 출력하라.
select ename, sal, comm
from emp
where sal not in (select sal from emp where deptno=30)
and comm not in (select nvl(comm,0) from emp where deptno=30);

--------------------------------------------------------------------------------------------
/*
5 select
1 from
2 where
3 group by
4 having
6 order by

기본함수 : 문자, 숫자, 날짜, 변환, 일반함수
다중테이블 : Join
subquery

+ DML(insert update, delete) : 암기필수....
*/

--[INSERT, UPDATE, DELETE] 데이터 삽입, 수정, 삭제
/*
오라클기준
DDL(데이터 정의어) : CREATE, ALTER, DROP, TRUNCATE, RENAME, MODIFY --> DBA
DML(데이터 조작어) : INSERT, UPDATE, DELETE --> 개발자
DQL(데이터 질의어) : SELECT --> 개발자 (함수, JOIN, Subquery) 
DCL(데이터 제어어) : 권한(GRANT, REVOKE) --> DBA
TCL(트랜잭션) : COMMIT, ROLLBACK, SAVEPOINT --> 개발자
*/
--DML 작업
--오라클 내부적으로 트랜잭션을 동반 : 
--오라클서버 ( begin tran....) 자동으로~~~ 처리완료(rollback, commit)<--insert ...실행

--트랜잭션(Transaction) : 하나의 논리적은 작업 단위
--업무(트랜잭션)
--은행업무 (A계좌 돈의 1000 인출 B계좌 입금
--하나의 업무단위(A계좌 인출~~~~~~~ B계좌 입금)
/*
시작
  A계좌 update 계좌set 잔액=잔액-출금액
  B계좌 update 계좌 set 잔액=잔액+입금액
끝 commit
끝까지 오지않고 문제가 하나라도 생기면 원점으로 rollback
*/

desc emp; -- 테이블 기본정보
select * from tab; -- 접속 계정이 다룰 수 있는 table 목록
select * from tab where tname='EMP'; --테이블 생성 여부,,, 있는지 없는지
select * from col where tname='EMP';
select * from user_tables; --관리자, 튜닝
select * from user_tables where table_name='DEPT';

--제 10 장 데이터 조작 168p 160/340
INSERT INTO table_name [(column1[, column2, . . . . . ])]
VALUES  (value1[, value2, . . . . . . ]);

create table temp(
id number primary key, --id 컬럼에 date는 null(X),중복값(X) 강제하는 방법==제약 (대표적으로 primary key)
name varchar2(20) --default null
);
 
insert into temp(id,name)
values (100,'홍길동');

select * from temp;
commit;

--2.컬럼 리스트 생략하기
insert into temp --컬럼리스트 생략 -> 대신 values 데이터가 순서대로 들어가짐 -- 되도록 생략하지 말기....
values (200,'김유신');

--1
insert into temp(id,name) --unique constraint (BITUSER.SYS_C007005) violated 중복키 PK제약 위반
values (100,'아무개');

--2
insert into temp(name)--cannot insert NULL into ("BITUSER"."TEMP"."ID") null 값 PK제약 위반
values ('누구야');

--재미^^
--sql 변수, 제어문(x)
--pl-sql(java언어처럼 사용가능)
create table temp2(id varchar2(20));
/*
begin
  for i in 1..1000 loop
  insert into temp2(id) values('A'||to_char(i));
  end loop;
end;
*/
select * from temp2;
select count(*) from temp2;

--
create table temp3(
  memberid number(3) not null,
  name varchar2(10), -- default null
  regdate date default sysdate --컬럼에 데이터를 넣지않아도 시스템 데이터가 들어가짐.
)

insert into temp3(memberid, name, regdate)
values (100,'홍길동','2019-09-27');

select * from temp3;
commit;

insert into temp3(memberid, name)
values (200,'김유신');

insert into temp3(memberid)
values (300);

--옵션 tip
--1.대량데이터 삽입
create table temp4(id number);
create table temp5(num number);

insert into temp4(id) values(1);
insert into temp4(id) values(2);
insert into temp4(id) values(3);
insert into temp4(id) values(4);
insert into temp4(id) values(5);
insert into temp4(id) values(6);
insert into temp4(id) values(7);
insert into temp4(id) values(8);
insert into temp4(id) values(9);
insert into temp4(id) values(10);
commit;
select * from temp4;

--요구사항 : temp4 테이블에 있는 모든 데이터를 temp5에 넣고싶댜.
--insert into 테이블명(컬럼리스트) select --values 대신 selete 구문
--단 컬럼개수와 타입이 일치.

insert into temp5(num)
select id from temp4;

select * from temp5;
commit;

--2.insert 복제개념으로 (clone)
--테이블이 없는 상황에서 [테이블도 자동생성][대량 데이터 삽입]
--단 제약정보는 복사 불가 (Primary key 등..)

--emp >> copyemp 테이블을 만들고 데이터 똑같이..
create table copyemp
as
  select * from emp;
select * from copyemp;

create table copyemp2
as
  select empno, ename, sal
  from emp
  where deptno=30;
select * from copyemp2;

-------------------------------
--구조만 복사하고 데이터는 복사X
create table copyemp3
as
  select * from emp where 1=2; --구조만 있는 테이블 조회...
select * from copyemp3;

commit;
--insert end
--update
UPDATE  table_name
SET  column1 = value1 [,column2 = value2, . . . . . . .]
[WHERE  condition]; 

UPDATE  table_name
SET  (column1, column2, . . . . ) = ( SELECT  column1,column2,... --set 절에 subquery가 올 수 있다.
                                      FROM   table_name
                                      WHERE  coundition)
[WHERE  condition];

select * from copyemp;

update copyemp
set sal=0; --sal 값을 모두 0으로 변경
rollback;

update copyemp
set job='NOT...'
where deptno=20;

select * from copyemp where deptno=20;
commit;

update copyemp
set sal = (select sum(sal) from emp)

select * from copyemp;
rollback;

update copyemp
set ename='AAA', job='BBB', sal=(select sum(sal) from emp)
where deptno=10;

select * from copyemp where deptno=10;
commit;

--update end
--delete
delete from copyemp; --date 만 지우기
select * from copyemp;
rollback;

delete from copyemp
where sal > 3000;
commit;
--delete end

/*
APP(java) --> JDBC API -> Oracle(mysql, ms-sql...)
개발자 : CRUD 작업
Create : insert
Read : select
Update : update
Delete : delete

C U D >> 트랜잭션 동반(commit, rollback)
EMP 테이블 (Oracle)
java
삽입, 수정, 삭제, 전체조회, 조건조회(PK, where empno = 7788)
java 함수 5개

public int insertEmp(Emp emp) { insert into emp .......}
public List<Emp> getEmpList() {select * from emp}
public Emp gerEmpListByEmpno(){select ... where empno=7788}

*/






