/* 참가자 테이블  */
drop table tbl_artist_201905;

create table tbl_artist_201905(
	artist_id char(4) not null, 
	artist_name varchar2(20),
	artist_birth char(8), /*20001214 */
	artist_gender char(1), /* M, F */
	talent char(1),
	agency varchar2(20),
	constraint artist_id_pk primary key (artist_id),
	constraint artist_gender_check check (artist_gender in ('M', 'F')),
	constraint talent_check check (talent in ('1', '2', '3'))
);

insert into tbl_artist_201905 values('A001', '황스타', '19970101', 'F', '1', 'A엔터테인먼트');
insert into tbl_artist_201905 values('A002', '정스타', '19980201', 'M', '2', 'B엔터테인먼트');
insert into tbl_artist_201905 values('A003', '박스타', '19990301', 'M', '3', 'C엔터테인먼트');
insert into tbl_artist_201905 values('A004', '김스타', '20000401', 'M', '1', 'D엔터테인먼트');
insert into tbl_artist_201905 values('A005', '서스타', '20010501', 'F', '2', 'E엔터테인먼트');

select * from tbl_artist_201905;
delete from tbl_artist_201905 where artist_id = 'A009';

/* 멘토 테이블 */
drop table tbl_mento_201905;

create table tbl_mento_201905(
	mento_id char(4) not null,
	mento_name varchar2(20),
	constraint mento_id_pk primary key (mento_id)
);

insert into tbl_mento_201905 values('J001', '이멘토');
insert into tbl_mento_201905 values('J002', '안멘토');
insert into tbl_mento_201905 values('J003', '한멘토');

select * from tbl_mento_201905;

/* 점수 테이블 */
drop table tbl_point_201905;

create table tbl_point_201905(
	serial_no char(4) not null,
	artist_id char(4),
	mento_id char(4),
	point number(3),
	constraint serial_no_pk primary key (serial_no),
	constraint artist_id_fk foreign key (artist_id) references tbl_artist_201905 (artist_id),
	constraint mento_id_fk foreign key (mento_id) references tbl_mento_201905 (mento_id)
);

insert into tbl_point_201905 values('P001', 'A001', 'J001', 84);
insert into tbl_point_201905 values('P002', 'A001', 'J002', 82);
insert into tbl_point_201905 values('P003', 'A001', 'J003', 86);
insert into tbl_point_201905 values('P004', 'A002', 'J001', 98);
insert into tbl_point_201905 values('P005', 'A002', 'J002', 99);
insert into tbl_point_201905 values('P006', 'A002', 'J003', 100);
insert into tbl_point_201905 values('P007', 'A003', 'J001', 23);
insert into tbl_point_201905 values('P008', 'A003', 'J002', 43);
insert into tbl_point_201905 values('P009', 'A003', 'J003', 34);
insert into tbl_point_201905 values('P010', 'A004', 'J001', 67);
insert into tbl_point_201905 values('P011', 'A004', 'J002', 56);
insert into tbl_point_201905 values('P012', 'A004', 'J003', 89);
insert into tbl_point_201905 values('P013', 'A005', 'J001', 3);
insert into tbl_point_201905 values('P014', 'A005', 'J002', 6);
insert into tbl_point_201905 values('P015', 'A005', 'J003', 9);

select * from tbl_point_201905;


select a.artist_id, artist_name, artist_birth, point, mento_name
	from TBL_ARTIST_201905 a, TBL_MENTO_201905 b, TBL_POINT_201905 c 
	where a.artist_id = c.artist_id and b.mento_id = c.mento_id;
	
select artist_id, artist_name, p_sum, p_avg, rownum as rk from (
select a.artist_id, artist_name, sum(point) as p_sum, round(avg(point), 2) p_avg
	from tbl_artist_201905 a, TBL_POINT_201905 b 
	where a.artist_id = b.artist_id
	group by a.artist_id, artist_name
	order by sum(point) desc
)








