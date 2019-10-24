const A = require('./globalA');
// A에 globalA 참조해서 할당

global.message = '안녕하세요';
console.log(A());
//A의 ()함수 호출
//() => global.message;
//안녕하세요 출력