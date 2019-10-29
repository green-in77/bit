const timeout = setTimeout(() => { //주어진 시간 후 콜백함수 실행
    console.log('1.5초 후 실행'); //3번으로 실행
}, 1500);

const interval = setInterval(() => { //주어진 시간마다 콜백함수 반복실행
    console.log('1초마다 실행'); //2번으로 실행, 4번으로 실행
}, 1000);

const timeout2 = setTimeout(() => {
    console.log('실행되지 않습니다.');
}, 3000);

setTimeout(() => {//5번으로 실행 모두 취소했으므로 2는 실행되지않고 인터벌은 멈춤
    clearTimeout(timeout2); //취소 
    clearInterval(interval); //취소
}, 2500);

const immediate = setImmediate(() => { //1번으로 실행
    console.log('즉시 실행');
});

const immediate2 = setImmediate(() => { //아래에서 바로 취소했기 때문에 실행되지 않음.
    console.log('실행되지 않습니다.');
});

clearImmediate(immediate2); //취소