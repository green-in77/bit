var express = require('express') //모듈s에서 파일을 가져오는 것
var app = express() // express라는 함수를 실행하는 것. 세미콜론 생략
var router = express.Router();
var path = require('path');
var mysql = require('mysql')

var connection = mysql.createConnection({
    host : 'localhost',
    port : 3306,
    user : 'user',
    password : '1004',
    database : 'node'
})

connection.connect();


router.post('/form',function(req,res){
    //get : req.param('email)'"
    //post : body-parser 사용
    console.log(req.body.email)//form 에서 전송된 값을 server에서 받는다.
    //res.send("<h1>welcome " + req.body.email + "</h1>")
    res.render('email.ejs', {'email' : req.body.email})
});

router.post('/ajax',function(req, res){
    console.log(req.body.email)
    //check validation  => select DB
    //var responseData = {'result' : 'ok', 'email' : req.body.email};
    var email = req.body.email;
    var responseData = {};

    var query = connection.query('select name from user where email="'+email+'"', function(err, rows){
        if(err) throw err;
        if(rows[0]) {
            console.log(rows[0].name);
            responseData.result = "ok";
            responseData.name = rows[0].name;
        }else {
            console.log('none : ' + rows[0] )
            responseData.result = "none";
            responseData.name = "";
        }
        res.json(responseData);
    })
    
});

module.exports = router;