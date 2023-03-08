import React, { Component } from "react";

function Person(props) {
  
    return (
        <div className="person">
            {props.name}
        </div>
    )
  }
  
  export default Person