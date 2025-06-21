import React from "react";
import { Box, Grid, Card, CardContent, Typography, Link } from "@mui/material";

const quickLinks: { label: string; href: string }[] = [
  { label: "My Profile", href: "/profile" },
  { label: "Settings", href: "/settings" },
  { label: "Help Center", href: "/help" }
];

const Dashboard: React.FC = () => {
  return (
    <Box p={3}>
      <Typography variant='h5' gutterBottom>
        Quick Links
      </Typography>
      <Grid container spacing={2}>
        {quickLinks.map((link, index) => (
          <Card variant='outlined'>
            <CardContent>
              <Typography variant='h6'>
                <Link href={link.href} underline='hover'>
                  {link.label}
                </Link>
              </Typography>
            </CardContent>
          </Card>
        ))}
      </Grid>
    </Box>
  );
};

export default Dashboard;
