insert into users (id, active, birthname, dateofbirth, firstname, ip_address, lastname, locale, locked, pw, salt, username, gender)
 values
 (1, '1', 'ROOT', '1970-01-01', 'ROOT', '0:0:0:0:0:0:0:1', 'ROOT', 'US', '0', '2F6E7FCB5EE172C379BCBB7A5098E17761B02E6AC49EECCC5AF689983DA6E8C0315B14E17B3277B11932C0290F7BFAD2732BB1ACC69AB9062B919A5C8B24044D504547B739347787C453A4B2DD314372A439AFF8CE590DF7B8D0C263FE05CB25673E77B68026DEC6BBDCEF40B569AD626122EC8B5001F0513104CBB0E558EEB1', 'HcR5JbNt', 'root','MALE');
 insert into user_roles(id, role_id, user_id)
 values
 (1, 1, 1),
 (2, 2, 1),
 (3, 3, 1);