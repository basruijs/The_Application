import React from 'react';

export default function SkillData(props) {
    return (
        <div className="skillOverview bordered">
            {props.editable ? (
                <button
                    className="edit bordered"
                    onClick={() => props.setEdit(true)}
                >
                    ✎
                </button>
            ) : (
                <></>
            )}
            <h2>
                {props.skill.name}
                <i className="hardsoftskill">
                    {props.skill.hardSkill ? ' Hard skill' : ' Soft skill'}
                </i>
            </h2>
            <div className="info-flex">
                <span className="icon">
                    {props.skill.completed ? '✓' : '✘'}
                </span>
                <span>
                    {props.skill.completed ? 'Completed' : 'Not completed'}
                </span>
            </div>
            <div className="info-flex">
                <span className="icon">🗎</span>
                {props.skill.certificate ? (
                    <a
                        href={`http://localhost:8082/api/skill/certificate/${props.skill.id}`}
                        download={props.skill.certificate.fileName}
                    >
                        {props.skill.certificate.fileName}
                    </a>
                ) : (
                    <span>No certificate</span>
                )}
            </div>
            <p>{props.skill.report}</p>
        </div>
    );
}
