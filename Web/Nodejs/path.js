const path = require('path');

const String = __filename;

console.log('path.sep : ' , path.sep); //구분자 \
console.log('path.delimiter : ', path.delimiter); //환경변수 구분자 ;
console.log('-------------------------------------------');

console.log('path.dirname() : ', path.dirname(String)); //폴더경로
console.log('path.extname() : ', path.extname(String)); //확장자
console.log('path.basename() : ', path.basename(String)); //파일이름
console.log('path.basename() : ', path.basename(String, path.extname(String))); //확장자 제외하고 보고싶을때
console.log('-------------------------------------------');

console.log('path.parse() : ', path.parse(String)); //파일경로구분 root, dir, base, ext, name
console.log('path.format() : ', path.format({ //parse 한 객체를 파일경로로 합침
    dir : 'C:\\users\\zorocho',
    name : 'path',
    ext : '.js',
}));
console.log('path.normalize() : ', path.normalize('C://users\\\\zorocho\\\path.js')); // \, / 사용실수 시 정상경로로 변환해줌
console.log('-------------------------------------------');

console.log('path.inAbsolute() : ', path.isAbsolute('C:\\')); // 절대인지 상대인지 t / f 반환
console.log('path.inAbsolute() : ', path.isAbsolute('./home')); 
console.log('-------------------------------------------');

console.log('path.relative() : ', path.relative('C:\\users\\zerosho\\path.js', 'C:\\')); // 첫번째 경로에서 두번째 경로로 가는 방법
console.log('path.join() : ', path.join(__dirname, '..','/users','.', '/zerocho')); // 하나의 경로로 합쳐줌(부모,현위치 알아서 처리)
console.log('path.resolve() : ', path.resolve(__dirname, '..', 'users', '.', '/zorocho')) // /만나면 절대경로로 인식해서 앞의 경로 무시