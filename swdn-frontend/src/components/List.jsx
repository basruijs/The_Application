import React from 'react';
import ListItem from './ListItem';

function List(props) {
    return (
        <div className="listWrapper">
            <h3>{props.title}</h3>

            <div className="list">
                {props.content.map((item) => (
                    <ListItem
                        name={item.name}
                        id={item.id}
                        key={item.id}
                        selected={props.selected}
                        select={props.select}
                    />
                ))}
            </div>
        </div>
    );
}

export default List;
