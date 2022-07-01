import { Routes, Route } from "react-router-dom";
import { AuthProvider } from "./contexts/AuthContext";
import PrivateRoute from "./components/PrivateRoute";
import Event from "./pages/Event";
import Home from "./pages/Home";
import Login from "./pages/Login";
import SignUp from "./pages/SignUp";
import Dashboard from "./pages/Dashboard";
import Users from "./pages/Users";
import DashboardEvents from "./pages/DashboardEvents";
import Sessions from "./pages/Sessions";
import Rooms from "./pages/Rooms";

function App() {
  return (
    <AuthProvider>
      <Routes>
        {/* public routes */}
        <Route path="/login" element={<Login />} />
        <Route path="/signup" element={<SignUp />} />

        {/* common user routes */}
        <Route path="/" element={<Home />} />
        <Route path="/event" element={<Event />} />

        {/* admin routes */}
        <Route path="/dashboard" element={<Dashboard />} />
        <Route path="/users" element={<Users />} />
        <Route path="/events" element={<DashboardEvents />} />
        <Route path="/sessions" element={<Sessions />} />
        <Route path="/rooms" element={<Rooms />} />
      </Routes>
    </AuthProvider>
  );
}

export default App;
