import React, { useEffect, useState } from 'react';

export default function SkillEditor(props) {
    return (
        <div className="feedbackOverview bordered">
            <input
                type="submit"
                className="edit bordered"
                value="✓"
            />
            <h2>{props.feedback.name}</h2>
            <p>{props.feedback.sendDate}</p>
            <div className="info-flex">
                <form action="">
                    <textarea className="feedbackInputBox"></textarea>
                </form>
            </div>
        </div>
    );
}
