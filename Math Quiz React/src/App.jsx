import { useState, useRef } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'

function App() {
  const [completed,setCompleted] = useState(0);
  const [correct,setCorrect] = useState(0);
  const problems = [{question:"2+2 = ?",answer:"4"},{question:"17-9 = ?",answer:"8"},
    {question:"12*4 = ?",answer:"48"},{question:"8*7 = ?",answer:"56"},{question:"65/5 = ?",answer:"13"}];
  
  const ansInput = useRef();


  function checkAns() {
    let check = ansInput.current.value;

    if(check == problems[completed].answer){
      
      setCompleted(completed + 1);
      setCorrect(correct + 1)
    }
    else{
      setCompleted(completed + 1);
    }
  }

  if(completed < 5)
    return (
      <div>
        <label htmlFor="question">{problems[completed].question}</label>
        <input type="text" ref={ansInput} id="ans" />
        <button onClick={checkAns}>Check Answer</button>
        <p>You have {correct} out of {completed} correct.</p>
      </div>
    );
  else
    return (
      <div>
        <p>Quiz Over</p>
        <p>You answered {correct} out of 5 correctly.</p>
      </div>

    );
}

export default App
