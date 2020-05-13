var express = require('express') //모듈s에서 파일을 가져오는 것
var app = express() // express라는 함수를 실행하는 것. 세미콜론 생략
var router = express.Router();
var path = require('path');
var mysql = require('mysql')
var passport = require('passport')
var LocalStrategy = require('passport-local').Strategy


var connection = mysql.createConnection({
    host : 'localhost',
    port : 3306,
    user : 'user',
    password : '1004',
    database : 'node'
})

connection.connect();

// /join 으로 get 요청이 들어왔을 때
router.get('/', function(req,res) {
	var msg;
	var errMsg = req.flash('error')
    if(errMsg) msg = errMsg;
    //res.sendfile(path.join(__dirname,'../../public/join.html'))
	res.render('join.ejs', {'message' : msg});
})

passport.serializeUser(function(user, done){
    console.log('passport session save : ', user.id)
    done(null, user.id) //sessuib id뽑아서 페이지에 전달?
})

passport.deserializeUser(function(id, done){
    console.log('session user id : ', id)
    done(null, id);
})

passport.use('local-join', new LocalStrategy({
    usernameField: 'email',
  passwordField: 'password',
  passReqToCallback : true
}, function(req, email, password, done) {
    var query = connection.query('select * from user where email=?', [email], function(err,rows) {
        if(err) return done(err);

        if(rows.length) {
            console.log('existed user')
            return done(null, false, {message : 'your email is already used'})
        } else {
            var sql = {email: email, pw:password};
            var query = connection.query('insert into user set ?', sql, function(err,rows) {
                if(err) throw err
                return done(null, {'email' : email, 'id' : rows.insertId});
            })

        }
    })
}
));

router.post('/', passport.authenticate('local-join', {
    successRedirect: '/main',
    failureRedirect: '/join',
    failureFlash: true })
)


// router.post('/',function(req,res){
//    var body = req.body;
//    var email = body.email;
//    var name = body.name;
//    var passwd = body.password;
//     var sql = {email : email, name : name, pw : passwd};

//    //var query = connection.query('insert into user (email, name, pw) values ("' + email +'","' + name + '","' + passwd + '")', function(err,rows){
//     var query = connection.query('insert into user set ?', sql, function(err,rows){
//         if(err) throw err
//         //console.log("ok Db insert", rows.insertId, name);
//         else res.render('welcome.ejs', {'name':name, 'id':rows.insertId})
//    });
// });

module.exports = router;