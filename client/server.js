const express = require('express');
const path = require('path');
const bodyParser = require('body-parser');
const https = require('https');
const http = require('http');
const fs = require('fs');
const logger = require('morgan');
const helmet = require('helmet');

require('dotenv').config({ path: path.join(__dirname, '/env/.env') });

const key = fs.readFileSync(path.join(__dirname, '/../encryption/vklochkov.key'));
const cert = fs.readFileSync(path.join(__dirname, '/../encryption/vklochkov.crt' ));

const options = { key, cert };

const app = express();
const router = express.Router();

const environment = process.env.NODE_ENV;

const route = require('./server/route/index.js');

app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: false }));
app.use(express.static(path.join(__dirname, 'dist/SellMeGood')));
app.use(helmet());

if (environment !== 'production') {
    app.use(logger('dev'));
}

app.use(function(req, res, next) {
    if (req.secure) {
        next();
    } else {
        res.redirect('https://' + req.headers.host + req.url);
    }
});

app.use('/api', route(router));

app.get('*', (req, res) => {
    res.sendFile(path.join(__dirname, 'dist/SellMeGood/index.html'));
});

const port = process.env.PORT || '80';
app.set('port', port);

http.createServer(app).listen(port, () => console.log(`API is running on localhost:${port}`));
https.createServer(options, app).listen(443);
