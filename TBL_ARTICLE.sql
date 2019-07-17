create database sts;
use sts;
create table tbl_article(a_id int primary key auto_increment,a_title varchar(50),a_category varchar(50));
show tables;
select * from tbl_article;
insert into tbl_article values(2,"Article 2","Category 2");

