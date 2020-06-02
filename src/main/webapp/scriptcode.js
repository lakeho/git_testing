/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var manganh = [4];
var i=0;
var auto;
manganh[0]="images/h1.jpg";
manganh[1]="images/h2.jpg";
manganh[2]="images/h3.jpg";
manganh[3]="images/h4.jpg";

function next(){
        i++;
        if(i>manganh.length-1){
                i=0;
        }
        document.getElementById("headpic").src = manganh[i];
}
function pre(){
        i--;
        if(i <0){
                i =manganh.length-1;
        }
        document.getElementById("headpic").src = manganh[i];

}

function first(){
        i=0;
        document.getElementById("headpic").src = manganh[i];
}

function last(){
        i=manganh.length-1;
        document.getElementById("headpic").src = manganh[i];
}

function stop(){
        clearTimeout(auto);
}

function Auto(){
        i = i+1;
        if(i>manganh.length-1)
                i=0;
        document.getElementById("headpic").src = manganh[i];			
        auto = setTimeout(Auto,2000);
}

window.onload=function(){
        auto = setTimeout(Auto,2000);
}



