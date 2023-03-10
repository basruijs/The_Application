import React, { useState, useEffect } from 'react';
import NavBar from './components/NavBar';
import ListItem from './components/ListItem';
import List from './components/List';
import SkillOverview from './components/SkillOverview';
import NewSkill from './components/NewSkill';
import NewMeeting from './components/NewMeeting';

export default function CoachDashboard() {
    const [viewer, setViewer] = useState(-1);
    const [people, setPeople] = useState([]);
    const [person, setPerson] = useState(-1);
    const [skills, setSkills] = useState([]);
    const [skill, setSkill] = useState(-1);
    const [meetings, setMeetings] = useState([]);

    const fetchViewer = async () => {
        //Hardcoded as person with an ID of 1 until log in features are added
        const result = await fetch('http://localhost:8082/api/person/1');
        if (!result.ok) {
            throw new Error('Data coud not be fetched!');
        } else {
            return result.json();
        }
    };

    const fetchData = async () => {
        const result = await fetch(
            'http://localhost:8082/api/role/trainee/all'
        );
        if (!result.ok) {
            throw new Error('Data coud not be fetched!');
        } else {
            return result.json();
        }
    };

    const fetchSkills = async () => {
        const result = await fetch(
            `http://localhost:8082/api/skill/${person}/all`
        );
        if (!result.ok) {
            throw new Error('Data coud not be fetched!');
        } else {
            return result.json();
        }
    };

    const fetchMeetings = async () => {
        const result = await fetch(
            `http://localhost:8082/api/evaluation/${person}/trainee/all`
        );
        if (!result.ok) {
            throw new Error('Data coud not be fetched!');
        } else {
            return result.json();
        }
    };

    useEffect(() => {
        fetchViewer()
            .then((result) => {
                setViewer(result);
            })
            .catch((e) => {
                console.log(e.message);
            });
    }, []);

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

    useEffect(() => {
        if (person > 0) {
            fetchMeetings()
                .then((result) => {
                    setMeetings(result);
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
                title="Trainees"
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
            />
            <div className="sidebar">
                <NewSkill
                    person={person}
                    update={() => {
                        fetchSkills()
                            .then((result) => {
                                setSkills(result);
                            })
                            .catch((e) => {
                                console.log(e.message);
                            });
                    }}
                />
                <NewMeeting
                    evaluator={viewer.id}
                    trainee={person}
                    update={() => {
                        fetchMeetings()
                            .then((result) => {
                                setMeetings(result);
                            })
                            .catch((e) => {
                                console.log(e.message);
                            });
                    }}
                />
            </div>
        </div>
    );
}
