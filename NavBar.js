import React from 'react';
import Box from '@material-ui/core/Box';
import AppBar from '@material-ui/core/AppBar';
import Toolbar from '@material-ui/core/Toolbar';
//import Typography from '@material-ui/core/Typography';


const NavBar = () => {
    return(
        <div>
            <AppBar position="static">
                <Toolbar>
                    <Box mx={67} fontSize={50} p={5}>
                        Voter Registration
                    </Box>
{/*                     <Typography variant="h2" gutterBottom>
                        Voter Registration
                    </Typography> */}
                </Toolbar>
            </AppBar>
        </div>

    )
}
export default NavBar;
