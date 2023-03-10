import React from 'react';

export default function ChangeRequested(props) {
    return (
        <div className="changerequest bordered">
            <h2>Change Requested</h2>
            <br />
            <h3>Dummy Name</h3>
            <p>Dummy Address</p>
            <p>Dummy City</p>
            <br />
            <span>
                <button>Approve</button>
                <button>Deny</button>
            </span>
        </div>
    );
}
