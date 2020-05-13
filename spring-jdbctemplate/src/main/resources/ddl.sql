create table stock (
                       stock_id serial not null primary key,
                       stock_name varchar(20) DEFAULT NULL,
                       symbol varchar(20) DEFAULT NULL,
                       company varchar(20) DEFAULT NULL,
                       favorite varchar(20) DEFAULT NULL,
                       start_year date DEFAULT NULL,
                       market_cap integer DEFAULT NULL
);

create table people (
                        id serial not null primary key,
                        first_name varchar(20) not null,
                        last_name varchar(20) not null,
                        age integer not null
);