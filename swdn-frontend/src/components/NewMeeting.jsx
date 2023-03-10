import React, { useState } from 'react';

function NewMeeting(props) {
    const [date, setDate] = useState();
    const [time, setTime] = useState();
    const [duration, setDuration] = useState();

    function addMeeting(date, time, duration) {
        if (props.trainee == -1) {
            alert('No trainee selected!');
        } else {
            const newMeeting = JSON.stringify({
                date: date,
                time: time,
                duration: duration,
            });
            setDate();
            setTime();
            setDuration();
            fetch(
                `http://localhost:8082/api/evaluation/new/${props.evaluator}/${props.trainee}`,
                {
                    method: 'POST',
                    headers: { 'Content-Type': 'application/json' },
                    body: newMeeting,
                }
            ).then(() => props.update());
        }
    }

    return (
        <div className="newMeeting bordered">
            <h2>Plan evaluation meeting</h2>
            <form
                onSubmit={(e) => {
                    addMeeting(date, time, duration);
                    e.preventDefault();
                }}
            >
                <label for="date">Date: </label>
                <input
                    type="date"
                    name="date"
                    id="date"
                    required
                    onChange={(e) => setDate(e.target.value)}
                />
                <br />
                <label for="time">Time: </label>
                <input
                    type="time"
                    name="time"
                    id="time"
                    required
                    onChange={(e) => setTime(e.target.value)}
                />
                <br />
                <label for="duration">Duration: </label>
                <input
                    type="time"
                    name="duration"
                    id="duration"
                    required
                    onChange={(e) => setDuration(e.target.value)}
                />
                <br />
                <input
                    type="submit"
                    value="Plan meeting"
                />
            </form>
        </div>
    );
}

export default NewMeeting;
