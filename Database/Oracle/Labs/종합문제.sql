--���չ���
--1> �μ����̺��� ��� �����͸� ����϶�.
select * from dept;
 
--2> EMP���̺��� �� ����� ����, �����ȣ, �̸�, �Ի����� ����϶�.
select job,empno,hiredate from emp;
 
--3> EMP���̺��� ������ ����ϵ�, �� �׸�(ROW)�� �ߺ����� �ʰ�
-- ����϶�.
select distinct job from emp;
 
--4> �޿��� 2850 �̻��� ����� �̸� �� �޿��� ����϶�.
select ename, sal
from emp
where sal>=2850;
 
--5> �����ȣ�� 7566�� ����� �̸� �� �μ���ȣ�� ����϶�.
select ename, deptno
from emp
where empno=7566;
 
--6> �޿��� 1500�̻� ~ 2850������ ������ ������ �ʴ� ��� ����� �̸�
-- �� �޿��� ����϶�.
select ename, sal
from emp
where sal between 1500 and 2850;
 
--7> 1981�� 2�� 20�� ~ 1981�� 5�� 1�Ͽ� �Ի��� ����� �̸�,���� �� 
--�Ի����� ����϶�. �Ի����� �������� �ؼ� ������������ �����϶�.
select ename, job, hiredate
from emp
where to_number(to_char((hiredate),'YYYYMMDD')) between 19810220 and 19810501
order by hiredate;
 
--8> 10�� �� 30�� �μ��� ���ϴ� ��� ����� �̸��� �μ� ��ȣ��
-- ����ϵ�, �̸��� ���ĺ������� �����Ͽ� ����϶�.
select ename, deptno
from emp
where deptno=10 or deptno=30
order by ename;
 
--9> 10�� �� 30�� �μ��� ���ϴ� ��� ��� �� �޿��� 1500�� �Ѵ�
-- ����� �̸� �� �޿��� ����϶�.
--(�� �÷����� ���� employee �� Monthly Salary�� �����Ͻÿ�)
select ename as "employee", sal as "Monthly Salary"
from emp
where (deptno=10 or deptno=30) and sal>1500;
 
--10> �����ڰ� ���� ��� ����� �̸� �� ������ ����϶�.
select ename, job
from emp
where mgr is null;
 
--11> Ŀ�̼��� �޴� ��� ����� �̸�, �޿� �� Ŀ�̼��� ����ϵ�, 
-- �޿��� �������� ������������ �����Ͽ� ����϶�.
select ename, sal, comm
from emp
where comm is not null
order by sal desc;
 
--12> �̸��� �� ��° ���ڰ� A�� ��� ����� �̸��� ����϶�.
select ename
from emp
where ename like '__A%';
 
--13> �̸��� L�� �� �� ���� �μ� 30�� �����ִ� ����� �̸��� 
--����϶�.
select ename
from emp
where ename like '%L%L%' and deptno=30;
 
--14> ������ Clerk �Ǵ� Analyst �̸鼭 �޿��� 1000,3000,5000 �� 
-- �ƴ� ��� ����� �̸�, ���� �� �޿��� ����϶�.
select ename, job, sal
from emp
where (job='CLERK' or job='ANALYST') and sal not in (1000,3000,5000);
 
--15> �����ȣ, �̸�, �޿� �׸��� 15%�λ�� �޿��� ������ ǥ���ϵ� 
--�÷����� New Salary�� �����Ͽ� ����϶�.
select empno, ename, sal, (sal*1.15) as "New Salary"
from emp;
 
--16> 15�� ������ ������ ����Ÿ���� �޿� �λ��(�� �޿����� ���� 
-- �޿��� �� ��)�� �߰��ؼ� ����϶�.(�÷����� Increase�� �϶�). 
select empno, ename, sal, "New Salary", ("New Salary"-sal) as "Increase"
from (select empno, ename, sal, (sal*1.15) as "New Salary" from emp);
 
--18> ��� ����� �̸�(ù ���ڴ� 
-- �빮�ڷ�, ������ ���ڴ� �ҹ��ڷ� ǥ��) �� �̸� ���̸� ǥ���ϴ�
-- ������ �ۼ��ϰ� �÷� ��Ī�� ������ �־ ����϶�.
select initcap(ename) as "�̸�", length(ename) as "�̸�����"
from emp;
 
--19> ����� �̸��� Ŀ�̼��� ����ϵ�, Ŀ�̼��� å������ ���� 
-- ����� Ŀ�̼��� 'no commission'���� ����϶�.
select ename, (nvl(to_char(comm),'no commission')) as comm
from emp;
 
