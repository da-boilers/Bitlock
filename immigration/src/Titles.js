import React from 'react';
import Box from '@material-ui/core/Box';
import AppBar from '@material-ui/core/AppBar';
import Toolbar from '@material-ui/core/Toolbar';

const Titles = () => {
    return(
        <div>
            <AppBar position="static">
                <Toolbar>
                    <Box color="primary" lineHeight={1} fontFamily="Myriad Pro Semibold Italic" fontWeight="fontWeightBold" textAlign="center" fontSize={70}>U.S. Customs and Border Protection
                    Immigration Form
                    </Box>
                </Toolbar>
            </AppBar>
        </div>

    )
}
export default Titles;