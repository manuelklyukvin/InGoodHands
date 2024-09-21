const express = require('express');
const databaseConnection = require('./db');

const feedRoutes = require('./routes/feed');

const app = express();
const port = 3000;

app.use('/feed', feedRoutes);

app.listen(port, () => {
    console.log('The server is running on http://localhost:' + port);
});

app.get('/', (_, response) => {
    response.send('The server is running');
});

databaseConnection.connect((error) => {
    if (error) {
        console.error('Database connection error:', error);
        return;
    }
    console.log('Connection is successful');
});