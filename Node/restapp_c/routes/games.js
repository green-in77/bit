// var async = require("async");
var express = require('express')
var mysql = require("mysql");
var router = express.Router();
var config = require("./config"); // config.js

var pool = mysql.createPool({
    // config.js에 있는 정보를 바탕으로 연결
    host: config.mysql.host,
    port: config.mysql.port,
    user: config.mysql.username,
    password: config.mysql.password,
    database: config.mysql.db,
    connectionLimit: 20,
    waitForConnections: false
});

// >>POST
router.post("/", function (req, res) {
    var result = {};
    var title = mysql.escape(req.body.title);
    //console.log(req.body);

    if (title == undefined) {
        result = returnResult(new Error("Title is empty"), res);
    } else {
        pool.getConnection(function (err, conn) {
            var sql = "INSERT INTO myGames (title) VALUES (" + title + ");";
            console.log("SQL: " + sql);

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

router.get("/", function (req, res) {
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

router.get("/:id", function (req, res) {
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

router.put("/:id", function (req, res) {
    var result = {};
    var id = null;
    var title = null;

    id = req.params.id;
    title = mysql.escape(req.body.title);

    console.log(id);
    console.log(req.body);
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

router.delete("/:id", function (req, res) {
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

module.exports = router;