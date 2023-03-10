import { useState } from 'react';
import reactLogo from './assets/react.svg';
import './App.css';
import CoachDashboard from './CoachDashboard';
import NavBar from './components/NavBar';
import { Routes, Route } from 'react-router-dom';
import HRDashboard from './HRDashboard';

function App() {
    const [count, setCount] = useState(0);

    return (
        <div className="App">
            <NavBar />
            <Routes>
                <Route
                    path="/coach"
                    element={<CoachDashboard />}
                />
                <Route
                    path="/hr"
                    element={<HRDashboard />}
                />
            </Routes>
        </div>
    );
}

export default App;
