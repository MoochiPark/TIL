CREATE TABLE DEPARTMENT (
  DEPT_CODE VARCHAR(20) PRIMARY KEY,
  DEPT_NAME VARCHAR(20) NOT NULL,
  DEPT_LOC VARCHAR(20)
);

INSERT INTO DEPARTMENT VALUES ('D001', '���', '����Ư����'),
('D002', '�����ù��', '����Ư����'),
('D003', '����(�ַ�)', '����Ư����'),
('D004', '����(�׷�)', '����Ư����'),
('D005', '�ڹ̵��', '����Ư����'),
('D101', '�������', '����Ư����'),
('D102', '��ȭ����', '����������'),
('D103', '��������', '������'),
('D104', '��������', '����Ư����'),
('D301', '�ӿ�', '����Ư����');
INSERT INTO DEPARTMENT (DEPT_CODE, DEPT_NAME) VALUES ('D201', '������');
