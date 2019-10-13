import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Radio from '@material-ui/core/Radio';
import RadioGroup from '@material-ui/core/RadioGroup';
import FormControlLabel from '@material-ui/core/FormControlLabel';
import FormControl from '@material-ui/core/FormControl';
import FormLabel from '@material-ui/core/FormLabel';

const useStyles = makeStyles(theme => ({
  formControl: {
    margin: theme.spacing(6.2),
  },
}));

export default function RadioButtonsGroup() {
  const classes = useStyles();
  const [value, setValue] = React.useState('female');

  const handleChange = event => {
    setValue(event.target.value);
  };

  return (
    <div>
      <FormControl component="fieldset" className={classes.formControl}>
        <FormLabel component="legend">Gender</FormLabel>
        <RadioGroup aria-label="gender" name="gender1"  onChange={handleChange}>
          <FormControlLabel value="female" control={<Radio />} label="Female" />
          <FormControlLabel value="male" control={<Radio />} label="Male" />
          <FormControlLabel value="other" control={<Radio />} label="Other" />

        </RadioGroup>
      </FormControl>
      <FormControl component="fieldset" className={classes.formControl}>
        <FormLabel component="legend">Firearm Type</FormLabel>
        <RadioGroup aria-label="gender" name="gender1"  onChange={handleChange}>
          <FormControlLabel value="female" control={<Radio />} label="Long Gun " />
          <FormControlLabel value="male" control={<Radio />} label="Handgun" />
          <FormControlLabel value="other" control={<Radio />} label="Other" />

        </RadioGroup>
      </FormControl>

      <FormControl component="fieldset" className={classes.formControl}>
        <FormLabel component="legend">If Long Gun:</FormLabel>
        <RadioGroup aria-label="gender" name="gender1"  onChange={handleChange}>
          <FormControlLabel value="female" control={<Radio />} label="Rifle" />
          <FormControlLabel value="male" control={<Radio />} label="Shotgun" />
          <FormControlLabel value="other" control={<Radio />} label="Other" />

        </RadioGroup>
      </FormControl>

      <FormControl component="fieldset" className={classes.formControl}>
        <FormLabel component="legend">If Hand Gun:</FormLabel>
        <RadioGroup aria-label="gender" name="gender1"  onChange={handleChange}>
          <FormControlLabel value="female" control={<Radio />} label="Semiauto" />
          <FormControlLabel value="male" control={<Radio />} label="Single-Shot" />
          <FormControlLabel value="revolver" control={<Radio />} label="Revolver" />
          <FormControlLabel value="other" control={<Radio />} label="Other" />

        </RadioGroup>
      </FormControl>

      <FormControl component="fieldset" className={classes.formControl}>
        <FormLabel component="legend">Acquired From:</FormLabel>
        <RadioGroup aria-label="gender" name="gender1"  onChange={handleChange}>
          <FormControlLabel value="female" control={<Radio />} label="Firearms Dealer" />
          <FormControlLabel value="male" control={<Radio />} label="Private Dealer" />
          <FormControlLabel value="family" control={<Radio />} label="Family Member (specify relationship)" />
          <FormControlLabel value="other" control={<Radio />} label="Gun Show" />

        </RadioGroup>
      </FormControl>
    
    </div>
  );
} 