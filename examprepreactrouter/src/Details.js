import React from 'react'
import { Link } from 'react-router-dom'
export default class Details extends React.Component {
    constructor(props) {
        super(props);
        this.state = { user: {}, json: [] }
    }

    componentWillMount() {
        let id = this.props.match.params.index;
        fetch('http://localhost:3333/users').then((res) => {
            return res.json();
        }).then((json) => {
            const users = json;
            this.setState({
                user: users[id]
            })




            this.setState({ json: json });
        })
    }

    getDetails(){
        if(this.state.user){
            return <div><p> gender: {this.state.user.gender},
            first name: {this.state.user.first},
             last name: {this.state.user.last}</p></div>;
        } else {
            return <p>error: person doesnt exist</p>
        }
    }

    render() {
       const get = this.getDetails();

        return (<div>
            <p>hello from details</p>
            <Link to="/">back to welcome</Link>
            {get}

        </div>)
    }
}