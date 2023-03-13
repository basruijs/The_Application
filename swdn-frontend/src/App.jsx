import { useState } from 'react';
import reactLogo from './assets/react.svg';
import './App.css';
import CoachDashboard from './CoachDashboard';
import NavBar from './components/NavBar';
import { Routes, Route } from 'react-router-dom';
import HRDashboard from './HRDashboard';
import LoginPage from './LoginPage';

function App() {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [person, setPerson] = useState({
        name: 'Dummy Name',
        role: {
            name: 'Not Logged In',
        },
    });

    return (
        <div className="App">
            <NavBar person={person} />
            <Routes>
                <Route
                    path="/coach"
                    element={
                        <CoachDashboard
                            email={email}
                            password={password}
                        />
                    }
                />
                <Route
                    path="/hr"
                    element={
                        <HRDashboard
                            email={email}
                            password={password}
                            person={person}
                        />
                    }
                />
                <Route
                    path="/login"
                    element={
                        <LoginPage
                            setEmail={setEmail}
                            setPassword={setPassword}
                            setPerson={setPerson}
                        />
                    }
                />
            </Routes>
        </div>
    );
}

export default App;
