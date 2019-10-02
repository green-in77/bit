--191001
--�� 12 �� VIEW 192p 185/340
--view �������̺� : ������X, ��� �޸𸮿� �÷��� �����.
--View ��ü (create �� ����)
create view ���̸� as [view �� ���� �ڿ����(select ��)]
--view�� ���̺�ó�� ��� ����(�������̺�) => ���� emp, dept ���� ���̺�� ������ ����
--view�� �޸𸮻󿡸� �����ϴ� ���� ���̺�(subquery -> in line view -> ���� ���̺�ó�� ��� ��ޱ��)
--view = sql ���� ���

--������ �Ϲ� ���̺�� ���� select from where ....
--DML>>view �� ���ؼ� �������� ���̺� ����... insert, update, delete ���������� �ǵ��� ������� ����...

--view ����
--�������� ����(join, subquery - ������ ����..
--������ ���� �ܼ�ȭ
--����(���Ѻ��� ó��)

create view v_001--ORA-01031: insufficient privileges
as
  select empno, ename from emp; -- bituser ���� view �� �� �� �ִ� ������ ����..
--���������->�ý��۱���-> CREATE ANY VIEW	true	true

select * from v_001; --�����δ� view �� ������ �ִ� sql ������ ����Ǵ� ��.
--view �� �� �� �ִ� �����Ϳ� ���ؼ��� DML ����, ������ ����

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

--�ڱ�μ��� ��տ��޺��� �� ���� ������ �޴� ����� ���, �̸�, �μ���ȣ, �μ��� ��տ����� ����ϼ���.
--in - line - view
select e.empno, e.ename, e.deptno, e.sal, trunc(s.avgsal,0)
from emp e join (select deptno, avg(sal) as avgsal from emp group by deptno) s
on e.deptno = s.deptno
where e.sal > s.avgsal;

select e.empno, e.ename, e.deptno, e.sal, trunc(s.avgsal,0)
from emp e join v_003 s
on e.deptno = s.deptno
where e.sal > s.avgsal;

--Join ó���� ���ϴ� ���� ���̺�� �����Ѵٸ�..........view

CREATE  [OR  REPLACE]  [FORCE | NOFORCE]  VIEW view_name [(alias[,alias,...])]
AS Subquery
[WITH  CHECK  OPTION  [CONSTRAINT  constraint ]]
[WITH  READ  ONLY]
/*
OR  REPLACE : �̹� �����Ѵٸ� �ٽ� �����Ѵ�.  --�����

FORCE :  Base Table ������ ������� VIEW �� �����.  --���ǾȾ�.
NOFORCE : �⺻ ���̺��� ������ ��쿡�� VIEW �� �����Ѵ�. 

view_name : VIEW �� �̸� 
Alias : Subquery �� ���� ���õ� ���� ���� Column ���� �ȴ�. 
Subquery : SELECT ������ ����Ѵ�. 

WITH CHECK OPTION : VIEW �� ���� �׼��� �� �� �ִ� �ุ�� �Է�,���ŵ� �� �ִ�.  
Constraint : CHECK OPTON ���� ���ǿ� ���� ������ �̸��̴�. 
WITH READ ONLY : �� VIEW ���� DML �� ����� �� ���� �Ѵ�. 
*/
--������ ���� view ����
create or replace view view�̸� --�����

create or replace view v_004
as
  select empno,ename,sal from emp;

drop view v_004; --view ����

create or replace view v_emp
as
  select empno, ename, deptno from emp where deptno=20;
  
select * from v_emp;

--view ���� ���̺� DML(insert, update, delete..)
--view �� ���ؼ� �ٶ� �� �ִ� �����Ϳ� ���ؼ� ����
--join �� X , ���� ���̺�� �۾��� �͸� ��밡��

select * from v_emp;
delete from v_emp; --view�� ������ �����̺��� ���� ����
select * from emp where deptno=20;
rollback;

update v_emp
set ename = 'AAA'
where deptno=30; --view�� 20���� ������ �ֱ� ������ 30�� �����ʹ� �����Ұ�

--1. 30�� �μ� ������� ����, �̸�, ������ ��� VIEW�� ������.
create or replace view dept30
as
  select job, ename, sal
  from emp
  where deptno=30;
 
select * from dept30;
--2. 30�� �μ� �������  ����, �̸�, ������ ��� VIEW�� ����µ�,
-- ������ �÷����� ����, ����̸�, �������� ALIAS�� �ְ� ������
-- 300���� ���� ����鸸 �����ϵ��� �϶�.
-- create or replace view view001 (�÷���, �÷���, .....)  
create or replace view dept30 --CREATE OR REPLACE VIEW  VIEW101 ( ����, ����̸� ,���� )
as
  select job as "����", ename as "����̸�", sal as "����"
  from emp
  where deptno=30 and sal>300;

select * from dept30; 
--3. �μ��� �ִ����, �ּҿ���, ��տ����� ��� VIEW�� ������.
--view �� ���̺��̱� ������ ������ �÷��̸��� ������� �Ѵ�.....
create or replace view v_ex
as
  select deptno, max(sal) as "max", min(sal) as "min", trunc(avg(sal),0) as "avg"
  from emp
  group by deptno;

select * from v_ex;
       
--4. �μ��� ��տ����� ��� VIEW�� �����, ��տ����� 2000 �̻���
-- �μ��� ����ϵ��� �϶�.
create or replace view avgsal
as
  select deptno, avg(sal) as "avg"
  from emp
  group by deptno
  having avg(sal)>=2000;
  
select * from avgsal;

--5. ������ �ѿ����� ��� VIEW�� �����, ������ MANAGER�� ������� �����ϰ� �ѿ����� 3000 �̻��� ������ ���
create or replace view sumsal
as
  select job, sum(sal) as "sum"
  from emp
  where job!='MANAGER'
  group by job
  having sum(sal)>=3000;
  
select * from sumsal;
--
--�� 11 �� SEQUENCE 185p 177/340
--������ ��ü
--��������(ä����) : �ڵ����� ��ȣ�� �����ؼ� �����ϴ� ��ü
CREATE  SEQUENCE  sequence_name
[INCREMENT  BY  n]
[START  WITH  n]
[{MAXVALUE n | NOMAXVALUE}]
[{MINVALUE n | NOMINVALUE}]
[{CYCLE | NOCYCLE}]
[{CACHE | NOCACHE}]; 
/*
sequence_name : SEQUENCE �� �̸��Դϴ�. 
INCREMENT  BY  n : ���� ���� n ���� SEQUENCE ��ȣ ������ ������ ����. 
    �� ���� �����Ǹ� SEQUENCE �� 1 �� ����. 
START  WITH  n : �����ϱ� ���� ù��° SEQUENCE �� ����. 
    �� ���� �����Ǹ� SEQUENCE �� 1 �� ����. 
MAXVALUE n : SEQUENCE �� ������ �� �ִ� �ִ� ���� ����.  --�ִ밪 ���� �����Ϸ��� �ϸ� ����.
NOMAXVALUE : ���������� 10^27 �ִ밪�� ����������-1 �� �ּҰ��� ����. 
MINVALUE n : �ּ� SEQUENCE ���� ����. 
NOMINVALUE : ���������� 1 �� ����������-(10^26)�� �ּҰ��� ����. 
CYCLE | NOCYCLE : �ִ� �Ǵ� �ּҰ��� ������ �Ŀ� ��� ���� ������ ���� ���θ� ����. NOCYCLE �� ����Ʈ.  --cycle�ɸ� �ٽ� 1�� ���ư�...
CACHE | NOCACHE : �󸶳� ���� ���� �޸𸮿� ����Ŭ ������ �̸� �Ҵ��ϰ� �����ϴ°��� ����. ����Ʈ�� ����Ŭ ������ 20 �� CACHE. 
*/
--�Խ���
/*
create table board(
  boardid number primary key,
  title varchar2(50)
)

boardid �۹�ȣ�� >> �ߺ��� X, null X
�Ǽ����� �����͸� ���� �� ������????

where boardid=10 ... �ϳ��� row return ����
*/
create table kboard(
  num number constraint pk_kboard_num primary key,
  title varchar2(50)
);
--ó���� num=1
--������ num=2...
insert into kboard(num,title) values ((select nvl(max(num),0)+1 from kboard),'ó��');
insert into kboard(num,title) values ((select nvl(max(num),0)+1 from kboard),'�ι�');
insert into kboard(num,title) values ((select nvl(max(num),0)+1 from kboard),'����');
--�´� ���!!

select * from kboard;

insert into kboard(num,title) values ((select count(num)+1 from kboard),'�׹�');
insert into kboard(num,title) values ((select count(num)+1 from kboard),'�ټ���');
--�� ���� �� count �ߺ��� �� ��ϰ���

--��ȣ�� �����ؼ� �ߺ����� �ȳ����� �������� �� ����.
create sequence seq_num;
--�� ������ ������ ��ü Ȯ��
select * from user_sequences;
/*
1.4.1 NEXTVAL �� CURRVAL �ǻ翭 
��) Ư¡
  1) NEXTVAL �� ���� ��� ������ SEQUENCE ���� ��ȯ �Ѵ�. 
  2) SEQUENCE �� ������ �� ����, �ٸ� ����ڿ��� ������ ������ ���� ��ȯ�Ѵ�.
  3) CURRVAL �� ���� SEQUENCE ���� ��´�.
  4) CURRVAL �� �����Ǳ� ���� NEXTVAL �� ���Ǿ�� �Ѵ�. 
*/

--��ȣ�����ϱ�
select seq_num.nextval from dual;
--���簪 ����Ȯ���ϱ� (���������� ����� ���� Ȯ��)
select seq_num.currval from dual;

create table sboard(
  num number constraint pk_sboard_num primary key,
  title varchar2(50)
);

insert into sboard(num,title) values (seq_num.nextval,'ó��');
insert into sboard(num,title) values (seq_num.nextval,'�ι�');
insert into sboard(num,title) values (seq_num.nextval,'����');

select * from sboard;

delete from sboard where num=11; --11���� �� �߰� �� 12������ �߰�.
insert into sboard(num,title) values (seq_num.nextval,'�ټ���');

--1. sequence rollback ������������.
rollback; --�ѹ��ص� ���ڴ� ��� �����ؼ� 13������~
insert into sboard(num,title) values (seq_num.nextval,'ó��');
insert into sboard(num,title) values (seq_num.nextval,'�ι�');
insert into sboard(num,title) values (seq_num.nextval,'����');
commit;

/*
�ǻ��÷��� ���̺��� [�÷�]ó�� ����������
������ ���̺� ������� �ʴ� �÷��� �ǹ��Ѵ�.
select �������� �ǻ��÷��� ����� �� ������, DML ���忡���� �� �� ����.
���������� ����ϴ� nextval �̳� currval�� �ǻ��÷��� �����̸�, ��ǥ���� ���� rownum �̴�.
*/

--�Խ��� 10��
--�����Խ���, �����Խ���, �������� �ϳ��� �۹�ȣ ����
--sequence 1��
create sequence board_seq;

insert into qboard() values(board_seq.nextval...)
insert into fboard() values(board_seq.nextval...)
insert into kboard() values(board_seq.nextval...)

--TIP)
--ms-sql
--create table board (boardnum int identity(1,1), title varchar(20)); --sequence ������ �� ms-sql...
--insert into board(title) values ('MSó��');
--���� : 2012���� : ����Ŭó�� sequence�� ����..

