import { useState } from 'react'
import reactLogo from './assets/react.svg'
import './App.css'
import CoachDashboard from './CoachDashboard'

function App() {
  const [count, setCount] = useState(0)

  return (
    <div className="App">
      <CoachDashboard/>
    </div>
  )
}

export default App
