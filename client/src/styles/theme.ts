import { createTheme, responsiveFontSizes } from "@mui/material/styles";

const theme = createTheme({
  palette: {
    mode: "light", // or 'dark'
    primary: {
      main: "#1976d2" // blue
    },
    secondary: {
      main: "#9c27b0" // purple
    },
    error: {
      main: "#d32f2f" // red
    },
    background: {
      default: "#f5f5f5",
      paper: "#fff"
    }
  },
  typography: {
    fontFamily: `"Roboto", "Helvetica", "Arial", sans-serif`,
    h1: {
      fontSize: "2.5rem",
      fontWeight: 600
    },
    h2: {
      fontSize: "2rem",
      fontWeight: 500
    },
    button: {
      textTransform: "none"
    }
  },
  shape: {
    borderRadius: 10
  },
  components: {
    MuiButton: {
      styleOverrides: {
        root: {
          borderRadius: 8
        }
      }
    }
  }
});

export default responsiveFontSizes(theme);
