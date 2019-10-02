--190930
--oracle 11g �����÷�(�����÷�)
--�÷� : ����, ����, ����.... >> ��, ���
--�÷� : ����, ����, ����, ��, ��� �ڵ�ȭ

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
--�����÷��� �����͸� ���� �Է��� �� ����.

select column_name, data_type, data_default
from user_tab_columns where table_name='VTABLE';

--�ǹ��� ���Ǵ� ������ �ڵ�
--��ǰ�� ����(�԰���) �������� �б�(1~4�б�)
--20190101, 20190520

create table vtable2(
  no number, --����
  p_code char(4), --��ǰ�ڵ�(A001, B002)
  p_date char(8), --�԰���(20190909) --��¥Ÿ�� .... ��������...
  p_qty number, --����
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

--DDL ���̺� �ٷ��
--�� 9 �� ���̺�(TABLE) ���� 138p 130/340

--1.���̺� �����ϱ�
create table tamp6(
  id number
);

--2.���̺� �����ϱ�(�÷��߰�) add �ѹ��� �ϳ��� �÷��� �߰� ����
alter table tamp6
add ename varchar2(20);

--3.���̺� �����ϱ�(�÷�����) (ename -> username) rename
alter table tamp6
rename column ename to username;

--4.���̺� �����ϱ�(�÷� Ÿ�Լ���) modify
alter table tamp6
modify (username varchar2(2000));

--5.���̺� �����ϱ�(�÷�����) drop
alter table tamp6
drop column username;

--6.delete : ���̺� ������ ����
--���̺��� ó������� ó�� ũ�� >> �����͸� ������ >> ���̺��� Ŀ��
--ex) ó�� ���̺� 1M >> 10���ǵ����� >> 101M  >> ��������ü���� delete >> ���̺��� ũ�� 101M
--���̺� ������ ������ ����Ȯ��[ó�����·�] truncate (where ���� ���Ұ�)

--drop talbe tamp6

--���̺� ���� �����ϱ� p144 136/340
--������ ���Ἲ Ȯ�� 
--���� (constraint) insert, update �ַ�....
/* �� �� �� ��                      ��     �� 
NOT NULL(NN)      ���� NULL ���� ������ �� �����ϴ�. 
UNIQUE key(UK)    ���̺��� ��� ���� �����ϰ� �ϴ� ���� ���� ��(NULL �� ���)  - �ߺ����� ������ ���ϰ� �ϴ� ��.
                  unique + not null : �÷��� ������ŭ

PRIMARY KEY(PK)   �����ϰ� ���̺��� ������ �ĺ�(NOT NULL �� UNIQUE ������ ����) 
                  ���̺�� 1��(�������� ��� �ϳ��� ���� ���� : ����Ű)
                  ex) �ֹι�ȣ, �Խ��� �۹�ȣ, �й�, �ڵ�����ȣ ....
                  index �ڵ����� : where pk �� ���� �ϰڱ���..�ؼ� ������ index table ������. : �����˻�
                  ������ : 1�� / ���� : �ּ�(����3�� ��) -->>> ���� ������ �ʿ���..( �ֱ������� ������Ʈ) --> ���...(DBA)
                  
FOREIGN KEY(FK)   ���� ������ �� ������ �ܷ�Ű ���踦 �����ϰ� �����մϴ�. 
                  �������� : ���̺�� ���̺��� ����
                  EMP, DEPT �������� �ʿ��ѵ� ������ ����....�����ʹ� ������ �ִ� �� ó�� ��������
                  ������ ���Ѵ�(DEPT) PK / ������ �ϴ� ��(EMP) FK
                  
CHECK(CK)         ���̾�� �ϴ� ������ ������(��κ� ���� ��Ģ�� ����)
                  ���ϴ� ���� �޴� ��.(gender �÷��� �����ʹ� '��','��' �� �ްڴ�)
                  �����͸� üũ��.
                  
5���� ������ ����� ����
1. ���̺��� ������ �� (create table)
2. ���̺� ��������(create table -> �ʿ�� alter table add constraint ....)
*/
--���̺� ������� Ȯ��
select * from user_constraints where table_name='EMP';

--����ǥ���(����X)
--SYS_C007012,SYS_C007013 ���������� �����̸��� ����
create table temp7(
  id number primary key,
  name varchar2(20) not null,
  addr varchar2(50)
);

select * from user_constraints where table_name='TEMP7';

--full ǥ��� �����̸��� ����ڰ� ���� ����
create table temp7(
  id number constraint pk_temp7_id primary key, --�����̸��� �������� ��Ģ�� ����..
  name varchar2(20) not null,
  addr varchar2(50)
);

