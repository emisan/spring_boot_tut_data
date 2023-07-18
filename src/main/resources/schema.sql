create table content(
    id INTEGER AUTO_INCREMENT,
    title VARCHAR(255) not null,
    description text,
    status VARCHAR(20) not null,
    content_type VARCHAR(50) not null,
    created TIMESTAMP not null,
    updated TIMESTAMP,
    url VARCHAR(255),
    primary key(id)
);

insert into content (
title, description, status, content_type, created)
values ('Inserted jdbc article',
        'insert from h2database in spring-jdbc',
        'IN_PROGRESS',
        'ARTICLE',
        '2023-07-18 12:05:00');