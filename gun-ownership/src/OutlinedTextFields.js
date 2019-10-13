import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import TextField from '@material-ui/core/TextField';

const useStyles = makeStyles(theme => ({
  container: {
    display: 'flex',
    flexWrap: 'wrap',
  },
  textField: {
    marginLeft: theme.spacing(1),
    marginRight: theme.spacing(1),
  },
  dense: {
    marginTop: theme.spacing(2),
  },
  menu: {
    width: 200,
  },
}));

export default function OutlinedTextFields() {
  const classes = useStyles();
  const [values, setValues] = React.useState({
    name: 'Cat in the Hat',
    age: '',
    multiline: 'Controlled',
    currency: 'EUR',
  });

  const handleChange = name => event => {
    setValues({ ...values, [name]: event.target.value });
    
  };

  return (
    <form className={classes.container} noValidate autoComplete="off">
      <TextField
        required
        id="outlined-required"
        label="First Name"
        defaultValue=""
        className={classes.textField}
        margin="dense"
        textAlign={'center'}
        variant="outlined"
      />
      <TextField
        id="outlined-required"
        label="MI"
        defaultValue=""
        className={classes.textField}
        margin="dense"
        textAlign={'center'}
        variant="outlined"
      />
      <br/>
      <br/>
      <TextField
        required
        id="outlined-required"
        label="Last Name"
        defaultValue=""
        className={classes.textField}
        margin="dense"
        textAlign={'center'}
        variant="outlined"
      />
      <br/>
      <TextField
        required
        id="outlined-email-input"
        label="Email"
        className={classes.textField}
        type="email"
        name="email"
        autoComplete="email"
        margin="dense"
        textAlign={'center'}
        variant="outlined"
      />
      <br/>
      <TextField
        required
        id="outlined-password-input"
        label="Last 4 digits of SSN"
        className={classes.textField}
        type="password"
        autoComplete="current-password"
        margin="dense"
        textAlign={'center'}
        variant="outlined"
      />
      <TextField
        id="filled-number"
        required
        label="Serial Number"
        value={values.age}
        onChange={handleChange('age')}
        type="number"
        className={classes.textField}
        InputLabelProps={{
          shrink: true,
        }}
        margin="dense"
        variant="filled"
      />
      </form>
  );
}