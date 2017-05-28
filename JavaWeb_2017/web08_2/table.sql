show tables;
create table friend_user(
    id int primary key auto_increment,
    userName varchar(20) unique,
    name varchar(20),
    password varchar(10),
    age int(3),
    sex varchar(1),
    phone varchar(20));
select * from friend_user;
select * from friend_pic;

delete from friend_user ;
    create table friend_pic(
    id int primary key auto_increment,
    picName varchar(100),
    userId int);

    select * from
        friend_user u
            left join;
        friend_pic p
            on u.id=p.userId;
drop table friend_user;
drop tables friend_pic;