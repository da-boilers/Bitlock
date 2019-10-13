import React, { Component } from 'react';
import Titles from './Titles';
import FilledTextFields from './FilledTextFields';
import Popup from './components/Popup';
import Button from '@material-ui/core/Button';
import './App.css';

class App extends Component{
  constructor(props){
    super(props);
    this.state = { showPopup: false };
  }

  togglePopup() {
         this.setState({
           showPopup: !this.state.showPopup,
          
         });
       }

    onChange = updatedValue => {
          this.setState({
            fields: {
              ...this.state.fields,
              ...updatedValue
            }
          })
        };
  render () {
    return (
      <div className="App">
        <Titles />
        <FilledTextFields />
        <br/>
        <Button onClick={this.togglePopup.bind(this)} alignItems={'center'} style={{paddingLeft:'0px'}} variant="outlined" color="primary" >
                           SUBMIT
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

export default App;
