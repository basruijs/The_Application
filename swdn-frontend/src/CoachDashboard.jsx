import React, { useState, useEffect } from 'react';
import List from './components/List';
import SkillOverview from './components/SkillOverview';
import NewSkill from './components/NewSkill';
import NewMeeting from './components/NewMeeting';
import Meetings from './components/Meetings';

export default function CoachDashboard(props) {
    const [skills, setSkills] = useState([]);
    const [skill, setSkill] = useState(-1);
    const [viewerMeetings, setViewerMeetings] = useState([]);
    const [traineeMeetings, setTraineeMeetings] = useState([]);

    const fetchData = async () => {
        const result = await fetch(
            `http://localhost:8082/api/person/gettrainees/${props.person.id}`,
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

    const fetchSkills = async () => {
        const result = await fetch(
            `http://localhost:8082/api/skill/${props.trainee}/all`,
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

    const fetchTraineeMeetings = async () => {
        const result = await fetch(
            `http://localhost:8082/api/evaluation/trainee/${props.trainee}/future`,
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

    const fetchViewerMeetings = async () => {
        const result = await fetch(
            `http://localhost:8082/api/evaluation/evaluator/${props.person.id}/future`,
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

    useEffect(() => {
        fetchData()
            .then((result) => {
                props.setTrainees(result);
            })
            .catch((e) => {
                console.log(e.message);
            });
    }, []);

    useEffect(() => {
        if (props.trainee > 0) {
            fetchSkills()
                .then((result) => {
                    setSkills(result);
                })
                .catch((e) => {
                    console.log(e.message);
                });
        }
    }, [props.trainee]);

    useEffect(() => {
        if (props.trainee > 0) {
            fetchViewerMeetings()
                .then((result) => {
                    setViewerMeetings(result);
                })
                .catch((e) => {
                    console.log(e.message);
                });
        }
    }, [props.trainee]);

    useEffect(() => {
        if (props.trainee > 0) {
            fetchTraineeMeetings()
                .then((result) => {
                    setTraineeMeetings(result);
                })
                .catch((e) => {
                    console.log(e.message);
                });
        }
    }, [props.trainee]);

    return (
        <div className="dashboard">
            <List
                content={props.trainees}
                selected={props.trainee}
                select={props.setTrainee}
                title="Trainees"
            />
            <List
                content={skills.sort((a, b) => a.completed - b.completed)}
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
                editable={true}
                email={props.email}
                password={props.password}
            />
            <div className="sidebar">
                <NewSkill
                    person={props.trainee}
                    update={() => {
                        fetchSkills()
                            .then((result) => {
                                setSkills(result);
                            })
                            .catch((e) => {
                                console.log(e.message);
                            });
                    }}
                    email={props.email}
                    password={props.password}
                    skills={skills}
                    templates={props.templates}
                    template={props.template}
                    setTemplate={props.setTemplate}
                />
                <NewMeeting
                    evaluator={props.person.id}
                    trainee={props.trainee}
                    evaluatorMeetings={viewerMeetings}
                    traineeMeetings={traineeMeetings}
                    update={() => {
                        fetchTraineeMeetings()
                            .then((result) => {
                                setTraineeMeetings(result);
                            })
                            .catch((e) => {
                                console.log(e.message);
                            });
                        fetchViewerMeetings()
                            .then((result) => {
                                setViewerMeetings(result);
                            })
                            .catch((e) => {
                                console.log(e.message);
                            });
                    }}
                    email={props.email}
                    password={props.password}
                />
                <Meetings
                    meetings={viewerMeetings}
                    isTrainee={false}
                />
            </div>
        </div>
    );
}
