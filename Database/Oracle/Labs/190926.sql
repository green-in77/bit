--190926
--문자
--숫자
--날짜
--변환(to_char ...)

--일반함수
--프로그래밍 성향이 강한...
--nvl(), nvl2() : null 처리 함수.
--decode() : if
--case() : switch

select comm, nvl(comm,0) from emp;

create table t_emp(
id number(6), -- 6자리까지 허용
job varchar2(20)
);

select * from t_emp;

insert into t_emp(id,job) values(100,'IT');
insert into t_emp(id,job) values(200,'SALES');
insert into t_emp(id,job) values(300,'MGR');
insert into t_emp(id) values(400);
insert into t_emp(id,job) values(500,'MGR');
commit;

--1. nvl() : parameter 2개, 1번이 null 이면 2번으로 대체
select id, job, nvl(job,'Empty....') from t_emp;

--2. nvl2() : parameter 3개, 1번이 있으면 2번째, 1번이 Null 이면 3번으로 대체
-- if 와 비슷. (조건) 맞으면 2번 다르면 3번
select id, job, nvl2(job, job||'입니다' , 'empty..') from t_emp;
select id, job, nvl2(job,'AAAA', 'BBBB') from t_emp;

--★★★3. decode()★★★ : sql 언어는 제어문이 없음.
--decode(표현식, 조건1, 결과1, 조건2, 결과2, 조건3, 결과3.....)
--통계 데이터 추출
select id,job, decode(id,100,'IT...', -- id가 100 이면
                         200,'SALES...', -- 200이면
                         300,'MGR...', --300이면
                         'ETC...') as "decodejob" -- 그외는 
from t_emp;

select job, decode(job,'IT',1) from t_emp; --기본값이 없으면 decode 조건에 해당되지 않는 건 null
select job, decode(job,'IT',1,1111) from t_emp; -- null 이 싫으면 기본값 채워주기..

--활용(통계데이터)
select decode(job,'IT',1) as "IT",
       decode(job,'SALES',1) as "SALES",
       decode(job,'MGR',1) as "MGR"
from t_emp;

--집계데이터
select count(decode(job,'IT',1)) as "IT", --count 숫자를 세줌.
       count(decode(job,'SALES',1)) as "SALES",
       count(decode(job,'MGR',1)) as "MGR"
from t_emp;

/*
emp 테이블에서 부서번호가 10이면 '인사부' , 20 '관리부' , 30 '회계부' 나머지 부서 번호는
'기타부서' 라고 출력하는 쿼리문을 만드세요
decode 를 사용해서
*/
select empno, ename, deptno, decode(deptno,10,'인사부',
                                           20,'관리부',
                                           30,'회계부',
                                           '기타부서') as "부서명"
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

--t_emp2 id,jumin jumin의 앞자리가 1이면 남성, 2이면 여성, 3이면 중성, 그 외는 기타
select id, decode(substr(jumin,1,1),1, '남성',
                                    2, '여성',
                                    3, '중성',
                                    '기타') as "성별"
from t_emp2;

--난이도 중급
--java if(if()) oracle decode(decode())

--emp테이블에서 부서번호가 20인 사람들 중 이름이 스미스면 hello 그 외는 world, 부서번호가 20이 아니면 etc 출력
select deptno, ename, decode(deptno,20,decode(ename,'SMITH','HELLO',
                                                    'WORLD'),
                                    'ETC') as "decode"
from emp;

--CASE 문 java : switch
/*
  CASE 조건 WHEN 결과1 THEN 출력1
                WHEN 결과2 THEN 출력2
                WHEN 결과3 THEN 출력3
                WHEN 결과4 THEN 출력4
                ELSE  출력5
  END "컬럼명"
*/

create table t_zip(zipcode number);
insert into t_zip(zipcode) values(2);
insert into t_zip(zipcode) values(31);
insert into t_zip(zipcode) values(32);
insert into t_zip(zipcode) values(33);
insert into t_zip(zipcode) values(41);
commit;

select * from t_zip;

