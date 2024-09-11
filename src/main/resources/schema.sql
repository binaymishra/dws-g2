--user table
DROP TABLE IF EXISTS users CASCADE;
create table users (
  id int primary key auto_increment,
  username varchar(255) not null,
  email varchar(255) not null,
  password varchar(255) not null
);

--course table
DROP TABLE IF EXISTS courses CASCADE;
create table courses (
  id int primary key auto_increment,
  title varchar(255) not null,
  score int not null
);

--enrollment table
DROP TABLE IF EXISTS enrollments CASCADE;
create table enrollments (
  id int primary key auto_increment,
  user_id int not null,
  course_id int not null,
  is_completed boolean not null,
  foreign key (user_id) references users (id),
  foreign key (course_id) references courses (id)
);

-- rewards table
DROP TABLE IF EXISTS rewards CASCADE;
create table rewards (
  id int primary key auto_increment,
  user_id int not null,
  reward int not null,
  foreign key (user_id) references users (id)
);

-- streaks table
DROP TABLE IF EXISTS streaks CASCADE;
create table streaks (
  id int primary key auto_increment,
  user_id int not null,
  login_date date not null,
  foreign key (user_id) references users (id)
);

-- fund details table
DROP TABLE IF EXISTS fund_details CASCADE;
create table fund_details (
  id int primary key auto_increment,
  fund_name varchar(255) not null,
  mornigstar_rating int not null,
  sharpe_ratio decimal not null,
  tracking_error decimal not null,
  information_ratio decimal not null,
  esg_score int not null,
  sector varchar(255) not null
);

-- user fund detail table
DROP TABLE IF EXISTS user_fund_details CASCADE;
create table user_fund_details (
  id int primary key auto_increment,
  user_id int not null,
  fund_id int not null,
  contribution decimal not null,
  contribution_frequency int not null,
  boost_factor int not null,
  contribution_cap decimal not null,
  foreign key (user_id) references users (id),
  foreign key (fund_id) references fund_details (id)
);

--fund nav table
DROP TABLE IF EXISTS fund_navs CASCADE;
create table fund_navs (
  id int primary key auto_increment,
  fund_id int not null,
  nav_date date not null,
  nav_value decimal not null,
  foreign key (fund_id) references fund_details (id)
);

----invested amount table
DROP TABLE IF EXISTS invested_amounts CASCADE;
create table invested_amounts (
  id int primary key auto_increment,
  fund_id int not null,
  invested_date date not null,
  invested_amount decimal not null,
  foreign key (fund_id) references fund_details (id)
);
--
----current investment value table
--DROP TABLE IF EXISTS current_investment_values CASCADE;
--create table current_investment_values (
--  id int primary key auto_increment,
--  fund_id int not null,
--  investment_date date not null,
--  current_value decimal not null,
--  foreign key (fund_id) references fund_details (id)
--);
--
----portfolio table
--DROP TABLE IF EXISTS portfolios CASCADE;
--create table portfolios (
--  id int primary key auto_increment,
--  user_id int not null,
--  fund_id int not null,
--  investment_amount decimal not null,
--  investment_date date not null,
--  current_value decimal not null,
--  percentage_change decimal not null,
--  foreign key (user_id) references users (id),
--  foreign key (fund_id) references fund_details (id)
--);

