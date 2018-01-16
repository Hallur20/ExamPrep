import React from 'react'
import {Link} from 'react-router-dom'

export default class Welcome extends React.Component{
    constructor(props) {
        super(props);
        this.state = {json : []}
    }

    componentWillMount(){
        fetch('http://localhost:3333/users').then((res)=>{
return res.json();
        }).then((json)=>{
            console.log(json);
            this.setState({ json : json});
       
        })
    }
    render(){
        const arr = this.state.json.map((element, index)=>{return <div key={index}><Link to={"/details/" + index}>{element.first}</Link></div>})
       return <div><p>hello from welcome</p>
       
       <Link to="all">all users</Link><br/><br/>
  
       {arr}
       </div>
    }
}