--191002
--JDBC
create table dememp
as
  select * from emp where 1=2;
  
alter table dememp
add constraint pk_dememp_empno primary key(empno);

select * from user_constraints where table_name='DEMEMP';

insert into dememp
select * from emp; --´ë·® insert
commit;

select * from dememp where deptno=20;

select * from dememp where deptno=30;