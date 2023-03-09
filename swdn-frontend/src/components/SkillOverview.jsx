import React, { useState } from 'react';
function SkillOverview(props) {
    if (props.skill) {
        const [name, setName] = useState(props.skill.name);
        const [hardSkill, setHardSkill] = useState(props.skill.hardSkill);
        const [completed, setCompleted] = useState(props.skill.completed);
        const [certificate, setCertificate] = useState(props.skill.certificate);
        const [report, setReport] = useState(props.skill.report);
        const [edit, setEdit] = useState(false);

        function sendChanges() {
            const newSkill = JSON.stringify({
                name: name,
                hardSkill: hardSkill,
                completed: completed,
                certificate: certificate,
                report: report,
            });
            fetch(`http://localhost:8082/api/skill/${props.skill.id}`, {
                method: 'PUT',
                headers: { 'Content-Type': 'application/json' },
                body: newSkill,
            }).then(() => props.update());
        }

        if (edit) {
            return (
                <form
                    className="skillOverview bordered"
                    onSubmit={(e) => {
                        sendChanges();
                        setEdit(false);
                        e.preventDefault();
                    }}
                >
                    <input
                        type="submit"
                        className="edit bordered"
                        value="✓"
                    />
                    <h2>
                        <input
                            type="text"
                            value={name}
                            onChange={(e) => setName(e.target.value)}
                            required
                            maxLength={100}
                        />
                        <div>
                            <input
                                type="radio"
                                name="skill-hardness"
                                id="hard"
                                value={true}
                                checked={hardSkill}
                                onChange={(e) => setHardSkill(true)}
                            />
                            <label
                                htmlFor="hard"
                                className="hardsoftskill"
                            >
                                Hard Skill
                            </label>
                            <br />
                            <input
                                type="radio"
                                name="skill-hardness"
                                id="soft"
                                value={false}
                                checked={!hardSkill}
                                onChange={(e) => setHardSkill(false)}
                            />
                            <label
                                htmlFor="soft"
                                className="hardsoftskill"
                            >
                                Soft Skill
                            </label>
                        </div>
                    </h2>
                    <div className="info-flex">
                        <button
                            className="icon"
                            onClick={(e) => {
                                setCompleted(!completed);
                                e.preventDefault();
                            }}
                        >
                            {completed ? '✓' : '✘'}
                        </button>
                        <span>{completed ? 'Completed' : 'Not completed'}</span>
                    </div>
                    <div className="info-flex">
                        <span className="icon">🗎</span>

                        <input
                            type="file"
                            name="certificate"
                            id="certificate"
                            files={[certificate]}
                            onChange={(e) => {
                                setCertificate(e.target.files[0]);
                                console.log(e.target.files[0]);
                            }}
                        />
                    </div>
                    <textarea
                        name="report"
                        id="report"
                        cols="60"
                        rows="10"
                        value={report}
                        onChange={(e) => setReport(e.target.value)}
                        maxLength={600}
                    ></textarea>
                </form>
            );
        } else {
            return (
                <div className="skillOverview bordered">
                    <button
                        className="edit bordered"
                        onClick={() => setEdit(true)}
                    >
                        ✎
                    </button>
                    <h2>
                        {name}
                        <i className="hardsoftskill">
                            {hardSkill ? ' Hard skill' : ' Soft skill'}
                        </i>
                    </h2>
                    <div className="info-flex">
                        <span className="icon">{completed ? '✓' : '✘'}</span>
                        <span>{completed ? 'Completed' : 'Not completed'}</span>
                    </div>
                    <div className="info-flex">
                        <span className="icon">🗎</span>
                        <span>
                            {certificate ? certificate.name : 'No certificate'}
                        </span>
                    </div>
                    <p>{report}</p>
                </div>
            );
        }
    } else {
        return <div className="skillOverview bordered">None selected</div>;
    }
}
export default SkillOverview;
