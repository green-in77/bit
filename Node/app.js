var express = require('express') //모듈s에서 파일을 가져오는 것
var app = express() // express라는 함수를 실행하는 것. 세미콜론 생략
var bodyParser = require('body-parser')

var passport = require('passport')
var LocalStrategy = require('passport-local').Strategy
var session = require('express-session')
var flash = require('connect-flash')

// var mysql = require('mysql')

var router = require('./router/index') //.js 생략가능
// var main = require('./router/main') //.js 생략가능
// var email = require('./router/email') //.js 생략가능


// var connection = mysql.createConnection({
//     host : 'localhost',
//     port : 3306,
//     user : 'user',
//     password : '1004',
//     database : 'node'
// })

// connection.connect();

app.listen(3000, function(){
    console.log("start! express server on port 3000");
}); //listen 3000port 로 함수를 실행시켜 주는 것

//http://127.0.0.1:3000/
//(localhost) 서버 실행

//static 폴더 설정
app.use(express.static('public'))
app.use(bodyParser.json())
app.use(bodyParser.urlencoded({extended:true}))
app.set('view engine', 'ejs')

//nodemon 사용 : js 파일 수정 시 수동으로 실행시키지 않아도 자동 재시작

// app.get('/',function(req,res){
//     res.sendFile(__dirname + "/public/main.html");
//     //__dirname : 현재 절대경로 표현
// });

//main 경로로 접속 시 
// app.get('/main',function(req,res){
//     res.sendFile(__dirname + "/public/main.html");
//     //__dirname : 현재 절대경로 표현
// });

app.use(session({
  secret: 'keyboard cat',
  resave: false,
  saveUninitialized: true
}))
app.use(passport.initialize())
app.use(passport.session())
app.use(flash())

app.use(router)
// app.use('/main', main)
// app.use('/email', email)

// app.post('/email_post',function(req,res){
//     //get : req.param('email)'"
//     //post : body-parser 사용
//     console.log(req.body.email)//form 에서 전송된 값을 server에서 받는다.
//     //res.send("<h1>welcome " + req.body.email + "</h1>")
//     res.render('email.ejs', {'email' : req.body.email})
// });

// app.post('/ajax_send_email',function(req, res){
//     console.log(req.body.email)
//     //check validation  => select DB
//     //var responseData = {'result' : 'ok', 'email' : req.body.email};
//     var email = req.body.email;
//     var responseData = {};

//     var query = connection.query('select name from user where email="'+email+'"', function(err, rows){
//         if(err) throw err;
//         if(rows[0]) {
//             console.log(rows[0].name);
//             responseData.result = "ok";
//             responseData.name = rows[0].name;
//         }else {
//             console.log('none : ' + rows[0] )
//             responseData.result = "none";
//             responseData.name = "";
//         }
//         res.json(responseData);
//     })
    
// });