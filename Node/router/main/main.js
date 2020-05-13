var express = require('express') //모듈s에서 파일을 가져오는 것
var app = express() // express라는 함수를 실행하는 것. 세미콜론 생략
var router = express.Router();
var path = require('path');

//session 이 있을때만 접근이 가능하도록 하자?
router.get('/',function(req,res){
    console.log('main js loaded', req.user)
    var id = req.user
    if(!id) res.render('login.ejs')
    res.render('main.ejs', {'id' : id});

    //res.sendFile(path.join(__dirname, "../../public/main.html"));
    //path 상대경로
    //__dirname : 현재 절대경로 표현
});


module.exports = router;