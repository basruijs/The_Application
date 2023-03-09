import React, { useState, useEffect } from 'react';
import NavBar from './components/NavBar';
import ListItem from './components/ListItem';
import List from './components/List';
import SkillOverview from './components/SkillOverview';

export default function CoachDashboard() {
    const [people, setPeople] = useState([]);
    const [person, setPerson] = useState(-1);
    const [skills, setSkills] = useState([
        { name: 'Skill 1', id: 1 },
        { name: 'Skill 2', id: 2 },
    ]);
    const [skill, setSkill] = useState(-1);

    const fetchData = async () => {
        const result = await fetch('http://localhost:8082/api/person/all');
        if (!result.ok) {
            throw new Error('Data coud not be fetched!');
        } else {
            return result.json();
        }
    };

    useEffect(() => {
        fetchData()
            .then((result) => {
                setPeople(result);
            })
            .catch((e) => {
                console.log(e.message);
            });
    }, []);
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
            <SkillOverview skill={skills.find((x) => x.id === skill)} />
        </div>
    );
}
