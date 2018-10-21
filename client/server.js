const express = require('express');
const path = require('path');
const bodyParser = require('body-parser');
const https = require('https');
const http = require('http');
const fs = require('fs');

const key = fs.readFileSync(path.join(__dirname, '/../encryption/vklochkov.key'));
const cert = fs.readFileSync(path.join(__dirname, '/../encryption/vklochkov.crt' ));

const app = express();

const options = { key, cert };

app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: false }));
app.use(express.static(path.join(__dirname, 'dist/SellMeGood')));

app.use(function(req, res, next) {
    if (req.secure) {
        next();
    } else {
        res.redirect('https://' + req.headers.host + req.url);
    }
});

app.get('*', (req, res) => {
    res.sendFile(path.join(__dirname, 'dist/SellMeGood/index.html'));
});

const port = process.env.PORT || '80';
app.set('port', port);

https.createServer(options, app).listen(443);
http.createServer(app).listen(port, () => console.log(`API is running on localhost:${port}`));
