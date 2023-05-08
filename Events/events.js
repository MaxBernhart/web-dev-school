var events;
var details;
var participants;

function showConfirm(data){
    let eventDiv = document.getElementById('event');
    eventDiv.style.display = 'none';
    
    let confirmDiv = document.getElementById('confirm');
    confirmDiv.style.display = 'block';
}

function signUP(){
    
    let nameField = document.getElementById('name');
    let emailField = document.getElementById('email');
    var toPost = {event:details.id,name:nameField.value,email:emailField.value};

    fetch('http://localhost:8085/participants', {
        method: 'POST',
        body: JSON.stringify(toPost),
        headers: {
          'Content-type': 'application/json; charset=UTF-8'
        }
      }).then(response => response.json()).then(response => showConfirm(response));
}

function displayParticipants(data){
    participants = data;
    let partList = document.getElementById('participants')

    let length = participants.length;
    for(let i = 0; i < length; i++){
        let newRow = document.createElement('li');
        newRow.innerText = participants[i].name;
        partList.appendChild(newRow);
    }
}

function receiveDetails(data){
    details = data;

    let listDiv = document.getElementById('list');
    listDiv.style.display = 'none';
    
    let eventDiv = document.getElementById('event');
    eventDiv.style.display = 'block';

    let head = document.getElementById('head')
    head.innerHTML = data.title;

    let time = document.getElementById('time')
    time.innerHTML = data.time;

    let place = document.getElementById('place')
    place.innerHTML = data.place;

    let description = document.getElementById('desc')
    description.innerHTML = data.description;

    fetch('http://localhost:8085/participants?event=' + details.id).then(response => response.json()).then(response => { displayParticipants(response); });
}

function selectEvent(){
    let select = document.getElementById('select');
    let choice = select.value;

    fetch('http://localhost:8085/events/'+ choice).then(response => response.json()).then(response => { receiveDetails(response); });
}

function receiveEvents(data){
    events = data;

    let loadDiv = document.getElementById('load');
    loadDiv.style.display = 'none';
    
    let listDiv = document.getElementById('list');
    listDiv.style.display = 'block';

    let selectBody = document.getElementById('select')
    selectBody.innerHTML = '';

    let length = events.length;
    for(let i = 0; i < length; i++){
        let newRow = document.createElement('option');
        newRow.setAttribute('value', events[i].id);
        newRow.innerText = events[i].title;
        selectBody.appendChild(newRow);
    }
}

function setUp(){

    let selectButton = document.getElementById('selectButton');
    selectButton.addEventListener('click',()=>selectEvent());

    let signUpButton = document.getElementById('signup');
    signUpButton.addEventListener('click',()=>signUP());
    
    let listDiv = document.getElementById('list');
    listDiv.style.display = 'none';
    let eventDiv = document.getElementById('event');
    eventDiv.style.display = 'none';
    let confirmDiv = document.getElementById('confirm');
    confirmDiv.style.display = 'none';

    fetch('http://localhost:8085/handles').then(response => response.json()).then(response => { receiveEvents(response); });
}

window.addEventListener('load',setUp,false);