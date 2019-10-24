const string = 'abc';
const number = 1;
const boolean = true;
const obj = {
    outside: {
        inside : {
            key: 'value',
        },
    },
};

console.time('전체시간'); // console.time(레이블) : 같은 레이블을 가진 time 과 timeEnd 사이의 시간 측정
console.log('평범한 로그입니다 쉼표로 구분해 여러 값을 찍을 수 있습니다'); // 일반 로그 콘솔 표시
console.log(string, number, boolean);
console.error('에러 메시지는 console.error에 담아주세요.'); //에러를 콘솔에 표시

console.dir(obj, {colors : false, depth : 2}); //console.dir(객체, 옵션) : 객체를 콘솔에 표시할때 사용
console.dir(obj, {colors : true, depth : 1}); // colors 를 true로 하면 콘솔에 색이 추가됨, depth는 객체의 몇 단계까지 보여줄것인지(기본 2)

console.time('시간 측정');
for(let i = 0; i < 100000; i++){
    continue;    
}
console.timeEnd('시간 측정');

function b() {
    console.trace('에러 위치 추적'); //에러발생구간 추적
}

function a() {
    b();
}

a();

console.timeEnd('전체 시간');