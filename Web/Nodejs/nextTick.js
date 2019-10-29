setImmediate(() => {
    console.log('immediate');
});

process.nextTick(() => { //이벤트 루프가 다른 콜백함수보다 nextTick을 우선으로 처리하게 만듬 1.
    console.log('nextTick');
});

setTimeout(() => {
    console.log('timeout');
},0);

Promise.resolve().then(() => console.log('promise')); // 다른 콜백들 보다 우선실행 2.
