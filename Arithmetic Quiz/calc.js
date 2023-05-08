var questions = [{id:0, q:"4*13", a: 52},{id:1, q:"60 / 5", a: 12},{id:2, q:"23-17", a: 6},
                {id:3, q:"13+8", a: 21},{id:4, q:"7-18", a: -11}];
var current = 0;
var numCorrect = 0;

function submitHandler(){
    let ansField = document.getElementById('ans');
    let ans = ansField.value;
    let scoreField = document.getElementById('score');
    let qDisplay = document.getElementById("qdisp");

    if (current <= 4){
        if(ans == questions[current].a){
            current++;
            numCorrect++
        }
        else{
            current++;
        }
    
        let score = "You have " + numCorrect + " out of " + current + " problems right";
        scoreField.textContent = score;

        if (current < 5){
            qDisplay.innerText = questions[current].q;
        }
        else{
            qDisplay.innerText = "Game is Over"
        }

    }
    }

function setup(){
    let submitButton = document.getElementById("submit");
    submitButton.addEventListener('click',submitHandler,false);

    let qDisplay = document.getElementById("qdisp");
    qDisplay.innerText = questions[current].q;

    let scoreField = document.getElementById('score');
    let score = "You have " + numCorrect + " out of " + current + " problems right";
    scoreField.textContent = score;
}

window.addEventListener('load',setup,false);