const os = require('os');

console.log('운영체제 정보-------------------------------------------');
console.log('os.arch():', os.arch()); //process.arch 와 동일 : x64
console.log('os.platform():', os.platform()); //process.platform 동일 : win32
console.log('os.type() : ', os.type()); //운영체제의 종류 : windows_NT
console.log('os.uptime() : ', os.uptime());
console.log('os.hostname() : ', os.hostname());
console.log('os.release() : ', os.release());

console.log('경로-------------------------------------------');
console.log('os.homedir() : ' , os.homedir());
console.log('os.tmpdir() : ', os.tmpdir());

console.log('cpu 정보-------------------------------------------');
console.log('os.cpus() : ', os.cpus());
console.log('os.cpus().length : ', os.cpus().length);

console.log('메모리 정보-------------------------------------------');
console.log('os.freemem() : ', os.freemem());
console.log('os.totalmem() : ', os.totalmem());