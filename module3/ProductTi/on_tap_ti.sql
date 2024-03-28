create database on_tap_ti;
use on_tap_ti;
create table category(
	id_category int primary key auto_increment,
    name_category varchar(50)
);

create table product(
	id int primary key auto_increment,
    name varchar(50),
    day date,
    id_category INT,
    foreign key(id_category) references category(id_category)
);
select p.id, p.name, p.day, c.name_category from product p join category c on p.category_id = c.id_category;
SELECT s.*, c.name_category as category FROM product p join category c on p.id_category=c.category_id where p.name like  concat('%',?,'%');
select product.id, product.name, phone.day, category.name_category from product join category on product.id_category = category.category_id where product.id=1;
select * from product;
