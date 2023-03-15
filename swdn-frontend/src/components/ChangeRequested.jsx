import React, { useState, useEffect } from 'react';

export default function ChangeRequested(props) {
    const [request, setRequest] = useState({
        name: 'Dummy Name',
        address: 'Dummy Address',
        city: 'Dummy City',
    });

    useEffect(() => {
        getRequest();
    }, [props.personid]);

    function getRequest() {
        fetch(
            `http://localhost:8082/api/changerequest/byperson/${props.personid}`,
            {
                headers: {
                    Authorization:
                        'Basic ' + btoa(props.email + ':' + props.password),
                },
            }
        ).then((response) => {
            console.log(response);
            if (response) {
                response.json().then((data) => {
                    console.log(data);
                    setRequest(data);
                });
            } else {
                setRequest(null);
            }
        });
    }

    function deleteRequest() {
        fetch(`http://localhost:8082/api/changerequest/delete/${request.id}`, {
            method: 'DELETE',
            headers: {
                Authorization:
                    'Basic ' + btoa(props.email + ':' + props.password),
            },
        }).then(() => getRequest());
    }

    if (request.id) {
        return (
            <div className="changerequest bordered">
                <h2>Change Requested</h2>
                <br />
                <h3>{request.name}</h3>
                <p>{request.address}</p>
                <p>{request.city}</p>
                <br />
                <span>
                    <button
                        onClick={() => {
                            props.changeNAW(
                                request.name,
                                request.address,
                                request.city
                            );
                            deleteRequest();
                        }}
                    >
                        Approve
                    </button>
                    <button onClick={() => deleteRequest()}>Deny</button>
                </span>
            </div>
        );
    } else {
        return (
            <div className="changerequest bordered">
                <h2>No Change Requested</h2>
            </div>
        );
    }
}
