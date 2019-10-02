--190927
------------------------------------------------------------------------------
-- �ʱ� ������ : �Լ�, ����
------------------------------------------------------------------------------
--�� 7 �� ��������(SUBQUERY)  100p 92/340
-- sql ���� �ذ�� >> sql ��
/*
select 5
from 1
where 2
group by 3
having 4
order by 6
*/
--������̺��� ������� ��� ���޺��� �� ���� �޿��� �޴� ����� ���, �̸�, �޿� ���
--subquery
select avg(sal) from emp; -- 2073
--main query
select empno, ename, sal
from emp
where sal > 2073;

--query �� �ȿ� query
select empno, ename, sal
from emp
where sal > (select avg(sal) from emp);
--1. ��ȣ�ȿ� ������ �Ѵ�.
--2. ����� �ϳ��� �÷�
--3. ��ȣ�ȿ� �ִ� query �� ���� ����ǰ� ����� ������ main query �� �����.

-- �Լ�(�������̺�) -> ����(2���̻����̺�) -> subquery

/*
subquery
����
�ϳ��� �÷����� ���� �����*/
--1. single row subquery : subquery�� ����� 1�� row(���ϰ�) : �÷� 1��
select sum(sal) from emp;
--2. multi row subquery : subquery�� ����� 1�� �̻��� row(������) : �÷� 1��
select sal from emp;
/*
�����ϴ� ���� (���Ǵ� ������ ����)
������(in, not in)(any, all) : ���� ������ó��
all : sal > 1000 and sal > 2000 and .......
any : sal > 1000 or sal > 2000 or .......

����(����)
1. subquery �� ��ȣ�ȿ� �־�� �Ѵ�. >> (select sal from emp)
2. subquery �� ���� �÷����� �����Ǿ�� �Ѵ�. >> select sum(sal), avg(sal) from emp (X)
3. subquery �ܵ����� ���� �����ؾ� �Ѵ�.

subquery �� ������ ��������
1.subquery ����
2.subquery ����� ������ mainquery �� ����ȴ�.
*/

--������̺��� jones�� �޿����� �� ���� �޿��� �޴� ����� ���, �̸�, �޿�
select *
from emp
where sal > (select sal from emp where ename='JONES');

--�ڡ�IN ������ (���� or ���� or ���� or.....)
select *
from emp
where sal in (select sal from emp where deptno=30);
-- where sal=1600 or sal=1250 or sal=2850 sal=1500 or sal=950
--�ڡڡڡڡڡ�not in -> 10���� �ƴϰ� 20���� �ƴ� ��. (������ and)
select *
from emp
where sal not in (select sal from emp where deptno=30);
-- where sal!=1600 and sal!=1250 and sal!=2850 and sal!=1500 and sal!=950

--���������� �ִ� ����� ����� �̸��� ���
select empno, ename
from emp where empno in (select mgr from emp);
--or ������ null �������.
--���������� ���� ����� ����� �̸�
select empno, ename
from emp where empno not in (select nvl(mgr,0) from emp);
-- empno!=7902 and empno!=7698 and empno is null and...) >> null
-- nvl�Ǵ� in not null�� ���� ������ ������� ������ ����.

--king ���� �����ϴ� �� ���� ����� king �� ����� ���, �̸�, ����, �����ڻ��
select empno, ename, job, mgr
from emp
where mgr = (select empno from emp where ename='KING');

--20�� �μ��� ����߿��� ���� ���� �޿��� �޴� ������� �� ���� �޿��� �޴� �����
--���, �̸�, �޿�, �μ���ȣ
select empno, ename, sal, deptno
from emp
where sal > (select max(sal)from emp where deptno = 20);

select * from emp
where deptno in (select deptno from emp where job='SALESMAN')
and sal in (select sal from emp where job='SALESMAN');

--����

--1. 'SMITH'���� ������ ���� �޴� ������� �̸��� ������ ����϶�.
select ename, sal
from emp
where sal > (select sal from emp where ename='SMITH');
 
--2. 10�� �μ��� ������ ���� ������ �޴� ������� �̸�, ����,
-- �μ���ȣ�� ����϶�.
select ename, sal, deptno
from emp
where sal in (select sal from emp where deptno=10);
 
