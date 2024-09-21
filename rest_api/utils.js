const databaseConnection = require('./db');

function executeQuery(query, params, response) {
    databaseConnection.query(query, params, (error, results) => {
        if (error) {
            console.error('Query error:', error);
            response.status(500).send('Server error');
            return;
        }

        if (results.length === 0) {
            response.status(404).send('No data found');
            return;
        }

        response.json(results);
    });
}

module.exports = executeQuery;