const express = require('express');

const router = express.Router();

const executeQuery = require('../utils/execute_query');

router.get('/posts', (request, response) => {
    const postCount = request.query.postCount
    const pageNumber = request.query.pageNumber
    const offset = (postCount - 1) * pageNumber

    const query = `
        SELECT post.id, post_image.image_url, post.title, category.name AS category, city.name as city
        FROM post 
        JOIN post_image ON post.id = post_image.post_id
        JOIN category ON post.category_id = category.id
        JOIN address ON post.address_id = address.id
        JOIN city ON address.city_id = city.id
        ORDER BY post.id DESC 
        LIMIT ${postCount} OFFSET ${offset};
    `;
    executeQuery(query, null, response);
});

module.exports = router;