import React from 'react';
import { NavLink } from 'react-router-dom';

function NavBar(props) {
    return (
        <div className="navBar bordered">
            <h2>{props.person.name || ''}</h2>
            <nav>
                <NavLink
                    to="/login"
                    className="navButton"
                >
                    Login
                </NavLink>
                {props.person.role.name === 'HR' ? (
                    <NavLink
                        to="/hr"
                        className="navButton"
                    >
                        Dashboard
                    </NavLink>
                ) : (
                    ''
                )}
                {props.person.role.name === 'COACH' ? (
                    <NavLink
                        to="/coach"
                        className="navButton"
                    >
                        Dashboard
                    </NavLink>
                ) : (
                    ''
                )}
            </nav>
            <h2>😎</h2>
        </div>
    );
}

export default NavBar;
