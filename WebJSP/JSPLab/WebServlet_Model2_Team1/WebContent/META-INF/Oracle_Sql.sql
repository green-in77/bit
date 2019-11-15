--emp, dept 그대로 사용함

--adminlist, emp_img 새로 생성

CREATE TABLE EMP
(EMPNO number not null,
ENAME VARCHAR2(10),
JOB VARCHAR2(9),
MGR number ,
HIREDATE date,
SAL number ,
COMM number ,
DEPTNO number );


INSERT INTO EMP VALUES
(7369,'SMITH','CLERK',7902,'1980-12-17',800,null,20);
INSERT INTO EMP VALUES
(7499,'ALLEN','SALESMAN',7698,'1981-02-20',1600,300,30);
INSERT INTO EMP VALUES
(7521,'WARD','SALESMAN',7698,'1981-02-22',1250,200,30);
INSERT INTO EMP VALUES
(7566,'JONES','MANAGER',7839,'1981-04-02',2975,30,20);
INSERT INTO EMP VALUES
(7654,'MARTIN','SALESMAN',7698,'1981-09-28',1250,300,30);
INSERT INTO EMP VALUES
(7698,'BLAKE','MANAGER',7839,'1981-04-01',2850,null,30);
INSERT INTO EMP VALUES
(7782,'CLARK','MANAGER',7839,'1981-06-01',2450,null,10);
INSERT INTO EMP VALUES
(7788,'SCOTT','ANALYST',7566,'1982-10-09',3000,null,20);
INSERT INTO EMP VALUES
(7839,'KING','PRESIDENT',null,'1981-11-17',5000,3500,10);
INSERT INTO EMP VALUES
(7844,'TURNER','SALESMAN',7698,'1981-09-08',1500,0,30);
INSERT INTO EMP VALUES
(7876,'ADAMS','CLERK',7788,'1983-01-12',1100,null,20);
INSERT INTO EMP VALUES
(7900,'JAMES','CLERK',7698,'1981-10-03',950,null,30);
INSERT INTO EMP VALUES
(7902,'FORD','ANALYST',7566,'1981-10-3',3000,null,20);
INSERT INTO EMP VALUES
(7934,'MILLER','CLERK',7782,'1982-01-23',1300,null,10);

COMMIT;

CREATE TABLE DEPT
(DEPTNO number,
DNAME VARCHAR2(14),
LOC VARCHAR2(13) );

INSERT INTO DEPT VALUES (10,'ACCOUNTING','NEW YORK');
INSERT INTO DEPT VALUES (20,'RESEARCH','DALLAS');
INSERT INTO DEPT VALUES (30,'SALES','CHICAGO');
INSERT INTO DEPT VALUES (40,'OPERATIONS','BOSTON');

COMMIT;

create table adminlist(
userid varchar2(20) not null,
pwd varchar2(20) not null
);


insert into adminlist values('admin', '1004');
insert into adminlist values('adminkim', '1234');
commit;

/*이미지 업로드 테이블*/
create table emp_img (
 empno number not null, /* 사번 */
 orign_picture varchar2(30), /* 원본사진이름 */
 save_picture varchar2(40), /* 저장사진이름 */
 savefolder varchar2(1000) /* 저장경로 */
);

alter table emp
 add
  constraint pk_empno
  primary key (
   empno
  );
  
alter table emp_img
 add
  constraint fk_emp_to_img
  foreign key (
   empno
  )
  references emp (
   empno
  );
  
insert into emp_img(empno,SAVE_PICTURE) values (7369,'avatar.png');
insert into emp_img(empno,SAVE_PICTURE) values (7499,'avatar.png');
insert into emp_img(empno,SAVE_PICTURE) values (7521,'avatar.png');
insert into emp_img(empno,SAVE_PICTURE) values (7566,'avatar.png');
insert into emp_img(empno,SAVE_PICTURE) values (7564,'avatar.png');
insert into emp_img(empno,SAVE_PICTURE) values (7698,'avatar.png');
insert into emp_img(empno,SAVE_PICTURE) values (7782,'avatar.png');
insert into emp_img(empno,SAVE_PICTURE) values (7788,'avatar.png');
insert into emp_img(empno,SAVE_PICTURE) values (7839,'avatar.png');
insert into emp_img(empno,SAVE_PICTURE) values (7844,'avatar.png');
insert into emp_img(empno,SAVE_PICTURE) values (7876,'avatar.png');
insert into emp_img(empno,SAVE_PICTURE) values (7900,'avatar.png');
insert into emp_img(empno,SAVE_PICTURE) values (7902,'avatar.png');
insert into emp_img(empno,SAVE_PICTURE) values (7934,'avatar.png');

COMMIT;  