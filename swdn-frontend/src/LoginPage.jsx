import React, { useState } from 'react';

export default function LoginPage(props) {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');

    function checkCredentials() {
        const loginCredentials = JSON.stringify({
            email: email,
            password: password,
        });

        fetch(`http://localhost:8082/api/user/login`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: loginCredentials,
        }).then(
            (response) => {
                if (response.ok) {
                    props.setEmail(email);
                    props.setPassword(password);
                    response.json().then((data) => {
                        props.setPerson(data);
                    });
                } else {
                    alert('Incorrect username or password.');
                }
            },
            () => {
                alert('Server is currently unavailable, try again later');
            }
        );
    }

    return (
        <div>
            <div className="title">
                <h1>XXXX Coaching App</h1>
            </div>
            <form
                className="login-wrapper"
                onSubmit={(e) => {
                    checkCredentials();
                    e.preventDefault();
                }}
            >
                <h2>Login</h2>
                <input
                    type="email"
                    name="email"
                    id="email"
                    required
                    value={email}
                    onChange={(e) => setEmail(e.target.value)}
                />
                <input
                    type="password"
                    name="password"
                    id="password"
                    required
                    value={password}
                    onChange={(e) => setPassword(e.target.value)}
                />
                <input
                    type="submit"
                    value="Log in"
                />
            </form>
        </div>
    );
}
