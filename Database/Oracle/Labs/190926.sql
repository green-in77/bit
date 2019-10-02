--190926
--����
--����
--��¥
--��ȯ(to_char ...)

--�Ϲ��Լ�
--���α׷��� ������ ����...
--nvl(), nvl2() : null ó�� �Լ�.
--decode() : if
--case() : switch

select comm, nvl(comm,0) from emp;

create table t_emp(
id number(6), -- 6�ڸ����� ���
job varchar2(20)
);

select * from t_emp;

insert into t_emp(id,job) values(100,'IT');
insert into t_emp(id,job) values(200,'SALES');
insert into t_emp(id,job) values(300,'MGR');
insert into t_emp(id) values(400);
insert into t_emp(id,job) values(500,'MGR');
commit;

--1. nvl() : parameter 2��, 1���� null �̸� 2������ ��ü
select id, job, nvl(job,'Empty....') from t_emp;

--2. nvl2() : parameter 3��, 1���� ������ 2��°, 1���� Null �̸� 3������ ��ü
-- if �� ���. (����) ������ 2�� �ٸ��� 3��
select id, job, nvl2(job, job||'�Դϴ�' , 'empty..') from t_emp;
select id, job, nvl2(job,'AAAA', 'BBBB') from t_emp;

--�ڡڡ�3. decode()�ڡڡ� : sql ���� ����� ����.
--decode(ǥ����, ����1, ���1, ����2, ���2, ����3, ���3.....)
--��� ������ ����
select id,job, decode(id,100,'IT...', -- id�� 100 �̸�
                         200,'SALES...', -- 200�̸�
                         300,'MGR...', --300�̸�
                         'ETC...') as "decodejob" -- �׿ܴ� 
from t_emp;

select job, decode(job,'IT',1) from t_emp; --�⺻���� ������ decode ���ǿ� �ش���� �ʴ� �� null
select job, decode(job,'IT',1,1111) from t_emp; -- null �� ������ �⺻�� ä���ֱ�..

--Ȱ��(��赥����)
select decode(job,'IT',1) as "IT",
       decode(job,'SALES',1) as "SALES",
       decode(job,'MGR',1) as "MGR"
from t_emp;

--���赥����
select count(decode(job,'IT',1)) as "IT", --count ���ڸ� ����.
       count(decode(job,'SALES',1)) as "SALES",
       count(decode(job,'MGR',1)) as "MGR"
from t_emp;

/*
emp ���̺��� �μ���ȣ�� 10�̸� '�λ��' , 20 '������' , 30 'ȸ���' ������ �μ� ��ȣ��
'��Ÿ�μ�' ��� ����ϴ� �������� ���弼��
decode �� ����ؼ�
*/
select empno, ename, deptno, decode(deptno,10,'�λ��',
                                           20,'������',
                                           30,'ȸ���',
                                           '��Ÿ�μ�') as "�μ���"
from emp;

create table t_emp2(
id number(2),
jumin char(7)
);

select * from t_emp2;
insert into t_emp2(id,jumin) values(1,'1234567');
insert into t_emp2(id,jumin) values(2,'2234567');
insert into t_emp2(id,jumin) values(3,'3234567');
insert into t_emp2(id,jumin) values(4,'4234567');
insert into t_emp2(id,jumin) values(5,'9234567');
commit;

--t_emp2 id,jumin jumin�� ���ڸ��� 1�̸� ����, 2�̸� ����, 3�̸� �߼�, �� �ܴ� ��Ÿ
select id, decode(substr(jumin,1,1),1, '����',
                                    2, '����',
                                    3, '�߼�',
                                    '��Ÿ') as "����"
from t_emp2;

--���̵� �߱�
--java if(if()) oracle decode(decode())

--emp���̺��� �μ���ȣ�� 20�� ����� �� �̸��� ���̽��� hello �� �ܴ� world, �μ���ȣ�� 20�� �ƴϸ� etc ���
select deptno, ename, decode(deptno,20,decode(ename,'SMITH','HELLO',
                                                    'WORLD'),
                                    'ETC') as "decode"
from emp;

--CASE �� java : switch
/*
  CASE ���� WHEN ���1 THEN ���1
                WHEN ���2 THEN ���2
                WHEN ���3 THEN ���3
                WHEN ���4 THEN ���4
                ELSE  ���5
  END "�÷���"
*/

create table t_zip(zipcode number);
insert into t_zip(zipcode) values(2);
insert into t_zip(zipcode) values(31);
insert into t_zip(zipcode) values(32);
insert into t_zip(zipcode) values(33);
insert into t_zip(zipcode) values(41);
commit;

