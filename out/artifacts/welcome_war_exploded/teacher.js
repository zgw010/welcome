var $TABLE = $('#table');

$('.table-add').click(function () {
  var $clone = $TABLE
    .find('tr.hide')
    .clone(true)
    .removeClass('hide table-line');
  $TABLE
    .find('table')
    .append($clone);
});

$('.table-remove').click(function () {
  $(this)
    .parents('tr')
    .detach();
});

// A few jQuery helpers for exporting only
jQuery.fn.pop = [].pop;
jQuery.fn.shift = [].shift;

document.querySelector('.table')

//

const newStudentButton = document.querySelector('.newStudentButton');
const informationInput = document.querySelector('.informationInput')
const informationExamine = document.querySelector('.informationExamine')
const informationQuery = document.querySelector('.informationQuery')

const informationInputMenu = document.querySelector('.informationInputMenu')
const informationExamineMenu = document.querySelector('.informationExamineMenu')
const informationQueryMenu = document.querySelector('.informationQueryMenu')

const informationInputClose = document.querySelector('.informationInputClose')
const informationExamineClose = document.querySelector('.informationExamineClose')
const informationQueryClose = document.querySelector('.informationQueryClose')


// informationInput.style.top = (625 - informationInput.offsetHeight) / 2 + "px";
informationExamine.style.top = (625 - informationExamine.offsetHeight) / 2 + "px";
// informationQuery.style.top = (625 - informationQuery.offsetHeight) / 2 + "px";
newStudentButton.addEventListener('click', function () {
  $('.table-add').click();
  if (informationInput.offsetHeight <= 625) {
    informationInput.style.top = (625 - informationInput.offsetHeight) / 2 + "px";
  }
})
informationInputMenu.addEventListener('click', function () {

  informationExamine.style.display = 'none';
  informationQuery.style.display = 'none';
  informationInput.style.display = 'block';
  informationInput.style.opacity = 0;
  setTimeout(() => {
    informationInput.style.opacity = 1;

  }, 0);
});
informationInputClose.addEventListener('click', function () {

  informationInput.style.opacity = 0;
  setTimeout(() => {
    informationInput.style.display = 'none';
  }, 600);

});
informationExamineMenu.addEventListener('click', function () {
    document.querySelector(".informationExamineListSubmit").click();
  informationInput.style.display = 'none';
  informationQuery.style.display = 'none';
  informationExamine.style.display = 'block';
  informationExamine.style.opacity = 0;
  setTimeout(() => {
    informationExamine.style.opacity = 1;

  }, 0);
});
informationExamineClose.addEventListener('click', function () {
  informationExamine.style.opacity = 0;
  setTimeout(() => {
    informationExamine.style.display = 'none';
  }, 600);

});
informationQueryMenu.addEventListener('click', function () {

  informationExamine.style.display = 'none';
  informationInput.style.display = 'none';
  informationQuery.style.display = 'block';
  informationQuery.style.opacity = 0;
  setTimeout(() => {
    informationQuery.style.opacity = 1;

  }, 0);
});
informationQueryClose.addEventListener('click', function () {
  informationQuery.style.opacity = 0;
  setTimeout(() => {
    informationQuery.style.display = 'none';
  }, 600);

});


document.querySelector(".newStudentInfoSubmitButton").addEventListener('click',function () {
    var submitForm = document.querySelectorAll(".newStudentInfoForm input")
    var newStudentInfo = document.querySelectorAll(".tableAdd tr td");//[0].innerText;
    submitForm[0].value=newStudentInfo[5].innerText;
    submitForm[1].value=newStudentInfo[6].innerText;
    submitForm[2].value=newStudentInfo[7].innerText;
    submitForm[3].value=newStudentInfo[8].innerText;
    console.log(submitForm[0].value);
    console.log(submitForm[1].value);
    console.log(submitForm[2].value);
    console.log(submitForm[3].value);
    document.querySelector(".newStudentInfoSubmitRButton").click();
})

if(document.querySelector(".next")){
    document.querySelector(".next").addEventListener('click',function () {
        document.querySelector(".rNextSubmit").click();
    });
}
if(document.querySelector(".last")){
    document.querySelector(".last").addEventListener('click',function () {
        document.querySelector(".rLastSubmit").click();
    });
}
document.querySelector(".go").addEventListener('click',function () {
    document.querySelector(".rGoSubmit").click();
});

document.querySelectorAll(".examineOk").forEach(e=>e.addEventListener('click',function () {
    console.log("dia")
    document.querySelector(".rExamineOk").click();
}));
