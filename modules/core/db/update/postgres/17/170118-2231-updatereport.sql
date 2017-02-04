

insert into adclient_report(id, version, create_ts, created_by, name, description)
VALUES (newid(), 1, now(), 'admin', 'Членство пользователей в группах', '');
insert into adclient_report(id, version, create_ts, created_by, name, description)
VALUES (newid(), 1, now(), 'admin', 'Доступ к ресурсам', '');
insert into adclient_report(id, version, create_ts, created_by, name, description)
VALUES (newid(), 1, now(), 'admin', 'Учет ресурсов', '');
insert into adclient_report(id, version, create_ts, created_by, name, description)
VALUES (newid(), 1, now(), 'admin', 'Перечень пользователей',
        'Перечень пользователей с указанием окончания срока действия пароля');
insert into adclient_report(id, version, create_ts, created_by, name, description)
VALUES (newid(), 1, now(), 'admin', 'Перечень групп',
        'Перечень групп с назначенными им правами доступа');
insert into adclient_report(id, version, create_ts, created_by, name, description)
VALUES (newid(), 1, now(), 'admin', 'Перечень устаревших учетных записей пользователей', '');
insert into adclient_report(id, version, create_ts, created_by, name, description)
VALUES (newid(), 1, now(), 'admin', 'Активность учетных записей пользователей', '');