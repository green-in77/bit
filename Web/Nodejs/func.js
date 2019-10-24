const {odd, even} = require('./var');
//require함수 : 모듈의 경로를 parameter 값을 가져옴 (확장자 생략가능)

function checkOddOrEven(num){
    if(num % 2) { //홀수면
        return odd;
    }
    return even; //짝수면
}

module.exports = checkOddOrEven;