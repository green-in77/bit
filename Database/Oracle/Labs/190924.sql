--190924
---[1����]
SELECT [DISTINCT]  {*, column [alias], . . .}
FROM  table_name
[WHERE  condition]
[ORDER BY {column, expression} [ASC | DESC]]; 
/*
[] = ���ȣ�� ���� �����ϴ�.
{} = �ݵ�� �־�� �Ѵ�.

DISTINCT  �ߺ� �� ���� �ɼ� 
*   ���̺��� ��� column ��� 
alias   �ش� column �� ���� �ٸ� �̸� �ο� 
table_name ���̺�� ���� ��� ���̺� �̸� 
WHERE   ������ �����ϴ� ��鸸 �˻� 
condition  column, ǥ����, ��� �� �� ������ 
ORDER BY  ���� ��� ������ ���� �ɼ�(ASC:��������(Default),DESC ��������)
*/
--1. ������̺� �ִ� ��� �����͸� ����ϼ���.
select * from emp;
SELECT * FROM EMP; --�������� ��ҹ��� �������� ����.

--2. Ư�� �÷� ������ �����ϱ�
select empno, ename, job, sal from emp;
select empno from emp;
select hiredate, deptno from emp;

--3. �÷��� ����Ī(alias) �ο��ϱ�
select empno ���, ename �̸� from emp;
--select empno ��    ��, ename ��    �� from emp;
--���� ���� �νĺҰ�
select empno "��    ��", ename "��    ��" from emp;
--�ֵ���ǥ�� ������ ���ڿ��� �ν�(����ǥ���� �ƴ�..)

--���Ĺ���(ansi ǥ��) >> ������� as
select empno as "��    ��", ename as "��    ��" from emp;

--oracle : ���ڿ� ������ ( �����ϰ� ��ҹ��� ���� )
--������ : a��A �ٸ� ����
--���ڿ�(����) ������ : ''
select * from emp where ename='king'; -- �ҹ��� king ����
select * from emp where ename='King'; -- King ����
select * from emp where ename='KING'; -- �빮�� KING ����

--oracle : ������(���� ������) >> || >> 'hello' || 'world' >> ���� 'helloworld'
--java : + ���&���� 10 + 10 (���) / "A"+"B" (����)
--TIP) ms-sql : + ����&����

--oracle ���� "" ���� ���� ����Ī �ۿ� ����..
select '����� �̸��� ' || ename || ' �Դϴ�.' as "��   ��"
from emp;

--java : class Emp {private int empno;}
--POINT : ����Ŭ�� �÷��� Ÿ�� ������ ���´�.
--���� ���� ������ �ִ� emp ���̺��� ������ ���� ���
desc emp; -- emp �÷��� Ÿ�� ����

select empno + ename as "����" -- ����Ŭ + �� ������ �������
from emp; --invalid number ename �����Ͱ� ���ڰ� �ƴ϶� ������ ���Ѵ�...

select empno || ename as "����" -- ���� || ���� ���� ���� - ���� ���������� �ڵ�����ȯ(���� -> ����) to_char() �Լ� ����
from emp;

--���� ����(������ ��� �ֳ�??)
select job from emp;
--�ߺ� ������ ���� Ű���� : distinct
select distinct job from emp;
select distinct deptno from emp;

----�ڡ�distinct ���� ( �÷��� 2�� �̻� ) -- grouping (�׸��׷��� �����ϱ�...)
select job,deptno from emp order by job;
select distinct job, deptno from emp order by job;
--�ΰ��� �� �´� �͸� �ߺ����� ���
--1. job ���� �׷��� ���, deptno �� �� �׷��� ����.
--order by : ����
select distinct deptno, job from emp order by deptno;

--����Ŭ(���) (SQL ����ȭ�� ���Ǹ� �� �� �ִ� ���)
--java �� ���. (������)
--����Ŭ�� ������(�ڹٿ� 80% ���� ��ġ)
--java % ������ -> ����Ŭ % �˻��� �����ڿ����� Ȱ�� >>
-- ����Ŭ ������ ���� �Լ���� : Mod()
--oracle (+,-,*,/) + mod()

--������̺��� ����� �޿��� 100�޷� �λ��� ����� ����ϼ���.
desc emp;
select empno, ename, sal, sal + 100 as "�λ�޿�"
from emp;

------------��̷�~~--------
select 100 + 100 from dual; -- ���� �ӽ÷� ��� ���̺� dual(test �� ���)
select 100 || 100 from dual; -- || ���ڿ� �������� ó��. ( 100100 )
select '100' + 100 from dual; -- +�� ��������̶� ����100�� ����100���� ����ȯ
select 'A100'+100 from dual; -- error A�� ���ڶ� ���ó�� �Ұ�.

--�񱳿�����
-- > , < , <= ....
--java ���� == ,  �Ҵ� =
--javascript ���� ===
--����Ŭ ���� = , �����ʴ� !=

--��������
-- AND, OR, NOT

/*
SELECT [DISTINCT]  {*, column [alias], . . .}
FROM  table_name
[WHERE  condition]
[ORDER BY {column, expression} [ASC | DESC]]; 
*/

