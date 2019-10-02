--190930
--oracle 11g 가상컬럼(조합컬럼)
--컬럼 : 국어, 영어, 수학.... >> 합, 평균
--컬럼 : 국어, 영어, 수학, 합, 평균 자동화

create table vtable(
  no1 number,
  no2 number,
  no3 number GENERATED ALWAYS as (no1+no2) VIRTUAL
);

select * from vtable;

insert into vtable(no1,no2) values (100,200);
insert into vtable(no1,no2) values (200,200);
commit;

insert into vtable(no1,no2,no3) values (10,50,60);
--ORA-54013: INSERT operation disallowed on virtual columns
--가상컬럼은 데이터를 직접 입력할 수 없음.

select column_name, data_type, data_default
from user_tab_columns where table_name='VTABLE';

--실무에 사용되는 형식의 코드
--제품의 정보(입고일) 기준으로 분기(1~4분기)
--20190101, 20190520

create table vtable2(
  no number, --순번
  p_code char(4), --제품코드(A001, B002)
  p_date char(8), --입고일(20190909) --날짜타입 .... 문자형식...
  p_qty number, --수량
  p_bungi number(1)GENERATED ALWAYS as (
                    case when substr(p_date,5,2) in ('01','02','03') then 1
                         when substr(p_date,5,2) in ('04','05','06') then 2
                         when substr(p_date,5,2) in ('07','08','09') then 3
                         else 4
                    end
                    ) VIRTUAL
);

select * from vtable2;

select column_name, data_type, data_default
from user_tab_columns where table_name='VTABLE2';

insert into vtable2(p_date) values('20190101');
insert into vtable2(p_date) values('20190129');
insert into vtable2(p_date) values('20190404');
insert into vtable2(p_date) values('20191101');
insert into vtable2(p_date) values('20191201');
commit;

select * from vtable2 where p_bungi=1;

--DDL 테이블 다루기
--제 9 장 테이블(TABLE) 생성 138p 130/340

--1.테이블 생성하기
create table tamp6(
  id number
);

--2.테이블 수정하기(컬럼추가) add 한번에 하나의 컬럼만 추가 가능
alter table tamp6
add ename varchar2(20);

--3.테이블 수정하기(컬럼수정) (ename -> username) rename
alter table tamp6
rename column ename to username;

--4.테이블 수정하기(컬럼 타입수정) modify
alter table tamp6
modify (username varchar2(2000));

--5.테이블 수정하기(컬럼삭제) drop
alter table tamp6
drop column username;

--6.delete : 테이블 데이터 삭제
--테이블을 처음만들면 처음 크기 >> 데이터를 넣으면 >> 테이블이 커짐
--ex) 처음 테이블 1M >> 10만건데이터 >> 101M  >> 데이터전체삭제 delete >> 테이블의 크기 101M
--테이블 데이터 삭제시 공간확보[처음상태로] truncate (where 조건 사용불가)

--drop talbe tamp6

--테이블 제약 설정하기 p144 136/340
--데이터 무결성 확보 
--제약 (constraint) insert, update 주로....
/* 제 약 조 건                      설     명 
NOT NULL(NN)      열은 NULL 값을 포함할 수 없습니다. 
UNIQUE key(UK)    테이블의 모든 행을 유일하게 하는 값을 가진 열(NULL 을 허용)  - 중복값이 들어오지 못하게 하는 것.
                  unique + not null : 컬럼의 갯수만큼

PRIMARY KEY(PK)   유일하게 테이블의 각행을 식별(NOT NULL 과 UNIQUE 조건을 만족) 
                  테이블당 1개(여러개를 묶어서 하나로 만들어서 가능 : 복합키)
                  ex) 주민번호, 게시판 글번호, 학번, 핸드폰번호 ....
                  index 자동생성 : where pk 를 많이 하겠구나..해서 별도의 index table 생성함. : 빠른검색
                  물리적 : 1개 / 논리적 : 주소(가열3행 등) -->>> 별도 관리가 필요함..( 주기적으로 업데이트) --> 비용...(DBA)
                  
FOREIGN KEY(FK)   열과 참조된 열 사이의 외래키 관계를 적용하고 설정합니다. 
                  참조제약 : 테이블과 테이블간의 제약
                  EMP, DEPT 참조제약 필요한데 지금은 없음....데이터는 제약이 있는 것 처럼 맞춰있음
                  참조를 당한다(DEPT) PK / 참조를 하는 쪽(EMP) FK
                  
CHECK(CK)         참이어야 하는 조건을 지정함(대부분 업무 규칙을 설정)
                  원하는 값만 받는 것.(gender 컬럼의 데이터는 '남','여' 만 받겠다)
                  데이터를 체크함.
                  
5가지 제약을 만드는 시점
1. 테이블을 생성할 때 (create table)
2. 테이블 생성이후(create table -> 필요시 alter table add constraint ....)
*/
--테이블 제약사항 확인
select * from user_constraints where table_name='EMP';