select * from t_zip;

select 'O'||to_char(zipcode), case zipcode when 2 then '����'
                                           when 31 then '���'
                                           when 32 then '����'
                                           when 41 then '����'
                                           else '��Ÿ����'
                              end "regionname"
from t_zip;

/*
������̺��� ����޿��� 1000�޷� ���ϸ� 4��   
1001 �޷� 2000�޷� ���ϸ� 3��
2001 �޷� 3000�޷� ���ϸ� 2��
3001 �޷� 4000�޷� ���ϸ� 1��
4001 �޷� �̻��̸� Ư���� �ο��ϴ� �����͸� ����ϼ��� 

1. case �������� ������.
   case �÷��� when ��� then ���
2. case when �÷��� ���Ǻ� ��� then
*/

select case when sal<=1000 then '4��' 
            when sal<=2000 then '3��'-- between 1001 and 2000 then
            when sal<=3000 then '2��'-- between 2001 and 3000 then
            when sal<=4000 then '1��'-- between 3001 and 4000 then
            else 'Ư��'
       end "�޼�", empno, ename, sal
from emp;

--���� -> ���� -> ��¥ -> ��ȯ -> �Ϲ��Լ� 
--�����Լ� �� 5 �� �׷� �Լ�(Multi Row Function) p75 PDF 67/340
--1. count(*), count(�÷���) >> ������ �Ǽ�
--2. sum()
--3. avg()
--4. max()
--5. min()
--���

--1. �����Լ��� �ݵ�� group by ���� ���� ���
--2. �ڡ� ��� �����Լ��� null�� ���� (�����Ұ�)
--3. �ڡ� select���� �����Լ� �̿��� �ٸ� �÷��� �ݵ�� group by���� ��õǾ�� �Ѵ�.
select * from emp;
select count(*) from emp; --row �� üũ 14
select count(empno) from emp; -- �������� �Ǽ� 14 (null X)
select count(comm) from emp; -- �������� �Ǽ� 6 (null X)

--null �Ǽ� ....
select count(nvl(comm,0)) from emp;

--�޿��� ��
select sum(sal) as "sum" from emp;

--��� �޿� ( �޿��� �� / ����� )
select trunc(avg(sal),0) as "avg" from emp;

--������ �� ��
select sum(comm) as "����" from emp; --4330
select trunc(avg(comm),0) as "��ռ���" from emp; --721
select comm from emp;
--null �� ������ ����.....
select trunc(avg(nvl(comm,0)),0) as "��ռ���" from emp; -- 309

select count(comm) from emp where comm is not null;
select count(comm) from emp;

select max(sal) from emp;
select min(sal) from emp;

-- �����Լ��� return �ϴ� ���� 1�� : ��� 1�� �̱⶧���� ��� ����.
select sum(sal), trunc(avg(sal)), max(sal), min(sal), count(sal), count(*) from emp;

--�μ��� ��� �޿�
select deptno, avg(sal) --3
from emp --1
group by deptno; --2

select avg(sal) from emp group by deptno;

--������ ��� �޿�, �޿���, �ִ�޿�, �ּұ޿�, �Ǽ��� ���
select job, trunc(avg(sal)), sum(sal), max(sal), min(sal), count(sal)
from emp
group by job;

/*
grouping ���� (�÷��� ����)
distinct �÷���1, �÷���2

order by �÷��� asc, �÷��� desc

group by �÷���1, �÷���2
*/
--�μ��� ������ �޿��� ���� ���ϼ���.
select deptno, job, sum(sal), count(sal)
from emp
group by deptno, job
order by deptno asc;

/*
select 5
from 1
where 2
group by 3
having 4
order by 6
*/

select job, avg(sal) from emp
group by job;
--������ ��ձ޿��� 3000�޷� �̻��� ����� ������ ��ձ޿��� ����ϼ���.
--��ձ޿� >= 3000 >> ��ձ޿��� group by �� ���� ���� ����.....
--where ��� �޿� �����͸� ����� �� ����...
--group by ����� ������ �Ŵ� ���� having 
--from ���� ������ : where
--group by���� ������ : having

select job, avg(sal) as "sal"
from emp
group by job
having avg(sal)>=3000; -- ��������� select ���� �����̶� ��Ī�� �ν����� ����.

