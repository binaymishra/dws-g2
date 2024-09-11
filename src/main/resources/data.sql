--user table data
insert into users (username, email, password) values ('Kush', 'kush@gmail.com', '@Kush123');
insert into users (username, email, password) values ('Kishor', 'kishor@gmail.com', '@Kishor123');
insert into users (username, email, password) values ('Binay', 'binay@gmail.com', '@Binay123');
insert into users (username, email, password) values ('Vikas', 'vikas@gmail.com', '@Vikas123');
insert into users (username, email, password) values ('Hemant', 'hemant@gmail.com', '@Hemant123');
insert into users (username, email, password) values ('Janvi', 'janvi@gmail.com', '@Janvi123');
insert into users (username, email, password) values ('Rahul', 'rahul@gmail.com', '@Rahul123');
insert into users (username, email, password) values ('Rajesh', 'rajesh@gmail.com', '@Rajesh123');
insert into users (username, email, password) values ('Raj', 'raj@gmail.com', '@Raj123');

--course table data
insert into courses (title,  score) values ('Introduction to Mutual Funds', 5);
insert into courses (title,  score) values ('Understanding Mutual Fund Investments', 5);
insert into courses (title,  score) values ('Mutual Fund Fundamentals', 4);
insert into courses (title,  score) values ('Advanced Mutual Fund Strategies', 4);
insert into courses (title,  score) values ('Building a Mutual Fund Portfolio', 5);
insert into courses (title,  score) values ('Analyzing Mutual Funds: Techniques and Tools', 5);
insert into courses (title,  score) values ('Risk Management in Mutual Fund Investing', 3);
insert into courses (title,  score) values ('ESG Investing: Ethical Choices in Mutual Funds', 3);
insert into courses (title,  score) values ('Taxation and Mutual Funds', 4);
insert into courses (title,  score) values ('Understanding Fees and Costs in Mutual Funds', 5);
insert into courses (title,  score) values ('Navigating the Mutual Fund Market', 4);
insert into courses (title,  score) values ('Performance Evaluation of Mutual Funds', 5);
insert into courses (title,  score) values ('Investment Strategies Using Mutual Funds', 3);
insert into courses (title,  score) values ('Behavioral Finance in Mutual Fund Investing', 5);
insert into courses (title,  score) values ('Mutual Funds vs. ETFs: Choosing the Right Investment', 5);

--enrollment table data
insert into enrollments (user_id, course_id, is_completed) values (1, 1, true);
insert into enrollments (user_id, course_id, is_completed) values (1, 10, true);
insert into enrollments (user_id, course_id, is_completed) values (1, 4, true);

insert into enrollments (user_id, course_id, is_completed) values (2, 11, true);
insert into enrollments (user_id, course_id, is_completed) values (2, 2, true);
insert into enrollments (user_id, course_id, is_completed) values (2, 5, true);

insert into enrollments (user_id, course_id, is_completed) values (3, 3, true);
insert into enrollments (user_id, course_id, is_completed) values (3, 12, false);

insert into enrollments (user_id, course_id, is_completed) values (4, 4, true);
insert into enrollments (user_id, course_id, is_completed) values (4, 13, true);

insert into enrollments (user_id, course_id, is_completed) values (5, 5, true);
insert into enrollments (user_id, course_id, is_completed) values (5, 14, true);

insert into enrollments (user_id, course_id, is_completed) values (6, 6, true);
insert into enrollments (user_id, course_id, is_completed) values (6, 15, true);

insert into enrollments (user_id, course_id, is_completed) values (7, 7, true);
insert into enrollments (user_id, course_id, is_completed) values (7, 1, true);

insert into enrollments (user_id, course_id, is_completed) values (8, 8, true);
insert into enrollments (user_id, course_id, is_completed) values (8, 2, true);

insert into enrollments (user_id, course_id, is_completed) values (9, 9, true);
insert into enrollments (user_id, course_id, is_completed) values (9, 3, true);

