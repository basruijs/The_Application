function CoachDashboard() {

    async function getAllPeople() {
        const result = await fetch("http://localhost:8082/api/person/all");
        await result.json().then(data=>console.log(data));
        return data;
    }

  
    return (
        <div>
            <button onClick={()=> getAllPeople()}>Click for all people</button>
        </div>
    )
  }
  
  export default CoachDashboard