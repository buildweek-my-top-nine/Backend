DELETE
FROM userinterests;

DELETE
FROM interest;

DELETE
FROM categories;

DELETE
FROM users;

INSERT INTO users (userid, username, password, primaryemail, created_by, created_date, last_modified_by, last_modified_date) VALUES (1,'testname', 'testpass123', 'test@mail.com', 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP);

INSERT INTO categories (categoryid, categoryname, created_by, created_date, last_modified_by, last_modified_date) VALUES (1, 'Books', 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP);
INSERT INTO categories (categoryid, categoryname, created_by, created_date, last_modified_by, last_modified_date) VALUES (2, 'Technology', 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP);
INSERT INTO categories (categoryid, categoryname, created_by, created_date, last_modified_by, last_modified_date) VALUES (3, 'Travel', 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP);
INSERT INTO categories (categoryid, categoryname, created_by, created_date, last_modified_by, last_modified_date) VALUES (4, 'Business', 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP);
INSERT INTO categories (categoryid, categoryname, created_by, created_date, last_modified_by, last_modified_date) VALUES (5, 'Sports', 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP);

INSERT INTO interest (interestid, interestname, description, categoryid, created_by, created_date, last_modified_by, last_modified_date) VALUES (1, 'Stonehenge', 'Mysterious heavy stones', 3, 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP);
INSERT INTO interest (interestid, interestname, description, categoryid, created_by, created_date, last_modified_by, last_modified_date) VALUES (2, 'Boston Dynamics', 'Robots that hopefully will not kill us', 2, 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP);
INSERT INTO interest (interestid, interestname, description, categoryid, created_by, created_date, last_modified_by, last_modified_date) VALUES (3, 'The Da Vinci Code', 'A book about an artist or something?', 1, 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP);
INSERT INTO interest (interestid, interestname, description, categoryid, created_by, created_date, last_modified_by, last_modified_date) VALUES (4, 'Entrepreneurism', 'Being a creative business person', 4, 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP);
INSERT INTO interest (interestid, interestname, description, categoryid, created_by, created_date, last_modified_by, last_modified_date) VALUES (5, 'Seahawks', 'A football team in Seattle', 5, 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP);

-- INSERT INTO interest (interestid, interestname, created_by, created_date, last_modified_by, last_modified_date) VALUES (1, 'Stonehenge', 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP);
-- INSERT INTO interest (interestid, interestname, created_by, created_date, last_modified_by, last_modified_date) VALUES (2, 'Boston Dynamics', 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP);
-- INSERT INTO interest (interestid, interestname, created_by, created_date, last_modified_by, last_modified_date) VALUES (3, 'The Da Vinci Code', 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP);
-- INSERT INTO interest (interestid, interestname, created_by, created_date, last_modified_by, last_modified_date) VALUES (4, 'Entrepreneurism', 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP);
-- INSERT INTO interest (interestid, interestname, created_by, created_date, last_modified_by, last_modified_date) VALUES (5, 'Seahawks', 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP);

-- INSERT INTO interests (interestid, interestname, userid, categoryid, created_by, created_date, last_modified_by, last_modified_date) VALUES (1, 'Stonehenge', 28, 3, 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP);
-- INSERT INTO interests (interestid, interestname, userid, categoryid, created_by, created_date, last_modified_by, last_modified_date) VALUES (2, 'Boston Dynamics', 28, 2, 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP);
-- INSERT INTO interests (interestid, interestname, userid, categoryid, created_by, created_date, last_modified_by, last_modified_date) VALUES (3, 'The Da Vinci Code', 28, 1, 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP);
-- INSERT INTO interests (interestid, interestname, userid, categoryid, created_by, created_date, last_modified_by, last_modified_date) VALUES (4, 'Entrepreneurism', 28, 4, 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP);
-- INSERT INTO interests (interestid, interestname, userid, categoryid, created_by, created_date, last_modified_by, last_modified_date) VALUES (5, 'Seahawks', 28, 5, 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP);

INSERT INTO userinterests (interestid, userid) VALUES (1, 1);
INSERT INTO userinterests (interestid, userid) VALUES (2, 1);
INSERT INTO userinterests (interestid, userid) VALUES (3, 1);
-- INSERT INTO userinterests (interestid, userid) VALUES (4, 1);
-- INSERT INTO userinterests (interestid, userid) VALUES (4, 1);
-- INSERT INTO userinterests (interestid, userid) VALUES (5, 1);



alter sequence hibernate_sequence restart with 25;
