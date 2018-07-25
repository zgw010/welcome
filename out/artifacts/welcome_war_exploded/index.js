const signIn = document.querySelector('.sign-in'); //登录按钮
const signInput = document.querySelector('.signInput'); //登录窗口
const signInputCancel = document.querySelector('.signInputCancel'); //登录窗口的取消按钮
const search = document.querySelector('.search'); //查询按钮
const signInputSucces = document.querySelector('.signInputSucces'); //登录窗口的登录按钮
const searchInput = document.querySelector('.searchInput') //查询的输入文本框
const loginspan = document.querySelector('.loginspan') //查询的输入文本框
const searchSubmit = document.querySelector('.searchSubmit') //查询的隐藏提交按钮
const signSubmit = document.querySelector('.signSubmit') //登录的隐藏提交按钮
const searchInputSubmit = document.querySelector('.searchInputSubmit') //查询按钮

let opacity = 0;

signIn.addEventListener('click', function () {
  signInput.style.top = 200 + 'px';
})
signInputCancel.addEventListener('click', function () {
  signInput.style.top = -200 + 'px';
})
searchInputSubmit.addEventListener('click', function () {
  searchSubmit.click();
})
signInputSucces.addEventListener('click', function () {
  signSubmit.click();
})
search.addEventListener('click', function () {
  if (opacity === 0) {
    loginspan.innerHTML = "取消查询"
  } else {
    loginspan.innerHTML = "录取查询"
  }
  searchInput.style.opacity = 1 - opacity;
  opacity = 1 - opacity;
})