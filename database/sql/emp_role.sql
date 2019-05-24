CREATE TABLE EMP_ROLE (
  EMP_RCODE VARCHAR(20) PRIMARY KEY,
  EMP_RNAME VARCHAR(20) NOT NULL
);

INSERT INTO EMP_ROLE VALUES ('R001', '엔터테이너'),
  ('R002', '국장'),
  ('R003', '실장'),
  ('R004', '대리'),
  ('R005', '사원'),
  ('R006', '이사'),
  ('R007', '사장');