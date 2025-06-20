import React from "react";
import { AppBar, Toolbar, Typography, CssBaseline, Drawer, IconButton, Box } from "@mui/material";
import { makeStyles } from "@mui/styles";
import MenuIcon from "@mui/icons-material/Menu";
import { Outlet } from "react-router-dom";
import DrawerItems from "./DrawerItems";

const drawerWidth = 240;

const useStyles = makeStyles((theme) => ({
  root: {
    display: "flex"
  },
  appBar: {
    transition: "margin 0.3s",
    zIndex: 1300
  },
  appBarShift: {
    marginLeft: drawerWidth,
    width: `calc(100% - ${drawerWidth}px)`,
    transition: "margin 0.3s"
  },
  drawer: {
    width: drawerWidth,
    flexShrink: 0,
    "& .MuiDrawer-paper": {
      width: drawerWidth,
      boxSizing: "border-box"
    }
  },
  drawerContainer: {
    overflow: "auto"
  },
  toolbar: {
    minHeight: 64
  },
  content: {
    flexGrow: 1,
    padding: 24,
    transition: "margin 0.3s",
    marginLeft: 0
  },
  contentShift: {
    marginLeft: drawerWidth
  },
  iconButton: {
    marginRight: 16
  }
}));

export default function AppFrame() {
  const classes = useStyles();
  const [open, setOpen] = React.useState(true);

  const toggleDrawer = () => setOpen(!open);

  return (
    <Box className={classes.root}>
      <CssBaseline />

      <AppBar position='fixed' className={`${classes.appBar} ${open ? classes.appBarShift : ""}`}>
        <Toolbar>
          <IconButton color='inherit' edge='start' onClick={toggleDrawer} className={classes.iconButton}>
            <MenuIcon />
          </IconButton>
          <Typography variant='h6' noWrap>
            HireNest
          </Typography>
        </Toolbar>
      </AppBar>

      <Drawer variant='persistent' anchor='left' open={open} className={classes.drawer}>
        <div className={classes.toolbar} />
        <div className={classes.drawerContainer}>
          <DrawerItems />
        </div>
      </Drawer>

      <main className={`${classes.content} ${open ? classes.contentShift : ""}`}>
        <div className={classes.toolbar} />
        <Outlet />
      </main>
    </Box>
  );
}
