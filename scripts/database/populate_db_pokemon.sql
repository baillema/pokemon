------------------------------------------------------------------------------------------------------------------------
--- LANGUAGES RELATED
------------------------------------------------------------------------------------------------------------------------

INSERT INTO LANGUAGES (language_name) VALUES ('French');

------------------------------------------------------------------------------------------------------------------------
--- USERS RELATED
------------------------------------------------------------------------------------------------------------------------

INSERT INTO ROLES (role_name) VALUES ('Supplier');
INSERT INTO ROLES (role_name) VALUES ('Admin');
INSERT INTO ROLES (role_name) VALUES ('Buyer');
INSERT INTO ROLES (role_name) VALUES ('Trader');

INSERT INTO ROLES_TRANSLATIONS (role_translation_role, role_translation_language_id, role_translation_translation) VALUES (1, 1, 'Fournisseur');
INSERT INTO ROLES_TRANSLATIONS (role_translation_role, role_translation_language_id, role_translation_translation) VALUES (2, 1, 'Administrateur');
INSERT INTO ROLES_TRANSLATIONS (role_translation_role, role_translation_language_id, role_translation_translation) VALUES (3, 1, 'Acheteur');
INSERT INTO ROLES_TRANSLATIONS (role_translation_role, role_translation_language_id, role_translation_translation) VALUES (4, 1, 'Négociant');

INSERT INTO USERS (user_firstname, user_birthday, user_gender, user_email, user_password, user_lastname) VALUES ('user_1', '2001-10-05', 'Male', 'user1@gmail.com', 'User@MDP' , 'user_1_last');
INSERT INTO USERS (user_firstname, user_birthday, user_gender, user_email, user_password, user_lastname) VALUES ('user_2', '2003-08-05', 'Male', 'user2@gmail.com', 'User@MDP', 'user_2_last');
INSERT INTO USERS (user_firstname, user_birthday, user_gender, user_email, user_password, user_lastname) VALUES ('user_3', '1995-04-05', 'Female', 'user3@gmail.com', 'User@MDP', 'user_3_last');
INSERT INTO USERS (user_firstname, user_birthday, user_gender, user_email, user_password, user_lastname) VALUES ('user_4', '1998-11-05', 'Female', 'user4@gmail.com','User@MDP','user_4_last');
INSERT INTO USERS (user_firstname, user_birthday, user_gender, user_email, user_password, user_lastname) VALUES ('user_5', '1990-11-05', 'Female', 'user5@gmail.com','User@MDP','user_5_last');
-- Test constraint MALE OR FEMALE
INSERT INTO USERS (user_gender) VALUES ('nop');

