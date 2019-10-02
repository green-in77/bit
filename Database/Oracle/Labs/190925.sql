--190925
--������
--������(union) : ���̺�� ���̺��� �����͸� ���ļ� �����ִ� ��.(�ߺ����� ����)
--������(union all) : �ߺ����� ���.

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
union --ut���� uta�� ���� ��ĥ���� �ߺ����� �ѹ���
select name from uta;

select name from ut
union all--ut���� uta�� ���� ��ĥ���� �ߺ� ��� ���
select name from uta;

--union ��Ģ
--�ڡ�1. �����Ǵ� �÷��� Ÿ���� ���� ( ut name : varchar2 = uta name : varchar2 )
select empno, ename from emp
union --empno nembr != dname varchar2 union �Ұ�
select dname, deptno from dept;

select empno, ename from emp
union 
select deptno, dname from dept;

--�ڡ�2. �����Ǵ� �÷��� ������ ���� (null �ʿ�)
select empno, ename, job, sal from emp
union --������ 4, �ؿ��� 3
select deptno, dname, loc from dept;

select empno, ename, job, sal from emp
union --null �� �÷��� ������ ������
select deptno, dname, loc, null from dept;

--����Ŭ �Լ� PDF 48page (40/340)
/*
4�� �������Լ�
1) ������ �Լ� : ���ڸ� �Է� �ް� ���ڿ� ���� �� ��θ� RETURN �� �� �ִ�.
2) ������ �Լ� : ���ڸ� �Է� �ް� ���ڸ� RETURN �Ѵ�.
3) ��¥�� �Լ� : ��¥���� ���� �����ϰ� ���ڸ� RETURN �ϴ� MONTHS_BETWEEN �Լ��� �����ϰ� ��� ��¥ ���������� ���� RETURN �Ѵ�.
4) ��ȯ�� �Լ� : � ���������� ���� �ٸ� ������������ ��ȯ�Ѵ�.
5) �Ϲ����� �Լ� : NVL, DECODE 
*/

--���ڿ��Լ� (�ڹ� ��Ʈ��Ŭ������ ����)
select initcap('the super man') from dual; --The Super Man �ܾ��� ù���ڸ� �빮�ڷ�
select lower('AAA'),upper('aaa') from dual; --�빮�� -> �ҹ��� / �ҹ��� -> �빮��
select ename , lower(ename) as "ename" from emp; -- �÷��� ��ü �Լ� ����
select * from emp where lower(ename) = 'king'; --�˻� �� �ش��÷��� �����͸� �ҹ��ڷ� �ٲ㼭

--������ ����(length)
select length('abcd') from dual; --4��
select length('ȫ�浿�ٺ�') from dual; --5��
select length('ȫ�浿  �ٺ�') from dual; --7�� ���鵵 ����

--���տ����� ||
--�����Լ� concat
select 'a' || 'b' || 'c' from dual;
select concat('a','b') from dual;
select concat(ename,job) from emp; -- ename+job ���ļ� ���
select ename||' '||job from emp;

--�κ� ���ڿ� ����
--java(substring)
--oracle(substr)
select substr('ABCDE',2,3) from dual; --BCD 2���� 3����
select substr('ABCDE',1,1) from dual; --A
select substr('ABCDE',3,1) from dual; --C
select substr('ABCDE',3) from dual; --CDE 3��°���� ������
select substr('ABCDE',-2,1) from dual; --D -2�� �ڿ������� 
select substr('ABCDE',-2,2) from dual; --DE -2�� �ڿ������� 

/*
������̺��� ename �÷������Ϳ� ���ؼ� ù���ڴ� �ҹ��ڷ� �������� �빮�ڷ� ����ϵ�
�ϳ��� �÷������ͷ� ���
�÷��� ����Ī:fullname
ù���ڿ� ������ ���ڻ��̿� ����
ex ) SMITH ��� : s MITH
*/
select lower(substr(ename,1,1))||' '||upper(substr(ename,2)) as fullname
from emp;

--lpad, rpad(ä���)
--����ä���, ������ä���
select lpad('abc',10,'*') from dual; --���� ���� 10 *�� ä����
select rpad('abc',10,'#') from dual; --������ ���� 10 *�� ä���� abc####### ( �� 10�����ε� �۾� �̿��� �������� ä���� )

--QUIZ
--����� ��� : hong1006
--ȭ�鿡 ho******(���� �� ���ڸ� �����ְ� �������� *��)
select rpad(substr('hong1006',1,2),length('hong1006'),'*') as "password" from dual; --ho****** �� 8�ڸ� �� ho �� �����ְ� �������� * ó��

