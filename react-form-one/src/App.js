import React, { Component } from 'react';
import {render} from 'react-dom';
import NavBar from './components/NavBar';
import Popup from './components/Popup';
import TextField from "./TextField";
import Button from '@material-ui/core/Button';
//import QrCode from 'react.qrcode.generator'
import './App.css';

class App extends Component{
    constructor(props){
    super(props);
    this.state = { showPopup: false };
    }
  
    togglePopup() {
     this.setState({
       showPopup: !this.state.showPopup,
      
     });
   }
//   state = {
//     isOpen: false,
//     fields: {}
//   };

  onChange = updatedValue => {
    this.setState({
      fields: {
        ...this.state.fields,
        ...updatedValue
      }
    })
  };
  
  render() {

      console.log(document.getElementsByName("firstName"));
  
      return (
        <div className="App">
               
                <NavBar />
                <TextField />
                
                <Button onClick={this.togglePopup.bind(this)} alignItems={'center'} style={{paddingLeft:'0px'}} variant="outlined" color="primary" >
                           Click to submit your profile
                </Button>

                {this.state.showPopup ?              
                 <Popup
                  closePopup={this.togglePopup.bind(this)}
                 />
                : null
                 }
                
              </div>
      );
    
  }
  
}

export default App;