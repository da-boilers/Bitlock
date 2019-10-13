//textAlign, fontStyle, fontSize, letterSpacing

import React from 'react';
import Box from '@material-ui/core/Box';
import AppBar from '@material-ui/core/AppBar';
import Toolbar from '@material-ui/core/Toolbar';

const Title = () => {
    return(
        <div>
            <AppBar position="static">
                <Toolbar>
                    <Box color="primary" lineHeight={0.3} fontFamily="Thonburi" fontWeight="fontWeightBold" textAlign="center" fontSize={70}>Firearm Ownership Report
                    </Box>
                </Toolbar>
            </AppBar>
        </div>

    )
}
export default Title;