import React from 'react';

export default function NawData(props) {
    return (
        <div className="naw bordered">
            <button
                className="edit bordered"
                onClick={() => setEdit(true)}
            >
                ✎
            </button>
            <h3>Dummy Name</h3>
            <br />
            <p>Dummy Address</p>
            <br />
            <p>Dummy City</p>
        </div>
    );
}