--간단표기법(권장X)
--SYS_C007012,SYS_C007013 내부적으로 제약이름을 생성
create table temp7(
  id number primary key,
  name varchar2(20) not null,
  addr varchar2(50)
);

select * from user_constraints where table_name='TEMP7';

--full 표기법 제약이름을 사용자가 설정 가능
create table temp7(
  id number constraint pk_temp7_id primary key, --제약이름은 관용적인 규칙이 있음..
  name varchar2(20) not null,
  addr varchar2(50)
);

insert into temp7(name, addr) values ('홍길동','서울시 강남구'); -- id의 PK 제약으로 null 이 될 수 없어서 insert 되지 않음.
insert into temp7(id,name, addr) values (10,'홍길동','서울시 강남구');
insert into temp7(id,name, addr) values (10,'김유신','서울시 강북구'); --"unique constraint (%s.%s) violated" id PK제약 중복값 불가
--PK 건다는 건 (where id 자주 사용한다) -PK걸면 그 컬럼에 대해 자동으로 Index를 부여한다. --검색속도를 향상시킨다.
select * from temp7 where id=10;

commit;

create table temp8(
  id number constraint pk_temp8_id primary key,
  name varchar2(20) not null,
  jumin char(6) constraint uk_temp8_jumin unique, --not null 아니기 때문에 null은 중복가능함.
  --jumin char(6) not null constraint uk_temp8_jumin unique, --not null 아니기 때문에 null은 중복가능함.
  addr varchar2(20)
);

select * from user_constraints where table_name='TEMP8';
select * from user_indexes where table_name='TEMP8';--제약사항확인

insert into temp8(id,name,jumin,addr) values (10,'홍길동','123456','서울시 강남구');
select * from temp8;
commit;

insert into temp8(id,name,jumin,addr) values (10,'A','456789','서울시 강남구');
-- ORA-00001: unique constraint (BITUSER.PK_TEMP8_ID) violated : id PK --unique

insert into temp8(name,jumin,addr) values ('A','456789','서울시 강남구');
--ORA-01400: cannot insert NULL into ("BITUSER"."TEMP8"."ID") : id PK - null

insert into temp8(id,name,jumin,addr) values (20,'A','123456','서울시 강남구');
--ORA-00001: unique constraint (BITUSER.UK_TEMP8_JUMIN) violated : jumin unique

insert into temp8(id,name,addr) values (20,'A','서울시 강남구');
--주민번호 데이터 null 가능.

insert into temp8(id,name,addr) values (30,'야무지개','서울시 강남구');
--주민번호 데이터 null 중복 가능

select * from temp8;
commit;

--테이블 생성 후 제약걸기
create table temp9(
  id number
);

--기존 테이블 >> 데이터 실습 >> 10, 10 2건 >> PK 불가(내부적으로 데이터 검사함) >> 중복삭제 후 PK해야함
alter table temp9
add constraint pk_temp9_id primary key(id);

select * from user_constraints where table_name='TEMP9';
select * from user_indexes where table_name='TEMP9';--제약사항확인

alter table temp9
add ename varchar2(20);

desc temp9;

--not null 추가하기 (예외적으로 modify)
alter table temp9
modify (ename not null);

--check
create table temp10(
  id number constraint pk_temp10_id primary key,
  name varchar2(20) not null,
  jumin char(6) constraint uk_temp10_jumin unique, --not null 아니기 때문에 null은 중복가능함.
  addr varchar2(20),
  age number constraint ck_temp10_age check(age>=19) --where age>=19
);

select * from user_constraints where table_name='TEMP10';

insert into temp10(id,name,jumin,addr,age) values(100,'홍길동','123456','서울시',20);
commit;
insert into temp10(id,name,jumin,addr,age) values(200,'김유신','789456','서울시',15);
--ORA-02290: check constraint (BITUSER.CK_TEMP10_AGE) violated --check 제약 19세 이상 체크

select * from temp10;

--2개 컬럼 묶어서 1개의 제약으로
alter table temp9
add constraint pk_temp9_id primary key(id,jumin); --중복키(복합키)

--------------------------------------------------------------------------------
--참조제약 >> 테이블과 테이블과의 관계 >> RDB
create table c_emp
as
  select empno, ename, deptno from emp where 1=2;
  
create table c_dept
as
  select deptno, dname from dept where 1=2;

select * from user_constraints where table_name='C_EMP';
select * from user_constraints where table_name='C_DEPT';

--참조키 FK c_emp deptno 컬럼은 c_dept deptno 컬럼을 참조합니다.
--c_dept deptno 는 c_emp deptno 는 참조를 당합니다.

alter table c_emp
add CONSTRAINT fk_c_emp_deptno foreign key(deptno) references c_dept(deptno);
-- c_emp deptno FK 참조하는건 c_dept deptno
-- ORA-02270: no matching unique or primary key for this column-list --c_dept(deptno)가 PK가 아님.