--3. 'BLAKE'�� ���� �μ��� �ִ� ������� �̸��� ������� �̴µ�
-- 'BLAKE'�� ���� ����϶�.
select ename, hiredate
from emp
where deptno = (select deptno from emp where ename='BLAKE')
and ename!='BLAKE';

--4. ��ձ޿����� ���� �޿��� �޴� ������� �����ȣ, �̸�, ������
-- ����ϵ�, ������ ���� ��� ������ ����϶�.
select empno, ename, sal
from emp
where sal > (select avg(sal) from emp)
order by sal desc;
 
--5. �̸��� 'T'�� �����ϰ� �ִ� ������ ���� �μ����� �ٹ��ϰ�
-- �ִ� ����� �����ȣ�� �̸��� ����϶�.
select empno, ename
from emp
where deptno in (select deptno from emp where ename like '%T%');

--6. 30�� �μ��� �ִ� ����� �߿��� ���� ���� ������ �޴� �������
-- ���� ������ �޴� ������� �̸�, �μ���ȣ, ������ ����϶�.
--(��, ALL(and) �Ǵ� ANY(or) �����ڸ� ����� ��)�ڡ� ���蹮���� �߳���... min �� any �� Ǯ��.
select ename, empno, sal
from emp
where sal > (select max(sal) from emp where deptno=30);
--
select ename, empno, sal
from emp
where sal > all (select sal from emp where deptno=30);
 
--7. 'DALLAS'���� �ٹ��ϰ� �ִ� ����� ���� �μ����� ���ϴ� �����
-- �̸�, �μ���ȣ, ������ ����϶�.

select ename, deptno, job
from emp
where deptno in (select e.deptno from emp e join dept d on e.deptno=d.deptno where d.loc='DALLAS');

SELECT ENAME, DEPTNO, JOB
FROM EMP
WHERE DEPTNO IN(SELECT DEPTNO    -- = �� �´µ�  IN
                      FROM DEPT
                      WHERE LOC='DALLAS');
                      
--8. SALES �μ����� ���ϴ� ������� �μ���ȣ, �̸�, ������ ����϶�.
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
 
--9. 'KING'���� �����ϴ� ��� ����� �̸��� �޿��� ����϶�
--king �� ����� ��� (mgr �����Ͱ� king ���)
select ename, sal
from emp
where mgr = (select empno from emp where ename='KING');
 
--10. �ڽ��� �޿��� ��� �޿����� ����, �̸��� 'S'�� ����
-- ����� ������ �μ����� �ٹ��ϴ� ��� ����� �����ȣ, �̸�,
-- �޿��� ����϶�.
select empno, ename, sal
from emp
where sal > (select avg(sal) from emp)
and deptno in (select deptno from emp where ename like '%S%');
 
--11. Ŀ�̼��� �޴� ����� �μ���ȣ, ������ ���� �����
-- �̸�, ����, �μ���ȣ�� ����϶�.
select ename, sal, deptno
from emp
where deptno in (select deptno from emp where comm is not null)
and sal in (select sal from emp where comm is not null);

--12. 30�� �μ� ������ ���ް� Ŀ�̼��� ���� ����
-- ������� �̸�, ����, Ŀ�̼��� ����϶�.
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

�⺻�Լ� : ����, ����, ��¥, ��ȯ, �Ϲ��Լ�
�������̺� : Join
subquery

+ DML(insert update, delete) : �ϱ��ʼ�....
*/

--[INSERT, UPDATE, DELETE] ������ ����, ����, ����
/*
����Ŭ����
DDL(������ ���Ǿ�) : CREATE, ALTER, DROP, TRUNCATE, RENAME, MODIFY --> DBA
DML(������ ���۾�) : INSERT, UPDATE, DELETE --> ������
DQL(������ ���Ǿ�) : SELECT --> ������ (�Լ�, JOIN, Subquery) 
DCL(������ �����) : ����(GRANT, REVOKE) --> DBA
TCL(Ʈ�����) : COMMIT, ROLLBACK, SAVEPOINT --> ������
*/
--DML �۾�
--����Ŭ ���������� Ʈ������� ���� : 
--����Ŭ���� ( begin tran....) �ڵ�����~~~ ó���Ϸ�(rollback, commit)<--insert ...����

