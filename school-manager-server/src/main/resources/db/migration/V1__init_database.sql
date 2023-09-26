
    create table classroom (
       classroom_id integer not null auto_increment,
        class_index varchar(255),
        class_range integer,
        students_number integer,
        primary key (classroom_id)
    ) engine=InnoDB;

    create table organized_classroom (
       id integer not null auto_increment,
        classroom_id integer,
        student_id integer,
        primary key (id)
    ) engine=InnoDB;

    create table student (
       student_id integer not null,
        age integer,
        classroom integer not null,
        first_name varchar(61) not null,
        gender varchar(255) not null,
        last_name varchar(43) not null,
        primary key (student_id)
    ) engine=InnoDB;

    create table student_seq (
       next_val bigint
    ) engine=InnoDB;

    insert into student_seq values ( 1 );

    alter table organized_classroom
       add constraint FKb2oq21g30b9quqoflw7l3tmaj
       foreign key (classroom_id)
       references classroom (classroom_id);

    alter table organized_classroom
       add constraint FK7fquvxrph7x7buli361gesbqd
       foreign key (student_id)
       references student (student_id);
