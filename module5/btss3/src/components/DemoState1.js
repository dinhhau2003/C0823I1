import {Component} from "react";

class DemoState1 extends Component{
    constructor() {
        super();
        this.state={
            num:1,
            // nameStudent:"Hau"
        }
    }
    incrementNum(){
        this.setState((previousState)=>{
            return{
                num:previousState.num+1
            }
        })
        this.setState((previousState)=>{
            return{
                num:previousState.num+1
            }
        })
    }
    render() {
        console.log(2)
        return(
            <div>
                {/*<h1>Tên: {this.state.nameStudent}</h1>*/}
                <h1>Giá trị: {this.state.num}</h1>
                <buton onClick={this.incrementNum.bind(this)}>+1</buton>
            </div>
        )
    }
}
export default DemoState1;