select * from emp
/*
������̺��� ������ �޿����� ����ϵ� ������ ���� �ް� �޿��� ���� 5000 �̻��� ������� ����� ����ϼ���
--�޿��� ���� ���� ������ ����ϼ���
*/
select job, sum(sal)
from emp
where comm is not null
group by job
having sum(sal)>=5000
order by sum(sal);

/*
������̺��� �μ� �ο��� 4���� ���� �μ��� �μ���ȣ ,�ο��� , �޿��� ���� ����ϼ���
*/
select deptno, count(deptno), sum(sal)
from emp
group by deptno
having count(deptno)>=4

/*
������̺��� ������ �޿��� ���� 5000�� �ʰ��ϴ� ������ �޿��� ���� ����ϼ���
�� �Ǹ�����(salesman) �� �����ϰ� �޿������� �������� �����ϼ���
*/
select job, sum(sal)
from emp
where job != 'SALESMAN'
group by job
having sum(sal)>5000
order by sum(sal) desc;

/*
������̺��� ������ �޿��� ���� 2000 �̻� 5000 ������ ������ �޿��� ����� �ݿø��ؼ� ������ ����ϼ���
�� ������ �����ϰ� �޿� ������� �ø����� �����ϼ���
*/
select * from emp;
select job, sum(sal)
from emp
group by job

select job, round(avg(sal),0) as "��ձ޿�"
from emp
where job != 'PRESIDENT'
group by job
having sum(sal) between 2000 and 5000
order by "��ձ޿�";

/*4��
��� ���̺��� ������ ����(�޿�*12)�� ����� 5000�̻��� ����� ����, ������ ����� ����ϼ���
��, 'CLERK'�� �����ϰ� ���� ����� ������������ �����ϼ���
*/
select job, avg(sal*12) as "�������"
from emp
where job != 'CLERK'
group by job
having avg(sal*12) >= 5000
order by "�������";

/*3��
��� ���̺��� �̸��� M Ȥ�� A�� �����ϴ� ����� ����, ��� �޿��� ����ϼ���
�� Ŀ�̼��� ���� �ƴ� ��� �߿���.
*/--where ename like 'A%'; --A �� �����ϴ�.
select job, avg(sal)
from emp
where (ename like 'M%' or ename like 'A%') and comm is not null
group by job;

/*2��
������ �ȹ޴� �������� �μ���, ������ �޿��� ������ 1000�̻��� �μ��� ������ �μ���ȣ�� ���� �ѱ޿��� �μ���ȣ�� ������������, �ѱ޿��� ���� ������ ����Ͻÿ�
*/
select deptno, job, sum(sal)
from emp
where comm is null
group by deptno, job
having sum(sal) >= 1000
order by deptno desc, sum(sal) desc;

--//////////////////////////////////////////////////////////////////////////////////////
--���ݱ��� SELECT ��� �ϳ��� ���̺�...
--RDBMS ������ ������ ���̽�
--java : class �۾� : ���� ( ���, ����, ����, ...)
--DB : Table Table ���� ���踦 ������ �ִ�.
--1:1 1:n m:n
--���� ���ϴ� �����Ͱ� �ϳ��� ���̺� �ִ� ���� �ƴϰ� 1�� �̻��� ���̺� �������� �ִ�.
--�������� ���̺��� ���ϴ� �����͸� ����ϴ� ��� >> JOIN

--EMP ���̺��� deptno �� DEPT ���̺��� deptno �� �����Ѵ�.
--DEPT ���̺��� deptno �� EMP ���̺��� deptno �� �������Ѵ�.
select * from emp;
select * from dept;
select * from salgrade;

--����
--1. �����(Equi Join) -> 70%
-- �����̺�� �����Ǵ� ���̺� �ִ� �÷��� ������ 1:1 ��Ī
--[ANSI ����]
--���� : Join on~������ , [inner]join on~������
create table M (M1 char(6) , M2 char(10));
create table S (S1 char(6) , S2 char(10));
create table X (X1 char(6) , X2 char(10));

insert into M values('A','1');
insert into M values('B','1');
insert into M values('C','3');
insert into M values(null,'3');
commit;

insert into S values('A','X');
insert into S values('B','Y');
insert into S values(null,'Z');
commit;

insert into X values('A','DATA');
commit;

select * from m;
select * from s;
select * from x;
------------------�Ʒ��� sql join ���� �ǵ��� ���� ���ƶ�....
select *
from m,s
where m.m1 = s.s1; --null�� ������ ����.
--m1=s1 �� ���� �÷��� ����.

select m.m1,m.m2,s.s2
from m,s
where m.m1 = s.s1;