select 'O'||to_char(zipcode), case zipcode when 2 then '서울'
                                           when 31 then '경기'
                                           when 32 then '강원'
                                           when 41 then '제주'
                                           else '기타지역'
                              end "regionname"
from t_zip;

/*
사원테이블에서 사원급여가 1000달러 이하면 4급   
1001 달러 2000달러 이하면 3급
2001 달러 3000달러 이하면 2급
3001 달러 4000달러 이하면 1급
4001 달러 이상이면 특급을 부여하는 데이터를 출력하세요 

1. case 범위값을 못잡음.
   case 컬럼명 when 결과 then 출력
2. case when 컬럼명 조건비교 결과 then
*/

select case when sal<=1000 then '4급' 
            when sal<=2000 then '3급'-- between 1001 and 2000 then
            when sal<=3000 then '2급'-- between 2001 and 3000 then
            when sal<=4000 then '1급'-- between 3001 and 4000 then
            else '특급'
       end "급수", empno, ename, sal
from emp;

--문자 -> 숫자 -> 날짜 -> 변환 -> 일반함수 
--집계함수 제 5 장 그룹 함수(Multi Row Function) p75 PDF 67/340
--1. count(*), count(컬럼명) >> 데이터 건수
--2. sum()
--3. avg()
--4. max()
--5. min()
--등등

--1. 집계함수는 반드시 group by 절과 같이 사용
--2. ★★ 모든 집계함수는 null을 무시 (인지불가)
--3. ★★ select절에 집계함수 이외의 다른 컬럼은 반드시 group by절에 명시되어야 한다.
select * from emp;
select count(*) from emp; --row 수 체크 14
select count(empno) from emp; -- 데이터의 건수 14 (null X)
select count(comm) from emp; -- 데이터의 건수 6 (null X)

--null 건수 ....
select count(nvl(comm,0)) from emp;

--급여의 합
select sum(sal) as "sum" from emp;

--평균 급여 ( 급여의 합 / 사원수 )
select trunc(avg(sal),0) as "avg" from emp;

--수당이 총 얼마
select sum(comm) as "수당" from emp; --4330
select trunc(avg(comm),0) as "평균수당" from emp; --721
select comm from emp;
--null 이 계산되지 않음.....
select trunc(avg(nvl(comm,0)),0) as "평균수당" from emp; -- 309

select count(comm) from emp where comm is not null;
select count(comm) from emp;

select max(sal) from emp;
select min(sal) from emp;

-- 집계함수가 return 하는 값은 1개 : 모두 1줄 이기때문에 출력 가능.
select sum(sal), trunc(avg(sal)), max(sal), min(sal), count(sal), count(*) from emp;

--부서별 평균 급여
select deptno, avg(sal) --3
from emp --1
group by deptno; --2

select avg(sal) from emp group by deptno;

--직종별 평균 급여, 급여합, 최대급여, 최소급여, 건수를 출력
select job, trunc(avg(sal)), sum(sal), max(sal), min(sal), count(sal)
from emp
group by job;

/*
grouping 원리 (컬럼의 순서)
distinct 컬럼명1, 컬럼명2

order by 컬럼명 asc, 컬럼명 desc

group by 컬럼명1, 컬럼명2
*/
--부서별 직종별 급여의 합을 구하세요.
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
--직종별 평균급여가 3000달러 이상인 사원의 직종과 평균급여를 출력하세요.
--평균급여 >= 3000 >> 평균급여는 group by 절 시행 이후 나옴.....
--where 평균 급여 데이터를 사용할 수 없음...
--group by 결과에 조건을 거는 것을 having 
--from 절의 조건절 : where
--group by절의 조건절 : having

select job, avg(sal) as "sal"
from emp
group by job
having avg(sal)>=3000; -- 실행순서가 select 보다 이전이라 별칭은 인식하지 못함.

select * from emp
/*
사원테이블에서 직종별 급여합을 출력하되 수당은 지급 받고 급여의 합이 5000 이상인 사원들의 목록을 출력하세요
--급여의 합이 낮은 순으로 출력하세요
*/
select job, sum(sal)
from emp
where comm is not null
group by job
having sum(sal)>=5000
order by sum(sal);

