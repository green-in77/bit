const http = require('http'); 
const url = require('url'); //모듈 로드
const querystring = require('querystring');

//const members = require('./monolithic_members.js');
const goods = require('./monlithic_goods.js');
//const purchases = require('./monolithic_purchases.js');

var server = http.createServer((req, res) => {
    var method = req.method; //메서드 얻어옴
    var uri = url.parse(req.url, true); 
    var pathname = uri.pathname; //uri 얻어옴

    if(method === "POST" || method === "PUT") {//data 가 head 에 달려서 나옴
        var body = "";
    
        req.on('data', (data) =>{
            body += data;
        })
    
        req.on('end', () => {
            var params;
            //헤더 정보가 json 이면
            if( req.headers['content-type'] == "application/json"){
                params = JSON.parse(body);
            }else {
                params = querystring.parse(body);
            }
            //get과 delete 면 query 정보를 읽음 //data 가 url 에 달려서 옴
            onRequest(res, method, pathname, params);
        })
    }
}).listen(8000);

function onRequest(res, method, pathname, params){
    switch(pathname) {
        case "/members":
            memvers.onRequest(res, method, pathname, params, response);
            break;
        case "/goods":
            goods.onRequest(res, method, pathname, params, response);
            break;
        case "/purchases":
            purchases.onRequest(res, method, pathname, params, response);
            break;
        default:
            res.writeHead(404);
            return res.end();
    }
    //res.end("response!"); //모든 요청에 "response!" 메시지를 보냄
}

function response(res, packet){
    res.writeHead(200, {'Content-Type':'application/json'});
    res.end(JSON.stringify(packet));
}