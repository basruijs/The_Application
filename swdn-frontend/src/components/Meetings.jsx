import React from 'react';
import Meeting from './Meeting';

function Meetings(props) {
    function sortMeetings() {
        const meetings = props.meetings;
        meetings.sort((a, b) =>
            a.time > b.time ? 1 : b.time > a.time ? -1 : 0
        );
        meetings.sort((a, b) =>
            a.date > b.date ? 1 : b.date > a.date ? -1 : 0
        );
        return meetings;
    }

    return (
        <div className="meetings bordered">
            <h2>Meetings:</h2>
            <div className="meetingsList">
                {sortMeetings().map((meeting, index) => (
                    <Meeting
                        date={meeting.date}
                        trainee={meeting.trainee.name}
                        evaluator={meeting.evaluator.name}
                        time={meeting.time}
                        duration={meeting.duration}
                        key={meeting.id}
                        isTrainee={props.isTrainee}
                    />
                ))}
            </div>
        </div>
    );
}

export default Meetings;
