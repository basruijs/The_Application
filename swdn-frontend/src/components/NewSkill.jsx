import React, { useState } from 'react';

function NewSkill(props) {
    const [name, setName] = useState('');
    const [hardSkill, setHardSkill] = useState(true);

    function addSkill(name, hardness) {
        const newSkill = JSON.stringify({ name: name, hardSkill: hardness });
        if (!name.replace(/\s/g, '').length) {
        } else {
            fetch(`http://localhost:8082/api/skill/new/${props.person}`, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                    Authorization:
                        'Basic ' + btoa(props.email + ':' + props.password),
                },
                body: newSkill,
            }).then(() => props.update());
        }
        setName('');
        setHardSkill(true);
    }

    return (
        <div className="newSkill bordered">
            <h2>Add new Skill</h2>
            <form
                onSubmit={(e) => {
                    addSkill(name, hardSkill);
                    e.preventDefault();
                }}
            >
                <input
                    type="text"
                    name="skillname"
                    id="skillname"
                    required
                    maxLength={100}
                    value={name}
                    onChange={(e) => setName(e.target.value)}
                />
                <br />
                <input
                    type="radio"
                    name="skill-hardness"
                    id="hard"
                    value={true}
                    checked={hardSkill}
                    onChange={(e) => setHardSkill(true)}
                />
                <label htmlFor="hard">Hard Skill</label>
                <br />
                <input
                    type="radio"
                    name="skill-hardness"
                    id="soft"
                    value={false}
                    checked={!hardSkill}
                    onChange={(e) => setHardSkill(false)}
                />
                <label htmlFor="soft">Soft Skill</label>
                <br />
                <input
                    type="submit"
                    value="Add Skill"
                />
            </form>
        </div>
    );
}

export default NewSkill;
