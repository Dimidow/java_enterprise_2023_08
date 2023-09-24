INSERT INTO classroom (class_index, class_range, students_number)
VALUES ('b', 6, 30);

INSERT INTO student (student_id, age, classroom, first_name, gender, last_name)
VALUES
    (1, 15, 1, 'dsvsvsAlex', 'MALE', 'dsvssdvsvAlex'),
    (2, 13, 1, 'dsvsvsvsvsvsAlex', 'MALE', 'dsvsAlex');

INSERT INTO organized_classroom (classroom_id, student_id)
VALUES
    (1, 1),
    (1, 2);