select emp.empno, emp.ename, emp.DEPTNO, dept.dname
from emp, dept
where emp.deptno = dept.deptno;

----------------------------------------------------------------------------
--ANSI ����
select * 
from m join s
on m.m1 = s.s1;

select m.m1, m.m2, s.s2
from m inner join s
on m.m1 = s.s1;

select emp.empno, emp.ename, emp.DEPTNO, dept.dname
from emp join dept
on emp.deptno = dept.deptno;

select e.empno, e.ename, e.DEPTNO, d.dname
from emp e join dept d -- table �� ����Ī �ο�
on e.deptno = d.deptno;

select *
from m, s
where m.m1 = s.s1 and m.m1='A'; -- join �� �������� from �� �������� �� �� ����..

select *
from m join s on m.m1=s.s1 -- join�� ����
where m.m1='A'; -- from �� ����

select *
from s join x
on s.s1 = x.x1;

--1�� �̻��� ���̺��� join �ɱ�.
--sql join ����
select * 
from m , s, x
where m.m1 = s.s1 and s.s1 = x.x1;

---ANSI ����
select m.m1, m.m2, s.s2, x.x2
from m join s on m.m1 = s.s1 
       join x on s.s1= x.x1;

--���, �̸�, �μ���ȣ, �μ���, �޿�, �޿������ ����ϼ���.
select * from emp;
select * from salgrade;

select e.EMPNO, e.ENAME, e.DEPTNO, d.DNAME, e.SAL, s.GRADE
from emp e join dept d on e.deptno = d.deptno
           join salgrade s on e.SAL between s.LOSAL and s.HISAL -- ������
order by e.empno;

--1. HR �������� �̵�...
select * from tabs; -- ������ ������ �����ִ� table �� ���
select * from EMPLOYEES;
select * from DEPARTMENTS;
select * from LOCATIONS;

-- 1. ���, �̸�(last_name), �μ���ȣ, �μ��̸��� ���
select e.EMPLOYEE_ID, e.LAST_NAME, e.DEPARTMENT_ID, d.DEPARTMENT_NAME
from EMPLOYEES e join DEPARTMENTS d on e.DEPARTMENT_ID = d.DEPARTMENT_ID;
--������ ����� 107�� >> ���� ��µ� 106 (�μ���ȣ null...)
--����� ���� �� ���� �ذ� �Ұ���... >> �ذ� (outer join)

--2. ���, �̸�(last_name), �μ���ȣ, �μ���, ���ø�
select e.EMPLOYEE_ID, e.LAST_NAME, e.DEPARTMENT_ID, d.DEPARTMENT_NAME, l.CITY
from EMPLOYEES e join DEPARTMENTS d on e.DEPARTMENT_ID = d.DEPARTMENT_ID
                 join LOCATIONS l on d.LOCATION_ID = l.LOCATION_ID;

--2. ������(non-euqi join) : �ǹ̸� ���� -> ������ �����
--�����̺�� �����Ǵ� ���̺� �ִ� �÷��� 1:1 ���ε��� ���� �����
-- emp, salgrade : sal�÷��� ������ ... 2���� �÷�( losal, hisal)
--��(1:1 ��Ī�Ǵ� �÷��� ����.)
select * from emp;
select * from salgrade;

--3. �ܺ�����(outer join) : null 
--�ΰ��� ���̺��� ��, �� ���� �ľ�
--����
-- left outer join ( ���� ��, ������ �� )
-- right outer join( ������ ��, ���� �� )
-- full outer join(left,right union)
-- ���������� ������� ���� �����ϰ� (��,��) ���� �ľ� �� ������ �Ǵ� ���̺� �����ִ� �����͸� ���� �´�.

select *
from m join s
on m.m1 = s.s1;

select *
from m left outer join s
on m.m1 = s.s1;


-- 1. ���, �̸�(last_name), �μ���ȣ, �μ��̸��� ���
--������ ����� 107�� >> ���� ��µ� 106 (�μ���ȣ null...)
select e.EMPLOYEE_ID, e.LAST_NAME, e.DEPARTMENT_ID, d.DEPARTMENT_NAME
from EMPLOYEES e left outer join DEPARTMENTS d on e.DEPARTMENT_ID = d.DEPARTMENT_ID;
--����� ���� �� ���� �ذ� �Ұ���... >> �ذ� (outer join)

