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

// /login 으로 get 요청이 들어왔을 때
router.get('/', function(req,res) {
	var msg;
	var errMsg = req.flash('error')
    if(errMsg) msg = errMsg;
    //res.sendfile(path.join(__dirname,'../../public/join.html'))
	res.render('login.ejs', {'message' : msg});
})

//passport.serialize
passport.serializeUser(function(user, done) {
    console.log(user);
	console.log('passport session save : ', user.id)
  done(null, user.id)
});

passport.deserializeUser(function(id, done) {
	console.log('passport session get id: ', id)
	done(null, id);
})

passport.use('local-login', new LocalStrategy({
    usernameField: 'email',
  passwordField: 'password',
  passReqToCallback : true
}, function(req, email, password, done) {
    
    var query = connection.query('select * from user where email=?', [email], function(err,rows) {
        if(err) return done(err);

        if(rows.length) {
            return done(null, {'email' : email, 'id' : rows[0].uid})
        } else {
                return done(null, false, {'message' : 'Incorrect email or password'})
        }
    })
}
));

router.post('/', function(req, res, next) {
	passport.authenticate('local-login', function(err, user, info) {
		if(err) res.status(500).json(err);
		if (!user) return res.status(401).json(info.message);

		req.logIn(user, function(err) {
            if (err) { return next(err); }
            return res.json(user);
        });

	})(req, res, next);
})

module.exports = router;