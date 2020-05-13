var express = require('express') //모듈s에서 파일을 가져오는 것
var app = express() // express라는 함수를 실행하는 것. 세미콜론 생략
var router = express.Router();

router.get('/', function(req, res){
    req.logout();
    res.redirect('/login');
})

module.exports = router