--������ ( ���ϴ� row�� ������ �´� )
--������� from -> where -> select 
select *            --3
from emp            --1
where sal >= 3000;  --2

--�̻�, ���� ( = ���� )
--�ʰ�, �̸�

--����� 7788���� ����� ���, �̸�, ����, �Ի����� ����ϼ���.
select empno, ename, hiredate -- 3�� ����
from emp                      -- 1�� ��������
where empno=7788;             -- 2�� ����

--����� �̸��� KING �� ����� ���, �̸� �޿� ���� ���
select empno, ename, sal 
from emp
where ename = 'KING';

--�޿��� 2000�޷� �̻��̸鼭 ������ maneger �� ����� ��� ����
--AND OR NOT
select *
from emp
where sal >= 2000 and job='MANAGER';

--�޿��� 2000�޷� �̻��̰ų� ������ maneger �� ����� ��� ����
select *
from emp
where sal >= 2000 or job='MANAGER';

--����Ŭ��¥ = DB������ ��¥
--�ý��� : ��¥�� ������ �ִ� >> sysdate
select sysdate from dual; --����ŬDB�� �ð� 19/09/24 (PC�� ��¥�� �ƴ�)
--ǥ��� fomating�� ���� �ٲ� �� ����.
--�Խ��� �۾��� : insert into board(writer, title, content, regdata)
--              values('ȫ�浿', '�氡�氡', '�������', systate);
--TIP) ms-sql >> selest getdate() �Լ��� ������.

select hiredate from emp;
desc emp; --DATE
--����Ŭ [�ý�������] �� ��� ���̺��� ������ ����
--ȯ�漳��
select * from SYS.NLS_SESSION_PARAMETERS;
-- NLS_LANGUAGE	KOREAN
-- NLS_DATE_FORMAT	RR/MM/DD -> ���浵 ����.
-- NLS_DATE_LANGUAGE	KOREAN
-- NLS_TIME_FORMAT	HH24:MI:SSXFF

select * from SYS.NLS_SESSION_PARAMETERS where parameter = 'NLS_DATE_FORMAT';
--POINT
--�������ؿ��� ���� ���� ���� (DBA)
--���� ������ �����(session) �� �������� ��������
--�ٸ� ������ bituser �� �����ϸ� ��¥������ ��������ʰ� �״�� ������..
--�����ӽ� �ٽ� �������� �������� ���ƿ�.

alter session set nls_date_format='YYYY-MM-DD HH24:MI:SS'; -- ����
select * from SYS.NLS_SESSION_PARAMETERS where parameter = 'NLS_DATE_FORMAT'; -- ����Ȯ��

--NLS_DATE_FORMAT	YYYY-MM-DD HH24:MI:SS
select sysdate from dual; --2019-09-24 11:51:51
select hiredate from emp; --1980-12-17 00:00:00 ������ĺ����.

select *
from emp
where hiredate='1980-12-17'; --��¥ ���� ǥ�� (���ڵ���)

select *
from emp
where hiredate='1980/12/17'; -- ������ ������- �Ǵ� ������/ �Ѵ� ��밡��

select * from emp;
select *
from emp where hiredate='80-12-17'; -- ��¥ ������ �����س��� ������ ��ȸ �Ұ�.
--RR/MM/DD -> YYYY/MM/DD

-- ����� �޿��� 2000�޷� �̻��̰� 4000�޷� ������ ��� ����� ����
select *
from emp
where 2000<=sal and sal<=4000;
--�ڡڿ����� : �÷��� between A and B (** =�� ����, �̻����ϸ� ���� - �ʰ��̸��� �Ұ�)
select *
from emp
where sal between 2000 and 4000;

--����� �޿��� 2000 �ʰ� 4000 �̸�
select *
from emp
where 2000<sal and sal<4000;

--�μ���ȣ�� 10�� �Ǵ� 20�� �Ǵ� 30���� ����� ���, �̸�, �޿�, �μ���ȣ ���
select empno, ename, sal, deptno
from emp
where deptno=10 or deptno=20 or deptno=30;
--�ڡ�IN ������ (���� or ���� or ���� or.....)
select empno, ename, sal, deptno
from emp
where deptno in (10,20,30);

--�μ���ȣ�� 10�� �Ǵ� 20���� �ƴ� ����� ���, �̸�, �޿�, �μ���ȣ ���
--10���� �ƴϰ� 20���� �ƴ� ��.
SELECT empno, ename, sal, deptno
from emp
where deptno!=10 and deptno!=20;
--�ڡ� NOT IN ������
SELECT empno, ename, sal, deptno
from emp
where deptno not in (10,20);

--Point : ���� ����(�����Ͱ� ����) = null
-- null (�ʿ��)

create table member( --table ����
userid varchar2(20) not null, --�ѱ� 10��(20byte), null�Ұ� ������ �ݵ�� �־����.
name varchar2(20) not null,
hobby varchar2(20) -- default >> null (null�� ���) : �ʼ��Է� �ƴ�.
);

desc member;

insert into member(userid, name) values('hong','ȫ�浿');
select * from member;

