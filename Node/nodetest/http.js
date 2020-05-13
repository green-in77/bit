//서버
const http = require('http'); //http 모듈 로드


var server = http.createServer((req, res) => {
    res.end("hello world"); //response 를 hello world 를 한다.
});

server.listen(8000); //8000번 포트 계속 보고있다.