--20> ��� ����� �̸�,�μ���ȣ,�μ��̸��� ǥ���ϴ� ���Ǹ� �ۼ��϶�.
select e.ename, e.deptno, d.dname
from emp e join dept d
on e.deptno = d.deptno;
 
--21> 30�� �μ��� ���� ����� �̸��� �μ���ȣ �׸��� �μ��̸��� ����϶�.
select e.ename, d.deptno, d.dname
from emp e join dept d
on e.deptno = d.deptno
where e.deptno=30;
 
--22> 30�� �μ��� ���� ������� ��� ������ �μ���ġ�� ����϶�.
--(��, ���� ����� �ߺ����� �ʰ� �϶�.)
select distinct e.job, e.job, d.loc
from emp e join dept d
on e.deptno = d.deptno
where e.deptno=30;
 
--23> Ŀ�̼��� å���Ǿ� �ִ� ��� ����� �̸�, �μ��̸� �� ��ġ�� ����϶�.
select e.ename, d.dname, d.loc
from emp e join dept d
on e.deptno = d.deptno
where comm is not null;
 
--24> �̸��� A�� ���� ��� ����� �̸��� �μ� �̸��� ����϶�.
select e.ename, d.dname
from emp e join dept d
on e.deptno = d.deptno
where ename like '%A%';
 
--25> Dallas���� �ٹ��ϴ� ��� ����� �̸�, ����, �μ���ȣ �� �μ��̸��� 
-- ����϶�.
select e.ename, e.job, e.deptno, d.dname
from emp e join dept d
on e.deptno = d.deptno
where d.loc='DALLAS';
 
--26> ����̸� �� �����ȣ, �ش� �������̸� �� ������ ��ȣ�� ����ϵ�,
-- �� �÷����� employee,emp#,manager,mgr#���� ǥ���Ͽ� ����϶�.
select e.ename as "employee", e.empno as "emp#", em.ename as "manager", e.mgr as "mgr#"
from emp e join emp em
on e.mgr = em.empno;
 
--27> ��� ����� �̸�,����,�μ��̸�,�޿� �� ����� ����϶�.
select e.ename, e.job, d.dname, e.sal, s.grade
from emp e join dept d on e.deptno = d.deptno
           join salgrade s on e.sal between s.losal and s.hisal;
 
--28> Smith���� �ʰ� �Ի��� ����� �̸� �� �Ի����� ����϶�.
select ename, hiredate
from emp
where hiredate > to_char((select hiredate from emp where ename='SMITH'),'YYYYMMDD');
 
--29> �ڽ��� �����ں��� ���� �Ի��� ��� ����� �̸�, �Ի���, 
-- �������� �̸�, �������� �Ի����� ����ϵ� ���� �÷����� 
-- Employee,EmpHiredate, Manager,MgrHiredate�� ǥ���Ͽ� 
-- ����϶�.
select e.ename as "Employee", e.hiredate as "EmpHiredate", em.ename as "Manager", em.hiredate as "MgrHiredate"
from emp e join emp em
on e.mgr = em.empno
where e.hiredate < em.hiredate;
 
--30> ��� ����� �޿� �ְ��,������,�Ѿ� �� ��վ��� ����ϵ� 
-- �� �÷����� Maximum,Minimum,Sum,Average�� �����Ͽ� ����϶�.
select max(sal) as "Maximum",
       min(sal) as "Minimum",
       sum(sal) as "Sum",
       trunc(avg(sal),0) as "Average"
from emp;

--31> �� �������� �޿� ������.�ְ��,�Ѿ� �� ��վ��� ����϶�.
select job,
       max(sal) as "Maximum",
       min(sal) as "Minimum",
       sum(sal) as "Sum",
       trunc(avg(sal),0) as "Average"
from emp
group by job;
 
--32> ������ ������ ��� ���� ������ ���� ����϶�.
select job, count(job)
from emp
group by job;
 
--33> �������� ���� ����ϵ�, ������ ��ȣ�� �ߺ����� �ʰ��϶�.
-- �׸���, �÷����� Number of Manager�� �����Ͽ� ����϶�.
select count(distinct mgr) as "Number of Manager"
from emp;
 
--34> �ְ� �޿��� ���� �޿��� ������ ����϶�.
select max(sal)-min(sal)
from emp;
 
--35> ������ ��ȣ �� �ش� �����ڿ� ���� ������� ���� �޿��� ����϶�.
-- ��, �����ڰ� ���� ��� �� ���� �޿��� 1000 �̸��� �׷��� ���ܽ�Ű�� 
-- �޿��� �������� ��� ����� ������������ �����϶�.
select *
from  (select mgr, min(sal) as minsal from emp where mgr is not null group by mgr)
where minsal > 1000
order by minsal desc;
 
