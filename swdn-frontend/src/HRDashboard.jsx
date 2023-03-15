import React, { useState, useEffect } from 'react';
import List from './components/List';
import SkillOverview from './components/SkillOverview';
import NewSkill from './components/NewSkill';
import NawData from './components/NawData';
import ChangeRequested from './components/ChangeRequested';
import NewPerson from './components/NewPerson';

export default function HRDashboard(props) {
    const [people, setPeople] = useState([]);
    const [person, setPerson] = useState(1);
    const [skills, setSkills] = useState([]);
    const [skill, setSkill] = useState(-1);

    const fetchData = async () => {
        const result = await fetch('http://localhost:8082/api/person/all', {
            headers: {
                Authorization:
                    'Basic ' + btoa(props.email + ':' + props.password),
            },
        });
        if (!result.ok) {
            throw new Error('Data coud not be fetched!');
        } else {
            return result.json();
        }
    };

    const fetchSkills = async () => {
        const result = await fetch(
            `http://localhost:8082/api/skill/${person}/all`,
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
            return result.json();
        }
    };

    function changeNAW(name, address, city) {
        const newNAW = JSON.stringify({
            name: name,
            address: address,
            city: city,
        });

        fetch(`http://localhost:8082/api/person/update/${person}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
                Authorization:
                    'Basic ' + btoa(props.email + ':' + props.password),
            },
            body: newNAW,
        }).then(() => {
            fetchData()
                .then((result) => {
                    setPeople(result);
                })
                .catch((e) => {
                    console.log(e.message);
                });
        });
    }

    useEffect(() => {
        fetchData()
            .then((result) => {
                setPeople(result);
            })
            .catch((e) => {
                console.log(e.message);
            });
    }, []);

    useEffect(() => {
        if (person > 0) {
            fetchSkills()
                .then((result) => {
                    setSkills(result);
                })
                .catch((e) => {
                    console.log(e.message);
                });
        }
    }, [person]);

    return (
        <div className="dashboard">
            <List
                content={people}
                selected={person}
                select={setPerson}
                title="People"
            />
            <List
                content={skills}
                selected={skill}
                select={setSkill}
                title="Skills"
            />
            <SkillOverview
                skill={skills.find((x) => x.id === skill)}
                update={() => {
                    fetchSkills()
                        .then((result) => {
                            setSkills(result);
                        })
                        .catch((e) => {
                            console.log(e.message);
                        });
                }}
                editable={false}
                email={props.email}
                password={props.password}
            />
            <div className="sidebar">
                <NawData
                    person={people.find((x) => x.id === person)}
                    email={props.email}
                    password={props.password}
                    changeNAW={changeNAW}
                />
                <ChangeRequested
                    personid={person}
                    email={props.email}
                    password={props.password}
                    changeNAW={changeNAW}
                />
                <NewPerson
                    update={() => {
                        fetchData()
                            .then((result) => {
                                setPeople(result);
                            })
                            .catch((e) => {
                                console.log(e.message);
                            });
                    }}
                    email={props.email}
                    password={props.password}
                />
            </div>
        </div>
    );
}
