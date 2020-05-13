module.exports = function(app, fs)
{
    app.get('/', function(req,res){
        res.render('index', {
            title : "MY HOMEPAGE",
            length : 5
        });
    });

    //url은 파일경로
    app.get('/list', function(req, res){ //uri = 리소스로 접근했을때 어떤 데이터를 가져오는가
        fs.readFile(__dirname + "/../data/" + "user.json", 'utf8', function (err, data){
            //__dirname 은 현재 모듈의 위치
            console.log(data);
            res.end(data);
        });
    })

    app.get('/getUser/:username', function(req, res){ //:username username을 읽어서 처리 => 해당하는 것을 가져올 수 있게...
        fs.readFile( __dirname + "/../data/user.json", 'utf8', function (err, data) {
            var users = JSON.parse(data); 
            //readFile()로 읽으면 텍스트 형식이라 JSON.parse()를 해야한다.
            res.json(users[req.params.username]); //username 이 params 라는 배열안에 들어가있는 것.(정확하게는 MAP)
            //req.body & req.params 가 중요!!!! console.log로 확인해보는것이 좋다...
        });
    });
}