--�ڡ�36> �μ����� �μ��̸�, �μ���ġ, ��� �� �� ��� �޿��� ����϶�.
-- �׸��� ������ �÷����� �μ���,��ġ,����� ��,��ձ޿��� ǥ���϶�.
select 
from (select d.dname, d.loc, count(d.dname),* from emp e join dept d on e.deptno = d.deptno)
group by deptno
 
--37> Smith�� ������ �μ��� ���� ��� ����� �̸� �� �Ի����� ����϶�.
-- ��, Smith�� �����ϰ� ����Ͻÿ�
select ename, hiredate
from emp
where deptno = (select deptno from emp where ename='SMITH') and ename!='SMITH';
 
--38> �ڽ��� �޿��� ��� �޿����� ���� ��� ����� ��� ��ȣ, �̸�, �޿��� 
--    ǥ���ϴ� ���Ǹ� �ۼ��ϰ� �޿��� �������� ����� ������������ �����϶�.
select empno, ename, sal
from emp
where sal>(select avg(sal)from emp)
order by sal desc;
 
--39> �̸��� T�� ���� ����� ���� �μ����� �ٹ��ϴ� ��� ����� �����ȣ
-- �� �̸��� ����϶�.
select empno, ename
from emp
where deptno in (select distinct deptno from emp where ename like '%T%');
 
--40> �μ���ġ�� Dallas�� ��� ����� �̸�,�μ���ȣ �� ������ ����϶�.
select e.ename, e.deptno, e.job
from emp e join dept d
on e.deptno = d.deptno
where d.loc='DALLAS';

--41> KING���� �����ϴ� ��� ����� �̸��� �޿��� ����϶�.
select e.ename, e.sal
from emp e join emp em
on e.mgr = em.empno
where em.ename = 'KING';
 
--42> Sales �μ��� ��� ����� ���� �μ���ȣ, �̸� �� ������ ����϶�.
select e.deptno, e.ename, e.job
from emp e join dept d
on e.deptno = d.deptno
where d.dname='SALES';
 
--43> �ڽ��� �޿��� ��� �޿����� ���� �̸��� T�� ���� ����� ������
-- �μ��� �ٹ��ϴ� ��� ����� ��� ��ȣ, �̸� �� �޿��� ����϶�.
select empno, ename, sal
from emp
where deptno =(select deptno from emp where sal > (select avg(sal) from emp) and ename like '%T%');
 
--44> Ŀ�̼��� �޴� ����� �޿��� ��ġ�ϴ� ����� �̸�,�μ���ȣ,�޿��� 
-- ����϶�.
select ename, deptno, sal
from emp
where sal in (select sal from emp where comm is not null);
 
--45> Dallas���� �ٹ��ϴ� ����� ������ ��ġ�ϴ� ����� �̸�,�μ��̸�,
--     �� �޿��� ����Ͻÿ�
create or replace view d_emp
as select distinct e.job
   from emp e join dept d
   on e.deptno = d.deptno
   where d.loc='DALLAS'

select * from d_emp;

select e.ename, d.dname, e.sal
from emp e join dept d
on e.deptno = d.deptno
where job in (select job from d_emp);

--�ڡ�46> Scott�� ������ �޿� �� Ŀ�̼��� �޴� ��� ����� �̸�, �Ի��� �� 
-- �޿��� ����Ͻÿ�
select *
from emp
where ename='SCOTT'

select *
from emp
where sal=(select sal from emp where ename='SCOTT') and comm = (select comm from emp where ename='SCOTT')
 
--47> ������ Clerk �� ����麸�� �� ���� �޿��� �޴� ����� �����ȣ,
-- �̸�, �޿��� ����ϵ�, ����� �޿��� ���� ������ �����϶�.
--all����
select distinct sal
from emp
where job='CLERK'
  
--48> �̸��� A�� ���� ����� ���� ������ ���� ����� �̸���
-- ����, �μ���ȣ�� ����϶�.
select distinct job
from emp
where ename like '%A%';
 
--49> New  York ���� �ٹ��ϴ� ����� �޿� �� Ŀ�̼��� ���� ����� 
-- ����̸��� �μ����� ����϶�.
 
 
 
--50> Dallas���� �ٹ��ϴ� ����� ���� �� �����ڰ� ���� ����� �����ȣ,����̸�,
--    ����,����,�μ���,Ŀ�̼��� ����ϵ� Ŀ�̼��� å������ ���� ����� NoCommission
--    ���� ǥ���ϰ�, Ŀ�̼��� �÷����� Comm���� ������ ����Ͻÿ�.
--    ��, �ְ���޺��� ��µǰ� �Ͻÿ