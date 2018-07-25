//四个页面

const registrationProces = document.querySelector('.registrationProces');
const perfectInformation = document.querySelector('.perfectInformation');
const payCost = document.querySelector('.payCost');
const chooseDormitories = document.querySelector('.chooseDormitories');
const queryInformation = document.querySelector('.queryInformation');
//导航栏的四个按钮
const registrationProcesMenu = document.querySelector('.registrationProcesMenu');
const perfectInformationMenu = document.querySelector('.perfectInformationMenu');
const payCostMenu = document.querySelector('.payCostMenu');
const chooseDormitoriesMenu = document.querySelector('.chooseDormitoriesMenu');
const queryInformationMenu = document.querySelector('.queryInformationMenu');
//四个页面的关闭按钮
const registrationProcesClose = document.querySelector('.registrationProcesClose');
const perfectInformationClose = document.querySelector('.perfectInformationClose');
const payCostClose = document.querySelector('.payCostClose');
const chooseDormitoriesClose = document.querySelector('.chooseDormitoriesClose');
const queryInformationClose = document.querySelector('.queryInformationClose');

const perfectInformationSubmit = document.querySelector('.perfectInformationSubmit');
const perfectInformationSubmitA = document.querySelector('.perfectInformationSubmitA');
perfectInformationSubmitA.addEventListener('click', function () {
    perfectInformationSubmit.click();
})
const payCostSubmit = document.querySelector('.payCostSubmit');
const payCostSubmitA = document.querySelector('.payCostSubmitA');
payCostSubmitA.addEventListener('click', function () {
    payCostSubmit.click();
})
//选择寝室部分
const selectRoomSubmitA = document.querySelector(".selectRoomSubmitA");
const chooseDormitoriesSubmit = document.querySelector(".chooseDormitoriesSubmit");
const selectRoomValue = document.querySelector(".selectRoomValue");
const selectRoom = document.querySelector(".selectRoom");




// registrationProces.addEventListener('click', function () {});
// perfectInformation.addEventListener('click', function () {});
// payCost.addEventListener('click', function () {});
// chooseDormitories.addEventListener('click', function () {});
// queryInformation.addEventListener('click', function () {});
// document.querySelector('.perfectInformationCheck').checked=false;
registrationProcesMenu.addEventListener('click', function () {

    perfectInformation.style.display = 'none';
    payCost.style.display = 'none';
    chooseDormitories.style.display = 'none';
    queryInformation.style.display = 'none';
    registrationProces.style.display = 'block';
    registrationProces.style.opacity = 0;
    setTimeout(() => {
        registrationProces.style.opacity = 1;
        },0);
});
perfectInformationMenu.addEventListener('click', function () {

    registrationProces.style.display = 'none';
    payCost.style.display = 'none';
    chooseDormitories.style.display = 'none';
    queryInformation.style.display = 'none';
    perfectInformation.style.display = 'block';
    perfectInformation.style.opacity = 0;
    setTimeout(() => {
        perfectInformation.style.opacity = 1;

},0
)
    ;
});
payCostMenu.addEventListener('click', function () {

    registrationProces.style.display = 'none';
    perfectInformation.style.display = 'none';
    chooseDormitories.style.display = 'none';
    queryInformation.style.display = 'none';
    payCost.style.display = 'block';
    payCost.style.opacity = 0;
    setTimeout(() => {
        payCost.style.opacity = 1;

},
    0
)
    ;
});
chooseDormitoriesMenu.addEventListener('click', function () {

    registrationProces.style.display = 'none';
    perfectInformation.style.display = 'none';
    payCost.style.display = 'none';
    queryInformation.style.display = 'none';
    chooseDormitories.style.display = 'block';
    chooseDormitories.style.opacity = 0;
    setTimeout(() => {
        chooseDormitories.style.opacity = 1;

},
    0
)
    ;
});
queryInformationMenu.addEventListener('click', function () {

    registrationProces.style.display = 'none';
    perfectInformation.style.display = 'none';
    payCost.style.display = 'none';
    chooseDormitories.style.display = 'none';
    queryInformation.style.display = 'block';
    queryInformation.style.opacity = 0;
    setTimeout(() => {
        queryInformation.style.opacity = 1;

},
    0
)
    ;
});

registrationProcesClose.addEventListener('click', function () {
    registrationProces.style.opacity = 0;
    setTimeout(() => {
        registrationProces.style.display = 'none';
},
    600
)
    ;

});
perfectInformationClose.addEventListener('click', function () {
    perfectInformation.style.opacity = 0;
    setTimeout(() => {
        perfectInformation.style.display = 'none';
},
    600
)
    ;
});


payCostClose.addEventListener('click', function () {
    payCost.style.opacity = 0;
    setTimeout(() => {
        payCost.style.display = 'none';
},
    600
)
    ;
});

chooseDormitoriesClose.addEventListener('click', function () {
    chooseDormitories.style.opacity = 0;
    setTimeout(() => {
        chooseDormitories.style.display = 'none';
},
    600
)
    ;
});
queryInformationClose.addEventListener('click', function () {
    queryInformation.style.opacity = 0;
    setTimeout(() => {
        queryInformation.style.display = 'none';
},600
);
});
// 修改默认学生信息
const info = document.cookie.trim().split(";");
let studentInfo = {}, tmp;
for (let i = 0, len = info.length; i < len; ++i) {
    tmp = info[i].split("=");
    tmp[0] = tmp[0].trim();
    studentInfo[tmp[0]] = tmp[1];
    if (tmp[0] !== "tel" && tmp[0] !== "address" && tmp[0] !== "stat" && tmp[0] !== "authority") {
        if (tmp[0] === "name") {
            document.querySelector(`.${tmp[0]}`).placeholder = decodeURI(tmp[1]);
        } else {
            document.querySelector(`.${tmp[0]}`).placeholder = tmp[1];
        }
    }
}


const stat = parseInt(studentInfo.stat);
const stata = parseInt(stat/100)%10;
const statb = parseInt(stat/10)%10;
const statc = stat%10;
console.log(stat);
console.log(stata);
console.log(statb);
console.log(statc);
if(stata===1){
    document.querySelector('.chooseDormitoriesCheck').checked =  true;
}
if(statb===1){
    document.querySelector('.payCostCheck').checked = true;
}
if(statc===1){

    document.querySelector('.perfectInformationCheck').checked =  true;
}
if(stata===1&&statb===1&&statc===1){
    document.querySelector(".queryInformationInfo").innerHTML="注册成功";
}
//选择寝室
selectRoomSubmitA.addEventListener('click',function () {
    // console.log(selectRoom.selectedIndex);

    let roomNumber = selectRoom.options[selectRoom.selectedIndex].value;
    // console.log(roomNumber);
    selectRoomValue.value=roomNumber;
    // console.log(selectRoomValue.value);
    chooseDormitoriesSubmit.click();
})

