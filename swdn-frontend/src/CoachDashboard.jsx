function CoachDashboard() {

    async function getAllPeople() {
        const result = await fetch("http://localhost:8082/api/person/all");
        const data = await result.json();
        return data;
        }



    function getAllPeople(){
        console.log(data)
    }
  
    return (
        <div>
            <button onClick={getAllPeople()}>Click for all people</button>
        </div>
    )
  }
  
  export default CoachDashboard