/*
사원테이블에서 부서 인원이 4명보다 많은 부서의 부서번호 ,인원수 , 급여의 합을 출력하세요
*/
select deptno, count(deptno), sum(sal)
from emp
group by deptno
having count(deptno)>=4

/*
사원테이블에서 직종별 급여의 합이 5000를 초과하는 직종과 급여의 합을 출력하세요
단 판매직종(salesman) 은 제외하고 급여합으로 내림차순 정렬하세요
*/
select job, sum(sal)
from emp
where job != 'SALESMAN'
group by job
having sum(sal)>5000
order by sum(sal) desc;

/*
사원테이블에서 직종별 급여의 합이 2000 이상 5000 이하의 직종과 급여의 평균을 반올림해서 정수만 출력하세요
단 사장은 제외하고 급여 평균으로 올림차순 정렬하세요
*/
select * from emp;
select job, sum(sal)
from emp
group by job

select job, round(avg(sal),0) as "평균급여"
from emp
where job != 'PRESIDENT'
group by job
having sum(sal) between 2000 and 5000
order by "평균급여";

/*4조
사원 테이블에서 직종별 연봉(급여*12)의 평균이 5000이상인 사원의 직종, 연봉의 평균을 출력하세요
단, 'CLERK'는 제외하고 연봉 평균을 오름차순으로 정렬하세요
*/
select job, avg(sal*12) as "연봉평균"
from emp
where job != 'CLERK'
group by job
having avg(sal*12) >= 5000
order by "연봉평균";

/*3조
사원 테이블에서 이름이 M 혹은 A로 시작하는 사원의 직종, 평균 급여를 출력하세요
단 커미션이 널이 아닌 사원 중에서.
*/--where ename like 'A%'; --A 로 시작하는.
select job, avg(sal)
from emp
where (ename like 'M%' or ename like 'A%') and comm is not null
group by job;

/*2조
수당을 안받는 직원들의 부서별, 직종별 급여의 총합이 1000이상인 부서별 직종의 부서번호와 직종 총급여를 부서번호는 내림차순으로, 총급여가 높은 순으로 출력하시오
*/
select deptno, job, sum(sal)
from emp
where comm is null
group by deptno, job
having sum(sal) >= 1000
order by deptno desc, sum(sal) desc;

--//////////////////////////////////////////////////////////////////////////////////////
--지금까지 SELECT 대상 하나의 테이블...
--RDBMS 관계형 데이터 베이스
--java : class 작업 : 관계 ( 상속, 구현, 연관, ...)
--DB : Table Table 끼리 관계를 가지고 있다.
--1:1 1:n m:n
--내가 원하는 데이터가 하나의 테이블에 있는 것이 아니고 1개 이상의 테이블에 나누어져 있다.
--나누어진 테이블에서 원하는 데이터를 출력하는 방법 >> JOIN

--EMP 테이블의 deptno 는 DEPT 테이블의 deptno 를 참조한다.
--DEPT 테이블의 deptno 는 EMP 테이블의 deptno 에 참조당한다.
select * from emp;
select * from dept;
select * from salgrade;

--종류
--1. 등가조인(Equi Join) -> 70%
-- 원테이블과 대응되는 테이블에 있는 컬럼의 데이터 1:1 매칭
--[ANSI 문법]
--문법 : Join on~조건절 , [inner]join on~조건절
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
------------------아래는 sql join 문법 되도록 쓰지 말아라....
select *
from m,s
where m.m1 = s.s1; --null은 비교하지 않음.
--m1=s1 이 같은 컬럼만 나옴.

select m.m1,m.m2,s.s2
from m,s
where m.m1 = s.s1;

select emp.empno, emp.ename, emp.DEPTNO, dept.dname
from emp, dept
where emp.deptno = dept.deptno;

----------------------------------------------------------------------------
--ANSI 문법
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
from emp e join dept d -- table 에 가명칭 부여
on e.deptno = d.deptno;

select *
from m, s
where m.m1 = s.s1 and m.m1='A'; -- join 의 조건인지 from 의 조건인지 알 수 없음..

