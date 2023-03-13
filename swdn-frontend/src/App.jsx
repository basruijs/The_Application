import { useState } from 'react';
import reactLogo from './assets/react.svg';
import './App.css';
import CoachDashboard from './CoachDashboard';
import NavBar from './components/NavBar';
import { Routes, Route } from 'react-router-dom';
import HRDashboard from './HRDashboard';
import LoginPage from './LoginPage';
import AccountPage from './AccountPage';

function App() {
    const [count, setCount] = useState(0);
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');

    return (
        <div className="App">
            <NavBar />
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
                        />
                    }
                />
                <Route
                    path="/login"
                    element={
                        <LoginPage
                            setEmail={setEmail}
                            setPassword={setPassword}
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
                        />
                    }
                />
                '
            </Routes>
        </div>
    );
}

export default App;
