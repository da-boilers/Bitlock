import React from 'react';
import QrCode from 'react.qrcode.generator';
import './style.css';

class Popup extends React.Component {

    
  render() {
    //var React2 = require('react');
    //var QrCode = require('qrcode.react');
    return (
      <div className='popup'>
        <div className='popup_inner'>
          <h1>{this.props.text}</h1>
          <button onClick={this.props.closePopup}>x</button>

            <QrCode mx="center" value = 'https.reactjs.org' size = "280"/>
            <br/>
             <p1>You are now registered to vote. You can scan this QR code to add your voter ID to your 
                wallet in the Waulthentic app. </p1>
        </div>
      </div>
    );
  }
}


export default Popup;