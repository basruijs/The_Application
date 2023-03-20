import React from 'react';
import Meeting from './Meeting';

function Meetings(props) {
    function sortMeetings() {
        // const currentDate = new Date();
        // let date = currentDate.getFullYear() + '-';
        // if (currentDate.getMonth() < 10) {
        //     date += '0';
        // }
        // date += currentDate.getMonth() + 1 + '-' + currentDate.getDate();
        // let time = '';
        // if (currentDate.getHours() < 10) {
        //     time += '0';
        // }
        // time += currentDate.getHours() + ':';
        // if (currentDate.getMinutes() < 10) {
        //     time += '0';
        // }
        // time += currentDate.getMinutes();

        const meetings = props.meetings;

        meetings.sort((a, b) =>
            a.time > b.time ? 1 : b.time > a.time ? -1 : 0
        );
        meetings.sort((a, b) =>
            a.date > b.date ? 1 : b.date > a.date ? -1 : 0
        );

        // for (let index = 0; index < meetings.length; index++) {
        //     const meeting = meetings[index];
        //     if (date >= meeting.date) {
        //         if (time >= meeting.time) {
        //             meetings.splice(index, 1);
        //         }
        //     }
        // }

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
