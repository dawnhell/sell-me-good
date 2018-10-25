const mongoose = require('mongoose');
const bcrypt = require('bcrypt');
const jwt = require('jsonwebtoken');

const User = require('../model/users');

const connUri = process.env.MONGO_LOCAL_CONN_URL;

module.exports = {
    add: (req, res) => {
        mongoose.connect(connUri, { useNewUrlParser : true }, async (err) => {
            let result = {};
            let status = 201;
            if (!err) {
                const { email, password } = req.body;
                let userExists = await mongoose.model('User').countDocuments({ email }, (err, count) => count);

                console.log('controller', userExists);
                if (userExists) {
                    status = 409;
                    result.status = 'User already exists.';
                    console.log('user exists', result);
                    res.status(status).json(result);
                } else {
                    const user = new User({ email, password });
                    console.log('user not exists', email);
                    // TODO: We can hash the password here before we insert instead of in the model
                    user.save((err, user) => {
                        console.log('controller here', err, user);
                        if (!err) {
                            result.status = status;
                            result.result = user;
                        } else {
                            status = 500;
                            result.status = status;
                            result.error = err;
                        }
                        res.status(status).json(result);
                    });
                }
            } else {
                console.log('cant connect to Mongo');
                status = 500;
                result.status = status;
                result.error = err;
                res.status(status).json(result);
            }
        });
    },

    login: (req, res) => {
        const { email, password } = req.body;

        mongoose.connect(connUri, { useNewUrlParser: true }, (err) => {
            let result = {};
            let status = 200;
            if(!err) {
                User.findOne({ email }, (err, user) => {
                    if (!err && user) {
                        // We could compare passwords in our model instead of below as well
                        bcrypt.compare(password, user.password).then(match => {
                            if (match) {
                                status = 200;
                                // Create a token
                                const payload = { user: user.email };
                                const options = { expiresIn: '1d', issuer: 'https://sell-me-good.io' };
                                const secret = process.env.JWT_SECRET;
                                const token = jwt.sign(payload, secret, options);

                                result.token = token;
                                result.status = status;
                                result.result = user.email;
                            } else {
                                status = 401;
                                result.status = status;
                                result.error = `Authentication error`;
                            }
                            res.status(status).send(result);
                        }).catch(err => {
                            status = 500;
                            result.status = status;
                            result.error = err;
                            res.status(status).send(result);
                        });
                    } else {
                        status = 404;
                        result.status = status;
                        result.error = err;
                        res.status(status).send(result);
                    }
                });
            } else {
                status = 500;
                result.status = status;
                result.error = err;
                res.status(status).send(result);
            }
        });
    },

    getAll: (req, res) => {
        mongoose.connect(connUri, { useNewUrlParser: true }, (err) => {
            let result = {};
            let status = 200;
            if (!err) {
                const payload = req.decoded;
                if (payload && payload.user === 'admin') {
                    User.find({}, (err, users) => {
                        if (!err) {
                            result.status = status;
                            result.error = err;
                            result.result = users;
                        } else {
                            status = 500;
                            result.status = status;
                            result.error = err;
                        }
                        res.status(status).send(result);
                    });
                } else {
                    status = 401;
                    result.status = status;
                    result.error = `Authentication error`;
                    res.status(status).send(result);
                }
            } else {
                status = 500;
                result.status = status;
                result.error = err;
                res.status(status).send(result);
            }
        });
    }
};
