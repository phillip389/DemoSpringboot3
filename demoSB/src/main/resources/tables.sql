create table fruit (
    FRUIT_ID bigint not null AUTO_INCREMENT,
    NAME varchar(255),
	primary key(FRUIT_ID)
    );

create table superhero (
    HERO_ID bigint not null AUTO_INCREMENT,
    NAME varchar(255),
    POWER varchar(255),
    primary key(HERO_ID)
    );
create table product (
    PRODUCT_ID bigint not null AUTO_INCREMENT,
    FRUIT_ID bigint,
    HERO_ID bigint,
    primary key(PRODUCT_ID),
    foreign key(FRUIT_ID) references fruit(FRUIT_ID),
    foreign key(HERO_ID) references superhero(HERO_ID)
    );

create table ORDERS (
    ORDER_ID bigint not null AUTO_INCREMENT,
    PRODUCT_ID bigint,
    primary key(ORDER_ID),
    foreign key(PRODUCT_ID) references product(PRODUCT_ID)
    );

insert into fruit(FRUIT_ID, NAME)
VALUES(1, 'Orange'), (2, 'Apples'), (3, 'Grapes'), (4, 'Strawberry'), (5, 'Blueberry');

insert into superhero(HERO_ID, NAME, POWER)
VALUES(1, 'Big Hero 6', 'Healing'), (2, 'Superman', 'Super Strength'), (3, 'Batman', 'Gadgets'), (4, 'Wolverine', 'Claws'), (5, 'Jean', 'Telekinesis');

insert into product(PRODUCT_ID, FRUIT_ID, HERO_ID)
VALUES(1, 3, 1), (2, 3, 3),(3, 3, 1), (4, 3, 3),(5, 2, 6), (6, 5, 2), (7, 4, 1);

