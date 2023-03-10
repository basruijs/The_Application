import React from 'react';

function Meeting(props) {
    return (
        <div className="meeting">
            at {props.date}, {props.time} with {props.person} <br />
            Duration: {props.duration}
        </div>
    );
}

export default Meeting;