--my-sql
--create table board (boardnum int auto_increment, title varchar(20));
--insert into board(title) values ('MYó��');

create sequence seq_num2
start with 10 --10���� �����ؼ�
increment by 2; --2�� ����

select seq_num2.nextval from dual;
select seq_num2.currval from dual; --currval �� ��� ���� �� Ȯ���̱⶧���� nextval�� ������� �ʾ��� ��� ����.

select * from user_sequences;
/*
�Խ��� �۹�ȣ
num : 1 2 4 6 10 15
�ֽű� ������ ��� �����ֱ�.*/
select * from board order by num desc; --��������..

--������(sequence, rownum)
--rownum �ǻ��÷�
--rownum : ������ ���̺� �������� �ʴ� �÷�(�� ��ȣ)
--rowid : �ּҰ�(���� ������ ����Ǵ� ����(�޸�)�ּҰ�)

select empno, ename from emp;
select rownum as ����, empno, ename from emp;

--Top-n���� ���..
--���̺��� ���ǿ� �´� ���� Top ���ڵ�(row) n�� ����
--�ٰ� : ���ĵ� ������ ���� ���� �����.....
select * from emp order by sal desc;

--Top-n
--ms-sql : select top 10, * from emp order by sal desc;
--oracle : rownum(�ǻ��÷�)

--1. ���������� �����
--2. ������ ����(rownum)�� �ο��ϰ� ����(where rownum <= 10) 

--1. ����
--in line view
select rownum as "num",e.*
from (
      select *
      from emp
      order by sal desc) e;

--2. ���� 10��
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
--SQL 1�� �н� END
-------------------------------------------------------------------------------
--SQL 2�� �н�(3�� ������Ʈ ����....)
--�������
--PL-SQL : ����, ���, Ŀ��, �Լ�, ���ν���, Ʈ����, ������





