import React, { Component } from 'react';
import OutlinedTextFields from './OutlinedTextFields';
import Title from './components/Title';
import Popup from './components/Popup';
import Button from '@material-ui/core/Button';
import SimpleSelect from './SimpleSelect';
import './Main.css';

class Main extends Component{
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
    

  render() {
  
    return (
      <div className="Main">
       <Title /> 
       <OutlinedTextFields />
       <SimpleSelect />
      <br/>

      
      <Button onClick={this.togglePopup.bind(this)} alignItems={'center'} style={{paddingLeft:'0px'}} variant="outlined" color="primary" >
                           UPLOAD
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

export default Main;

