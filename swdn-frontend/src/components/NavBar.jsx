import React from 'react';
import { NavLink } from 'react-router-dom';

function NavBar(props) {
    return (
        <div className="navBar bordered">
            <h2 className="nav-centering-left">{props.person.name || ''}</h2>
            <nav>
                {props.person.role.name === 'Not Logged In' ? (
                    <NavLink
                        to="/login"
                        className="navButton"
                    >
                        Login
                    </NavLink>
                ) : (
                    <>
                        <a
                            href="/login"
                            className="navButton"
                        >
                            Log out
                        </a>
                        <NavLink
                            to="/account"
                            className="navButton"
                        >
                            Account
                        </NavLink>
                    </>
                )}

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
                {props.person.role.name === 'MANAGER' ? (
                    <NavLink
                        to="/manager"
                        className="navButton"
                    >
                        Dashboard
                    </NavLink>
                ) : (
                    ''
                )}
                {props.person.role.name === 'TRAINEE' ? (
                    <NavLink
                        to="/trainee"
                        className="navButton"
                    >
                        Dashboard
                    </NavLink>
                ) : (
                    ''
                )}

                {props.person.role.name === 'TRAINEE' ? (
                    <NavLink
                        to="/feedback"
                        className="navButton"
                    >
                        Feedback
                    </NavLink>
                ) : (
                    ''
                )}
            </nav>
            <h2 className="nav-centering-right">😎</h2>
        </div>
    );
}

export default NavBar;
