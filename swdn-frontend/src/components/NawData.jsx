import React, { useEffect, useState } from 'react';

export default function NawData(props) {
    const [person, setPerson] = useState({
        name: 'Dummy Name',
        address: 'Dummy Address',
        city: 'Dummy City',
    });
    const [edit, setEdit] = useState(false);
    const [name, setName] = useState(person.name);
    const [address, setAddress] = useState(person.address);
    const [city, setCity] = useState(person.city);

    useEffect(() => {
        fetch(`http://localhost:8082/api/person/${props.personid}`, {
            headers: {
                Authorization:
                    'Basic ' + btoa(props.email + ':' + props.password),
            },
        })
            .then((response) => response.json())
            .then((data) => {
                setPerson(data);
                setName(data.name);
                setAddress(data.address);
                setCity(data.city);
            });
    }, [props.personid]);

    if (edit) {
        return (
            <form
                className="naw bordered"
                onSubmit={(e) => {
                    props.changeNAW(name, address, city);
                    setEdit(false);
                    e.preventDefault();
                }}
            >
                <input
                    type="submit"
                    className="edit bordered"
                    value="✓"
                />
                <label htmlFor="name">Name: </label>
                <input
                    id="name"
                    name="name"
                    type="text"
                    onChange={(e) => setName(e.target.value)}
                    value={name}
                />
                <br />
                <label htmlFor="address">address: </label>
                <input
                    id="address"
                    name="address"
                    type="text"
                    onChange={(e) => setAddress(e.target.value)}
                    value={address}
                />
                <br />
                <label htmlFor="city">city: </label>
                <input
                    id="city"
                    name="city"
                    type="city"
                    onChange={(e) => setCity(e.target.value)}
                    value={city}
                />
            </form>
        );
    } else {
        return (
            <div className="naw bordered">
                <button
                    className="edit bordered"
                    onClick={() => setEdit(true)}
                >
                    ✎
                </button>
                <h3>{name}</h3>
                <br />
                <p>{address}</p>
                <br />
                <p>{city}</p>
            </div>
        );
    }
}
