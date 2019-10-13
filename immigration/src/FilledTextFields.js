import React from 'react';
import clsx from 'clsx';
import { makeStyles } from '@material-ui/core/styles';
import MenuItem from '@material-ui/core/MenuItem';
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

export default function FilledTextFields() {
  const classes = useStyles();
  const [values, setValues] = React.useState({
  });

  const handleChange = name => event => {
    setValues({ ...values, [name]: event.target.value });
  };

  return (
    <form className={classes.container} noValidate autoComplete="off">
      <TextField
        required
        id="filled-lastname"
        label="Family Name"
        className={classes.textField}
        onChange={handleChange('name')}
        margin="normal"
        variant="filled"
      />
      <TextField
        required
        id="filled-firstname"
        label="First Name"
        className={classes.textField}
        onChange={handleChange('name')}
        margin="normal"
        variant="filled"
      />
      <TextField
        id="filled-miname"
        label="Middle Name"
        className={classes.textField}
        onChange={handleChange('name')}
        margin="normal"
        variant="filled"
      />
      <TextField
        required
        id="filled-members"
        label="No. of Family members traveling w/ you"
        className={classes.textField}
        onChange={handleChange('name')}
        margin="normal"
        variant="filled"
      />
      <TextField
        required
        id="filled-name"
        label="Passport Number"
        className={classes.textField}
        onChange={handleChange('name')}
        margin="normal"
        variant="filled"
      />
      <TextField
        required
        id="filled-name"
        label="Passport Issued by(country)"
        className={classes.textField}
        onChange={handleChange('name')}
        margin="normal"
        variant="filled"
      />
      <TextField
        required
        id="filled-name"
        label="Flight No./Vessel Name"
        className={classes.textField}
        onChange={handleChange('name')}
        margin="normal"
        variant="filled"
      />
    
      <TextField
        id="filled-number"
        label="Phone Number"
        value={values.age}
        onChange={handleChange('age')}
        type="number"
        className={classes.textField}
        InputLabelProps={{
          shrink: true,
        }}
        margin="normal"
        variant="filled"
      />
      <TextField
        id="filled-search"
        label="Search field"
        type="search"
        className={classes.textField}
        margin="normal"
        variant="filled"
      />
     
      <TextField
        id="filled-full-width"
        label="Countries visited on this trip prior to U.S. arrival"
        style={{ margin: 8 }}
        placeholder="List all countries"
        fullWidth
        margin="normal"
        variant="filled"
        InputLabelProps={{
          shrink: true,
        }}
      />
    </form>
  );
}