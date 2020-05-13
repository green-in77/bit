var express = require('express') //모듈s에서 파일을 가져오는 것
var app = express() // express라는 함수를 실행하는 것. 세미콜론 생략
var router = express.Router();
var path = require('path');

var main = require('./main/main') //.js 생략가능
var email = require('./email/email') //.js 생략가능
var join = require('./join/index') //.js 생략가능
var login = require('./login/index') //.js 생략가능
var logout = require('./logout/index') //.js 생략가능

router.get('/',function(req,res){
    res.sendFile(path.join(__dirname, "../public/main.html"));
    //__dirname : 현재 절대경로 표현
});

router.use('/main', main)
router.use('/email', email)
router.use('/join', join)
router.use('/login', login)
router.use('/logout', logout)

module.exports = router;