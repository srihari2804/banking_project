import { useState } from "react";
import { useNavigate } from "react-router-dom";
import api from "../api";

function Login() {

    const navigate = useNavigate();
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");

    function loginUser() {

        api.post("/api/auth/login", {
            username: username,
            password: password
        })
        .then(response => {
            localStorage.setItem("token", response.data.token);
            localStorage.setItem("role", response.data.role);
            localStorage.setItem("username", response.data.username);

            if (response.data.role === "USER") {
                navigate("/user/dashboard");
            } else if (response.data.role === "ADMIN") {
                navigate("/admin/dashboard");
            }
        })
        .catch(error => {
            console.log(error);
            alert(error.response?.data?.message || "Invalid username or password");
        });
    }

    return (
        <div className="container mt-5">
            <div className="row justify-content-center">
                <div className="col-md-4">
                    <div className="card shadow">
                        <div className="card-body">
                            <h2 className="text-center mb-4">🏦 Hari Bank</h2>
                            <input type="text" className="form-control mb-3" placeholder="Username" value={username} onChange={(e) => setUsername(e.target.value)} />
                            <input type="password" className="form-control mb-3" placeholder="Password" value={password} onChange={(e) => setPassword(e.target.value)} />
                            <button className="btn btn-primary w-100" onClick={loginUser}>Login</button>
                            <div className="text-center mt-3">
                                <button className="btn btn-link" onClick={() => navigate("/register")}>Create Account</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default Login;
