import React from 'react'
import {Link} from 'react-router-dom'
export default class AllUsers extends React.Component {

    constructor(props){
        super(props);
        this.state = {json : []}
     
    }

    componentWillMount(){
        fetch('http://localhost:3333/users').then((res)=>{
            return res.json();
        }).then((json)=>{
            console.log(json);
            this.setState({json:json});
        })
    }
    render() {
        const arr = this.state.json.map((element)=>{ return <div><p>gender: {element.gender}, first name: {element.first}, last name: {element.last}</p></div>})
        return (<div><p>hello from all users</p>
            <Link to="/">back to welcome</Link>
         {arr}
        </div>)
    }
}