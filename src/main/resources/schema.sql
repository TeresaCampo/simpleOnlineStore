create table users (
    username VARCHAR(50) COLLATE utf8mb4_general_ci not null primary key,
    password VARCHAR(500) not null,
    enabled BOOLEAN not null
);

create table authorities (
    username VARCHAR(50) COLLATE utf8mb4_general_ci not null,
    authority VARCHAR(50) COLLATE utf8mb4_general_ci not null,
    constraint fk_authorities_users foreign key(username) references users(username)
);

create unique index ix_auth_usern on authorities(username, authority);
