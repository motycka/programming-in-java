create table if not exists users (
    id serial primary key,
    name text not null,
    weight decimal,
    date_of_birth date,
    token text not null unique,
    created_at timestamp default current_timestamp
);

create table if not exists i18n (
    locale text not null,
    message_key text not null,
    message_value text not null,
    primary key (locale, message_key)
);
