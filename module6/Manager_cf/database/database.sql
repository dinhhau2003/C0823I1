SELECT * FROM hello.product;

create database c1023l1;
use c1023L1;
create table `table`(
	table_id int primary key auto_increment,
    table_code nvarchar(30) not null,
    table_name nvarchar(30) not null,
    status bit not null default 1
);

create table roles 
(
	role_id int primary key auto_increment,
    role_name nvarchar(30) not null
);

create table category(
category_id int primary key auto_increment,
category_code nvarchar(30) not null,
category_name nvarchar(255) not null,
category_img_url nvarchar(255) null
);

create table users
(
	user_id int primary key auto_increment,
    full_name nvarchar(50) not null,
    numberphone nvarchar(10) not null,
    img_url nvarchar(255) ,
    birthday date not null,
    email nvarchar(50) not null,
    create_at datetime,
    update_at datetime,
    salary double not null default 0,
    gender boolean default true,
    address nvarchar(50) not null,
    is_active bit not null default 1,
    user_name nvarchar(50) not null,
    `password` nvarchar(255) not null,
    role_id int,
    foreign key (role_id) references roles(role_id)
);

create table product(
product_id int primary key auto_increment,
product_code nvarchar(30) not null,
product_name nvarchar(255) not null,
product_price double not null,
product_img_url varchar(255) null,
product_status bit not null default 1,
create_day datetime not null,
update_day datetime null,		
category_id int,
foreign key (category_id) references category(category_id)
);


create table `order` (
	order_id int primary key auto_increment,
    day_create datetime not null,
    day_update datetime not null,
    quantity int , 
    shipping_day datetime not null,
    total_money_order double not null,
    table_id int,
    user_id int,
    foreign key(table_id) references `table`(table_id),
    foreign key(user_id) references users (user_id)
);


create table order_details (
	order_detail_id int primary key auto_increment,
    quantily int not null,
    total_money_product double not null,
    product_id int ,
    order_id int, 
    foreign key(product_id) references product(product_id),
    foreign key(order_id) references `order`(order_id)
);

create table feedback (
	feedback_id int primary key auto_increment,
    feedback_code nvarchar(10) not null,
    name_customer nvarchar(100) not null,
    day_create datetime not null,
    email_customer varchar(200) not null,
    content nvarchar(255) not null,
    status nvarchar(20) not null,
    user_id int, 
    foreign key (user_id) references users(user_id)
);


create table SendCode 
(
	id int primary key auto_increment,
    checkcode varchar(10) not null,
    email varchar(50) not null,
    create_date datetime
);

ALTER TABLE Users ADD created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP; 
-- cái này chính là không cần thêm ở bên phía BE mà nó tự động thêm ở phía database cái này chính là thời gian thêm;--

ALTER TABLE Users ADD updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP;
-- cái này là thời gian cập n--
select * from sendcode;
alter table sendcode add column create_date datetime;
ALTER TABLE sendcode 
MODIFY create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP;
delete from sendcode where create_date < now()- interval  2 minute;
SET SQL_SAFE_UPDATES = 0;


select * from users