import React from 'react';

function ListItem(props) {
    return (
        <button
            className={
                props.selected == props.id
                    ? 'listItem bordered selected'
                    : 'listItem bordered'
            }
            onClick={() => props.select(props.id)}
        >
            {props.name}
        </button>
    );
}

export default ListItem;
