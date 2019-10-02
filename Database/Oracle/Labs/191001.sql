--191001
--제 12 장 VIEW 192p 185/340
--view 가상테이블 : 물리적X, 잠시 메모리에 올려서 사용함.
--View 객체 (create 로 생성)
create view 뷰이름 as [view 가 보는 자원목록(select 절)]
--view는 테이블처럼 사용 가능(가상테이블) => 실제 emp, dept 같은 테이블과 사용법이 동일
--view는 메모리상에만 존재하는 가상 테이블(subquery -> in line view -> 실제 테이블처럼 사용 고급기능)
--view = sql 문장 덩어리

--사용법은 일반 테이블과 동일 select from where ....
--DML>>view 를 통해서 물리적인 테이블에 접근... insert, update, delete 가능하지만 되도록 사용하지 말기...

--view 장점
--개발자의 편리성(join, subquery - 쿼리문 쉽게..
--복잡한 쿼리 단순화
--보안(권한별로 처리)

create view v_001--ORA-01031: insufficient privileges
as
  select empno, ename from emp; -- bituser 에는 view 를 쓸 수 있는 권한이 없음..
--사용자편집->시스템권한-> CREATE ANY VIEW	true	true

select * from v_001; --실제로는 view 가 가지고 있는 sql 문장이 실행되는 것.
--view 가 볼 수 있는 데이터에 대해서는 DML 가능, 조건절 가능

select * from v_001 where empno=7788;

create view v_002
as
  select e.empno, e.ename, e.sal, e.deptno, d.dname
  from emp e join dept d
  on e.deptno = d.deptno;

select * from v_002;

create view v_003
as
  select deptno, avg(sal) as avgsal
  from emp
  group by deptno;
  
select * from v_003;

--자기부서의 평균월급보다 더 많은 월급을 받는 사원의 사번, 이름, 부서번호, 부서별 평균월급을 출력하세요.
--in - line - view
select e.empno, e.ename, e.deptno, e.sal, trunc(s.avgsal,0)
from emp e join (select deptno, avg(sal) as avgsal from emp group by deptno) s
on e.deptno = s.deptno
where e.sal > s.avgsal;

select e.empno, e.ename, e.deptno, e.sal, trunc(s.avgsal,0)
from emp e join v_003 s
on e.deptno = s.deptno
where e.sal > s.avgsal;

--Join 처리시 원하는 값이 테이블로 존재한다면..........view

CREATE  [OR  REPLACE]  [FORCE | NOFORCE]  VIEW view_name [(alias[,alias,...])]
AS Subquery
[WITH  CHECK  OPTION  [CONSTRAINT  constraint ]]
[WITH  READ  ONLY]
/*
OR  REPLACE : 이미 존재한다면 다시 생성한다.  --덮어쓰기

FORCE :  Base Table 유무에 관계없이 VIEW 을 만든다.  --거의안씀.
NOFORCE : 기본 테이블이 존재할 경우에만 VIEW 를 생성한다. 

view_name : VIEW 의 이름 
Alias : Subquery 를 통해 선택된 값에 대한 Column 명이 된다. 
Subquery : SELECT 문장을 기술한다. 

WITH CHECK OPTION : VIEW 에 의해 액세스 될 수 있는 행만이 입력,갱신될 수 있다.  
Constraint : CHECK OPTON 제약 조건에 대해 지정된 이름이다. 
WITH READ ONLY : 이 VIEW 에서 DML 이 수행될 수 없게 한다. 
*/
--기존에 만든 view 수정
create or replace view view이름 --덮어쓰기

create or replace view v_004
as
  select empno,ename,sal from emp;

drop view v_004; --view 삭제

create or replace view v_emp
as
  select empno, ename, deptno from emp where deptno=20;
  
select * from v_emp;

--view 가상 테이블 DML(insert, update, delete..)
--view 를 통해서 바라볼 수 있는 데이터에 대해서 가능
--join 한 X , 단일 테이블로 작업한 것만 사용가능

select * from v_emp;
delete from v_emp; --view가 가지는 원테이블의 정보 삭제
select * from emp where deptno=20;
rollback;

update v_emp
set ename = 'AAA'
where deptno=30; --view는 20번만 가지고 있기 때문에 30번 데이터는 수정불가

--1. 30번 부서 사원들의 직위, 이름, 월급을 담는 VIEW를 만들어라.
create or replace view dept30
as
  select job, ename, sal
  from emp
  where deptno=30;
 
select * from dept30;
--2. 30번 부서 사원들의  직위, 이름, 월급을 담는 VIEW를 만드는데,
-- 각각의 컬럼명을 직위, 사원이름, 월급으로 ALIAS를 주고 월급이
-- 300보다 많은 사원들만 추출하도록 하라.
-- create or replace view view001 (컬럼명, 컬럼명, .....)  
create or replace view dept30 --CREATE OR REPLACE VIEW  VIEW101 ( 직위, 사원이름 ,월급 )
as
  select job as "직위", ename as "사원이름", sal as "월급"
  from emp
  where deptno=30 and sal>300;

select * from dept30; 
--3. 부서별 최대월급, 최소월급, 평균월급을 담는 VIEW를 만들어라.
--view 도 테이블이기 때문에 별도의 컬럼이름을 지어줘야 한다.....
create or replace view v_ex
as
  select deptno, max(sal) as "max", min(sal) as "min", trunc(avg(sal),0) as "avg"
  from emp
  group by deptno;

select * from v_ex;
       
--4. 부서별 평균월급을 담는 VIEW를 만들되, 평균월급이 2000 이상인
-- 부서만 출력하도록 하라.
create or replace view avgsal
as
  select deptno, avg(sal) as "avg"
  from emp
  group by deptno
  having avg(sal)>=2000;
  
select * from avgsal;

--5. 직위별 총월급을 담는 VIEW를 만들되, 직위가 MANAGER인 사원들은 제외하고 총월급이 3000 이상인 직위만 출력
create or replace view sumsal
as
  select job, sum(sal) as "sum"
  from emp
  where job!='MANAGER'
  group by job
  having sum(sal)>=3000;
  
select * from sumsal;
--
--제 11 장 SEQUENCE 185p 177/340
--시퀀스 객체
--순번추출(채번기) : 자동으로 번호를 생성해서 전달하는 객체
CREATE  SEQUENCE  sequence_name
[INCREMENT  BY  n]
[START  WITH  n]
[{MAXVALUE n | NOMAXVALUE}]
[{MINVALUE n | NOMINVALUE}]
[{CYCLE | NOCYCLE}]
[{CACHE | NOCACHE}]; 
/*
sequence_name : SEQUENCE 의 이름입니다. 
INCREMENT  BY  n : 정수 값인 n 으로 SEQUENCE 번호 사이의 간격을 지정. 
    이 절이 생략되면 SEQUENCE 는 1 씩 증가. 
START  WITH  n : 생성하기 위해 첫번째 SEQUENCE 를 지정. 
    이 절이 생략되면 SEQUENCE 는 1 로 시작. 
MAXVALUE n : SEQUENCE 를 생성할 수 있는 최대 값을 지정.  --최대값 이후 추출하려고 하면 에러.
NOMAXVALUE : 오름차순용 10^27 최대값과 내림차순용-1 의 최소값을 지정. 
MINVALUE n : 최소 SEQUENCE 값을 지정. 
NOMINVALUE : 오름차순용 1 과 내림차순용-(10^26)의 최소값을 지정. 
CYCLE | NOCYCLE : 최대 또는 최소값에 도달한 후에 계속 값을 생성할 지의 여부를 지정. NOCYCLE 이 디폴트.  --cycle걸면 다시 1로 돌아감...
CACHE | NOCACHE : 얼마나 많은 값이 메모리에 오라클 서버가 미리 할당하고 유지하는가를 지정. 디폴트로 오라클 서버는 20 을 CACHE. 
*/
--게시판
/*
create table board(
  boardid number primary key,
  title varchar2(50)
)

boardid 글번호는 >> 중복값 X, null X
실수없이 데이터를 넣을 수 있을까????

where boardid=10 ... 하나의 row return 보장
*/
create table kboard(
  num number constraint pk_kboard_num primary key,
  title varchar2(50)
);
--처음글 num=1
--다음글 num=2...
insert into kboard(num,title) values ((select nvl(max(num),0)+1 from kboard),'처음');
insert into kboard(num,title) values ((select nvl(max(num),0)+1 from kboard),'두번');
insert into kboard(num,title) values ((select nvl(max(num),0)+1 from kboard),'세번');
--맞는 방식!!

select * from kboard;

insert into kboard(num,title) values ((select count(num)+1 from kboard),'네번');
insert into kboard(num,title) values ((select count(num)+1 from kboard),'다섯번');
--글 삭제 시 count 중복된 글 등록가능

--번호를 추출해서 중복값이 안나오게 순차적인 값 전달.
create sequence seq_num;
--내 계정이 가지는 객체 확인
select * from user_sequences;
/*
1.4.1 NEXTVAL 과 CURRVAL 의사열 
가) 특징
  1) NEXTVAL 는 다음 사용 가능한 SEQUENCE 값을 반환 한다. 
  2) SEQUENCE 가 참조될 때 마다, 다른 사용자에게 조차도 유일한 값을 반환한다.
  3) CURRVAL 은 현재 SEQUENCE 값을 얻는다.
  4) CURRVAL 이 참조되기 전에 NEXTVAL 이 사용되어야 한다. 
*/

--번호추출하기
select seq_num.nextval from dual;
--현재값 정보확인하기 (마지막으로 추출된 순번 확인)
select seq_num.currval from dual;

create table sboard(
  num number constraint pk_sboard_num primary key,
  title varchar2(50)
);

insert into sboard(num,title) values (seq_num.nextval,'처음');
insert into sboard(num,title) values (seq_num.nextval,'두번');
insert into sboard(num,title) values (seq_num.nextval,'세번');

select * from sboard;

delete from sboard where num=11; --11삭제 후 추가 시 12번으로 추가.
insert into sboard(num,title) values (seq_num.nextval,'다섯번');

--1. sequence rollback 지원하지않음.
rollback; --롤백해도 숫자는 계속 증가해서 13번부터~
insert into sboard(num,title) values (seq_num.nextval,'처음');
insert into sboard(num,title) values (seq_num.nextval,'두번');
insert into sboard(num,title) values (seq_num.nextval,'세번');
commit;

/*
의사컬럼은 테이블의 [컬럼]처럼 동작하지만
실제로 테이블에 저장되지 않는 컬럼을 의미한다.
select 문에서는 의사컬럼을 사용할 수 있지만, DML 문장에서는 할 수 없다.
시퀀스에서 사용하는 nextval 이나 currval도 의사컬럼의 일종이며, 대표적인 예는 rownum 이다.
*/

--게시판 10개
--질문게시판, 자유게시판, 공지사항 하나의 글번호 통합
--sequence 1개
create sequence board_seq;

insert into qboard() values(board_seq.nextval...)
insert into fboard() values(board_seq.nextval...)
insert into kboard() values(board_seq.nextval...)

--TIP)
--ms-sql
--create table board (boardnum int identity(1,1), title varchar(20)); --sequence 없었을 때 ms-sql...
--insert into board(title) values ('MS처음');
--버전 : 2012버전 : 오라클처럼 sequence를 만듬..

