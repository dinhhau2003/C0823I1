import logo from './logo.svg';
import './App.css';
import YoutubeItem from "./component/Youtube/YoutubeItem";
import {Data} from "./data";
import YoutubeList from "./component/Youtube/YoutubeList";
import Toggle from "./component/state/Toggle";


function App() {
  // console.log(Data)
  return (
   <YoutubeList></YoutubeList>
      // <Toggle></Toggle>
  );
}

export default App;
