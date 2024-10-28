-- Inserting into the geolocalizations table
INSERT INTO geolocalizations (id, lat, lng) VALUES (1, '-37.3159', '81.1496');
INSERT INTO geolocalizations (id, lat, lng) VALUES (2, '-43.9509', '-34.4618');
INSERT INTO geolocalizations (id, lat, lng) VALUES (3, '-68.6102', '-47.0653');
INSERT INTO geolocalizations (id, lat, lng) VALUES (4, '29.4572', '-164.2990');
INSERT INTO geolocalizations (id, lat, lng) VALUES (5, '-31.8129', '62.5342');
INSERT INTO geolocalizations (id, lat, lng) VALUES (6, '-71.4197', '71.7478');
INSERT INTO geolocalizations (id, lat, lng) VALUES (7, '24.8918', '21.8984');
INSERT INTO geolocalizations (id, lat, lng) VALUES (8, '-14.3990', '-120.7677');
INSERT INTO geolocalizations (id, lat, lng) VALUES (9, '24.6463', '-168.8889');
INSERT INTO geolocalizations (id, lat, lng) VALUES (10, '-38.2386', '57.2232');

-- Inserting into the company table
INSERT INTO companies (id, name, catch_phrase, bs) VALUES (1, 'Romaguera-Crona', 'Multi-layered client-server neural-net', 'harness real-time e-markets');
INSERT INTO companies (id, name, catch_phrase, bs) VALUES (2, 'Deckow-Crist', 'Proactive didactic contingency', 'synergize scalable supply-chains');
INSERT INTO companies (id, name, catch_phrase, bs) VALUES (3, 'Romaguera-Jacobson', 'Face to face bifurcated interface', 'e-enable strategic applications');
INSERT INTO companies (id, name, catch_phrase, bs) VALUES (4, 'Robel-Corkery', 'Multi-tiered zero tolerance productivity', 'transition cutting-edge web services');
INSERT INTO companies (id, name, catch_phrase, bs) VALUES (5, 'Keebler LLC', 'User-centric fault-tolerant solution', 'revolutionize end-to-end systems');
INSERT INTO companies (id, name, catch_phrase, bs) VALUES (6, 'Considine-Lockman', 'Synchronised bottom-line interface', 'e-enable innovative applications');
INSERT INTO companies (id, name, catch_phrase, bs) VALUES (7, 'Johns Group', 'Configurable multimedia task-force', 'generate enterprise e-tailers');
INSERT INTO companies (id, name, catch_phrase, bs) VALUES (8, 'Abernathy Group', 'Implemented secondary concept', 'e-enable extensible e-tailers');
INSERT INTO companies (id, name, catch_phrase, bs) VALUES (9, 'Yost and Sons', 'Switchable contextually-based project', 'aggregate real-time technologies');
INSERT INTO companies (id, name, catch_phrase, bs) VALUES (10, 'Hoeger LLC', 'Centralized empowering task-force', 'target end-to-end models');

-- Inserting into the address table
INSERT INTO addresses (id, street, suite, city, zipcode, geo_id) VALUES (1, 'Kulas Light', 'Apt. 556', 'Gwenborough', '92998-3874', 1);
INSERT INTO addresses (id, street, suite, city, zipcode, geo_id) VALUES (2, 'Victor Plains', 'Suite 879', 'Wisokyburgh', '90566-7771', 2);
INSERT INTO addresses (id, street, suite, city, zipcode, geo_id) VALUES (3, 'Douglas Extension', 'Suite 847', 'McKenziehaven', '59590-4157', 3);
INSERT INTO addresses (id, street, suite, city, zipcode, geo_id) VALUES (4, 'Hoeger Mall', 'Apt. 692', 'South Elvis', '53919-4257', 4);
INSERT INTO addresses (id, street, suite, city, zipcode, geo_id) VALUES (5, 'Skiles Walks', 'Suite 351', 'Roscoeview', '33263', 5);
INSERT INTO addresses (id, street, suite, city, zipcode, geo_id) VALUES (6, 'Norberto Crossing', 'Apt. 950', 'South Christy', '23505-1337', 6);
INSERT INTO addresses (id, street, suite, city, zipcode, geo_id) VALUES (7, 'Rex Trail', 'Suite 280', 'Howemouth', '58804-1099', 7);
INSERT INTO addresses (id, street, suite, city, zipcode, geo_id) VALUES (8, 'Ellsworth Summit', 'Suite 729', 'Aliyaview', '45169', 8);
INSERT INTO addresses (id, street, suite, city, zipcode, geo_id) VALUES (9, 'Dayna Park', 'Suite 449', 'Bartholomebury', '76495-3109', 9);
INSERT INTO addresses (id, street, suite, city, zipcode, geo_id) VALUES (10, 'Kattie Turnpike', 'Suite 198', 'Lebsackbury', '31428-2261', 10);

-- Inserting into the user table
INSERT INTO users (id, name, username, email, phone, website, address_id, company_id) VALUES (1, 'Leanne Graham', 'Bret', 'Sincere@april.biz', '1-770-736-8031 x56442', 'hildegard.org', 1, 1);
INSERT INTO users (id, name, username, email, phone, website, address_id, company_id) VALUES (2, 'Ervin Howell', 'Antonette', 'Shanna@melissa.tv', '010-692-6593 x09125', 'anastasia.net', 2, 2);
INSERT INTO users (id, name, username, email, phone, website, address_id, company_id) VALUES (3, 'Clementine Bauch', 'Samantha', 'Nathan@yesenia.net', '1-463-123-4447', 'ramiro.info', 3, 3);
INSERT INTO users (id, name, username, email, phone, website, address_id, company_id) VALUES (4, 'Patricia Lebsack', 'Karianne', 'Julianne.OConner@kory.org', '493-170-9623 x156', 'kale.biz', 4, 4);
INSERT INTO users (id, name, username, email, phone, website, address_id, company_id) VALUES (5, 'Chelsey Dietrich', 'Kamren', 'Lucio_Hettinger@annie.ca', '(254)954-1289', 'demarco.info', 5, 5);
INSERT INTO users (id, name, username, email, phone, website, address_id, company_id) VALUES (6, 'Mrs. Dennis Schulist', 'Leopoldo_Corkery', 'Karley_Dach@jasper.info', '1-477-935-8478 x6430', 'ola.org', 6, 6);
INSERT INTO users (id, name, username, email, phone, website, address_id, company_id) VALUES (7, 'Kurtis Weissnat', 'Elwyn.Skiles', 'Telly.Hoeger@billy.biz', '210.067.6132', 'elvis.io', 7, 7);
INSERT INTO users (id, name, username, email, phone, website, address_id, company_id) VALUES (8, 'Nicholas Runolfsdottir V', 'Maxime_Nienow', 'Sherwood@rosamond.me', '586.493.6943 x140', 'jacynthe.com', 8, 8);
INSERT INTO users (id, name, username, email, phone, website, address_id, company_id) VALUES (9, 'Glenna Reichert', 'Delphine', 'Chaim_McDermott@dana.io', '(775)976-6794 x41206', 'conrad.com', 9, 9);
INSERT INTO users (id, name, username, email, phone, website, address_id, company_id) VALUES (10, 'Clementina DuBuque', 'Moriah.Stanton', 'Rey.Padberg@karina.biz', '024-648-3804', 'ambrose.net', 10, 10);
