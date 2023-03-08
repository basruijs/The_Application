import React, { Component } from "react";

function Person(props) {
  

    console.log("hij doet het")
    return (
        <div>
            <div>{props.name}</div>
        </div>
    )
  }
  
  export default Person