-- Buyer + Trader
INSERT INTO USERS_ROLES (user_role_user_id, user_role_role_id) VALUES ('1', '3');
INSERT INTO USERS_ROLES (user_role_user_id, user_role_role_id) VALUES ('1', '4');
-- Supplier
INSERT INTO USERS_ROLES (user_role_user_id, user_role_role_id) VALUES ('2', '1');
INSERT INTO USERS_ROLES (user_role_user_id, user_role_role_id) VALUES ('5', '1');
-- Admin
INSERT INTO USERS_ROLES (user_role_user_id, user_role_role_id) VALUES ('3', '2');
-- Buyer [WARNING : He is only Buyer, he can't trade]
INSERT INTO USERS_ROLES (user_role_user_id, user_role_role_id) VALUES ('4', '3');

INSERT INTO FEEDBACK (feedback_text, feedback_mark, feedback_user_id) VALUES ('Vendeur agréable', 9, 2);
INSERT INTO FEEDBACK (feedback_text, feedback_mark, feedback_user_id) VALUES ('Merci pour l échange', 7, 1);
INSERT INTO FEEDBACK (feedback_text, feedback_mark, feedback_user_id) VALUES ('Bonjour admin, tu es le plus fort !'; 10; 2);
-- Check constraint : Mark <= 10, Mark >= 1
INSERT INTO FEEDBACK (feedback_text, feedback_mark, feedback_user_id) VALUES ('Bonjour admin, tu es un dieu' ,100, 3);
INSERT INTO FEEDBACK (feedback_text, feedback_mark, feedback_user_id) VALUES ('Bonjour admin, tu es un zéro' ,0, 3);
------------------------------------------------------------------------------------------------------------------------
--- ITEMS RELATED
------------------------------------------------------------------------------------------------------------------------

INSERT INTO "articles" (article_name,article_price,artcle_description,article_user_id) VALUES ('Hector',7776,'dui, semper et, lacinia vitae, sodales at, velit. Pellentesque ultricies dignissim lacus. Aliquam rutrum lorem',2),('Roth',5041,'porttitor scelerisque neque. Nullam nisl. Maecenas malesuada fringilla est. Mauris eu turpis. Nulla aliquet. Proin',1),('Stuart',6871,'erat vitae risus. Duis a mi fringilla mi lacinia mattis. Integer eu lacus. Quisque imperdiet,',1),('Amy',7634,'mattis ornare, lectus ante dictum mi, ac mattis velit justo nec ante. Maecenas mi felis,',1),('Rina',4107,'nisi dictum augue malesuada malesuada. Integer id magna et ipsum cursus vestibulum. Mauris magna. Duis',1),('Savannah',7816,'consectetuer mauris id sapien. Cras dolor dolor, tempus non, lacinia at, iaculis quis, pede. Praesent',1),('Xanthus',9512,'nascetur ridiculus mus. Donec dignissim magna a tortor. Nunc commodo auctor velit. Aliquam nisl. Nulla',1),('Skyler',4359,'tristique ac, eleifend vitae, erat. Vivamus nisi. Mauris nulla. Integer urna. Vivamus molestie dapibus ligula.',1),('Nomlanga',3333,'netus et malesuada fames ac turpis egestas. Fusce aliquet magna a neque. Nullam ut nisi',1),('Wynter',8780,'orci sem eget massa. Suspendisse eleifend. Cras sed leo. Cras vehicula aliquet libero. Integer in',1);
INSERT INTO "articles" (article_name,article_price,artcle_description,article_user_id) VALUES ('Nigel',9543,'nulla at sem molestie sodales. Mauris blandit enim consequat purus. Maecenas libero est, congue a,',1),('Reese',3694,'non, lacinia at, iaculis quis, pede. Praesent eu dui. Cum sociis natoque penatibus et magnis',1),('Amber',1655,'Vivamus nibh dolor, nonummy ac, feugiat non, lobortis quis, pede. Suspendisse dui. Fusce diam nunc,',2),('Addison',9289,'sed dui. Fusce aliquam, enim nec tempus scelerisque, lorem ipsum sodales purus, in molestie tortor',2),('Octavia',7690,'et pede. Nunc sed orci lobortis augue scelerisque mollis. Phasellus libero mauris, aliquam eu, accumsan',2),('Aileen',1831,'vel pede blandit congue. In scelerisque scelerisque dui. Suspendisse ac metus vitae velit egestas lacinia.',2),('Martena',9317,'ultrices a, auctor non, feugiat nec, diam. Duis mi enim, condimentum eget, volutpat ornare, facilisis',1),('Aspen',8444,'est. Nunc laoreet lectus quis massa. Mauris vestibulum, neque sed dictum eleifend, nunc risus varius',2),('Anne',841,'Morbi neque tellus, imperdiet non, vestibulum nec, euismod in, dolor. Fusce feugiat. Lorem ipsum dolor',2),('Kermit',1584,'pellentesque. Sed dictum. Proin eget odio. Aliquam vulputate ullamcorper magna. Sed eu eros. Nam consequat',1);
INSERT INTO "articles" (article_name,article_price,artcle_description,article_user_id) VALUES ('Winifred',4343,'tortor nibh sit amet orci. Ut sagittis lobortis mauris. Suspendisse aliquet molestie tellus. Aenean egestas',2),('Cynthia',2420,'sodales nisi magna sed dui. Fusce aliquam, enim nec tempus scelerisque, lorem ipsum sodales purus,',2),('Prescott',4044,'non arcu. Vivamus sit amet risus. Donec egestas. Aliquam nec enim. Nunc ut erat. Sed',2),('Cedric',6998,'consectetuer ipsum nunc id enim. Curabitur massa. Vestibulum accumsan neque et nunc. Quisque ornare tortor',2),('Fay',2380,'adipiscing lobortis risus. In mi pede, nonummy ut, molestie in, tempus eu, ligula. Aenean euismod',2),('Xerxes',1412,'Morbi vehicula. Pellentesque tincidunt tempus risus. Donec egestas. Duis ac arcu. Nunc mauris. Morbi non',2),('Camilla',415,'erat nonummy ultricies ornare, elit elit fermentum risus, at fringilla purus mauris a nunc. In',1),('Illiana',5193,'Fusce dolor quam, elementum at, egestas a, scelerisque sed, sapien. Nunc pulvinar arcu et pede.',1),('Yvette',8971,'risus quis diam luctus lobortis. Class aptent taciti sociosqu ad litora torquent per conubia nostra,',2),('Dorian',4970,'Donec feugiat metus sit amet ante. Vivamus non lorem vitae odio sagittis semper. Nam tempor',1);
INSERT INTO "articles" (article_name,article_price,artcle_description,article_user_id) VALUES ('Rebecca',9688,'tellus faucibus leo, in lobortis tellus justo sit amet nulla. Donec non justo. Proin non',1),('McKenzie',748,'metus. Aliquam erat volutpat. Nulla facilisis. Suspendisse commodo tincidunt nibh. Phasellus nulla. Integer vulputate, risus',2),('Norman',6579,'ac, feugiat non, lobortis quis, pede. Suspendisse dui. Fusce diam nunc, ullamcorper eu, euismod ac,',1),('MacKenzie',7293,'iaculis quis, pede. Praesent eu dui. Cum sociis natoque penatibus et magnis dis parturient montes,',2),('Blair',2542,'lacus. Cras interdum. Nunc sollicitudin commodo ipsum. Suspendisse non leo. Vivamus nibh dolor, nonummy ac,',2),('Raja',7923,'convallis dolor. Quisque tincidunt pede ac urna. Ut tincidunt vehicula risus. Nulla eget metus eu',2),('Roary',2040,'Sed eget lacus. Mauris non dui nec urna suscipit nonummy. Fusce fermentum fermentum arcu. Vestibulum',1),('Cairo',7673,'dui augue eu tellus. Phasellus elit pede, malesuada vel, venenatis vel, faucibus id, libero. Donec',1),('Imogene',2113,'mauris a nunc. In at pede. Cras vulputate velit eu sem. Pellentesque ut ipsum ac',2),('Herrod',7192,'tristique senectus et netus et malesuada fames ac turpis egestas. Aliquam fringilla cursus purus. Nullam',2);
INSERT INTO "articles" (article_name,article_price,artcle_description,article_user_id) VALUES ('Andrew',3969,'Donec porttitor tellus non magna. Nam ligula elit, pretium et, rutrum non, hendrerit id, ante.',2),('Barrett',7613,'ligula. Nullam feugiat placerat velit. Quisque varius. Nam porttitor scelerisque neque. Nullam nisl. Maecenas malesuada',1),('Inga',4105,'natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec dignissim magna a tortor.',1),('Aurelia',5406,'porttitor scelerisque neque. Nullam nisl. Maecenas malesuada fringilla est. Mauris eu turpis. Nulla aliquet. Proin',2),('Abraham',9293,'turpis. In condimentum. Donec at arcu. Vestibulum ante ipsum primis in faucibus orci luctus et',1),('Amy',4667,'erat semper rutrum. Fusce dolor quam, elementum at, egestas a, scelerisque sed, sapien. Nunc pulvinar',1),('Elmo',6540,'ornare. Fusce mollis. Duis sit amet diam eu dolor egestas rhoncus. Proin nisl sem, consequat',2),('Stephanie',4896,'diam luctus lobortis. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos',2),('Cassady',7965,'Sed nunc est, mollis non, cursus non, egestas a, dui. Cras pellentesque. Sed dictum. Proin',2),('Xena',2515,'Quisque nonummy ipsum non arcu. Vivamus sit amet risus. Donec egestas. Aliquam nec enim. Nunc',2);
INSERT INTO "articles" (article_name,article_price,artcle_description,article_user_id) VALUES ('Yvonne',9147,'eget nisi dictum augue malesuada malesuada. Integer id magna et ipsum cursus vestibulum. Mauris magna.',2),('Edward',6267,'sapien imperdiet ornare. In faucibus. Morbi vehicula. Pellentesque tincidunt tempus risus. Donec egestas. Duis ac',2),('Ralph',1379,'tellus non magna. Nam ligula elit, pretium et, rutrum non, hendrerit id, ante. Nunc mauris',1),('Kelly',4354,'dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer aliquam adipiscing lacus. Ut nec',2),('Griffith',7723,'Aenean sed pede nec ante blandit viverra. Donec tempus, lorem fringilla ornare placerat, orci lacus',2),('Elton',6676,'aliquet diam. Sed diam lorem, auctor quis, tristique ac, eleifend vitae, erat. Vivamus nisi. Mauris',1),('Castor',4743,'libero. Morbi accumsan laoreet ipsum. Curabitur consequat, lectus sit amet luctus vulputate, nisi sem semper',2),('Regan',5632,'natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Proin vel arcu eu odio',1),('Rhoda',5702,'Mauris nulla. Integer urna. Vivamus molestie dapibus ligula. Aliquam erat volutpat. Nulla dignissim. Maecenas ornare',2),('Raphael',567,'Nunc commodo auctor velit. Aliquam nisl. Nulla eu neque pellentesque massa lobortis ultrices. Vivamus rhoncus.',1);
INSERT INTO "articles" (article_name,article_price,artcle_description,article_user_id) VALUES ('Alfonso',294,'a, malesuada id, erat. Etiam vestibulum massa rutrum magna. Cras convallis convallis dolor. Quisque tincidunt',2),('Gage',6961,'at fringilla purus mauris a nunc. In at pede. Cras vulputate velit eu sem. Pellentesque',1),('Alea',7804,'eget, venenatis a, magna. Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Etiam laoreet, libero',2),('Jescie',997,'vel nisl. Quisque fringilla euismod enim. Etiam gravida molestie arcu. Sed eu nibh vulputate mauris',2),('Darrel',5246,'ullamcorper magna. Sed eu eros. Nam consequat dolor vitae dolor. Donec fringilla. Donec feugiat metus',1),('Seth',2030,'consectetuer adipiscing elit. Curabitur sed tortor. Integer aliquam adipiscing lacus. Ut nec urna et arcu',2),('Hammett',2791,'non, vestibulum nec, euismod in, dolor. Fusce feugiat. Lorem ipsum dolor sit amet, consectetuer adipiscing',2),('Lydia',8821,'hendrerit consectetuer, cursus et, magna. Praesent interdum ligula eu enim. Etiam imperdiet dictum magna. Ut',1),('Michelle',9882,'ante. Vivamus non lorem vitae odio sagittis semper. Nam tempor diam dictum sapien. Aenean massa.',1),('Jolie',4805,'ut cursus luctus, ipsum leo elementum sem, vitae aliquam eros turpis non enim. Mauris quis',1);
INSERT INTO "articles" (article_name,article_price,artcle_description,article_user_id) VALUES ('Myles',1071,'laoreet, libero et tristique pellentesque, tellus sem mollis dui, in sodales elit erat vitae risus.',2),('Armando',7428,'tempor diam dictum sapien. Aenean massa. Integer vitae nibh. Donec est mauris, rhoncus id, mollis',2),('Sylvia',4038,'ipsum porta elit, a feugiat tellus lorem eu metus. In lorem. Donec elementum, lorem ut',2),('Colette',2386,'pede. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Proin vel',1),('Isaiah',6654,'nonummy ultricies ornare, elit elit fermentum risus, at fringilla purus mauris a nunc. In at',2),('Hedy',8792,'eu tellus eu augue porttitor interdum. Sed auctor odio a purus. Duis elementum, dui quis',2),('Montana',5435,'volutpat. Nulla facilisis. Suspendisse commodo tincidunt nibh. Phasellus nulla. Integer vulputate, risus a ultricies adipiscing,',1),('Buckminster',2393,'tincidunt vehicula risus. Nulla eget metus eu erat semper rutrum. Fusce dolor quam, elementum at,',1),('Amy',5175,'ornare, lectus ante dictum mi, ac mattis velit justo nec ante. Maecenas mi felis, adipiscing',2),('Tatum',7996,'et, euismod et, commodo at, libero. Morbi accumsan laoreet ipsum. Curabitur consequat, lectus sit amet',1);
INSERT INTO "articles" (article_name,article_price,artcle_description,article_user_id) VALUES ('Amber',6295,'enim nec tempus scelerisque, lorem ipsum sodales purus, in molestie tortor nibh sit amet orci.',2),('Ignatius',9827,'imperdiet ullamcorper. Duis at lacus. Quisque purus sapien, gravida non, sollicitudin a, malesuada id, erat.',1),('Ebony',7761,'malesuada vel, convallis in, cursus et, eros. Proin ultrices. Duis volutpat nunc sit amet metus.',2),('Aladdin',1782,'sed dui. Fusce aliquam, enim nec tempus scelerisque, lorem ipsum sodales purus, in molestie tortor',1),('Samantha',4160,'a, enim. Suspendisse aliquet, sem ut cursus luctus, ipsum leo elementum sem, vitae aliquam eros',2),('Fleur',8607,'Cras pellentesque. Sed dictum. Proin eget odio. Aliquam vulputate ullamcorper magna. Sed eu eros. Nam',2),('Kiona',1799,'magnis dis parturient montes, nascetur ridiculus mus. Proin vel nisl. Quisque fringilla euismod enim. Etiam',2),('Isabelle',9012,'commodo tincidunt nibh. Phasellus nulla. Integer vulputate, risus a ultricies adipiscing, enim mi tempor lorem,',1),('Benedict',5830,'sapien imperdiet ornare. In faucibus. Morbi vehicula. Pellentesque tincidunt tempus risus. Donec egestas. Duis ac',1),('Madeline',769,'nibh. Quisque nonummy ipsum non arcu. Vivamus sit amet risus. Donec egestas. Aliquam nec enim.',2);
INSERT INTO "articles" (article_name,article_price,artcle_description,article_user_id) VALUES ('Jaquelyn',9840,'amet massa. Quisque porttitor eros nec tellus. Nunc lectus pede, ultrices a, auctor non, feugiat',1),('Lester',8242,'dictum placerat, augue. Sed molestie. Sed id risus quis diam luctus lobortis. Class aptent taciti',1),('Travis',7759,'sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Proin vel nisl. Quisque',2),('Quinn',3495,'aliquam adipiscing lacus. Ut nec urna et arcu imperdiet ullamcorper. Duis at lacus. Quisque purus',1),('Kathleen',1193,'massa non ante bibendum ullamcorper. Duis cursus, diam at pretium aliquet, metus urna convallis erat,',1),('Eric',6243,'tincidunt dui augue eu tellus. Phasellus elit pede, malesuada vel, venenatis vel, faucibus id, libero.',1),('Jaime',7022,'ultricies sem magna nec quam. Curabitur vel lectus. Cum sociis natoque penatibus et magnis dis',1),('Ulysses',5837,'mauris eu elit. Nulla facilisi. Sed neque. Sed eget lacus. Mauris non dui nec urna',1),('Adena',6266,'Nunc laoreet lectus quis massa. Mauris vestibulum, neque sed dictum eleifend, nunc risus varius orci,',1),('Martena',784,'Duis a mi fringilla mi lacinia mattis. Integer eu lacus. Quisque imperdiet, erat nonummy ultricies',1);

INSERT INTO "LOTS" (lot_name,lot_description,lot_prix) VALUES ('vulputate, lacus.','Etiam laoreet, libero et tristique pellentesque, tellus sem mollis dui, in sodales elit erat vitae risus. Duis a mi fringilla',2767);
INSERT INTO "LOTS" (lot_name,lot_description,lot_prix) VALUES ('Vivamus euismod','Ut nec urna et arcu imperdiet ullamcorper. Duis at lacus. Quisque purus sapien, gravida non, sollicitudin a, malesuada id, erat.',1295);
INSERT INTO "LOTS" (lot_name,lot_description,lot_prix) VALUES ('arcu imperdiet','faucibus ut, nulla. Cras eu tellus eu augue porttitor interdum. Sed auctor odio a purus. Duis elementum, dui quis accumsan',2032);
INSERT INTO "LOTS" (lot_name,lot_description,lot_prix) VALUES ('consequat, lectus','ut lacus. Nulla tincidunt, neque vitae semper egestas, urna justo faucibus lectus, a sollicitudin orci sem eget massa. Suspendisse eleifend.',1767);
INSERT INTO "LOTS" (lot_name,lot_description,lot_prix) VALUES ('at arcu.','In faucibus. Morbi vehicula. Pellentesque tincidunt tempus risus. Donec egestas. Duis ac arcu. Nunc mauris. Morbi non sapien molestie orci',4523);
INSERT INTO "LOTS" (lot_name,lot_description,lot_prix) VALUES ('nisi. Cum','tellus faucibus leo, in lobortis tellus justo sit amet nulla. Donec non justo. Proin non massa non ante bibendum ullamcorper.',624);
INSERT INTO "LOTS" (lot_name,lot_description,lot_prix) VALUES ('Curae; Phasellus','a ultricies adipiscing, enim mi tempor lorem, eget mollis lectus pede et risus. Quisque libero lacus, varius et, euismod et,',76);
INSERT INTO "LOTS" (lot_name,lot_description,lot_prix) VALUES ('pellentesque massa','Donec tincidunt. Donec vitae erat vel pede blandit congue. In scelerisque scelerisque dui. Suspendisse ac metus vitae velit egestas lacinia.',1468);
INSERT INTO "LOTS" (lot_name,lot_description,lot_prix) VALUES ('eros. Nam','non massa non ante bibendum ullamcorper. Duis cursus, diam at pretium aliquet, metus urna convallis erat, eget tincidunt dui augue',4407);
INSERT INTO "LOTS" (lot_name,lot_description,lot_prix) VALUES ('Nunc lectus','libero lacus, varius et, euismod et, commodo at, libero. Morbi accumsan laoreet ipsum. Curabitur consequat, lectus sit amet luctus vulputate,',277);
INSERT INTO "LOTS" (lot_name,lot_description,lot_prix) VALUES ('et pede.','Morbi neque tellus, imperdiet non, vestibulum nec, euismod in, dolor. Fusce feugiat. Lorem ipsum dolor sit amet, consectetuer adipiscing elit.',498);
INSERT INTO "LOTS" (lot_name,lot_description,lot_prix) VALUES ('Duis ac','risus. Quisque libero lacus, varius et, euismod et, commodo at, libero. Morbi accumsan laoreet ipsum. Curabitur consequat, lectus sit amet',1357);
INSERT INTO "LOTS" (lot_name,lot_description,lot_prix) VALUES ('Nunc pulvinar','Fusce dolor quam, elementum at, egestas a, scelerisque sed, sapien. Nunc pulvinar arcu et pede. Nunc sed orci lobortis augue',2385);
INSERT INTO "LOTS" (lot_name,lot_description,lot_prix) VALUES ('accumsan sed,','dui, in sodales elit erat vitae risus. Duis a mi fringilla mi lacinia mattis. Integer eu lacus. Quisque imperdiet, erat',4835);
INSERT INTO "LOTS" (lot_name,lot_description,lot_prix) VALUES ('interdum. Nunc','massa. Vestibulum accumsan neque et nunc. Quisque ornare tortor at risus. Nunc ac sem ut dolor dapibus gravida. Aliquam tincidunt,',3412);
INSERT INTO "LOTS" (lot_name,lot_description,lot_prix) VALUES ('mollis non,','magna a tortor. Nunc commodo auctor velit. Aliquam nisl. Nulla eu neque pellentesque massa lobortis ultrices. Vivamus rhoncus. Donec est.',1105);
INSERT INTO "LOTS" (lot_name,lot_description,lot_prix) VALUES ('lacus vestibulum','sem molestie sodales. Mauris blandit enim consequat purus. Maecenas libero est, congue a, aliquet vel, vulputate eu, odio. Phasellus at',4890);
INSERT INTO "LOTS" (lot_name,lot_description,lot_prix) VALUES ('imperdiet ullamcorper.','Donec egestas. Aliquam nec enim. Nunc ut erat. Sed nunc est, mollis non, cursus non, egestas a, dui. Cras pellentesque.',3858);
INSERT INTO "LOTS" (lot_name,lot_description,lot_prix) VALUES ('in consequat','ut, sem. Nulla interdum. Curabitur dictum. Phasellus in felis. Nulla tempor augue ac ipsum. Phasellus vitae mauris sit amet lorem',2671);
INSERT INTO "LOTS" (lot_name,lot_description,lot_prix) VALUES ('dui. Fusce','sit amet, dapibus id, blandit at, nisi. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Proin',1768);
INSERT INTO "LOTS" (lot_name,lot_description,lot_prix) VALUES ('Donec egestas.','mauris sit amet lorem semper auctor. Mauris vel turpis. Aliquam adipiscing lobortis risus. In mi pede, nonummy ut, molestie in,',365);
INSERT INTO "LOTS" (lot_name,lot_description,lot_prix) VALUES ('ultricies ornare,','ligula. Nullam enim. Sed nulla ante, iaculis nec, eleifend non, dapibus rutrum, justo. Praesent luctus. Curabitur egestas nunc sed libero.',3860);
INSERT INTO "LOTS" (lot_name,lot_description,lot_prix) VALUES ('non quam.','Proin vel nisl. Quisque fringilla euismod enim. Etiam gravida molestie arcu. Sed eu nibh vulputate mauris sagittis placerat. Cras dictum',1497);
INSERT INTO "LOTS" (lot_name,lot_description,lot_prix) VALUES ('a, arcu.','sed, sapien. Nunc pulvinar arcu et pede. Nunc sed orci lobortis augue scelerisque mollis. Phasellus libero mauris, aliquam eu, accumsan',962);
INSERT INTO "LOTS" (lot_name,lot_description,lot_prix) VALUES ('Nam porttitor','Sed eget lacus. Mauris non dui nec urna suscipit nonummy. Fusce fermentum fermentum arcu. Vestibulum ante ipsum primis in faucibus',32);
INSERT INTO "LOTS" (lot_name,lot_description,lot_prix) VALUES ('vel, vulputate','at risus. Nunc ac sem ut dolor dapibus gravida. Aliquam tincidunt, nunc ac mattis ornare, lectus ante dictum mi, ac',2773);
INSERT INTO "LOTS" (lot_name,lot_description,lot_prix) VALUES ('Aenean eget','id, ante. Nunc mauris sapien, cursus in, hendrerit consectetuer, cursus et, magna. Praesent interdum ligula eu enim. Etiam imperdiet dictum',565);
INSERT INTO "LOTS" (lot_name,lot_description,lot_prix) VALUES ('arcu ac','vel lectus. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec dignissim magna a tortor. Nunc',3551);
INSERT INTO "LOTS" (lot_name,lot_description,lot_prix) VALUES ('Donec dignissim','posuere at, velit. Cras lorem lorem, luctus ut, pellentesque eget, dictum placerat, augue. Sed molestie. Sed id risus quis diam',3965);
INSERT INTO "LOTS" (lot_name,lot_description,lot_prix) VALUES ('a, arcu.','accumsan sed, facilisis vitae, orci. Phasellus dapibus quam quis diam. Pellentesque habitant morbi tristique senectus et netus et malesuada fames',3368);
INSERT INTO "LOTS" (lot_name,lot_description,lot_prix) VALUES ('sem elit,','nisi. Aenean eget metus. In nec orci. Donec nibh. Quisque nonummy ipsum non arcu. Vivamus sit amet risus. Donec egestas.',2266);
INSERT INTO "LOTS" (lot_name,lot_description,lot_prix) VALUES ('nec tempus','vitae diam. Proin dolor. Nulla semper tellus id nunc interdum feugiat. Sed nec metus facilisis lorem tristique aliquet. Phasellus fermentum',350);
INSERT INTO "LOTS" (lot_name,lot_description,lot_prix) VALUES ('fringilla purus','eros nec tellus. Nunc lectus pede, ultrices a, auctor non, feugiat nec, diam. Duis mi enim, condimentum eget, volutpat ornare,',1303);
INSERT INTO "LOTS" (lot_name,lot_description,lot_prix) VALUES ('cursus. Nunc','et malesuada fames ac turpis egestas. Fusce aliquet magna a neque. Nullam ut nisi a odio semper cursus. Integer mollis.',968);
INSERT INTO "LOTS" (lot_name,lot_description,lot_prix) VALUES ('mus. Donec','ipsum. Suspendisse sagittis. Nullam vitae diam. Proin dolor. Nulla semper tellus id nunc interdum feugiat. Sed nec metus facilisis lorem',4182);
INSERT INTO "LOTS" (lot_name,lot_description,lot_prix) VALUES ('In scelerisque','lacus. Etiam bibendum fermentum metus. Aenean sed pede nec ante blandit viverra. Donec tempus, lorem fringilla ornare placerat, orci lacus',1422);
INSERT INTO "LOTS" (lot_name,lot_description,lot_prix) VALUES ('Nullam feugiat','Mauris quis turpis vitae purus gravida sagittis. Duis gravida. Praesent eu nulla at sem molestie sodales. Mauris blandit enim consequat',3472);
INSERT INTO "LOTS" (lot_name,lot_description,lot_prix) VALUES ('erat vitae','leo elementum sem, vitae aliquam eros turpis non enim. Mauris quis turpis vitae purus gravida sagittis. Duis gravida. Praesent eu',3984);
INSERT INTO "LOTS" (lot_name,lot_description,lot_prix) VALUES ('euismod mauris','pede. Cras vulputate velit eu sem. Pellentesque ut ipsum ac mi eleifend egestas. Sed pharetra, felis eget varius ultrices, mauris',3377);
INSERT INTO "LOTS" (lot_name,lot_description,lot_prix) VALUES ('felis ullamcorper','arcu eu odio tristique pharetra. Quisque ac libero nec ligula consectetuer rhoncus. Nullam velit dui, semper et, lacinia vitae, sodales',1414);
INSERT INTO "LOTS" (lot_name,lot_description,lot_prix) VALUES ('dui. Fusce','tincidunt pede ac urna. Ut tincidunt vehicula risus. Nulla eget metus eu erat semper rutrum. Fusce dolor quam, elementum at,',1317);
INSERT INTO "LOTS" (lot_name,lot_description,lot_prix) VALUES ('Fusce diam','nec urna et arcu imperdiet ullamcorper. Duis at lacus. Quisque purus sapien, gravida non, sollicitudin a, malesuada id, erat. Etiam',3680);
INSERT INTO "LOTS" (lot_name,lot_description,lot_prix) VALUES ('lacus vestibulum','aliquet. Proin velit. Sed malesuada augue ut lacus. Nulla tincidunt, neque vitae semper egestas, urna justo faucibus lectus, a sollicitudin',459);
INSERT INTO "LOTS" (lot_name,lot_description,lot_prix) VALUES ('eget, ipsum.','pede. Nunc sed orci lobortis augue scelerisque mollis. Phasellus libero mauris, aliquam eu, accumsan sed, facilisis vitae, orci. Phasellus dapibus',4789);
INSERT INTO "LOTS" (lot_name,lot_description,lot_prix) VALUES ('est, congue','ornare egestas ligula. Nullam feugiat placerat velit. Quisque varius. Nam porttitor scelerisque neque. Nullam nisl. Maecenas malesuada fringilla est. Mauris',483);
INSERT INTO "LOTS" (lot_name,lot_description,lot_prix) VALUES ('iaculis aliquet','volutpat. Nulla facilisis. Suspendisse commodo tincidunt nibh. Phasellus nulla. Integer vulputate, risus a ultricies adipiscing, enim mi tempor lorem, eget',284);
INSERT INTO "LOTS" (lot_name,lot_description,lot_prix) VALUES ('ut aliquam','amet luctus vulputate, nisi sem semper erat, in consectetuer ipsum nunc id enim. Curabitur massa. Vestibulum accumsan neque et nunc.',3191);
INSERT INTO "LOTS" (lot_name,lot_description,lot_prix) VALUES ('turpis. In','et magnis dis parturient montes, nascetur ridiculus mus. Proin vel arcu eu odio tristique pharetra. Quisque ac libero nec ligula',991);
INSERT INTO "LOTS" (lot_name,lot_description,lot_prix) VALUES ('Morbi sit','vitae velit egestas lacinia. Sed congue, elit sed consequat auctor, nunc nulla vulputate dui, nec tempus mauris erat eget ipsum.',2813);
INSERT INTO "LOTS" (lot_name,lot_description,lot_prix) VALUES ('facilisis non,','orci lobortis augue scelerisque mollis. Phasellus libero mauris, aliquam eu, accumsan sed, facilisis vitae, orci. Phasellus dapibus quam quis diam.',4632);
INSERT INTO "LOTS" (lot_name,lot_description,lot_prix) VALUES ('diam eu','metus sit amet ante. Vivamus non lorem vitae odio sagittis semper. Nam tempor diam dictum sapien. Aenean massa. Integer vitae',1402);
INSERT INTO "LOTS" (lot_name,lot_description,lot_prix) VALUES ('sagittis. Duis','at sem molestie sodales. Mauris blandit enim consequat purus. Maecenas libero est, congue a, aliquet vel, vulputate eu, odio. Phasellus',4520);
INSERT INTO "LOTS" (lot_name,lot_description,lot_prix) VALUES ('nec enim.','eget tincidunt dui augue eu tellus. Phasellus elit pede, malesuada vel, venenatis vel, faucibus id, libero. Donec consectetuer mauris id',4372);
INSERT INTO "LOTS" (lot_name,lot_description,lot_prix) VALUES ('sed orci','orci. Ut sagittis lobortis mauris. Suspendisse aliquet molestie tellus. Aenean egestas hendrerit neque. In ornare sagittis felis. Donec tempor, est',1200);
INSERT INTO "LOTS" (lot_name,lot_description,lot_prix) VALUES ('Suspendisse sed','Quisque imperdiet, erat nonummy ultricies ornare, elit elit fermentum risus, at fringilla purus mauris a nunc. In at pede. Cras',1187);
INSERT INTO "LOTS" (lot_name,lot_description,lot_prix) VALUES ('varius ultrices,','in faucibus orci luctus et ultrices posuere cubilia Curae; Phasellus ornare. Fusce mollis. Duis sit amet diam eu dolor egestas',848);
INSERT INTO "LOTS" (lot_name,lot_description,lot_prix) VALUES ('leo elementum','Integer sem elit, pharetra ut, pharetra sed, hendrerit a, arcu. Sed et libero. Proin mi. Aliquam gravida mauris ut mi.',762);
INSERT INTO "LOTS" (lot_name,lot_description,lot_prix) VALUES ('a, scelerisque','gravida mauris ut mi. Duis risus odio, auctor vitae, aliquet nec, imperdiet nec, leo. Morbi neque tellus, imperdiet non, vestibulum',4592);
INSERT INTO "LOTS" (lot_name,lot_description,lot_prix) VALUES ('lorem semper','dolor quam, elementum at, egestas a, scelerisque sed, sapien. Nunc pulvinar arcu et pede. Nunc sed orci lobortis augue scelerisque',4947);
INSERT INTO "LOTS" (lot_name,lot_description,lot_prix) VALUES ('Cras convallis','imperdiet ornare. In faucibus. Morbi vehicula. Pellentesque tincidunt tempus risus. Donec egestas. Duis ac arcu. Nunc mauris. Morbi non sapien',3242);
INSERT INTO "LOTS" (lot_name,lot_description,lot_prix) VALUES ('scelerisque scelerisque','sed orci lobortis augue scelerisque mollis. Phasellus libero mauris, aliquam eu, accumsan sed, facilisis vitae, orci. Phasellus dapibus quam quis',2716);
INSERT INTO "LOTS" (lot_name,lot_description,lot_prix) VALUES ('iaculis nec,','lobortis risus. In mi pede, nonummy ut, molestie in, tempus eu, ligula. Aenean euismod mauris eu elit. Nulla facilisi. Sed',3289);
INSERT INTO "LOTS" (lot_name,lot_description,lot_prix) VALUES ('in lobortis','Mauris eu turpis. Nulla aliquet. Proin velit. Sed malesuada augue ut lacus. Nulla tincidunt, neque vitae semper egestas, urna justo',3079);
INSERT INTO "LOTS" (lot_name,lot_description,lot_prix) VALUES ('pharetra ut,','elit. Curabitur sed tortor. Integer aliquam adipiscing lacus. Ut nec urna et arcu imperdiet ullamcorper. Duis at lacus. Quisque purus',3488);
INSERT INTO "LOTS" (lot_name,lot_description,lot_prix) VALUES ('odio semper','erat. Etiam vestibulum massa rutrum magna. Cras convallis convallis dolor. Quisque tincidunt pede ac urna. Ut tincidunt vehicula risus. Nulla',3583);
INSERT INTO "LOTS" (lot_name,lot_description,lot_prix) VALUES ('leo elementum','tincidunt congue turpis. In condimentum. Donec at arcu. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia',765);
INSERT INTO "LOTS" (lot_name,lot_description,lot_prix) VALUES ('ipsum. Suspendisse','nec tempus mauris erat eget ipsum. Suspendisse sagittis. Nullam vitae diam. Proin dolor. Nulla semper tellus id nunc interdum feugiat.',4146);
INSERT INTO "LOTS" (lot_name,lot_description,lot_prix) VALUES ('a, malesuada','leo. Cras vehicula aliquet libero. Integer in magna. Phasellus dolor elit, pellentesque a, facilisis non, bibendum sed, est. Nunc laoreet',1344);
INSERT INTO "LOTS" (lot_name,lot_description,lot_prix) VALUES ('lectus. Nullam','turpis nec mauris blandit mattis. Cras eget nisi dictum augue malesuada malesuada. Integer id magna et ipsum cursus vestibulum. Mauris',4798);
INSERT INTO "LOTS" (lot_name,lot_description,lot_prix) VALUES ('imperdiet ornare.','Donec est mauris, rhoncus id, mollis nec, cursus a, enim. Suspendisse aliquet, sem ut cursus luctus, ipsum leo elementum sem,',4991);

INSERT INTO "LOTS_ARTICLES" (lot_article_lot_id,lot_article_article_id) VALUES (1,1);
INSERT INTO "LOTS_ARTICLES" (lot_article_lot_id,lot_article_article_id) VALUES (2,2);
INSERT INTO "LOTS_ARTICLES" (lot_article_lot_id,lot_article_article_id) VALUES (3,3);
INSERT INTO "LOTS_ARTICLES" (lot_article_lot_id,lot_article_article_id) VALUES (4,4);
INSERT INTO "LOTS_ARTICLES" (lot_article_lot_id,lot_article_article_id) VALUES (5,5);
INSERT INTO "LOTS_ARTICLES" (lot_article_lot_id,lot_article_article_id) VALUES (6,6);
INSERT INTO "LOTS_ARTICLES" (lot_article_lot_id,lot_article_article_id) VALUES (7,7);
INSERT INTO "LOTS_ARTICLES" (lot_article_lot_id,lot_article_article_id) VALUES (8,8);
INSERT INTO "LOTS_ARTICLES" (lot_article_lot_id,lot_article_article_id) VALUES (9,9);
INSERT INTO "LOTS_ARTICLES" (lot_article_lot_id,lot_article_article_id) VALUES (10,10);
INSERT INTO "LOTS_ARTICLES" (lot_article_lot_id,lot_article_article_id) VALUES (11,11);
INSERT INTO "LOTS_ARTICLES" (lot_article_lot_id,lot_article_article_id) VALUES (12,12);
INSERT INTO "LOTS_ARTICLES" (lot_article_lot_id,lot_article_article_id) VALUES (13,13);
INSERT INTO "LOTS_ARTICLES" (lot_article_lot_id,lot_article_article_id) VALUES (14,14);
INSERT INTO "LOTS_ARTICLES" (lot_article_lot_id,lot_article_article_id) VALUES (15,15);
INSERT INTO "LOTS_ARTICLES" (lot_article_lot_id,lot_article_article_id) VALUES (16,16);
INSERT INTO "LOTS_ARTICLES" (lot_article_lot_id,lot_article_article_id) VALUES (17,17);
INSERT INTO "LOTS_ARTICLES" (lot_article_lot_id,lot_article_article_id) VALUES (18,18);
INSERT INTO "LOTS_ARTICLES" (lot_article_lot_id,lot_article_article_id) VALUES (19,19);
INSERT INTO "LOTS_ARTICLES" (lot_article_lot_id,lot_article_article_id) VALUES (20,20);
INSERT INTO "LOTS_ARTICLES" (lot_article_lot_id,lot_article_article_id) VALUES (21,21);
INSERT INTO "LOTS_ARTICLES" (lot_article_lot_id,lot_article_article_id) VALUES (22,22);
INSERT INTO "LOTS_ARTICLES" (lot_article_lot_id,lot_article_article_id) VALUES (23,23);
INSERT INTO "LOTS_ARTICLES" (lot_article_lot_id,lot_article_article_id) VALUES (24,24);
INSERT INTO "LOTS_ARTICLES" (lot_article_lot_id,lot_article_article_id) VALUES (25,25);
INSERT INTO "LOTS_ARTICLES" (lot_article_lot_id,lot_article_article_id) VALUES (26,26);
INSERT INTO "LOTS_ARTICLES" (lot_article_lot_id,lot_article_article_id) VALUES (27,27);
INSERT INTO "LOTS_ARTICLES" (lot_article_lot_id,lot_article_article_id) VALUES (28,28);
INSERT INTO "LOTS_ARTICLES" (lot_article_lot_id,lot_article_article_id) VALUES (29,29);
INSERT INTO "LOTS_ARTICLES" (lot_article_lot_id,lot_article_article_id) VALUES (30,30);
INSERT INTO "LOTS_ARTICLES" (lot_article_lot_id,lot_article_article_id) VALUES (31,31);
INSERT INTO "LOTS_ARTICLES" (lot_article_lot_id,lot_article_article_id) VALUES (32,32);
INSERT INTO "LOTS_ARTICLES" (lot_article_lot_id,lot_article_article_id) VALUES (33,33);
INSERT INTO "LOTS_ARTICLES" (lot_article_lot_id,lot_article_article_id) VALUES (34,34);
INSERT INTO "LOTS_ARTICLES" (lot_article_lot_id,lot_article_article_id) VALUES (35,35);
INSERT INTO "LOTS_ARTICLES" (lot_article_lot_id,lot_article_article_id) VALUES (36,36);
INSERT INTO "LOTS_ARTICLES" (lot_article_lot_id,lot_article_article_id) VALUES (37,37);
INSERT INTO "LOTS_ARTICLES" (lot_article_lot_id,lot_article_article_id) VALUES (38,38);
INSERT INTO "LOTS_ARTICLES" (lot_article_lot_id,lot_article_article_id) VALUES (39,39);
INSERT INTO "LOTS_ARTICLES" (lot_article_lot_id,lot_article_article_id) VALUES (40,40);
INSERT INTO "LOTS_ARTICLES" (lot_article_lot_id,lot_article_article_id) VALUES (41,41);
INSERT INTO "LOTS_ARTICLES" (lot_article_lot_id,lot_article_article_id) VALUES (42,42);
INSERT INTO "LOTS_ARTICLES" (lot_article_lot_id,lot_article_article_id) VALUES (43,43);
INSERT INTO "LOTS_ARTICLES" (lot_article_lot_id,lot_article_article_id) VALUES (44,44);
INSERT INTO "LOTS_ARTICLES" (lot_article_lot_id,lot_article_article_id) VALUES (45,45);
INSERT INTO "LOTS_ARTICLES" (lot_article_lot_id,lot_article_article_id) VALUES (46,46);
INSERT INTO "LOTS_ARTICLES" (lot_article_lot_id,lot_article_article_id) VALUES (47,47);
INSERT INTO "LOTS_ARTICLES" (lot_article_lot_id,lot_article_article_id) VALUES (48,48);
INSERT INTO "LOTS_ARTICLES" (lot_article_lot_id,lot_article_article_id) VALUES (49,49);
INSERT INTO "LOTS_ARTICLES" (lot_article_lot_id,lot_article_article_id) VALUES (50,50);
INSERT INTO "LOTS_ARTICLES" (lot_article_lot_id,lot_article_article_id) VALUES (51,51);
INSERT INTO "LOTS_ARTICLES" (lot_article_lot_id,lot_article_article_id) VALUES (52,52);
INSERT INTO "LOTS_ARTICLES" (lot_article_lot_id,lot_article_article_id) VALUES (53,53);
INSERT INTO "LOTS_ARTICLES" (lot_article_lot_id,lot_article_article_id) VALUES (54,54);
INSERT INTO "LOTS_ARTICLES" (lot_article_lot_id,lot_article_article_id) VALUES (55,55);
INSERT INTO "LOTS_ARTICLES" (lot_article_lot_id,lot_article_article_id) VALUES (56,56);
INSERT INTO "LOTS_ARTICLES" (lot_article_lot_id,lot_article_article_id) VALUES (57,57);
INSERT INTO "LOTS_ARTICLES" (lot_article_lot_id,lot_article_article_id) VALUES (58,58);
INSERT INTO "LOTS_ARTICLES" (lot_article_lot_id,lot_article_article_id) VALUES (59,59);
INSERT INTO "LOTS_ARTICLES" (lot_article_lot_id,lot_article_article_id) VALUES (60,60);
INSERT INTO "LOTS_ARTICLES" (lot_article_lot_id,lot_article_article_id) VALUES (61,61);
INSERT INTO "LOTS_ARTICLES" (lot_article_lot_id,lot_article_article_id) VALUES (62,62);
INSERT INTO "LOTS_ARTICLES" (lot_article_lot_id,lot_article_article_id) VALUES (63,63);
INSERT INTO "LOTS_ARTICLES" (lot_article_lot_id,lot_article_article_id) VALUES (64,64);
INSERT INTO "LOTS_ARTICLES" (lot_article_lot_id,lot_article_article_id) VALUES (65,65);
INSERT INTO "LOTS_ARTICLES" (lot_article_lot_id,lot_article_article_id) VALUES (66,66);
INSERT INTO "LOTS_ARTICLES" (lot_article_lot_id,lot_article_article_id) VALUES (67,67);
INSERT INTO "LOTS_ARTICLES" (lot_article_lot_id,lot_article_article_id) VALUES (68,68);
INSERT INTO "LOTS_ARTICLES" (lot_article_lot_id,lot_article_article_id) VALUES (69,69);
INSERT INTO "LOTS_ARTICLES" (lot_article_lot_id,lot_article_article_id) VALUES (70,70);

INSERT INTO "LOTS_ARTICLES" (lot_article_lot_id,lot_article_article_id) VALUES (1,71);
INSERT INTO "LOTS_ARTICLES" (lot_article_lot_id,lot_article_article_id) VALUES (1,72);
INSERT INTO "LOTS_ARTICLES" (lot_article_lot_id,lot_article_article_id) VALUES (1,73);
INSERT INTO "LOTS_ARTICLES" (lot_article_lot_id,lot_article_article_id) VALUES (1,74);
INSERT INTO "LOTS_ARTICLES" (lot_article_lot_id,lot_article_article_id) VALUES (1,75);
INSERT INTO "LOTS_ARTICLES" (lot_article_lot_id,lot_article_article_id) VALUES (2,76);
INSERT INTO "LOTS_ARTICLES" (lot_article_lot_id,lot_article_article_id) VALUES (2,77);
INSERT INTO "LOTS_ARTICLES" (lot_article_lot_id,lot_article_article_id) VALUES (2,78);
INSERT INTO "LOTS_ARTICLES" (lot_article_lot_id,lot_article_article_id) VALUES (2,79);
INSERT INTO "LOTS_ARTICLES" (lot_article_lot_id,lot_article_article_id) VALUES (3,80);
INSERT INTO "LOTS_ARTICLES" (lot_article_lot_id,lot_article_article_id) VALUES (3,81);
INSERT INTO "LOTS_ARTICLES" (lot_article_lot_id,lot_article_article_id) VALUES (4,82);
INSERT INTO "LOTS_ARTICLES" (lot_article_lot_id,lot_article_article_id) VALUES (4,83);
INSERT INTO "LOTS_ARTICLES" (lot_article_lot_id,lot_article_article_id) VALUES (4,84);
INSERT INTO "LOTS_ARTICLES" (lot_article_lot_id,lot_article_article_id) VALUES (4,85);
INSERT INTO "LOTS_ARTICLES" (lot_article_lot_id,lot_article_article_id) VALUES (4,86);
INSERT INTO "LOTS_ARTICLES" (lot_article_lot_id,lot_article_article_id) VALUES (4,87);
INSERT INTO "LOTS_ARTICLES" (lot_article_lot_id,lot_article_article_id) VALUES (4,88);
INSERT INTO "LOTS_ARTICLES" (lot_article_lot_id,lot_article_article_id) VALUES (5,89);
INSERT INTO "LOTS_ARTICLES" (lot_article_lot_id,lot_article_article_id) VALUES (5,90);
INSERT INTO "LOTS_ARTICLES" (lot_article_lot_id,lot_article_article_id) VALUES (5,91);
INSERT INTO "LOTS_ARTICLES" (lot_article_lot_id,lot_article_article_id) VALUES (5,92);
INSERT INTO "LOTS_ARTICLES" (lot_article_lot_id,lot_article_article_id) VALUES (5,93);
INSERT INTO "LOTS_ARTICLES" (lot_article_lot_id,lot_article_article_id) VALUES (5,94);
INSERT INTO "LOTS_ARTICLES" (lot_article_lot_id,lot_article_article_id) VALUES (5,95);
INSERT INTO "LOTS_ARTICLES" (lot_article_lot_id,lot_article_article_id) VALUES (6,96);
INSERT INTO "LOTS_ARTICLES" (lot_article_lot_id,lot_article_article_id) VALUES (7,97);
INSERT INTO "LOTS_ARTICLES" (lot_article_lot_id,lot_article_article_id) VALUES (7,98);
INSERT INTO "LOTS_ARTICLES" (lot_article_lot_id,lot_article_article_id) VALUES (7,99);
INSERT INTO "LOTS_ARTICLES" (lot_article_lot_id,lot_article_article_id) VALUES (7,100);

INSERT INTO TAGS (tag_article_id, tag_article_coupled) VALUES (1, 8);
INSERT INTO TAGS (tag_article_id, tag_article_coupled) VALUES (1, 9);
INSERT INTO TAGS (tag_article_id, tag_article_coupled) VALUES (1, 10);
INSERT INTO TAGS (tag_article_id, tag_article_coupled) VALUES (1, 11);
INSERT INTO TAGS (tag_article_id, tag_article_coupled) VALUES (1, 12);
INSERT INTO TAGS (tag_article_id, tag_article_coupled) VALUES (2, 13);
INSERT INTO TAGS (tag_article_id, tag_article_coupled) VALUES (2, 14);
INSERT INTO TAGS (tag_article_id, tag_article_coupled) VALUES (2, 15);
INSERT INTO TAGS (tag_article_id, tag_article_coupled) VALUES (3, 16);
INSERT INTO TAGS (tag_article_id, tag_article_coupled) VALUES (3, 17);
INSERT INTO TAGS (tag_article_id, tag_article_coupled) VALUES (3, 18);
INSERT INTO TAGS (tag_article_id, tag_article_coupled) VALUES (3, 19);
INSERT INTO TAGS (tag_article_id, tag_article_coupled) VALUES (3, 20);
INSERT INTO TAGS (tag_article_id, tag_article_coupled) VALUES (3, 21);
INSERT INTO TAGS (tag_article_id, tag_article_coupled) VALUES (4, 22);
INSERT INTO TAGS (tag_article_id, tag_article_coupled) VALUES (4, 23);
INSERT INTO TAGS (tag_article_id, tag_article_coupled) VALUES (4, 24);
INSERT INTO TAGS (tag_article_id, tag_article_coupled) VALUES (5, 25);
INSERT INTO TAGS (tag_article_id, tag_article_coupled) VALUES (6, 26);
INSERT INTO TAGS (tag_article_id, tag_article_coupled) VALUES (7, 27);
-- Check constraint 
INSERT INTO TAGS (tag_article_id, tag_article_coupled) VALUES (7, 7);


------------------------------------------------------------------------------------------------------------------------
--- BASKETS RELATED
------------------------------------------------------------------------------------------------------------------------

INSERT INTO BASKETS VALUES ();
INSERT INTO BASKETS VALUES ();
INSERT INTO BASKETS VALUES ();
INSERT INTO BASKETS VALUES ();

INSERT INTO BASKET_LOTS (basket_lot_basket_id, basket_lot_lot_id) VALUES (1, 1);
INSERT INTO BASKET_LOTS (basket_lot_basket_id, basket_lot_lot_id) VALUES (1, 2);
INSERT INTO BASKET_LOTS (basket_lot_basket_id, basket_lot_lot_id) VALUES (1, 3);
INSERT INTO BASKET_LOTS (basket_lot_basket_id, basket_lot_lot_id) VALUES (2, 4);
INSERT INTO BASKET_LOTS (basket_lot_basket_id, basket_lot_lot_id) VALUES (2, 5);
INSERT INTO BASKET_LOTS (basket_lot_basket_id, basket_lot_lot_id) VALUES (3, 6);
INSERT INTO BASKET_LOTS (basket_lot_basket_id, basket_lot_lot_id) VALUES (4, 7);

------------------------------------------------------------------------------------------------------------------------
--- TRANSACTION RELATED
------------------------------------------------------------------------------------------------------------------------
INSERT INTO ORDERS (order_user_id, order_basket_id) VALUES (1, 4);
