import React, { useState } from 'react';

function FeedbackRequest(props) {
    const [email, setEmail] = useState('');
<<<<<<< Updated upstream
=======
    const [query, setQuery] = useState('');
    const [people, setPeople] = useState([]);
>>>>>>> Stashed changes

    function addInvitation(email) {
        const currentDate = new Date();
        const newInvitation = JSON.stringify({
            email: email,
            sendDate: currentDate,
        });
        setEmail('');
        fetch(`http://localhost:8082/api/invitation/new/${props.person}`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
                Authorization:
                    'Basic ' + btoa(props.email + ':' + props.password),
            },
            body: newInvitation,
        }).then((response) => {
            if (!response.ok) {
                alert('Email not found');
            }
        });
    }

    return (
        <div className="feedbackRequest bordered">
            <h2>Ask for 360 feedback</h2>
            <form
                onSubmit={(e) => {
                    addInvitation(email);
                    e.preventDefault();
                }}
            >
                <label htmlFor="email">email: </label>
                <input
                    type="email"
                    name="email"
                    id="email"
                    value={email}
                    required
                    maxLength={100}
                    onChange={(e) => setEmail(e.target.value)}
                ></input>
                <input type="submit"></input>
            </form>
        </div>
    );
}

export default FeedbackRequest;