--2. ���, �̸�(last_name), �μ���ȣ, �μ���, ���ø�
select e.EMPLOYEE_ID, e.LAST_NAME, e.DEPARTMENT_ID, d.DEPARTMENT_NAME, l.CITY
from EMPLOYEES e left outer join DEPARTMENTS d on e.DEPARTMENT_ID = d.DEPARTMENT_ID
                 left outer join LOCATIONS l on d.LOCATION_ID = l.LOCATION_ID;


select *
from m full outer join s
on m.m1 = s.s1;

--4. self join(�ڱ�����)
--emp ���̺��� smith ����� ������ �̸�
--�ϳ��� ���̺��� � �÷��� �ٸ� �÷��� ���� �ϴ� ��쿡 
select * from emp;

--����� ���� king �����͵� ���� ������... left outer ����.
select e.empno, e.ename, m.empno, m.ename
from emp e left outer join emp m
on e.MGR = m.EMPNO;

select * from emp;
-- 1. ������� �̸�, �μ���ȣ, �μ��̸��� ����϶�.
select e.ename, e.deptno, d.DNAME
from emp e join dept d
on e.DEPTNO = d.DEPTNO;
 
select * from dept;
-- 2. DALLAS���� �ٹ��ϴ� ����� �̸�, ����, �μ���ȣ, �μ��̸���
-- ����϶�.
select e.ename, e.JOB, e.DEPTNO, d.DNAME
from emp e join dept d
on e.DEPTNO = d.DEPTNO
where d.LOC = 'DALLAS';

 
-- 3. �̸��� 'A'�� ���� ������� �̸��� �μ��̸��� ����϶�.
select e.ename, d.DNAME
from emp e join dept d on e.DEPTNO = d.DEPTNO
where ename like '%A%';

-- 4. ����̸��� �� ����� ���� �μ��� �μ���, �׸��� ������
--����ϴµ� ������ 3000�̻��� ����� ����϶�.
select emp.ename, dept.dname, emp.sal
from emp join dept on emp.DEPTNO = dept.DEPTNO
where SAL >= 3000;

 
-- 5. ����(����)�� 'SALESMAN'�� ������� ������ �� ����̸�, �׸���
-- �� ����� ���� �μ� �̸��� ����϶�.
select e.job, e.ename, d.DNAME
from emp e join dept d on e.DEPTNO = d.DEPTNO
where job = 'SALESMAN';

-- 6. Ŀ�̼��� å���� ������� �����ȣ, �̸�, ����, ����+Ŀ�̼�,
-- �޿������ ����ϵ�, ������ �÷����� '�����ȣ', '����̸�',
-- '����','�Ǳ޿�', '�޿����'���� �Ͽ� ����϶�.
--(�� ) 1 : 1 ���� ��� �÷��� ����
select e.empno as "�����ȣ", e.ename as "����̸�", e.SAL*12 as "����", e.SAL+e.COMM as "�Ǳ޿�", s.GRADE as " �޿����"
from emp e join salgrade s on e.SAL between s.losal and s.HISAL
where comm is not null;

-- 7. �μ���ȣ�� 10���� ������� �μ���ȣ, �μ��̸�, ����̸�,
-- ����, �޿������ ����϶�.
select e.DEPTNO, d.DNAME, e.ENAME, e.sal, s.GRADE
from emp e join dept d on e.DEPTNO = d.DEPTNO
           join salgrade s on e.SAL between s.losal and s.hisal
where e.deptno = 10; 
 
-- 8. �μ���ȣ�� 10��, 20���� ������� �μ���ȣ, �μ��̸�,
-- ����̸�, ����, �޿������ ����϶�. �׸��� �� ��µ�
-- ������� �μ���ȣ�� ���� ������, ������ ���� ������
-- �����϶�.
select e.DEPTNO, d.DNAME, e.ENAME, e.SAL, s.GRADE
from emp e join dept d on e.DEPTNO = d.DEPTNO
           join salgrade s on e.SAL between s.losal and s.hisal
where e.deptno=10 or e.deptno=20
order by d.DEPTNO asc, e.sal desc;
 
-- 9. �����ȣ�� ����̸�, �׸��� �� ����� �����ϴ� ��������
-- �����ȣ�� ����̸��� ����ϵ� ������ �÷����� '�����ȣ',
-- '����̸�', '�����ڹ�ȣ', '�������̸�'���� �Ͽ� ����϶�.
--SELF JOIN (�ڱ� �ڽ����̺��� �÷��� ���� �ϴ� ���)

select e.empno as "�����ȣ", e.ename as "����̸�", e.MGR as "�����ڹ�ȣ", em.ENAME as "�������̸�"
from emp e left outer join emp em on e.mgr = em.empno;