insert into temp7(name, addr) values ('ȫ�浿','����� ������'); -- id�� PK �������� null �� �� �� ��� insert ���� ����.
insert into temp7(id,name, addr) values (10,'ȫ�浿','����� ������');
insert into temp7(id,name, addr) values (10,'������','����� ���ϱ�'); --"unique constraint (%s.%s) violated" id PK���� �ߺ��� �Ұ�
--PK �Ǵٴ� �� (where id ���� ����Ѵ�) -PK�ɸ� �� �÷��� ���� �ڵ����� Index�� �ο��Ѵ�. --�˻��ӵ��� ����Ų��.
select * from temp7 where id=10;

commit;

create table temp8(
  id number constraint pk_temp8_id primary key,
  name varchar2(20) not null,
  jumin char(6) constraint uk_temp8_jumin unique, --not null �ƴϱ� ������ null�� �ߺ�������.
  --jumin char(6) not null constraint uk_temp8_jumin unique, --not null �ƴϱ� ������ null�� �ߺ�������.
  addr varchar2(20)
);

select * from user_constraints where table_name='TEMP8';
select * from user_indexes where table_name='TEMP8';--�������Ȯ��

insert into temp8(id,name,jumin,addr) values (10,'ȫ�浿','123456','����� ������');
select * from temp8;
commit;

insert into temp8(id,name,jumin,addr) values (10,'A','456789','����� ������');
-- ORA-00001: unique constraint (BITUSER.PK_TEMP8_ID) violated : id PK --unique

insert into temp8(name,jumin,addr) values ('A','456789','����� ������');
--ORA-01400: cannot insert NULL into ("BITUSER"."TEMP8"."ID") : id PK - null

insert into temp8(id,name,jumin,addr) values (20,'A','123456','����� ������');
--ORA-00001: unique constraint (BITUSER.UK_TEMP8_JUMIN) violated : jumin unique

insert into temp8(id,name,addr) values (20,'A','����� ������');
--�ֹι�ȣ ������ null ����.

insert into temp8(id,name,addr) values (30,'�߹�����','����� ������');
--�ֹι�ȣ ������ null �ߺ� ����

select * from temp8;
commit;

--���̺� ���� �� ����ɱ�
create table temp9(
  id number
);

--���� ���̺� >> ������ �ǽ� >> 10, 10 2�� >> PK �Ұ�(���������� ������ �˻���) >> �ߺ����� �� PK�ؾ���
alter table temp9
add constraint pk_temp9_id primary key(id);

select * from user_constraints where table_name='TEMP9';
select * from user_indexes where table_name='TEMP9';--�������Ȯ��

alter table temp9
add ename varchar2(20);

desc temp9;

--not null �߰��ϱ� (���������� modify)
alter table temp9
modify (ename not null);

--check
create table temp10(
  id number constraint pk_temp10_id primary key,
  name varchar2(20) not null,
  jumin char(6) constraint uk_temp10_jumin unique, --not null �ƴϱ� ������ null�� �ߺ�������.
  addr varchar2(20),
  age number constraint ck_temp10_age check(age>=19) --where age>=19
);

select * from user_constraints where table_name='TEMP10';

insert into temp10(id,name,jumin,addr,age) values(100,'ȫ�浿','123456','�����',20);
commit;
insert into temp10(id,name,jumin,addr,age) values(200,'������','789456','�����',15);
--ORA-02290: check constraint (BITUSER.CK_TEMP10_AGE) violated --check ���� 19�� �̻� üũ

select * from temp10;

--2�� �÷� ��� 1���� ��������
alter table temp9
add constraint pk_temp9_id primary key(id,jumin); --�ߺ�Ű(����Ű)

--------------------------------------------------------------------------------
--�������� >> ���̺�� ���̺���� ���� >> RDB
create table c_emp
as
  select empno, ename, deptno from emp where 1=2;
  
create table c_dept
as
  select deptno, dname from dept where 1=2;

select * from user_constraints where table_name='C_EMP';
select * from user_constraints where table_name='C_DEPT';

--����Ű FK c_emp deptno �÷��� c_dept deptno �÷��� �����մϴ�.
--c_dept deptno �� c_emp deptno �� ������ ���մϴ�.

alter table c_emp
add CONSTRAINT fk_c_emp_deptno foreign key(deptno) references c_dept(deptno);
-- c_emp deptno FK �����ϴ°� c_dept deptno
-- ORA-02270: no matching unique or primary key for this column-list --c_dept(deptno)�� PK�� �ƴ�.

