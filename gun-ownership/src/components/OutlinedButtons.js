import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Button from '@material-ui/core/Button';

const useStyles = makeStyles(theme => ({
    button: {
        margin: theme.spacing(1),
    },
    input: {
        display: 'none',    
    },
}));

export default function OutlinedButtons() {
    const classes = useStyles();

    return (
        <div>
            <label htmlFor="outlined-button-file">
                <Button alignItems={'center'} variant="outlined" component="span" className={classes.button}>
                Upload
                </Button>
            </label>
            
        </div>
    );
}

