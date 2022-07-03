import { Routes, Route } from "react-router-dom";
import { AuthProvider } from "./contexts/AuthContext";
import RequireAuth from "./components/RequireAuth";
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
        <Route path="/" element={<Home />} />

        {/* common user routes */}
        <Route path="/event" element={<Event />} />
        <Route element={<RequireAuth allowedRoles={["USER", "VENDEDOR", "ADMIN"]} />}></Route>

        {/* admin routes */}
        <Route path="/dashboard" element={<Dashboard />} />
        <Route path="/users" element={<Users />} />
        <Route path="/events" element={<DashboardEvents />} />
        <Route path="/sessions" element={<Sessions />} />
        <Route path="/rooms" element={<Rooms />} />
        <Route element={<RequireAuth allowedRoles={["ADMIN"]} />}></Route>
      </Routes>
    </AuthProvider>
  );
}

export default App;