select *
from m join s on m.m1=s.s1 -- join의 조건
where m.m1='A'; -- from 의 조건

select *
from s join x
on s.s1 = x.x1;

--1개 이상의 테이블에서 join 걸기.
--sql join 문법
select * 
from m , s, x
where m.m1 = s.s1 and s.s1 = x.x1;

---ANSI 문법
select m.m1, m.m2, s.s2, x.x2
from m join s on m.m1 = s.s1 
       join x on s.s1= x.x1;

--사번, 이름, 부서번호, 부서명, 급여, 급여등급을 출력하세요.
select * from emp;
select * from salgrade;

select e.EMPNO, e.ENAME, e.DEPTNO, d.DNAME, e.SAL, s.GRADE
from emp e join dept d on e.deptno = d.deptno
           join salgrade s on e.SAL between s.LOSAL and s.HISAL -- 비등가조인
order by e.empno;

--1. HR 계정으로 이동...
select * from tabs; -- 접속한 계정이 갖고있는 table 의 목록
select * from EMPLOYEES;
select * from DEPARTMENTS;
select * from LOCATIONS;

-- 1. 사번, 이름(last_name), 부서번호, 부서이름을 출력
select e.EMPLOYEE_ID, e.LAST_NAME, e.DEPARTMENT_ID, d.DEPARTMENT_NAME
from EMPLOYEES e join DEPARTMENTS d on e.DEPARTMENT_ID = d.DEPARTMENT_ID;
--문제점 사원수 107명 >> 현재 출력된 106 (부서번호 null...)
--등가조인 문법 이 문제 해결 불가능... >> 해결 (outer join)

--2. 사번, 이름(last_name), 부서번호, 부서명, 도시명
select e.EMPLOYEE_ID, e.LAST_NAME, e.DEPARTMENT_ID, d.DEPARTMENT_NAME, l.CITY
from EMPLOYEES e join DEPARTMENTS d on e.DEPARTMENT_ID = d.DEPARTMENT_ID
                 join LOCATIONS l on d.LOCATION_ID = l.LOCATION_ID;

--2. 비등가조인(non-euqi join) : 의미만 존재 -> 문법은 등가조인
--원테이블과 대응되는 테이블에 있는 컬럼이 1:1 매핑되지 안흔 ㄴ경우
-- emp, salgrade : sal컬럼을 가지고 ... 2개의 컬럼( losal, hisal)
--비등가(1:1 매칭되는 컬럼이 없음.)
select * from emp;
select * from salgrade;

--3. 외부조인(outer join) : null 
--두개의 테이블에서 주, 종 관계 파악
--문법
-- left outer join ( 왼쪽 주, 오른쪽 종 )
-- right outer join( 오른쪽 주, 왼쪽 종 )
-- full outer join(left,right union)
-- 내부적으로 등가조인을 먼저 실행하고 (주,종) 관계 파악 후 주인이 되는 테이블에 남아있는 데이터를 갖고 온다.

select *
from m join s
on m.m1 = s.s1;

select *
from m left outer join s
on m.m1 = s.s1;


-- 1. 사번, 이름(last_name), 부서번호, 부서이름을 출력
--문제점 사원수 107명 >> 현재 출력된 106 (부서번호 null...)
select e.EMPLOYEE_ID, e.LAST_NAME, e.DEPARTMENT_ID, d.DEPARTMENT_NAME
from EMPLOYEES e left outer join DEPARTMENTS d on e.DEPARTMENT_ID = d.DEPARTMENT_ID;
--등가조인 문법 이 문제 해결 불가능... >> 해결 (outer join)

--2. 사번, 이름(last_name), 부서번호, 부서명, 도시명
select e.EMPLOYEE_ID, e.LAST_NAME, e.DEPARTMENT_ID, d.DEPARTMENT_NAME, l.CITY
from EMPLOYEES e left outer join DEPARTMENTS d on e.DEPARTMENT_ID = d.DEPARTMENT_ID
                 left outer join LOCATIONS l on d.LOCATION_ID = l.LOCATION_ID;


