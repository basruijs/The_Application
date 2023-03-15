import React, { useEffect, useState } from 'react';

export default function NawData(props) {
    const [person, setPerson] = useState({
        name: 'Dummy Name',
        address: 'Dummy Address',
        city: 'Dummy City',
    });

    useEffect(() => {
        fetch(`http://localhost:8082/api/person/${props.personid}`, {
            headers: {
                Authorization:
                    'Basic ' + btoa(props.email + ':' + props.password),
            },
        })
            .then((response) => response.json())
            .then((data) => setPerson(data));
    }, [props.personid]);

    return (
        <div className="naw bordered">
            <button
                className="edit bordered"
                onClick={() => setEdit(true)}
            >
                ✎
            </button>
            <h3>{person.name}</h3>
            <br />
            <p>{person.address}</p>
            <br />
            <p>{person.city}</p>
        </div>
    );
}