--emp ���̺��� ename �÷��� �����͸� ����ϴµ� ù���ڸ� ����ϰ� �������� *�� ���
select rpad(substr(ename,1,1),length(ename),'*') as ename from emp;

create table member2(
id number,
jumin varchar2(14)
);

insert into member2(id,jumin) values (100,'123456-1234567');
insert into member2(id,jumin) values (200,'234567-1234567');
commit;

select * from member2;

--QUIZ 100 : 123456-******* / 200 : 234567-******* ����Ī : jumin
select id||' : '||rpad(substr(jumin,1,7),length(jumin),'*') as "jumin" from member2;

--rtrim, ltrim
--������ ���������, ���� ���������
select rtrim('MILLER','ER') from dual; --�����ʿ��� ���� ���ڸ� ã�Ƽ� �����
select ltrim('MILLLLLLLER','MIL') from dual; -- ���ʿ��� MIL �� ã�Ƽ� ����µ� �ߺ��� ���� ����. ��� : ER

--ġȯ�Լ�
--replace
select ename, replace(ename,'A','�Ϳ�') from emp; -- A�� �Ϳ�� ����

--//////////////////////////////////���ڿ��Լ� END/////////////////////////////////

--���� �Լ�
--round �ݿø�
--       ����     0    ���
-- (... -3 -2 -1 0 1 2 3 ...)
select round(12.567,0) as "r" from dual; --�ݿø��ϴ� �Ҽ��� �ڸ��� 0 13
select round(12.567,1) as "r" from dual; --�ݿø��ϴ� �Ҽ��� �ڸ��� 1 12.6
select round(12.537,-1) as "r" from dual; --�ݿø��ϴ� �Ҽ��� �ڸ��� -1 10
select round(15.537,-1) as "r" from dual; --�ݿø��ϴ� �Ҽ��� �ڸ��� -1 20

--trunc ����
select trunc(12.567,0) as "t" from dual; --������ �Ҽ��� �ڸ��� 0 12
select trunc(12.567,1) as "t" from dual; --������ �Ҽ��� �ڸ��� 1 12.5
select trunc(12.567,-1) as "t" from dual; --������ �Ҽ��� �ڸ��� -1 10
select trunc(15.537,-1) as "t" from dual; --������ �Ҽ��� �ڸ��� -1 10
select trunc(15.537,-2) as "t" from dual; --������ �Ҽ��� �ڸ��� -2 0

--mod ������
select 12/10 from dual; -- 1.2 ��.������ �Բ�����.

select MOD(12,10) from dual; -- 12�� 10�� ���� ������ 2
select MOD(10,4) from dual; -- 10�� 4�� ���� ������ 2
select MOD(8,4) from dual; -- 8�� 4�� ���� ������ 0
select MOD(0,0) from dual; -- 0�� 0�� ���� ������ 0 �ڡ� �ڹٿ� �ٸ��� 0/0 ����

--////////////////////////////////////�����Լ� END//////////////////////////////////////

--��¥�Լ�
--sysdate
select sysdate from dual;
select hiredate from emp;
--date + number >> date
--date - number >> date
--date - date >> number (�ϼ�)

--��¥�� round, trunc ���밡��
select months_between('2019-02-27','2010-02-27') from dual;--������ �� 108 ����
select round(months_between(sysdate,'2010-01-01'),0) from dual;--117 ����
select trunc(months_between(sysdate,'2010-01-01'),0) from dual;--116 ����

select '2015-01-01' + 1000 from dual; --invalid number 2015-01-01 ���ڷ� ���

select to_date('2015-01-01') + 1000 from dual; --2017-09-27 00:00:00
--to_date �� ��¥�� �νĵǵ��� ����.

select sysdate + 100 from dual;

--QUIZ
/*
1. ������̺��� ������� �Ի��Ͽ��� ���糯¥(sysdate) ������ �ټӿ��� - ������ �����
2. �Ѵ��� 31�� �̶�� �����ϰ� �ټӿ����� ���ϼ���.
*/

select ename, hiredate, sysdate, trunc(months_between(sysdate, hiredate),0) as "�ټӿ���", trunc((sysdate-hiredate)/31,0) as "�ټӿ���2" from emp;
--                                                                               465                                        456
--///////////////////////////////////////////��¥�Լ� END/////////////////////////////////////////////////

--��ȯ�Լ��ڡڡڡڡڡڡڡڡ�
--oracle : ����, ����, ��¥ ������
--to_char() : ���� 10000 -> ���� $10,000 / ��¥ 1900-01-01 -> ���� 1900��01��01��
-- ������ �����ϴ� �뵵�� ���

