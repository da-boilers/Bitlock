import React, { Component } from 'react';
import NavBar from './components/NavBar';
import Popup from './components/Popup';
import TextField from "./TextField";
import Button from '@material-ui/core/Button';
import './App.css';

class App extends Component{
    constructor(props){
    super(props);
    this.state = { showPopup: false };
    }
  
    togglePopup() {
     this.setState({
       showPopup: !this.state.showPopup
     });
   }
  state = {
    isOpen: false,
    fields: {}
  };

  onChange = updatedValue => {
    this.setState({
      fields: {
        ...this.state.fields,
        ...updatedValue
      }
    })
  };
  
  render() {
    return (
      <div className="App">
       <button onClick={this.togglePopup.bind(this)}> Click To Launch Popup</button>

       {this.state.showPopup ?
         <Popup
          text='Click "Close Button" to hide popup'
          closePopup={this.togglePopup.bind(this)}
         />
         : null
       }
        <NavBar />
        <TextField />
        
        <Button variant="outlined" color="primary" >
                    Submit 
        </Button>
        <Popup />
      </div>
    );
  }
  
}

export default App;