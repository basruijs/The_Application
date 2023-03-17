import { useState } from 'react';
import reactLogo from './assets/react.svg';
import './App.css';
import CoachDashboard from './CoachDashboard';
import ManagerDashboard from './ManagerDashboard';

import NavBar from './components/NavBar';
import { Routes, Route } from 'react-router-dom';
import HRDashboard from './HRDashboard';
import LoginPage from './LoginPage';
import AccountPage from './AccountPage';
import FeedbackPage from './FeedbackPage';
import TraineeDashboard from './TraineeDashboard';

function App() {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [person, setPerson] = useState({
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
                            person={person}
                        />
                    }
                />
                <Route
                    path="/manager"
                    element={
                        <ManagerDashboard
                            email={email}
                            password={password}
                            person={person}
                        />
                    }
                />
                <Route
                    path="/trainee"
                    element={
                        <TraineeDashboard
                            email={email}
                            password={password}
                            person={person}
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
                '
                <Route
                    path="/account"
                    element={
                        <AccountPage
                            email={email}
                            password={password}
                            person={person}
                            setPassword={setPassword}
                        />
                    }
                />
                '
                <Route
                    path="/feedback"
                    element={
                        <FeedbackPage
                            email={email}
                            password={password}
                            person={person}
                        />
                    }
                />
            </Routes>
        </div>
    );
}

export default App;
