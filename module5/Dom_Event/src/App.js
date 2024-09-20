import logo from './logo.svg';
import './App.css';

function App() {
  return (
   <div id={"wrapper"}>
     <button onDoubleClick={()=>console.log(Math.random())}>Click me!</button>
   </div>
  );
}

export default App;
