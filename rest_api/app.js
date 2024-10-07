const express = require('express');

const app = express();
const port = 3000;

const connection = require('./db');

const feedRoutes = require('./routes/feed');

app.use('/images', express.static('images'));
app.use('/feed', feedRoutes);

app.listen(port, () => {
    console.log('The server is running on http://localhost:' + port);
});

app.get('/', (request, response) => {
    response.send('The server is running');
});

connection.connect((error) => {
    if (error) {
        console.error('Database connection error:', error);
        return;
    }
    console.log('Connection is successful');
});