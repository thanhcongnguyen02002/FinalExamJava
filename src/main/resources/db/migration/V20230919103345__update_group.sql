drop table groupmanager;

create table groupmanager
(
    id        serial8      NOT NULL PRIMARY KEY,
    groupName varchar(255) not null,
    member    int,
    creator   varchar(255),
    updater   timestamptz DEFAULT now()
)