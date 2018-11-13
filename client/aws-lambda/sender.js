const amqp = require('amqplib/callback_api');

module.exports = {
    sendEvent: (event) => {
        amqp.connect('amqp://localhost', function(err, conn) {
            conn.createChannel(function(err, ch) {
                const q = 'arraySort';

                ch.assertQueue(q, {durable: false});
                ch.sendToQueue(q, Buffer.from(event));
                console.log(" [x] Sent %s", event);
            });
            setTimeout(() => conn.close(), 500);
        });
    }
};

