const sender = require('./sender');

const arrayToSort = [1,3,5,2,4,2,5,77,4,3,23];
const scheduleTimeout = 1000 * 15;

const scheduler = () => setInterval(() => sender.sendEvent(arrayToSort), scheduleTimeout);

scheduler();