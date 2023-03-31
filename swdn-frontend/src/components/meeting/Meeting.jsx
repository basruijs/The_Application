import React from 'react';

function Meeting(props) {
    let person;
    if (props.isTrainee) {
        person = props.evaluator;
    } else {
        person = props.trainee;
    }
    return (
        <div className="meeting">
            at {props.date}, {props.time} with {person} <br />
            Duration: {props.duration}
        </div>
    );
}

export default Meeting;
