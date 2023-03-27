import React, { useState } from 'react';

export default function RestoreAccount(props) {
    const [email, setEmail] = useState('');

    function restorePerson() {
        fetch(`http://localhost:8082/api/user/restore`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
                Authorization:
                    'Basic ' + btoa(props.email + ':' + props.password),
            },
            body: email,
        }).then(() => props.update());
        setEmail('');
    }

    return (
        <form
            className="restoreAccount bordered"
            onSubmit={(e) => {
                restorePerson(email);
                e.preventDefault();
            }}
        >
            Restore Account &nbsp;
            <input
                type="email"
                name="email"
                id="email"
                required
                value={email}
                onChange={(e) => setEmail(e.target.value)}
            ></input>
            &nbsp;
            <input
                type="submit"
                value={'Restore'}
            ></input>
        </form>
    );
}
