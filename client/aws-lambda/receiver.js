const amqp = require('amqplib/callback_api');
const api = require('./api');

const receiveEvent = () => {
    amqp.connect('amqp://localhost', function(err, conn) {
        conn.createChannel(function(err, ch) {
            const q = 'arraySort';

            ch.assertQueue(q, {durable: false});
            console.log(" [*] Waiting for messages in %s. To exit press CTRL+C", q);
            ch.consume(q, function(msg) {
                console.log(" [x] Received %s", Array.prototype.slice.call(msg.content, 0));
                api.sortArray(Array.prototype.slice.call(msg.content, 0));
            }, {noAck: true});
        });
    });
};

receiveEvent();
