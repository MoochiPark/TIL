-	데이터 베이스 생성

```SQL
    CREATE DATABASE exercise ENCODING 'UTF8'
```

-	데이터 베이스 삭제

```SQL
    DROP DATABASE exercise
```

-	사용자 계정 생성

```SQL
    CREATE USER scott WITH PASSWORD 'tiger';
```

-	사용자 계정 삭제

```SQL
    DROP USER scott
```

-	사용자 계정 권한 부여

```SQL
    GRANT ALL ON DATABASE exercise TO scott WITH GRANT OPTION
```

-	데이터베이스 접속

```
    psql -U scott -d exercise

```

-	사용자 계정 권한 회수

```SQL
    REVOKE ALL ON DATABASE exercise FROM scott
```

-	psql 모드에서 데이터베이스에 접속하기

```
    \c exercise
```

-	데이터베이스 보기

```
    \list
```

-	테이블 생성하기

```SQL
    CREATE TABLE IF NOT EXISTS student(
      no INT NOT NULL,
      kname VARCHAR(4) NOT NULL,
      birthday DATE DEFAULT CURRENT_TIMESTAMP,
      spcode INT NOT NULL,
      PRIMARY KEY(no)
      CONSTRAINT student_pcode_fk
      FOREIGN KEY(spcode)
      REFERENCES professor(pcode)
    );
```

-	테이블 목록 보기

```
    \dt
```

-	테이블 수정하기

```SQL
    ALTER TABLE IF EXISTS student ADD COLUMN gender varchar(1);
    ALTER TABLE IF EXISTS student RENAME COLUMN kname TO name;
    ALTER TABLE IF EXISTS student ALTER COLUMN TYPE gender varchar(2);
    ALTER TABLE IF EXISTS student DROP COLUMN gender;
```

-	데이터 삽입

```SQL
    INSERT INTO student (no, kname, birthday) VALUES (20158011, '안덕기', '1991-12-23');

    or

    INSERT INTO student VALUES (12345678, '홍길동', '1234-56-78'),
    (23456789, '아지매', '2345-67-89'),
    ....
    (34567891, '임꺽정', '3456-45-78');
```

-	데이터 수정

```SQL
    UPDATE stduent SET birthday='1111-11-11' WHERE no=23456789;
```

-	데이터 삭제

```SQL
    DELETE FROM student WHERE no=23456789;
```

-	데이터 조회

```SQL
    SELECT * FROM stduent;
```

-	commit mode 설정 및 확인

```
    Session Level
    \ehco :AUTOCOMMIT
    \set AUTOCOMMIT on/off
```

```
    Global Session Level
    vim %APPDATA%\Roaming\postgresql\psqlrc.conf
    \set AUTOCOMMIT
```

-	sql 파일 적용방법

```
    \i filepath/filename.sql
```

-	외부함수

```SQL
    SELECT SUM(CTIME), MIN(CTIME), MAX(CTIME), COUNT(CTIME), CEIL(AVG(CTIME), 3)
      FROM COURSE;

    CEIL(반올림), ROUND(올림), FLOOR(버림)  
    집계함수는 반드시 안의 값이 1개가 되야한다.
```

-	Single Row와 Multiple Row

```SQL
  Single Row : '=', '>', '>=', '<', '<=', '<>', '!='
  Multiple Row : IN, NOT IN, ANY, ALL, EXISTS
```

-	내부 조인

```SQL
SELECT *
  FROM A, B
 WHERE A.ID = B.ID  
```

-	외부 조인
	-	왼쪽 외부 조인 : 왼쪽의 모든 ROW를 포함
	-	오른쪽 외부 조인 : 오른쪽의 모든 ROW를 포함
	-	완전 외부 조인 : 양쪽 모두의 ROW를 포함
