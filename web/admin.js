const authorityEdit = document.getElementsByClassName('authorityEdit');
const shouquanneirongA = document.querySelector(".shouquanneirongA");
const shouquanneirongB = document.querySelector(".shouquanneirongB");
const shouquantijiao = document.querySelector(".shouquantijiao");
const shouquanchuangkou = document.querySelector(".shouquanchuangkou");
const querenshouquan = document.querySelector(".querenshouquan");
const quxiaoshouquan = document.querySelector(".quxiaoshouquan");
const shouquanClose = document.querySelector(".shouquanClose");
const UESTC = document.querySelector(".UESTC");
const UESTCquanxian = document.querySelector('.UESTCquanxian');
UESTC.addEventListener('click', function () {
  UESTCquanxian.click();
})

for (let i = 0, len = authorityEdit.length; i < len; ++i) {
  authorityEdit[i].addEventListener('click', function () {
    shouquanchuangkou.style.display = 'block';
    document.querySelector(".allTeacherInfo").style.zIndex = -100000;
    document.querySelector(".quanxianName").innerText = authorityEdit[i].parentNode.previousElementSibling.innerText;
    document.querySelector(".quanxianQ").innerText = authorityEdit[i].parentNode.previousElementSibling.previousElementSibling.previousElementSibling.innerText;

    tmp = authorityEdit[i];
    console.log(authorityEdit[i]);


  });
}
shouquanClose.addEventListener("click", function () {

  document.querySelector(".allTeacherInfo").style.zIndex = 0;
  shouquanchuangkou.style.display = 'none';
})
querenshouquan.addEventListener('click', function () {
  // console.log(document.querySelector(".quanxianName"));
  // console.log();

  shouquanneirongB.value = 1;
  shouquanneirongA.value = document.querySelector(".quanxianQ").innerText;
  shouquantijiao.click();
})
quxiaoshouquan.addEventListener('click', function () {
  // conso    le.log(document.querySelector(".quanxianName"));
  // console.log();

  shouquanneirongB.value = 0;
  shouquanneirongA.value = document.querySelector(".quanxianQ").innerText;
  shouquantijiao.click();

})