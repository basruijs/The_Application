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
                {props.name}
                <i className="hardsoftskill">
                    {props.hardSkill ? ' Hard skill' : ' Soft skill'}
                </i>
            </h2>
            <div className="info-flex">
                <span className="icon">{props.completed ? '✓' : '✘'}</span>
                <span>{props.completed ? 'Completed' : 'Not completed'}</span>
            </div>
            <div className="info-flex">
                <span className="icon">🗎</span>
                {props.certificate ? (
                    <a
                        href={`http://localhost:8082/api/skill/certificate/${props.skill.id}`}
                        download={props.certificate.name}
                    >
                        {props.certificate.name}
                    </a>
                ) : (
                    <span>No certificate</span>
                )}
            </div>
            <p>{props.report}</p>
        </div>
    );
}
