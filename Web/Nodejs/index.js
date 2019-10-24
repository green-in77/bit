const {odd, even} = require('./var'); //var 모듈 참조
const checkNumber = require('./func'); //func 모듈 참조
//checkOddOrEven 함수는 checkNumber로 변경해서 참조할 수 있음

function checkStringOddOrEven(str) {
    if(str.length % 2) { //홀수면
        return odd;
    }
    return even;
}

console.log(checkNumber(10)); //checkOddOrEven(10) 사용
console.log(checkStringOddOrEven('hello'));
