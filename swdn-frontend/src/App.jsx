import { useState } from 'react';
import reactLogo from './assets/react.svg';
import './App.css';
import CoachDashboard from './CoachDashboard';
import NavBar from './components/NavBar';

function App() {
    const [count, setCount] = useState(0);

    return (
        <div className="App">
            <NavBar />
            <CoachDashboard />
        </div>
    );
}

export default App;
