-- �������ϸ� : exercise1.sql

--1. ��� ���̺��� ����Ʈ�� ����Ͻÿ�.
SELECT * FROM tab;

--2. ��� ���̺��� ������ ����Ͻÿ�.
DESC BONUS;
DESC DEPT;
DESC EMP;
DESC SALGRADE;
SELECT

--3. ���(emp)���̺��� ��� �����͸� ����Ͻÿ�.
SELECT * FROM EMP;

--4. ������̺��� �����ȣ, ����̸�, ������ ����Ͻÿ�.
SELECT EMPNO, ENAME, SAL FROM EMP;

--5. ������̺��� ���޿��� �̴µ� �ߺ��� �����Ͱ� ���� ����Ͻÿ�.
SELECT DISTINCT SAL FROM EMP;

--6. ������̺��� ����̸��� ������ ����ϴµ� ������ �÷�����
-- "�� ��","�� ��"���� �ٲ㼭 ����Ͻÿ�. ��, ALIAS�� ���� �߰�
SELECT ENAME "�� ��",SAL "�� ��" FROM EMP;

--7. ������̺��� ����̸�, ������ �̰�, ���ް� Ŀ�̼���  ���� ����
-- ����ϴµ� �÷����� '�Ǳ޿�'�̶�� �ؼ� ����Ͻÿ�.
-- ��, NULL���� ��Ÿ���� �ʰ� �Ͻÿ�.(Ŀ�̼� �ȹ޴»������)
SELECT ENAME,SAL,SAL+COMM "�Ǳ޿�" FROM  EMP  WHERE COMM IS NOT NULL ;

--8. ������̺��� 'SCOTT'�̶�� ����� �����ȣ, �̸�, ������ ����Ͻÿ�.
SELECT EMPNO,ENAME,SAL FROM EMP WHERE ENAME='SCOTT';

--9. ������̺��� ������ 'SALESMAN'�� ����� �����ȣ, �̸�, ������
-- ����Ͻÿ�.
SELECT EMPNO,ENAME,JOB FROM EMP WHERE JOB='SALESMAN';

--10. ������̺��� �����ȣ�� 7499, 7521, 7654�� ����� �����ȣ, �̸�
-- ������ ����Ͻÿ�.
SELECT EMPNO, ENAME, SAL FROM EMP WHERE EMPNO IN (7499, 7521, 7654);

--11. ������̺��� ������ 1500���� 3000������ ����� �����ȣ, �̸�,
-- ������ ����Ͻÿ�.
SELECT EMPNO,ENAME, SAL FROM EMP WHERE SAL BETWEEN 1500 AND 3000;

--12. ��� ���̺��� �μ� ��ġ�� ���� ���� ������ �̸��� ����Ͻÿ�.
SELECT ENAME FROM EMP WHERE DEPTNO IS NULL;

--13. ������̺��� ������ ���� ������ ��� ������ ����Ͻÿ�.
SELECT * FROM EMP ORDER BY SAL DESC;

--14. ������̺��� ������ �̸��� �Ի����� ����ϴµ� �ֱٿ� �Ի��� ������ ����Ͻÿ�.
SELECT ENAME, HIREDATE FROM EMP ORDER BY HIREDATE DESC;

--15. ��� ���̺��� 30�� �μ��� �ٹ��ϴ� �������� �̸��� ����ϴµ�
-- �Ի����� ������ ������ ����Ͻÿ�.
SELECT ENAME FROM EMP WHERE DEPTNO=30 ORDER BY HIREDATE ;

--select*from tab;
--
--SELECT*from bonus;
--SELECT*from dept;
--SELECT*from emp;
--SELECT*from salgrade;
--
--DESC emp;
--DESC dept;
--
--SELECT SYSDATE FROM dept
--SELECT SYSDATE FROM emp
--SELECT 10+20 FROM emp
--SELECT SYSDATE FROM dual
--SELECT ENAME,SAL,SAL*12+COMM,COMM FROM EMP;
--SELECT ENAME,SAL,SAL*12+NVL(COMM,0),COMM FROM EMP;