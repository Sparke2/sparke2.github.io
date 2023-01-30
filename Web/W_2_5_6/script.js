function proverit(){
	pr_otv_zadachi_1 = "да";
	pr_otv_zadachi_2 = "да";
	pr_otv_zadachi_3 = "да";
	pr_otv_zadachi_4 = "да";
	pr_otv_zadachi_5 = "да";
	pr_otv_zadachi_6 = "да";
	pr_otv_zadachi_7 = "да";
	pr_otv_zadachi_8 = "да";
	pr_otv_zadachi_9 = "да";
	pr_otv_zadachi_10 = "1995";
	otv_uch_1 = document.getElementById('z_1').value;
	otv_uch_2 = document.getElementById('z_2').value;
	otv_uch_3 = document.getElementById('z_3').value;
	otv_uch_4 = document.getElementById('z_4').value;
	otv_uch_5 = document.getElementById('z_5').value;
	otv_uch_6 = document.getElementById('z_6').value;
	otv_uch_7 = document.getElementById('z_7').value;
	otv_uch_8 = document.getElementById('z_8').value;
	otv_uch_9 = document.getElementById('z_9').value;
	otv_uch_10 = document.getElementById('z_10').value;
	ball = 0;
	if(otv_uch_1 == pr_otv_zadachi_1) {
		ball +=1;
	}
	if(otv_uch_2 == pr_otv_zadachi_2) {
		ball +=1;
	}
	if(otv_uch_3 == pr_otv_zadachi_3) {
		ball +=1;
	}
	if(otv_uch_4 == pr_otv_zadachi_4) {
		ball +=1;
	}
	if(otv_uch_5 == pr_otv_zadachi_5) {
		ball +=1;
	}
	if(otv_uch_6 == pr_otv_zadachi_6) {
		ball +=1;
	}
	if(otv_uch_7 == pr_otv_zadachi_7) {
		ball +=1;
	}
	if(otv_uch_8 == pr_otv_zadachi_8) {
		ball +=1;
	}
	if(otv_uch_9 == pr_otv_zadachi_9) {
		ball +=1;
	}
	if(otv_uch_10 == pr_otv_zadachi_10) {
		ball +=1;
	}
	vsego_zadach = 10;
	procent_vip = ball/vsego_zadach * 100;
	document.getElementById('rezultat').innerHTML = "Задания выполнены верно на "+procent_vip+"%.";
}

let name;

let btn = document.querySelector('.btn');
let popup = document.querySelector('.popup');

const togglePopup = () => {
	popup.classList.toggle('active');
}

btn.addEventListener('click', e => {
	e.stopPropagation();

	togglePopup();
	DateToday();
});

document.addEventListener('click', e => {
	let target = e.target;
	let its_popup = target == popup || popup.contains(target);
	let its_btn = target == btn;
	let popup_is_active = popup.classList.contains('active');
	
	if (!its_popup && !its_btn && popup_is_active) {
		togglePopup();
	}
})
function DateToday() {
	Data = new Date();
	Year = Data.getFullYear();
	Month = Data.getMonth();
	Day = Data.getDate();
	Hour = Data.getHours();
	Minutes = Data.getMinutes();
	Seconds = Data.getSeconds();

				// Преобразуем месяца
	switch (Month)
	{
	case 0: fMonth="января"; break;
	case 1: fMonth="февраля"; break;
	case 2: fMonth="марта"; break;
	case 3: fMonth="апреля"; break;
	case 4: fMonth="мае"; break;
	case 5: fMonth="июня"; break;
	case 6: fMonth="июля"; break;
	case 7: fMonth="августа"; break;
	case 8: fMonth="сентября"; break;
	case 9: fMonth="октября"; break;
	case 10: fMonth="ноября"; break;
	case 11: fMonth="декабря"; break;
	}

	document.getElementById('block2').innerHTML = "Сегодня " + Day + " " + fMonth + " " + Year + " года";
	document.getElementById('block3').innerHTML = "Текущее время: " + Hour + ":" + Minutes + ":" + Seconds;
}


function Hello(name) {
	alert("Привет, " + name);
}

function Work() {
	name = prompt("Введите свое имя");
	if(name!=null){
		Hello(name);
	}
	document.getElementById('block').innerHTML = name;
}

function Square() {
	let a = prompt("Основание");
	let h = prompt("Высота");
	let res = (a*h)/2;
	alert(res);
}
function Equals() {
	let a = prompt("Строка 1");
	let b = prompt("Строка 2");

	if (a.length == b.length) {
		alert(true);
	} else {
		alert(false);
	}
}
function Elem() {
	const arr = [];
	for (var i = 1; i <= 5; i++) {
		let a = prompt("Введите " + i + "-ый");
		arr.push(a);
	}
	min = arr[0];
	max = min;
	for (i = 1; i < arr.length; ++i) {
		if (arr[i] > max) max = arr[i];
		if (arr[i] < min) min = arr[i];
	}
	if (arr!=null) {
		alert("Минимальный: " + min + "; Максимальный: " + max);
	}
}

function showHide(element_id) {
	if (document.getElementById(element_id)) { 
		var obj = document.getElementById(element_id); 
		if (obj.style.display != "block") { 
			obj.style.display = "block"; 
		}
		else obj.style.display = "none"; 
	}
	
	else alert("Элемент с id: " + element_id + " не найден!"); 
}   