insert into member(userid, hobby) values('kim','��');
--ORA-01400: cannot insert NULL into 

insert into member(userid, name, hobby) values('pqck','�ڱ�','�౸');
select * from member;

--�����ݿ�
commit;
select * from member;

--������ ���� �ʴ� ��� ����� ������ ���
--null�� �ٸ� �����ڸ� ���´�... is null ( comm = null ����XXXXXXXXXX )
select *
from emp
where comm is null; -- null �񱳴� ��is null��

--������ �޴� ��� ����� ���� (null �� �ƴ� ���)
select *
from emp
where comm is not null;

--������̺��� ���, �̸�, �޿�, ����, �ѱ޿� ��� (�ѱ޿�=�޿�+����)
select empno, ename, sal, comm, sal+comm as "�ѱ޿�" -- null ���� �ȵ�....
from emp;

--Point(null)
--�ڡ� null ���� ��� ������ �� ����� : null
--�ڡڡڡڡڡ� nvl() �ڡڡڡڡڡڡ� - nul2()
-- null�� ������ ��ü������ �ٲ��.
--ms-sal : convert() / my-sql : IFNULL()

select 1000 + null from dual;
select 1000 + nvl(null,0) from dual; -- null �� 0����
select 1000 + nvl(null,1111) from dual; --null �� 1111��

select 'A' || null from dual; -- || ���ڿ� ����. A

select comm, nvl(comm,0) from emp;
--�ڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡ�
select empno, ename, sal, comm, sal+nvl(comm,0) as "�ѱ޿�"
from emp;
--�ڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡ�

--����� �޿��� 1000 �̻��̰� ������ �����ʴ� ����� ���, �̸�, ����, �޿�, ���� ���
select empno, ename, job, sal, comm
from emp
where sal >= 1000 and comm is null;

--DQL (data query language) : select
--DDL : create alter, drop (��ü�� ����, ����, ����)

create table board(
boardid number not null,
title varchar2(20) not null, --������,Ư��,���� : 1byte / �ѱ� : 2byte
content varchar2(2000) not null,
hp varchar2(20)
);
desc board;

--DML(������ ���۾�) : insert, update, delete
--�۾��ÿ��� [�����ݿ�] �̳� ���ó���� ���� (commit, rollback) �ݵ�� ���
insert into board(boardid, title, content)
values(100,'����Ŭ','������');
commit;

insert into board(boardid, title, content)
values(200,'��Ŭ','����');

insert into board(boardid, title, content)
values(300,'�ڹ�','����');
ollback;

select * from board;

--insert, update, delete �۾� ����Ŭ(������ commit, rollback �۾� �ݵ��)
--ms-sql(Auto commit) >> default commit; begin tran ~~~ commit or rollback

select BOARDID,hp, nvl(hp,'�ڵ��� �����') as "hp" -- nvl ���ڿ��� ���� �����ϴ�.
from board;
-- nvl�Լ��� ����,��¥,���ڿ��� ���� �����ϴ�.

--���ڿ� �˻�
--�ּҰ˻� : '����' �˻��ϸ� ���� ���ڿ� ����ִ� �ּҰ� �� ���´�.
--���ڿ� ���� �˻�(LIKE ������)

--like ������ (���ϵ� ī�� ���� [ % : ����, _ : �ѹ���] ����

select *
from emp
--where ename like '%A%'; --A �� ����ִ� ��� �̸� �˻�
where ename like 'A%'; --A �� �����ϴ�.
--where ename like '%A%A%'; --AA , ABA

select *
from emp
--where ename like '_A%'; --ù��° ���� �������, �ι�° ���ں��� A�� ���ԵǴ� ��.
where ename like '__A%'; --1,2 ���� �������, 3���ں��� A�� ���ԵǴ� ��.


--����Ŭ ���� (regexp_like) ���� ���� �˻�
--select * from emp where regexp_like (ename, ����ǥ����);
--����Ŭ ����ǥ����� �˻� ���� ����� (����3��) : �߰�������Ʈ �ݿ�......


--������ �����ϱ�
--order by �÷��� (����, ����, ��¥) asc or desc
--�������� : asc ������ ���� (default)
--�������� : desc ������ ����

select * from emp order by sal; --�޿��� ����������... asc �⺻
--select * from emp order by sal asc;

--�޿��� ���� �޴� ������ ����
select * from emp order by sal desc;

--A ����...���ڿ� ����
select * from emp order by ename asc;

--�Ի����� ���� ���� ������ ���� ���, �̸�, �޿�, �Ի���
select empno, ename, sal, hiredate
from emp
order by hiredate desc;

/*
select 3
from 1
where 2
order by 4 --select �� ����� ����
*/

select empno, ename, sal, job, hiredate
from emp
where job='MANAGER'
order by hiredate desc;
-- ������ �Ŵ����� �������� ���,�̸�,�޿�,����,�Ի����� �Ի����� ���� ������ �����ؼ�

select deptno, job
from emp
order by deptno desc, job asc; --���� 2��
-- ������̺��� �μ���ȣ, ������ ����ϵ� �μ���ȣ ��������, ������ ������������

select DISTINCT job
from emp;