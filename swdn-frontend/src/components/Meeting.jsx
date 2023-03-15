import React from 'react';

function Meeting(props) {
    let person;
    if (props.isTrainee) {
        person = props.trainee;
    } else {
        person = props.evaluator;
    }
    return (
        <div className="meeting">
            at {props.date}, {props.time} with {person} <br />
            Duration: {props.duration}
        </div>
    );
}

export default Meeting;
