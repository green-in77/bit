// var async = require("async");
var mysql = require("mysql");

module.exports = (app, pool) => {
    // >>POST
    app.post("/games", function (req, res) {
        var result = {};
        var title = mysql.escape(req.body.title);

        if (title == undefined) {
            result = returnResult(new Error("Title is empty"), res);
        } else {
            pool.getConnection(function (err, conn) {
                var sql =  "INSERT INTO myGames (title) VALUES (" + title + ");";
                console.log("SQL: " + sql);


출처: https://jizard.tistory.com/97?category=681364 [GEUMSON]
                conn.query(sql, function (err) {
                    //console.log(sql);
                    result = returnResult(err, res);
                    conn.release();
                });
            });
        }
        result.status = res.statusCode;
        res.send(result);
    });

    app.get("/games", function (req, res) {
        var result = {};

        pool.getConnection(function (err, conn) {
            var sql = "select * from mygames;";
            conn.query(sql, function (err, rows) {
                var result = returnResult(err, res);
                if (rows) {
                    result.message = rows;
                }
                conn.release();
                result.statusCode = res.statusCode
                res.send(result);
            });
        });
    });

    app.get("/games/:id", function (req, res) {
        var result = {};
        var id = mysql.escape(req.params.id);

        pool.getConnection(function (err, conn) {
            var sql = "select * from mygames where id=" + id + ";";

            conn.query(sql, function (err, rows) {
                var result = returnResult(err, res);
                if (rows) {
                    result.message = rows;
                }
                conn.release();
                result.status = res.statusCode;
                res.send(result);
            });
        });
    });

    app.put("/games/:id", function (req, res) {
        var result = {};
        var id = null;
        var title = null;

        id = req.params.id;
        title = mysql.escape(req.body.title);

        // console.log(id);
        // console.log(req.body);
        // console.log(title);

        if (title == undefined) {
            result = returnResult(new Error("Title is empty"), res);
        } else {
            pool.getConnection(function (err, conn) {
                // console.log(conn);
                var sql = "UPDATE myGames SET title=" + title + " WHERE id=" + id + ";";
                conn.query(sql, function (err) {
                    result = returnResult(err, res);
                    conn.release();
                });
            });
        }
        result.status = res.statusCode;
        res.send(result);
    });

    app.delete("/games/:id", function (req, res) {
        var result = {};
        var id = req.params.id;
        console.log(id);

        if (id == undefined) {
            result = returnResult(new Error("Id is empty"), res);
        } else {
            pool.getConnection(function (err, conn) {
                var sql = "DELETE FROM myGames WHERE id=" + id + ";";

                conn.query(sql, function (err) {
                    result = returnResult(err, res);
                    conn.release();
                });
            });
        }
        result.status = res.statusCode;
        res.send(result);
    });
}


var returnResult = function (err, res) {
    // 결과를 눈으로 보기 쉽게하기 위해 result 객체 생성
    var result = {};
    if (err) {
        res.status(400);
        result.message = err.stack;
    } else {
        res.status(200);
        result.message = "Success";
    }
    return result;
}