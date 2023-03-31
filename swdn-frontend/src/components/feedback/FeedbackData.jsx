import React from 'react';

export default function FeedbackData(props) {
    return (
        <div className="feedbackOverview bordered">
            {props.editable ? (
                <button
                    className="feedbackEditButton bordered"
                    onClick={() => props.setEdit(true)}
                >
                    ✎
                </button>
            ) : (
                <></>
            )}
            <h2>{props.feedback.name}</h2>
            <p>{props.feedback.sendDate}</p>
            <div className="info-flex text">{props.feedback.feedback}</div>
        </div>
    );
}
