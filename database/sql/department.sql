CREATE TABLE DEPARTMENT (
  DEPT_CODE VARCHAR(20) PRIMARY KEY,
  DEPT_NAME VARCHAR(20) NOT NULL,
  DEPT_LOC VARCHAR(20)
);

INSERT INTO DEPARTMENT VALUES ('D001', '배우', '서울특별시'),
('D002', '뮤지컬배우', '서울특별시'),
('D003', '가수(솔로)', '서울특별시'),
('D004', '가수(그룹)', '서울특별시'),
('D005', '코미디언', '서울특별시'),
('D101', '드라마제작', '서울특별시'),
('D102', '영화제작', '대전광역시'),
('D103', '음반제작', '수원시'),
('D104', '예능제작', '서울특별시'),
('D301', '임원', '서울특별시');
INSERT INTO DEPARTMENT (DEPT_CODE, DEPT_NAME) VALUES ('D201', '스태프');