--참조당하는 테이블의 컬럼을 먼저 PK, unique 제약
--1. PK 설정 2. FK 참조

alter table c_dept
add constraint pk_c_dept_deptno primary key(deptno);

select * from user_constraints where table_name='C_EMP';
select * from user_constraints where table_name='C_DEPT';

insert into c_dept(deptno, dname) values(100,'인사팀');
insert into c_dept(deptno, dname) values(200,'관리팀');
insert into c_dept(deptno, dname) values(300,'회계팀');
commit;

select * from c_dept;
select * from c_emp;

insert into c_emp(empno, ename, deptno) values(1,'신입이',111);
--ORA-02291: integrity constraint (BITUSER.FK_C_EMP_DEPTNO) violated - parent key not found
--참조키에 111값이 없기 때문에 입력할 수 없음.

insert into c_emp(empno, ename) values(1,'신입이');
--FK null 허용....
--회사 규정에 따라 FK 에 null여부 변경...

insert into c_emp(empno, ename, deptno) values(1,'아무개',100);
commit;

--두개의 관계에서 주,종 관계를 파악하면...
--fk_c_emp_deptno 관계에서 부모는 pk_c_demp_deptno = deptno의 값을 가져와야 하기때문에
-- master(dept) - child(emp)

delete from c_dept where deptno=200; --삭제가능 / 참조한 테이블이 없기 때문에.
delete from c_dept where deptno=100; --삭제불가 / 참조한 테이블이 있어서
--ORA-02292: integrity constraint (BITUSER.FK_C_EMP_DEPTNO) violated - child record found
--c_emp 에서 100번 찾아서 삭제한 후 c_dept 에서 삭제가능

/*
column datatype [CONSTRAINT constraint_name]
REFERENCES table_ name (column1[,column2,..] [ON DELETE CASCADE]) 

column datatype, . . . . . . . , [CONSTRAINT constraint_name]
FOREIGN KEY (column1[,column2,..])
REFERENCES table_name  (column1[,column2,..] [ON DELETE CASCADE]) 
*/
--[ON DELETE CASCADE] : 부모테이블과 생명을 같이 하겠다.
--삭제 시 참조되는 데이터까지 같이 삭제됨.

--DDL END
/*
--학생 성적 테이블
--학번의 데이터는 중복되거나 NULL 값을 허용하면 안된다
--이름 NULL 값을 허용하지 않는다
--국어
--영어
--수학 점수 컬럼은 숫자 타입이고 NULL 값을 허용
--국어 , 영어 , 수학  값을 입력하지 않으면  default로 0값을 갖는다
--총점 ,평균 컬럼은 가상컬럼으로(조합컬럼) 생성한다
--학과코드는 학과 테이블에 학과코드를 참조한다
--학번 , 이름 , 국어 , 영어 , 수학 , 총점 , 평균 , 학과코드

--학과 테이블
--학과코드 데이터는 중복되거나 NULL 값을 허용하면 안된다,
--학과명 은 null값을 허락하지 않는다

--학과코드 , 학과명

--그리고 select 결과는
--학번 , 이름  총점, 평균 , 학과코드 , 학과명 을 출력하세요
*/

create table grade(
  no number, --학번
  name varchar2(20) not null, --이름
  korean number default 0, --국어
  english number default 0, --영어
  math number default 0, --수학
  sum number GENERATED ALWAYS as (korean+english+math) VIRTUAL, --총점
  avg number GENERATED ALWAYS as (round((korean+english+math)/3),0) VIRTUAL, --평균 --round 추후추가 table 반영 안되어있음.
  departmentno number --학과코드
);

desc grade;
select * from grade;

create table department(
  departmentno number,
  departmentname varchar(40) not null
)

desc department;
select * from department;

alter table grade
add CONSTRAINT pk_grade_no primary key(no);

alter table department
add constraint pk_department_departmentno primary key(departmentno);

alter table grade
add constraint fk_grade_departmentno foreign key(departmentno) references department(departmentno);

select * from user_constraints where table_name='GRADE';
select * from user_constraints where table_name='DEPARTMENT';

insert into department(DEPARTMENTNO,DEPARTMENTNAME) values (100,'컴퓨터공학');
insert into department(DEPARTMENTNO,DEPARTMENTNAME) values (200,'전산회계');
insert into department(DEPARTMENTNO,DEPARTMENTNAME) values (300,'문예창작');
commit;

insert into grade(no,name,korean,math,departmentno) values(1010,'홍길동',80,70,100);
insert into grade(no,name,departmentno) values(2020,'김유신',300);
insert into grade(no,name,english,math,departmentno) values(3030,'아무개',80,100,200);
commit;

select e.no as "학번", e.name as "이름", e.sum as "총점", e.avg as "평균", e.departmentno as "학과코드", d.departmentname as "학과명"
from grade e join department d
on e.departmentno = d.departmentno;

