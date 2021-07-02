
create database test_db;


CREATE TABLE test_db.teachers (
    id         integer,
    first_name VARCHAR(128) NOT NULL,
    last_name  VARCHAR(128) NOT NULL,
    gender     VARCHAR(128) NOT NULL,
    subject    VARCHAR(128) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE test_db.students (
    id         integer,
    first_name VARCHAR(128) NOT NULL,
    last_name  VARCHAR(128) NOT NULL,
    gender     VARCHAR(128) NOT NULL,
    s_class    VARCHAR(128) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE test_db.teachers_and_students (
    id         integer,
    student_id integer,
    teacher_id integer,
    PRIMARY KEY (id)
);

select count(teacher_id)
from teachers_and_students
         inner join students on teachers_and_students.student_id = students.id
where (select id from students where first_name = 'გიორგი')

select count(teacher_id)
from teachers_and_students
where student_id in (select id from students where first_name = 'გიორგი')