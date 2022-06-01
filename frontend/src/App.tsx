import { Routes, Route } from "react-router-dom";
import Event from "./pages/Event";
import Home from "./pages/Home";
import Login from "./pages/Login";
import SignUp from "./pages/SignUp";

function App() {
  return (
    <Routes>
      <Route path="/" element={<Home />} />
      <Route path="/login" element={<Login />} />
      <Route path="/signup" element={<SignUp />} />
      <Route path="/event" element={<Event />} />
    </Routes>
  );
}

export default App;