--rewards table data

insert into rewards (user_id, reward) values (1, 14);
insert into rewards (user_id, reward) values (2, 14);
insert into rewards (user_id, reward) values (3, 4);
insert into rewards (user_id, reward) values (4, 7);
insert into rewards (user_id, reward) values (5, 10);
insert into rewards (user_id, reward) values (6, 10);
insert into rewards (user_id, reward) values (7, 8);
insert into rewards (user_id, reward) values (8, 8);
insert into rewards (user_id, reward) values (9, 7);

--streaks table data
insert into streaks (user_id, login_date) values (1, '2024-09-11');
insert into streaks (user_id, login_date) values (1, '2024-09-10');
insert into streaks (user_id, login_date) values (1, '2024-09-09');
insert into streaks (user_id, login_date) values (1, '2024-09-08');
insert into streaks (user_id, login_date) values (1, '2024-09-07');
insert into streaks (user_id, login_date) values (1, '2024-09-04');
insert into streaks (user_id, login_date) values (2, '2024-09-03');
insert into streaks (user_id, login_date) values (2, '2024-09-02');
insert into streaks (user_id, login_date) values (2, '2024-09-01');


--fund details table data
insert into fund_details (fund_name, mornigstar_rating, sharpe_ratio, tracking_error, information_ratio,
esg_score, sector) values ('Growth Equity Fund', 4, 1.25, 3, 0.8, 75, 'Technology');
insert into fund_details (fund_name, mornigstar_rating, sharpe_ratio, tracking_error, information_ratio,
esg_score, sector) values ('Balanced Income Fund', 4, 0.95, 1.5, 0.5, 65, 'Mixed Assets');
insert into fund_details (fund_name, mornigstar_rating, sharpe_ratio, tracking_error, information_ratio,
esg_score, sector) values ('Global Sustainability Fund', 5, 1.5, 2, 1.1, 85, 'ESG Focus');
insert into fund_details (fund_name, mornigstar_rating, sharpe_ratio, tracking_error, information_ratio,
esg_score, sector) values ('High Yield Bond Fund', 3, 0.75, 4, 0.4, 55, 'Fixed Income');
insert into fund_details (fund_name, mornigstar_rating, sharpe_ratio, tracking_error, information_ratio,
esg_score, sector) values ('International Growth Fund', 5, 1.4, 3.5, 0.9, 80, 'International');
insert into fund_details (fund_name, mornigstar_rating, sharpe_ratio, tracking_error, information_ratio,
esg_score, sector) values ('Real Estate Opportunity Fund', 4, 1.1, 2.5, 0.7, 70, 'Real Estate');
insert into fund_details (fund_name, mornigstar_rating, sharpe_ratio, tracking_error, information_ratio,
esg_score, sector) values ('Value Diversified Fund', 4, 1.2, 2, 0.85, 72, 'Value Stocks');
insert into fund_details (fund_name, mornigstar_rating, sharpe_ratio, tracking_error, information_ratio,
esg_score, sector) values ('Emerging Markets Equity Fund', 5, 1.3, 4.5, 1, 60, 'Emerging Markets');

--user fund detail table data
insert into user_fund_details (user_id, fund_id, contribution, contribution_frequency,
boost_factor, contribution_cap)
values (1, 1, 1000, 12, 10, 10000);
insert into user_fund_details (user_id, fund_id, contribution, contribution_frequency,
boost_factor, contribution_cap)
values (1, 2, 2000, 6, 5, 20000);
insert into user_fund_details (user_id, fund_id, contribution, contribution_frequency,
boost_factor, contribution_cap)
values (2, 3, 3000, 12, 10, 30000);
insert into user_fund_details (user_id, fund_id, contribution, contribution_frequency,
boost_factor, contribution_cap)
values (2, 4, 4000, 6, 5, 40000);