--to_date() : ���� -> ��¥ >> selete '2019-12-12'+100 >>select to_date('2019-12-12)...

--to_number : ���� -> ���� (�ڵ�����ȯ�� �Ǳ⶧���� �� ���� ����)
select '100' + 100 from dual; -- 200 ������ ����
select to_number('100')+100 from dual;

/*
����Ŭ �⺻ Ÿ��(������ Ÿ��)
create table ���̺�� (�÷���  Ÿ�� ); 
create table member(age number); 100�� ������ insert
--java > class member { int age } >> member m = new member(); 1��
--java > List<member> list = new ArrayList<>();   list.add(new member()) ������

���� Ÿ��
--char(20) >> 20byte >> �ѱ�10��,  ������,Ư������,���� 20��  >> �������̹��ڿ�
--varchar2(20) >>  20byte >> �ѱ�10��,  ������,Ư������,���� 20��  >> �������̹��ڿ�

char(20) >> 'ȫ�浿' >> 20byte ��� ��� 
varchar2(20) >> 'ȫ�浿' >> ������ ũ�� >> 6byte

�����ȵ����� : �� , ��   >> ó��  >> char(2)
�ᱹ >> varchar2(2) 

���� ���� ����))
char() ..... varchar2() ���� �˻��� �켱 ...

�ᱹ ������ �ѱ�
unicode (2byte) : �ѱ� , ������ , Ư������ , ���� >> 2byte
nchar(20) >> 20�� ������ ����  >> ���� byte *2 >> 40byte
nvarchar2(20) >> 20���� ���� 

�ѱ� 20�� , ������ 20��
*/
select 1 + 1 from dual; --2
select '1' + '1' from dual; --2
select '1A' + '1' from dual; -- ���ڰ� �ƴ϶� ����
--------------------------------------------------
select sysdate from dual;
select sysdate||'��' from dual;
select to_char(sysdate) || '��' from dual;

select sysdate,
to_char(sysdate, 'YYYY')||'��' as "YYYY",
to_char(sysdate, 'YEAR'),
to_char(sysdate, 'MM'),
to_char(sysdate, 'DD'),
to_char(sysdate, 'DAY'),
to_char(sysdate, 'DY')
from dual;

--Quiz
--�Ի����� 12���� ������� ���, �̸� �Ի���, �Ի�⵵, �Ի���� ����ϼ���.
select * from emp;
select empno as "���", ename as "�̸�", to_char(hiredate,'DD') as "�Ի���", to_char(hiredate,'YYYY') as "�Ի�⵵", to_char(hiredate,'MM') as "�Ի��"
from emp
where to_char(hiredate,'MM')='12';

select to_char(hiredate,'YYYY"��" MM"��" DD"��"') from emp;

--to_char() : ���� -> ����
--why : 1000000000 ->  $1,000,000,000 �̷� ������ ���ڵ����� to_char()
select '>' || to_char(12345,'999999999999') || '<' from dual; --���� �̿��� �������� ����ó�� >        12345<
select '>' || to_char(12345,'0999999999999') || '<' from dual; --���� �̿��� ������ 0 ó�� > 0000000012345<
select '>' || to_char(12345,'0000000000000') || '<' from dual; -- 0ó��                 > 0000000012345<

select '>' || to_char(12345,'$9,999,999,999,999') || '<' from dual; --���� ���� ��. >            $12,345<

select to_char(sal,'$999,999') as "sal" from emp;

-- ���� ���� ���� : bituser--

-- ���Ӱ��� HR �� ���� ������ ��� ��ӹڽ�..

select * from employees;
/*
QUIZ
������̺��� ����� �̸��� last_name , first_name ���ļ� fullname ��Ī �ο��ؼ� ����ϰ�
�Ի�����  YYYY-MM-DD �������� ����ϰ� ����(�޿� *12)�� ���ϰ� ������ 10%(���� * 1.1)�λ��� ���� 
����ϰ� �� ����� 1000���� �޸� ó���ؼ� ����ϼ���
�� 2005�� ���� �Ի��ڵ鸸 ����ϼ��� �׸��� ������ ���� ������  ����ϼ���
*/
select employee_id, first_name, last_name, hire_date, salary
from EMPLOYEES;

select employee_id,
       last_name||first_name as "fullname",
       to_char(hire_date,'YYYY-MM-DD') as "hire_date",
       salary * 12 as "����",
       to_char(salary*12*1.1,'999,999,999') as "salary"
from employees
where to_number(to_char(hire_date,'YYYY')) >= 2005
--where to_char(hire_date,'YYYY') >= '2005'
order by "����" desc;

