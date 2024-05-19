import React from 'react';
import { NavLink } from 'react-router-dom';
// import './navbar.css';

interface NavbarProps {
  title: string;
}

const Navbar: React.FC<NavbarProps> = ({ title }) => {
  return (
    <div className="navbar">
      <h1>{title}</h1>
      <div className="navbar-links">
        <NavLink to="/login">Login</NavLink>
        <NavLink to="/register">Cadastre-se</NavLink>
      </div>
    </div>
  );
};

export default Navbar;