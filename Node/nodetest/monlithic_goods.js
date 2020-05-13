const mysql = require('mysql')
const conn = {
    host : 'localhost',
    user : 'root',
    password : '1004',
    database : 'monolithic'
};

exports.onRequest = function(res, method, pathname, params, cb){
    switch (method) {
        case "POST" :
            return register(method, pathname, params, (response)=>{
                process.nextTick(cb, res, response); });

        case "GET" :
            return inquiry(method, pathname, params, (response)=>{
                process.nextTick(cb, res, response); });

        case "DELETE" :
            return unregister(method, pathname, params, (response)=>{
                process.nextTick(cb, res, response); });
        
        default:
            return process.nextTick(cb, res, null);
    }
}

function register(method, pathname, params, cb){
    var response = {
        errorcode: 0,
        errormessage : "success"
    };

    if(params.name == null || params.category == null || params.price == null || params.description == null){
        response.errorcode = 1;
        response.errormessage = "Invalid Parameters";
        cb(response);
    }else {
        console.log(params)

        var connection = mysql.createConnection(conn);

        connection.connect();        
        connection.query("insert into goods(name, category, price, description) values (?,?,?,?)"
        ,[params.name, params.category, params.price, params.description]
        , (error, results, fields) => {
            if(error){
                response.errorcode = 1;
                response.errormessage = error;
            }
            cb(response);
        });
        connection.end();
    }
}