import React, { useState, useEffect } from 'react';

export default function AccountPage(props) {
    const [edit, setEdit] = useState(false);
    const [person, setPerson] = useState(-1);
    const [name, setName] = useState(person.name);
    const [address, setAddress] = useState(-1);
    const [city, setCity] = useState(-1);
    const [email, setEmail] = useState(-1);

    const fetchData = async () => {
        //Hardcoded as person with an ID of 1 until log in features are added
        const result = await fetch('http://localhost:8082/api/person/1');
        if (!result.ok) {
            throw new Error('Data coud not be fetched!');
        } else {
            return result.json();
        }
    };

    function addChangeRequest(name, address, city, email) {
        const newChangeRequest = JSON.stringify({
            name: name,
            address: address,
            city: city,
            email: email,
        });
        setName('');
        fetch(`http://localhost:8082/api/changerequest/new/${person.id}`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
                Authorization:
                    'Basic ' + btoa(props.email + ':' + props.password),
            },
            body: newChangeRequest,
        }).then(() => props.update());
    }

    useEffect(() => {
        fetchData()
            .then((result) => {
                setPerson(result);
                setName(result.name);
                setAddress(result.address);
                setCity(result.city);
                setEmail(result.user.email);
            })
            .catch((e) => {
                console.log(e.message);
            });
    }, []);

    if (person.user != null) {
        if (edit) {
            return (
                <div className="accountPage">
                    <div className="account bordered">
                        <form
                            onSubmit={(e) => {
                                addChangeRequest(name, address, city, email);
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
                            <br />
                            <label htmlFor="email">E-mail: </label>
                            <input
                                id="email"
                                name="email"
                                type="email"
                                onChange={(e) => setEmail(e.target.value)}
                                value={email}
                            />
                            <br />
                        </form>
                    </div>
                </div>
            );
        } else {
            return (
                <div className="accountPage">
                    <div className="account bordered">
                        <button
                            className="edit bordered"
                            onClick={() => setEdit(true)}
                        >
                            ✎
                        </button>

                        <h2>{person.name}</h2>
                        <br />
                        <p>{person.address}</p>
                        <br />
                        <p>{person.city}</p>
                        <br />
                        <p>{person.user.email}</p>
                        <br />
                    </div>
                </div>
            );
        }
    } else {
        return (
            <div className="accountPage">
                <div className="account">No account found</div>
            </div>
        );
    }
}
