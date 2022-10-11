
create table users (
	user_id int not null auto_increment,
    user_name varchar(30) not null,
    user_password varchar(30) not null,
    primary key (user_id)
);

create table cards (
	card_id int not null auto_increment,
    card_name varchar(30) not null,
    card_points int not null,
    user_id int not null,
    primary key (card_id),
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);

insert users(user_id, user_name, user_password) value (1, "Karl", "qwerty");
insert cards(card_id, card_name, card_points, user_id ) value (1, "first", 0, 1)