--Ʈ�����(Transaction) : �ϳ��� ������ �۾� ����
--����(Ʈ�����)
--������� (A���� ���� 1000 ���� B���� �Ա�
--�ϳ��� ��������(A���� ����~~~~~~~ B���� �Ա�)
/*
����
  A���� update ����set �ܾ�=�ܾ�-��ݾ�
  B���� update ���� set �ܾ�=�ܾ�+�Աݾ�
�� commit
������ �����ʰ� ������ �ϳ��� ����� �������� rollback
*/

desc emp; -- ���̺� �⺻����
select * from tab; -- ���� ������ �ٷ� �� �ִ� table ���
select * from tab where tname='EMP'; --���̺� ���� ����,,, �ִ��� ������
select * from col where tname='EMP';
select * from user_tables; --������, Ʃ��
select * from user_tables where table_name='DEPT';

--�� 10 �� ������ ���� 168p 160/340
INSERT INTO table_name [(column1[, column2, . . . . . ])]
VALUES  (value1[, value2, . . . . . . ]);

create table temp(
id number primary key, --id �÷��� date�� null(X),�ߺ���(X) �����ϴ� ���==���� (��ǥ������ primary key)
name varchar2(20) --default null
);
 
insert into temp(id,name)
values (100,'ȫ�浿');

select * from temp;
commit;

--2.�÷� ����Ʈ �����ϱ�
insert into temp --�÷�����Ʈ ���� -> ��� values �����Ͱ� ������� ���� -- �ǵ��� �������� ����....
values (200,'������');

--1
insert into temp(id,name) --unique constraint (BITUSER.SYS_C007005) violated �ߺ�Ű PK���� ����
values (100,'�ƹ���');

--2
insert into temp(name)--cannot insert NULL into ("BITUSER"."TEMP"."ID") null �� PK���� ����
values ('������');

--���^^
--sql ����, ���(x)
--pl-sql(java���ó�� ��밡��)
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
  regdate date default sysdate --�÷��� �����͸� �����ʾƵ� �ý��� �����Ͱ� ����.
)

insert into temp3(memberid, name, regdate)
values (100,'ȫ�浿','2019-09-27');

select * from temp3;
commit;

insert into temp3(memberid, name)
values (200,'������');

insert into temp3(memberid)
values (300);

--�ɼ� tip
--1.�뷮������ ����
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

--�䱸���� : temp4 ���̺� �ִ� ��� �����͸� temp5�� �ְ�ʹ�.
--insert into ���̺��(�÷�����Ʈ) select --values ��� selete ����
--�� �÷������� Ÿ���� ��ġ.

insert into temp5(num)
select id from temp4;

select * from temp5;
commit;

--2.insert ������������ (clone)
--���̺��� ���� ��Ȳ���� [���̺� �ڵ�����][�뷮 ������ ����]
--�� ���������� ���� �Ұ� (Primary key ��..)

--emp >> copyemp ���̺��� ����� ������ �Ȱ���..
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
--������ �����ϰ� �����ʹ� ����X
create table copyemp3
as
  select * from emp where 1=2; --������ �ִ� ���̺� ��ȸ...
select * from copyemp3;

commit;
--insert end
--update
UPDATE  table_name
SET  column1 = value1 [,column2 = value2, . . . . . . .]
[WHERE  condition]; 

UPDATE  table_name
SET  (column1, column2, . . . . ) = ( SELECT  column1,column2,... --set ���� subquery�� �� �� �ִ�.
                                      FROM   table_name
                                      WHERE  coundition)
[WHERE  condition];

select * from copyemp;

update copyemp
set sal=0; --sal ���� ��� 0���� ����
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
delete from copyemp; --date �� �����
select * from copyemp;
rollback;

delete from copyemp
where sal > 3000;
commit;
--delete end

/*
APP(java) --> JDBC API -> Oracle(mysql, ms-sql...)
������ : CRUD �۾�
Create : insert
Read : select
Update : update
Delete : delete

C U D >> Ʈ����� ����(commit, rollback)
EMP ���̺� (Oracle)
java
����, ����, ����, ��ü��ȸ, ������ȸ(PK, where empno = 7788)
java �Լ� 5��

public int insertEmp(Emp emp) { insert into emp .......}
public List<Emp> getEmpList() {select * from emp}
public Emp gerEmpListByEmpno(){select ... where empno=7788}

*/






