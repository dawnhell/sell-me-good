const express = require('express');
const path = require('path');
const bodyParser = require('body-parser');
const http = require('http');

const app = express();

app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: false }));
console.log(__dirname);
app.use(express.static(path.join(__dirname, 'dist/SellMeGood')));



app.get('*', (req, res) => {
    res.sendFile(path.join(__dirname, 'dist/SellMeGood/index.html'));
});

const port = process.env.PORT || '3000';
app.set('port', port);

const server = http.createServer(app);

server.listen(port, () => console.log(`API is running on localhost:${port}`));
