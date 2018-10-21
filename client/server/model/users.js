const mongoose = require('mongoose');
const bcrypt = require('bcrypt');

const saltingRounds = process.env.SALTING_ROUNDS;

const Schema = mongoose.Schema;

const userSchema = new Schema({
    email: {
        type: 'String',
        required: true,
        trim: true,
        unique: true
    },
    password: {
        type: 'String',
        required: true,
        trim: true
    }
});

userSchema.pre('save', function(next) {
    const user = this;
    bcrypt.hash(user.password, parseInt(saltingRounds), (err, hash) => {
        if (err) {
            console.log('Error hashing password for user', user.email);
            next(err);
        } else {
            user.password = hash;
            next();
        }
    });
});

module.exports = mongoose.model('User', userSchema);
