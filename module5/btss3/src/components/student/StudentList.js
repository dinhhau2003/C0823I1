import {Component} from "react";

class StudentList extends Component{
    constructor(props) {
        super(props);
    }
    render() {
        return(
            <div>
                <h1>Danh sách học sinh</h1>
                <table>
                    <thead>
                    <tr>
                        <td>ID</td>
                        <td>Name</td>
                        <td>Address</td>
                    </tr>
                    </thead>
                    <tbody>
                    {
                        this.props.studentsProps.map((item)=>(
                            <tr key={item.id}>
                                <td>{item.id}</td>
                                <td>{item.name}</td>
                                <td>{item.address}</td>
                            </tr>
                        ))
                    }
                    </tbody>
                </table>
            </div>
        )
    }
}
export default StudentList;