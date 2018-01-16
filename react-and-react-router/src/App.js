import React from 'react'
import {
  BrowserRouter as Router,
  Route,
  Link,
  NavLink,
  Switch,
} from 'react-router-dom'
import Facade from './facade/Facade'

const Home = () => (
  <div>
    <h2>Home</h2>
    <p>Welcome ...</p>
  </div>
)

const About = () => (
  <div>
    <h2>About</h2>
  </div>
)

class Repository extends React.Component {
  
    constructor(props) {
      super(props);
      this.state = { repo: {} }
    }
  
    componentWillMount() {
      /*fetch('https://api.github.com/orgs/Cphdat3sem2017f/repos').then((res)=>{
        return res.json();
      }).then((json)=>{
        console.log(json);
        for(var i = 0; i < json.length; i++){
          if(json[i].name === this.props.match.params.name){
            this.setState({repo : json[i]})
          }
        }
      })*/
      var repo = Facade.getRepositoryFromName(this.props.match.params.name);
      this.setState({repo})
    }
    render() {
      //const match = this.props.match;
      return (<div>
        <h2>Repository</h2>
        <p>This control should show details for a SINGLE selected repository</p>
        <ul><li>full name: {this.state.repo.full_name}</li><br/><li>size:{this.state.repo.size}</li></ul>
      </div>
      )
    }
  }

class Repositories extends React.Component {

  constructor(props) {
    super(props);
    this.state = { repos: [] }
  }

  componentWillMount() {
    /*fetch('https://api.github.com/orgs/Cphdat3sem2017f/repos').then((res)=>{
      return res.json();
    }).then((json)=>{
      console.log(json);
      this.setState({repos: json});
    })*/
    Facade.fetchAllData(data =>{
      this.setState({repos: data});
    })
  }

  render() {
   
    var key = 0;
    const mapped = this.state.repos.map((element)=>{key++;
      return <div key={key}><li>{element.name}<Link to={"/repo/"+element.name}>details</Link></li></div>
    });    
    return (
      <div>
        <h2>Repositories</h2>
        <p>Complete this example to fecth the git-repositories (via link provided in the exercise),
          and populate the ul below with the name for each repository.
        </p>
        <ul>
          {mapped}
        </ul>
      </div>
    )
  }
}

const App = () => (
  <Router>
    <div>
      <div>
        <ul className="header">
          <li><NavLink exact to="/">Home</NavLink></li>
          <li><NavLink to="/repositories">Reposistories</NavLink></li>
          <li><NavLink to="/about">About</NavLink></li>
        </ul>
      </div>
      <Switch>
        <Route exact path="/" component={Home} />
        <Route path="/about" component={About}/>
        <Route path="/repositories" component={Repositories}/>
        <Route exatch path="/repo/:name" component={Repository}/>
        {/* Add the missing routes here */}
      </Switch>
    </div>
  </Router>
)
export default App