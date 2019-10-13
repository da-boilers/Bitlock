import React from 'react';
import clsx from 'clsx';
import { makeStyles } from '@material-ui/core/styles';
import TextField from '@material-ui/core/TextField';

const useStyles = makeStyles(theme => ({
  container: {
    display: 'flex',
    flexWrap: 'wrap',
  },
  textField: {
    marginLeft: theme.spacing(1),
    marginRight: theme.spacing(1),
    width: 200,
  },
  dense: {
    marginTop: 19,
  },
  menu: {
    width: 200,
  },
}));


export default function TextFields() {
  const classes = useStyles;
  const [values, setValues] = React.useState({
  });

  // eslint-disable-next-line
  const handleChange = name => event => {
    setValues({ ...values, [name]: event.target.value });
  };

  return (
    <form className={classes.container} noValidate autoComplete="off">
      <TextField
        id="standard-dense"
        textAlign={'center'}
        label="First Name"
        className={clsx(classes.textField, classes.dense)}
        margin="dense"
      />
      <br />
      <TextField
        id="standard-dense"
        textAlign={'center'}
        label="Last Name"
        className={clsx(classes.textField, classes.dense)}
        margin="dense"
      />
      <br />
      <TextField
        id="standard-dense"
        textAlign={'center'}
        label="Date of Birth"
        type="number"
        className={clsx(classes.textField, classes.dense)}
        margin="dense"
      />
      <br />
      <TextField
        id="standard-dense"
        textAlign={'center'}
        label="Email"
        className={clsx(classes.textField, classes.dense)}
        margin="dense"
      />
      <br />
      <TextField
        id="standard-password-input"
        textAlign={'center'}
        type="number"
        label="Last 4 digits of SSN"
        className={classes.textField}
        type="password"
        autoComplete="current-password"
        margin="normal"
      />
      <br />
      <TextField
        id="standard-dense"
        textAlign={'left'}
        label="Phone Number"
        type="number"
        className={clsx(classes.textField, classes.dense)}
        margin="dense"
      />
      <br />
      <br />
    </form>
  );
}