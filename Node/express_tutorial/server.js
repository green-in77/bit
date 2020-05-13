var express = require('express');
var app = express();
var bodyParser = require('body-parser'); // Post 데이터 처리
var session = require('express-session'); // 세션 관리
var fs = require("fs")

app.set('views', __dirname + '/views');
app.set('view engine', 'ejs');
app.engine('html', require('ejs').renderFile);


var server = app.listen(3000, function(){
 console.log("Express server has started on port 3000")
});

app.use(express.static('public'));

app.use(bodyParser.json()); // JOSN 으로 데이터 변환
app.use(bodyParser.urlencoded());

app.use(session({ //현재 session 사용하지 않음 //restFull 특징은 session 이 없는 것
 secret: '@#@$MYSIGN#@$#$',
 resave: false,
 saveUninitialized: true
}));


var router = require('./router/main')(app, fs); //uri를 타고 들어올 시 어떤 파일로 가야하는지 연결해줌.