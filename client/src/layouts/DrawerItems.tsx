import React from "react";
import { List, ListItem, ListItemIcon, ListItemText } from "@mui/material";
import InboxIcon from "@mui/icons-material/Inbox";
import { Link } from "react-router-dom";

export default function DrawerItems() {
  return (
    <List>
      <ListItem component={Link} to='f'>
        <ListItemIcon>
          <InboxIcon />
        </ListItemIcon>
        <ListItemText primary='Index' />
      </ListItem>
    </List>
  );
}
