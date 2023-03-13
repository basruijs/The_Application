import React from 'react';
import { NavLink } from 'react-router-dom';

function NavBar(props) {
    return (
        <div className="navBar bordered">
            <h2>{props.person.name || ''}</h2>
            <nav>
                <NavLink to="/login">Login</NavLink>
                <NavLink to="/hr">Dashboard HR</NavLink>
                <NavLink to="/coach">Dashboard Coach</NavLink>
            </nav>
            <h2>😎</h2>
        </div>
    );
}

export default NavBar;
