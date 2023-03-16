import React, { useState, useEffect } from 'react';
import List from './components/List';

export default function FeedbackPage(props) {
    const [allGiven, setAllGiven] = useState([]);
    const [allRequested, setAllRequested] = useState([]);

    const [given, setGiven] = useState(-1);
    const [requested, setRequested] = useState(-1);

    const [givers, setGivers] = useState([]);
    const [requesters, setRequesters] = useState([]);

    const [giver, setGiver] = useState(-1);
    const [requester, setRequester] = useState(-1);

    const fetchFeedbackRequested = async () => {
        const result = await fetch(
            `http://localhost:8082/api/invitation/requesters/${props.person.id}`,
            {
                headers: {
                    Authorization:
                        'Basic ' + btoa(props.email + ':' + props.password),
                },
            }
        );
        if (!result.ok) {
            throw new Error('Data coud not be fetched!');
        } else {
            const data = await result.json();
            console.log(data);
            return data;
        }
    };
    const fetchFeedbackGiven = async () => {
        console.log(props.person.id);
        const result = await fetch(
            `http://localhost:8082/api/invitation/givers/${props.person.id}`,
            {
                headers: {
                    Authorization:
                        'Basic ' + btoa(props.email + ':' + props.password),
                },
            }
        );
        if (!result.ok) {
            throw new Error('Data coud not be fetched!');
        } else {
            const data = await result.json();
            console.log(data);
            return data;
        }
    };

    useEffect(() => {
        fetchFeedbackGiven()
            .then((result) => {
                setAllGiven(result);
                console.log(result);
            })
            .catch((e) => {
                console.log(e.message);
            });
    }, []);

    useEffect(() => {
        fetchFeedbackRequested()
            .then((result) => {
                setAllRequested(result);
                console.log(result);
            })
            .catch((e) => {
                console.log(e.message);
            });
    }, []);

    return (
        <div className="feedbackPage">
            <List
                content={allRequested}
                selected={requested}
                select={setRequested}
                title="Requested feedback"
            />
            <List
                content={allGiven}
                selected={given}
                select={setGiven}
                title="Received feedback"
            />
        </div>
    );
}
