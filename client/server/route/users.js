const controller = require('../controller/users');
const validateToken = require('../util').validateToken;

module.exports = (router) => {
    router.route('/users')
        .post(controller.add)
        .get(validateToken, controller.getAll);

    router.route('/login')
        .post(controller.login);
};