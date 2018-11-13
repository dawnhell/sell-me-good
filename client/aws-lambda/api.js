const request = require('request');

module.exports = {
    sortArray: array =>
        request(`https://6x9r6079e2.execute-api.us-east-2.amazonaws.com/default/sortArrayLambda?array=[${array.toString()}]`, (error, response, body) => {
            console.log("Sorted array: ", body);
        })
};
