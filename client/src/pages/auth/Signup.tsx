import React, { useState } from "react";
import { Avatar, Button, TextField, Box, Typography, Container, IconButton, InputAdornment, CssBaseline } from "@mui/material";
import LockOutlinedIcon from "@mui/icons-material/LockOutlined";
import { Visibility, VisibilityOff } from "@mui/icons-material";
import { makeStyles } from "@mui/styles";
import { Link } from "react-router-dom";
import { ISignupPayload } from "../../features/auth/types";
import { useAuth } from "../../hooks/useAuth";

const useStyles = makeStyles(() => ({
  paper: {
    marginTop: "64px",
    display: "flex",
    flexDirection: "column",
    alignItems: "center",
    boxShadow: "0px 3px 6px rgba(0,0,0,0.1)",
    borderRadius: "20px",
    padding: "32px",
    backgroundColor: "#fff"
  },
  avatar: {
    margin: "8px",
    backgroundColor: "#1976d2"
  },
  form: {
    marginTop: "8px",
    width: "100%"
  },
  linkContainer: {
    display: "flex",
    justifyContent: "center",
    marginTop: "16px"
  },
  link: {
    cursor: "pointer"
  }
}));

export default function Signup() {
  const classes = useStyles();
  const { signup } = useAuth();

  const [showPassword, setShowPassword] = useState<boolean>(false);
  const [formData, setFormData] = useState<ISignupPayload>({
    firstName: "",
    lastName: "",
    email: "",
    password: ""
  });

  const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => setFormData({ ...formData, [e.target.name]: e.target.value });

  const handleSubmit = (e: React.FormEvent<HTMLFormElement>) => {
    e.preventDefault();
    signup(formData);
  };

  return (
    <Container component='main' maxWidth='xs'>
      <CssBaseline />
      <Box className={classes.paper}>
        <Avatar className={classes.avatar}>
          <LockOutlinedIcon />
        </Avatar>
        <Typography component='h1' variant='h5'>
          Sign up
        </Typography>
        <Box component='form' onSubmit={handleSubmit} className={classes.form}>
          <TextField
            margin='normal'
            required
            fullWidth
            label='First Name'
            name='firstName'
            value={formData.firstName}
            onChange={handleChange}
          />
          <TextField
            margin='normal'
            required
            fullWidth
            label='Last Name'
            name='lastName'
            value={formData.lastName}
            onChange={handleChange}
          />
          <TextField
            margin='normal'
            required
            fullWidth
            label='Email Address'
            name='email'
            type='email'
            value={formData.email}
            onChange={handleChange}
          />
          <TextField
            margin='normal'
            required
            fullWidth
            label='Password'
            name='password'
            type={showPassword ? "text" : "password"}
            value={formData.password}
            onChange={handleChange}
            InputProps={{
              endAdornment: (
                <InputAdornment position='end'>
                  <IconButton onClick={() => setShowPassword((prev) => !prev)} edge='end'>
                    {showPassword ? <VisibilityOff /> : <Visibility />}
                  </IconButton>
                </InputAdornment>
              )
            }}
          />
          <Button type='submit' fullWidth variant='contained' sx={{ mt: 2 }}>
            Sign Up
          </Button>
          <Box className={classes.linkContainer}>
            <Link to='/login' style={{ textDecoration: "none" }}>
              <Typography variant='body2' color='primary' className={classes.link}>
                Already have an account? Sign In
              </Typography>
            </Link>
          </Box>
        </Box>
      </Box>
    </Container>
  );
}