select *
from m full outer join s
on m.m1 = s.s1;

--4. self join(자기참조)
--emp 테이블에서 smith 사원의 관리자 이름
--하나의 테이블에서 어떤 컬럼이 다른 컬럼을 참조 하는 경우에 
select * from emp;

--사수가 없는 king 데이터도 같이 나오게... left outer 적용.
select e.empno, e.ename, m.empno, m.ename
from emp e left outer join emp m
on e.MGR = m.EMPNO;

select * from emp;
-- 1. 사원들의 이름, 부서번호, 부서이름을 출력하라.
select e.ename, e.deptno, d.DNAME
from emp e join dept d
on e.DEPTNO = d.DEPTNO;
 
select * from dept;
-- 2. DALLAS에서 근무하는 사원의 이름, 직위, 부서번호, 부서이름을
-- 출력하라.
select e.ename, e.JOB, e.DEPTNO, d.DNAME
from emp e join dept d
on e.DEPTNO = d.DEPTNO
where d.LOC = 'DALLAS';

 
-- 3. 이름에 'A'가 들어가는 사원들의 이름과 부서이름을 출력하라.
select e.ename, d.DNAME
from emp e join dept d on e.DEPTNO = d.DEPTNO
where ename like '%A%';

-- 4. 사원이름과 그 사원이 속한 부서의 부서명, 그리고 월급을
--출력하는데 월급이 3000이상인 사원을 출력하라.
select emp.ename, dept.dname, emp.sal
from emp join dept on emp.DEPTNO = dept.DEPTNO
where SAL >= 3000;

 
-- 5. 직위(직종)가 'SALESMAN'인 사원들의 직위와 그 사원이름, 그리고
-- 그 사원이 속한 부서 이름을 출력하라.
select e.job, e.ename, d.DNAME
from emp e join dept d on e.DEPTNO = d.DEPTNO
where job = 'SALESMAN';

-- 6. 커미션이 책정된 사원들의 사원번호, 이름, 연봉, 연봉+커미션,
-- 급여등급을 출력하되, 각각의 컬럼명을 '사원번호', '사원이름',
-- '연봉','실급여', '급여등급'으로 하여 출력하라.
--(비등가 ) 1 : 1 매핑 대는 컬럼이 없다
select e.empno as "사원번호", e.ename as "사원이름", e.SAL*12 as "연봉", e.SAL+e.COMM as "실급여", s.GRADE as " 급여등급"
from emp e join salgrade s on e.SAL between s.losal and s.HISAL
where comm is not null;

-- 7. 부서번호가 10번인 사원들의 부서번호, 부서이름, 사원이름,
-- 월급, 급여등급을 출력하라.
select e.DEPTNO, d.DNAME, e.ENAME, e.sal, s.GRADE
from emp e join dept d on e.DEPTNO = d.DEPTNO
           join salgrade s on e.SAL between s.losal and s.hisal
where e.deptno = 10; 
 
-- 8. 부서번호가 10번, 20번인 사원들의 부서번호, 부서이름,
-- 사원이름, 월급, 급여등급을 출력하라. 그리고 그 출력된
-- 결과물을 부서번호가 낮은 순으로, 월급이 높은 순으로
-- 정렬하라.
select e.DEPTNO, d.DNAME, e.ENAME, e.SAL, s.GRADE
from emp e join dept d on e.DEPTNO = d.DEPTNO
           join salgrade s on e.SAL between s.losal and s.hisal
where e.deptno=10 or e.deptno=20
order by d.DEPTNO asc, e.sal desc;
 
-- 9. 사원번호와 사원이름, 그리고 그 사원을 관리하는 관리자의
-- 사원번호와 사원이름을 출력하되 각각의 컬럼명을 '사원번호',
-- '사원이름', '관리자번호', '관리자이름'으로 하여 출력하라.
--SELF JOIN (자기 자신테이블의 컬럼을 참조 하는 경우)

select e.empno as "사원번호", e.ename as "사원이름", e.MGR as "관리자번호", em.ENAME as "관리자이름"
from emp e left outer join emp em on e.mgr = em.empno;



