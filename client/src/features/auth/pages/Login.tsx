import React, { useState } from "react";
import { Avatar, Button, TextField, Box, Typography, Container, IconButton, InputAdornment, CssBaseline } from "@mui/material";
import { makeStyles } from "@mui/styles";
import LockOutlinedIcon from "@mui/icons-material/LockOutlined";
import { Visibility, VisibilityOff } from "@mui/icons-material";
import { ILoginPayload } from "../types";
import { useAuth } from "../hooks/useAuth";
import { Link } from "react-router-dom";

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

const LoginPage: React.FC = () => {
  const classes = useStyles();
  const { login } = useAuth();

  const [showPassword, setShowPassword] = useState<boolean>(false);
  const [formData, setFormData] = useState<ILoginPayload>({
    email: "",
    password: ""
  });

  const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => setFormData({ ...formData, [e.target.name]: e.target.value });

  const handleSubmit = (e: React.FormEvent<HTMLFormElement>) => {
    e.preventDefault();
    login(formData);
  };

  return (
    <Container component='main' maxWidth='xs'>
      <CssBaseline />
      <Box className={classes.paper}>
        <Avatar className={classes.avatar}>
          <LockOutlinedIcon />
        </Avatar>
        <Typography component='h1' variant='h5'>
          Sign in
        </Typography>
        <Box component='form' onSubmit={handleSubmit} className={classes.form}>
          <TextField
            margin='normal'
            required
            fullWidth
            label='Email Address'
            name='email'
            value={formData.email}
            onChange={handleChange}
            autoComplete='email'
            autoFocus
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
            autoComplete='current-password'
            InputProps={{
              endAdornment: (
                <InputAdornment position='end'>
                  <IconButton onClick={() => setShowPassword((prev) => !prev)} edge='end' aria-label='toggle password visibility'>
                    {showPassword ? <VisibilityOff /> : <Visibility />}
                  </IconButton>
                </InputAdornment>
              )
            }}
          />
          <Button type='submit' fullWidth variant='contained'>
            Sign In
          </Button>
          <Box className={classes.linkContainer}>
            <Link to='/signup' style={{ textDecoration: "none" }}>
              <Typography variant='body2' color='primary' className={classes.link}>
                {"Don't have an account? Sign Up"}
              </Typography>
            </Link>
          </Box>
        </Box>
      </Box>
    </Container>
  );
};

export default LoginPage;
