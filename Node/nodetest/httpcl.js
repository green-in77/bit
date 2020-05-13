//클라이언트

const http = require('http'); //http 모듈 로드

var options = {
    host : "127.0.0.1",
    port : 8000,
    path : "/"
};

var req = http.request(options, (res) => {
    var data = "";
    res.on('data', (chunk) => {
        data += chunk; //수신된 데이터를 합침
    });

    res.on('end', () => {
        console.log(data);//데이터 수신 완료
    });
});

req.end();