let i = 1;
setInterval(() => {
    if( i === 5 ){
        console.log('종료!');
        process.exit();
    }
    console.log(i);
    i += 1;
},1000); //1초마다 실행
//i가 1씩 증가 -> 5가 되면 종료