--my-sql
--create table board (boardnum int auto_increment, title varchar(20));
--insert into board(title) values ('MY처음');

create sequence seq_num2
start with 10 --10부터 시작해서
increment by 2; --2씩 증가

select seq_num2.nextval from dual;
select seq_num2.currval from dual; --currval 은 사용 이후 값 확인이기때문에 nextval이 실행되지 않았을 경우 에러.

select * from user_sequences;
/*
게시판 글번호
num : 1 2 4 6 10 15
최신글 순으로 목록 보여주기.*/
select * from board order by num desc; --내림차순..

--개발자(sequence, rownum)
--rownum 의사컬럼
--rownum : 실제로 테이블에 존재하지 않는 컬럼(행 번호)
--rowid : 주소값(행이 실제로 저장되는 내부(메모리)주소값)

select empno, ename from emp;
select rownum as 순번, empno, ename from emp;

--Top-n쿼리 사용..
--테이블에서 조건에 맞는 상위 Top 레코드(row) n개 추출
--근거 : 정렬된 데이터 기준 줄을 세우고.....
select * from emp order by sal desc;

--Top-n
--ms-sql : select top 10, * from emp order by sal desc;
--oracle : rownum(의사컬럼)

--1. 정렬쿼리를 만든다
--2. 쿼리에 순번(rownum)을 부여하고 조건(where rownum <= 10) 

--1. 기준
--in line view
select rownum as "num",e.*
from (
      select *
      from emp
      order by sal desc) e;

--2. 조건 10명
select rownum as "num", e.*
from (
      select *
      from emp
      order by sal desc) e
where rownum <=10;


select *
from (
      select rownum as "num", e.*
      from (
            select *
            from emp
            order by sal desc) e
      ) n
where "num" <= 2;
-------------------------------------------------------------------------------
--SQL 1차 학습 END
-------------------------------------------------------------------------------
--SQL 2차 학습(3차 프로젝트 전에....)
--고급쿼리
--PL-SQL : 변수, 제어문, 커서, 함수, 프로시져, 트리거, 스케줄





