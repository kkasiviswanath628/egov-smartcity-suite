INSERT INTO EG_ROLEACTION (ROLEID, ACTIONID) VALUES ((SELECT id FROM eg_role WHERE name LIKE 'CITIZEN'), (SELECT id FROM eg_action WHERE name ='getWardsByLocality'));