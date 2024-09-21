const express = require('express');
const router = express.Router();

const executeQuery = require('../utils');

router.get('/posts', (_, response) => {
    const query = `
        SELECT post.id, post.title, category.name AS category, address.city 
        FROM post 
        JOIN category ON post.category_id = category.id
        JOIN address ON post.address_id = address.id
        ORDER BY post.id DESC 
        LIMIT 10;
    `;
    executeQuery(query, null, response);
});

router.get('/:id', (request, response) => {
    const id = request.params.id;
    const query = 'SELECT * FROM post WHERE id = ?;';
    executeQuery(query, id, response);
});

module.exports = router;