--�������ϴ� ���̺��� �÷��� ���� PK, unique ����
--1. PK ���� 2. FK ����

alter table c_dept
add constraint pk_c_dept_deptno primary key(deptno);

select * from user_constraints where table_name='C_EMP';
select * from user_constraints where table_name='C_DEPT';

insert into c_dept(deptno, dname) values(100,'�λ���');
insert into c_dept(deptno, dname) values(200,'������');
insert into c_dept(deptno, dname) values(300,'ȸ����');
commit;

select * from c_dept;
select * from c_emp;

insert into c_emp(empno, ename, deptno) values(1,'������',111);
--ORA-02291: integrity constraint (BITUSER.FK_C_EMP_DEPTNO) violated - parent key not found
--����Ű�� 111���� ���� ������ �Է��� �� ����.

insert into c_emp(empno, ename) values(1,'������');
--FK null ���....
--ȸ�� ������ ���� FK �� null���� ����...

insert into c_emp(empno, ename, deptno) values(1,'�ƹ���',100);
commit;

--�ΰ��� ���迡�� ��,�� ���踦 �ľ��ϸ�...
--fk_c_emp_deptno ���迡�� �θ�� pk_c_demp_deptno = deptno�� ���� �����;� �ϱ⶧����
-- master(dept) - child(emp)

delete from c_dept where deptno=200; --�������� / ������ ���̺��� ���� ������.
delete from c_dept where deptno=100; --�����Ұ� / ������ ���̺��� �־
--ORA-02292: integrity constraint (BITUSER.FK_C_EMP_DEPTNO) violated - child record found
--c_emp ���� 100�� ã�Ƽ� ������ �� c_dept ���� ��������

/*
column datatype [CONSTRAINT constraint_name]
REFERENCES table_ name (column1[,column2,..] [ON DELETE CASCADE]) 

column datatype, . . . . . . . , [CONSTRAINT constraint_name]
FOREIGN KEY (column1[,column2,..])
REFERENCES table_name  (column1[,column2,..] [ON DELETE CASCADE]) 
*/
--[ON DELETE CASCADE] : �θ����̺�� ������ ���� �ϰڴ�.
--���� �� �����Ǵ� �����ͱ��� ���� ������.

--DDL END
/*
--�л� ���� ���̺�
--�й��� �����ʹ� �ߺ��ǰų� NULL ���� ����ϸ� �ȵȴ�
--�̸� NULL ���� ������� �ʴ´�
--����
--����
--���� ���� �÷��� ���� Ÿ���̰� NULL ���� ���
--���� , ���� , ����  ���� �Է����� ������  default�� 0���� ���´�
--���� ,��� �÷��� �����÷�����(�����÷�) �����Ѵ�
--�а��ڵ�� �а� ���̺� �а��ڵ带 �����Ѵ�
--�й� , �̸� , ���� , ���� , ���� , ���� , ��� , �а��ڵ�

--�а� ���̺�
--�а��ڵ� �����ʹ� �ߺ��ǰų� NULL ���� ����ϸ� �ȵȴ�,
--�а��� �� null���� ������� �ʴ´�

--�а��ڵ� , �а���

--�׸��� select �����
--�й� , �̸�  ����, ��� , �а��ڵ� , �а��� �� ����ϼ���
*/

create table grade(
  no number, --�й�
  name varchar2(20) not null, --�̸�
  korean number default 0, --����
  english number default 0, --����
  math number default 0, --����
  sum number GENERATED ALWAYS as (korean+english+math) VIRTUAL, --����
  avg number GENERATED ALWAYS as (round((korean+english+math)/3),0) VIRTUAL, --��� --round �����߰� table �ݿ� �ȵǾ�����.
  departmentno number --�а��ڵ�
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

insert into department(DEPARTMENTNO,DEPARTMENTNAME) values (100,'��ǻ�Ͱ���');
insert into department(DEPARTMENTNO,DEPARTMENTNAME) values (200,'����ȸ��');
insert into department(DEPARTMENTNO,DEPARTMENTNAME) values (300,'����â��');
commit;

insert into grade(no,name,korean,math,departmentno) values(1010,'ȫ�浿',80,70,100);
insert into grade(no,name,departmentno) values(2020,'������',300);
insert into grade(no,name,english,math,departmentno) values(3030,'�ƹ���',80,100,200);
commit;

select e.no as "�й�", e.name as "�̸�", e.sum as "����", e.avg as "���", e.departmentno as "�а��ڵ�", d.departmentname as "�а���"
from grade e join department d
on e.departmentno = d.departmentno;

