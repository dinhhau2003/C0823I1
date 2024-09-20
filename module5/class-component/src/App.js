import AddComponent from './components/AddComponent';
import './App.css'
import React from "react";
// class-component =>
// class App extends React.Component{
//     constructor() {
//         super();
//         this.state={
//             data:[
//                 {
//                     id:1,
//                     name:"hau",
//                     age:"20"
//                 },
//                 {
//                     id:2,
//                     name:"hau1",
//                     age:"22"
//                 },
//                 {
//                     id:3,
//                     name:"hau3",
//                     age:"23"
//                 },
//             ]
//         }
//     }
//     render() {
//         return(
//           <div>
//               <Header />
//               <table>
//                   <tbody>
//                   {this.state.data.map((person,i)=> <TableRow key={i} data={person}/>)}
//                   </tbody>
//               </table>
//           </div>
//         );
//     }
// }
// class Header extends React.Component{
//     render() {
//         return(
//             <div>
//                 <h1>Header</h1>
//             </div>
//         );
//     }
// }
// class TableRow extends React.Component{
//     render() {
//         return(
//           <tr>
//               <td>{this.props.data.id}</td>
//               <td>{this.props.data.name}</td>
//               <td>{this.props.data.age}</td>
//           </tr>
//         );
//     }
// }

// class-component <=



// state =>

class App extends React.Component{
    constructor(props) {
        super(props);
        this.state={
            header:"Header from state...",
            content:"Content from state..."
        }
    }
    render() {
        return(
            <div>
                <h1>
                    {this.state.header}
                </h1>
                <h1>
                    {this.state.content}
                </h1>
            </div>
        )
    }
}
export default App;