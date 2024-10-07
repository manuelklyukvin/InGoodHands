const mysql = require('mysql2');

const host = 'localhost';
const user = 'server';
const password = 'IGH_Server_Password';
const database = 'in_good_hands';

const connection = mysql.createConnection({
    host: host,
    user: user,
    password: password,
    database: database
});

module.exports = connection;