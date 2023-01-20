insert into mo_bank(name, image) values('Carteira', null);
insert into mo_bank(name, image) values('Santander', null);
insert into mo_bank(name, image) values('Nubank', null);
insert into mo_user(username, password, name) values('admin', '$2a$10$ctw/uA0Ma5oqRoAWCeN.GOM/6PcFe3xT9wvZbqC7wU.rnHva9Ibaa', 'Admin');
insert into mo_account(color, name, bank_id, user_id, balance, type) values('GREEN','Carteira', 1, 1, 0.0, 'CARTEIRA');
insert into mo_account(color, name, bank_id, user_id, balance, type) values('RED','Santanter', 2, 1, -150.5, 'CONTA_CORRENTE');
insert into mo_account(color, name, bank_id, user_id, balance, type) values('PURPLE','NuConta', 3, 1, 179, 'CONTA_CORRENTE');